if ( typeof OpenAjax.htest === "undefined" ) {
    OpenAjax.htest = {};
}

var TestHubManager = function()
{
    OpenAjax.htest.testManager = this;
    this._sid1 = OpenAjax.hub.subscribe( "control.client",
            function( topic, data ) {
                this.onMsg( data );
            },
            this
    );
    this._sid2 = OpenAjax.hub.subscribe( "control.client.log",
            function( topic, data ) {
                doh.debug( data );
            },
            this
    );
}

TestHubManager.prototype.onMsg = function() {}

TestHubManager.prototype.sendMsg = function( msg )
{
    OpenAjax.hub.publish( "control.manager", msg );
}

TestHubManager.prototype.cleanup = function()
{
    OpenAjax.hub.publish( "control.manager", "__cleanup" );
    OpenAjax.hub.unsubscribe( this._sid1 );
    OpenAjax.hub.unsubscribe( this._sid2 );
    OpenAjax.htest.testManager = null;
}

////////////////////////////////////////////////////////////////////////////////

var TestHubClient = function( type, onComplete )
{
    // keep synced with "smash._securityTokenLength" in FIM.js
    this.smash_securityTokenLength = 6;
    
    this._onComplete = onComplete;
    
    if ( type == "inline" ) {
        this._initInline();
    } else {
        this._initIframe();
    }
}

TestHubClient.prototype.onMsg = function() {}

TestHubClient.prototype.sendMsg = function( msg )
{
    this._sendMsg( msg );
}

TestHubClient.prototype._receiveMsg = function( topic, data )
{
    if ( data == "__cleanup" ) {
        this._hub.unsubscribe( this._sid );
        return;
    }
    
    this.onMsg( data );
}

TestHubClient.prototype.shutdown = function( )
{
    this._shutdown( );
}

/**
 * @param {Boolean} result
 */
TestHubClient.prototype.callback = function( result, msg )
{
    this._sendResult( result, msg );
}

/**
 * @param {Error} error
 */
TestHubClient.prototype.errback = function( error )
{
    if ( error instanceof Error ) {
        error = error.message;
    }
    this._sendResult( false, error );
}

TestHubClient.prototype.assertTrue = function( condition, hint )
{
	if ( ! eval( condition ) ) {
		this._sendResult( false, "assertTrue('" + condition + "') failed", hint );
	}
}

TestHubClient.prototype.assertFalse = function( condition, hint )
{
	if ( eval( condition ) ) {
		this._sendResult( false, "assertFalse('" + condition + "') failed", hint );
	}
}

TestHubClient.prototype.assertEqual = function( expected, actual, hint )
{
    try {
        this._assertEqual( expected, actual, hint );
    } catch( e ) {
        this._sendResult( false, e.message );
    }
}

TestHubClient.prototype._assertFailure = function( msg, hint )
{
	if(hint){
		msg = (new String(msg||""))+" with hint: \n\t\t"+(new String(hint)+"\n");
	}
	throw new Error( msg );
}

TestHubClient.prototype._assertEqual = function( expected, actual, hint )
{
	if((expected === undefined)&&(actual === undefined)){ 
		return true;
	}
	if((expected === actual)||(expected == actual)){ 
		return true;
	}
	if(	(this._isArray(expected) && this._isArray(actual))&&
		(this._arrayEq(expected, actual)) ){
		return true;
	}
	if( ((typeof expected == "object")&&((typeof actual == "object")))&&
		(this._objPropEq(expected, actual)) ){
		return true;
	}
	this._assertFailure("assertEqual() failed:\n\texpected\n\t\t"+expected+"\n\tbut got\n\t\t"+actual+"\n\n", hint);
}

TestHubClient.prototype._arrayEq = function(expected, actual){
	if(expected.length != actual.length){ return false; }
	for(var x=0; x<expected.length; x++){
		if(!this._assertEqual(expected[x], actual[x])){ return false; }
	}
	return true;
}

TestHubClient.prototype._objPropEq = function(expected, actual){
	// Degenerate case: if they are both null, then their "properties" are equal.
	if(expected === null && actual === null){
		return true;
	}
	// If only one is null, they aren't equal.
	if(expected === null || actual === null){
		return false;
	}
	if(expected instanceof Date){
		return actual instanceof Date && expected.getTime()==actual.getTime();
	}
	var x;
	// Make sure ALL THE SAME properties are in both objects!
	for(x in actual){ // Lets check "actual" here, expected is checked below.
		if(expected[x] === undefined){
			return false;
		}
	};

	for(x in expected){
		if(!this._assertEqual(expected[x], actual[x])){
			return false;
		}
	}
	return true;
}

TestHubClient.prototype._isArray = function(it){
	return (it && it instanceof Array || typeof it == "array");
}

TestHubClient.prototype.assertError = function( expectedError, scope, functionName, args, hint )
{
	try {
		scope[functionName].apply( scope, args );
	} catch (e){
		if(e instanceof expectedError){
			return true;
		}else{
			this._sendResult( false, "assertError() failed:\n\texpected error\n\t\t"+expectedError+"\n\tbut got\n\t\t"+e+"\n\n", hint );
		}
	}
	this._sendResult( false, "assertError() failed:\n\texpected error\n\t\t"+expectedError+"\n\tbut no error caught\n\n", hint );
}

TestHubClient.prototype._sendResult = function( result, msg, hint )
{
    if ( hint ) {
        msg = (msg||"") + " with hint: \n\t\t" + hint + "\n";
    }
    
    var data = {
        r: result,
        m: msg
    };
    this._sendMsg( data );
}

/*****  inline clients *****/

TestHubClient.prototype._initInline = function()
{
    this._hub = OpenAjax.hub;
    if ( OpenAjax.htest.testManager ) {
        this._sid = OpenAjax.hub.subscribe( "control.manager", this._receiveMsg, this );
    }
    this._sendMsg = this._sendMsgInline;
    this._shutdown = this._shutdownInline;
    try {
        this._onComplete( this );
    } catch( e ) {
        this.errback( "Failed to run test: " + e );
    }
}

TestHubClient.prototype._sendMsgInline = function( data )
{
    OpenAjax.hub.publish( "control.client", data );
}

TestHubClient.prototype._shutdownInline = function( )
{
}

/*****  iframe clients *****/

TestHubClient.prototype._initIframe = function()
{
    this._sendMsg = this._sendMsgIframe;
    this._shutdown = this._shutdownIframe;
    this._initialized = false;
    this._q = [];

    this._hub = new OpenAjax.hub.ManagedHub({
        onPublish: function() { return true; },
        onSubscribe: function( topic, container ) {
            if ( topic == "msg" ) {
                // test tunnel has connected and subscribed, so we are
                // fully initialized
                this._setInitialized();
            }
            return true;
        },
        scope: this
    });

    // create hidden iframe container to handle communications to test page

    // create hidden DIV to contain IframeContainer
    var div = document.createElement( "div" );
    document.body.appendChild( div );
    div.style.left = div.style.top = "0px";
    div.style.height = div.style.width = "1px";
    div.style.visibility = "hidden";
    
    function onClientSecurityAlert( container, securityAlert ) {
        this.log( "TestHub: client security alert: " + securityAlert );
    }
    
    this._ifrContainer = new OpenAjax.hub.IframeContainer(
        this._hub,
        "test_iframe_container",
        {   Container: {
                onSecurityAlert: onClientSecurityAlert,
                onConnect: function( container ) {
                    try {
                        this._onComplete( this );
                    } catch( e ) {
                        this.errback( "Failed to run test: " + e );
                    }
                },
                scope: this
//               , log: function( msg ) {
//                   this.log( "TestTunnelContainer: " + msg );
//               }
            },
            IframeContainer: {
                uri: this._createTestContainerURI(),
                tunnelURI: this._createTestTunnelURI(),
                parent: div
            }
        }
    );
    
    // listen for control messages
    this._sid = this._hub.subscribe( "control.manager", this._receiveMsg, this );
}

TestHubClient.prototype._createTestContainerURI = function()
{
    var tunnelHub20Dir;
    var channel = OpenAjax.gadgets.rpc.getRelayChannel();
    if (channel === 'wpm' || channel === 'nix') {
        var tunnelURI = OpenAjax.gadgets.util.getUrlParameters().parent;
        tunnelHub20Dir = new RegExp( "(.*?" + HUB20_PATH + "/)" ).exec( tunnelURI )[1];
    } else {
        tunnelHub20Dir = OpenAjax.gadgets.util.getUrlParameters().oahParent + HUB20_PATH + '/';
    }
    var testtunnelURI = tunnelHub20Dir + "testsrc/util/test_tunnel.html?config=" + OpenAjax.gadgets.util.getUrlParameters().config;
    return testtunnelURI;
}

TestHubClient.prototype._createTestTunnelURI = function()
{
    var channel = OpenAjax.gadgets.rpc.getRelayChannel();
    if (channel !== 'wpm' && channel !== 'nix') {
        return null;
    }
    var tunnelURI = OpenAjax.gadgets.util.getUrlParameters().parent;
    var tunnelPath = new RegExp( "^[a-zA-Z]+://[^/?#]+(.*)" ).exec( tunnelURI )[1];
    var origin = window.location.protocol + "//" + window.location.host;
    return origin + tunnelPath;
}

TestHubClient.prototype._sendMsgIframe = function( msg )
{
    if ( this._initialized ) {
        this._hub.publish( "msg", msg );
        return;
    }

    this._q.push( msg );
}

TestHubClient.prototype.log = function( msg )
{
    this._hub.publish( "log", msg );
}

TestHubClient.prototype._shutdownIframe = function( )
{
	this._hub.disconnect();
	delete this._hub;
}

TestHubClient.prototype._setInitialized = function()
{
    this._initialized = true;
    if ( this._q.length > 0 ) {
        var that = this;
        setTimeout( function() {
            while ( that._q.length !== 0 ) {
                that._hub.publish( "msg", that._q.shift() );
            }
        }, 0 );
    }
}

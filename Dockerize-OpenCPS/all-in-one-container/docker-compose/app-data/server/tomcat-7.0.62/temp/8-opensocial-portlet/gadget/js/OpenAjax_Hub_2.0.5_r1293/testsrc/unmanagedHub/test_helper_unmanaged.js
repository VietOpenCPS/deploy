UnmanagedTestContainer = function( clientID ) 
{

	var TestHubClient = function( )
	{
		// setup logging function
		if ( typeof console !== "undefined" ) {
			this.log = TestHubManager.logToConsole;
		} else {
			this.log = function() {};
		}
	};
	TestHubClient.prototype.publish = function(topic, data) {
		OpenAjax.hub.publish( topic, data );
	}	
	TestHubClient.prototype.subscribeWrapper = function(topic, data, subscriberData) {
		if (topic.substr(0,8) != 'control.') {
			var onData = subscriberData.onData;
			var subData = subscriberData.subscriberData;
			onData.call(this, topic, data, subData);
		}
	}	
	TestHubClient.prototype.subscribe = function( topic, onData, scope, onComplete, subscriberData ) {
		var wrapper = new Object({onData:onData,subscriberData:subscriberData});
		var sid = OpenAjax.hub.subscribe( topic, this.subscribeWrapper, scope, wrapper );
		if (onComplete) {
			onComplete.call(scope, sid, true );
		}
		return sid;
	}
	TestHubClient.prototype.unsubscribe = function( subscriptionID ) {
		OpenAjax.hub.unsubscribe( subscriptionID );
	}

	var that = this;
	var test = new TestHubClient();
	test.hubClient = test;
	test.clientID = clientID;
	test.appendResult = function( msg ) {
		test.sendMsg("appendResult:"+msg);
	}
	test.appendToResultArray = function( arrayIndex, msg ) {
		test.sendMsg("appendToResultArray:"+arrayIndex+":"+msg );
	}
	test.incrementCounterArray = function( arrayIndex, msg ) {
		test.sendMsg("incrementCounterArray:"+arrayIndex+":"+msg );
	}
	test.errback = function( msg ) {
		test.sendMsg("errback:"+msg);
	}
	test.print = function( msg ) {
		doh.debug(msg);
	}
	test.sendMsg = function( msg ) {
		OpenAjax.hub.publish( "control.client", msg );
	};
	test.onMsg = function( msg ) {
		var parts = msg.split(":");
		var targetClient = parts[0];
		if (targetClient === "*" || targetClient === test.clientID) {
			var command = parts[1];
			switch (command) {
				case "loadscriptfile":
					test.autoloop = parts[3];  // whether to automatically invoke script N+1 after N
					setTimeout( function() {
						test.sendMsg('ready_for_next_command');
					}, 0 );
					break;
				case "runscript":
					var testname = parts[2];
					var scriptname = parts[3];
					var scriptcount = parts[4];
					var window_testname = window[testname];
					if (typeof window[testname] === "object" &&
						typeof window[testname][scriptname] === "function") {
						var func = window[testname][scriptname];
						func.call(test, scriptcount);
					}
					if (test.autoloop == "true") {
						setTimeout( function() {
							test.sendMsg('ready_for_next_command');
						}, 0 );
					}
					break;
				case "shutdown":
					OpenAjax.hub.unsubscribe(that._sid);
					delete that._sid;
					break;
			}
		}
	};
	var _receiveMsgManager = function(topic, data) {
		test.onMsg(data);
	}
    this._sid = OpenAjax.hub.subscribe( "control.manager", _receiveMsgManager, this );
    setTimeout( function() {
		test.sendMsg('ready_to_start');
    }, 0 );
}

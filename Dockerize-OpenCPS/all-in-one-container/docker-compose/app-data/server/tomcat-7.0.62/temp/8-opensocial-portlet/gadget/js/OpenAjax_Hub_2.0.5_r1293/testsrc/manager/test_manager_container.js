var TestManagerContainer = function() {}

TestManagerContainer.createContainerForTest = function( testName, hub, clientID, params )
{
    setTimeout( function() {
        TestManagerContainer._createHubClientForTest( testName, hub );
    }, 0 );
    
    return hub;
}

TestManagerContainer._createHubClientForTest = function( testName, hub )
{
    new TestHubClient( "inline", function( test ) {
        TestManagerContainer[ "_" + testName ]( test, hub );
    });
}

/**********************************************************************/
/**********************************************************************/

TestManagerContainer._managedhub_onsubscribe = function( test, hub )
{
    hub.subscribe( "test.manager", function() {} );
}

TestManagerContainer._managedhub_onpublish = function( test, hub )
{
    hub.subscribe( "test.second", function() {} );
    test.onMsg = function( data ) {
        if ( data == "publish" ) {
            hub.publish( "test.first", "goodbye" );
        }
    };
}

TestManagerContainer._managedhub_onunsubscribe = function( test, hub )
{
    var sid = hub.subscribe( "test.manager", function() {} );
    test.onMsg = function( data ) {
        if ( data == "unsubscribe" ) {
            hub.unsubscribe( sid );
        }
    };
}

TestManagerContainer._managedhub_onsubscribe_returnvalue = function( test, hub )
{
    hub.subscribe( "test.topic", function() {} );
    test.onMsg = function( data ) {
        if ( data == "publish" ) {
            hub.publish( "test.topic", "I am the manager!" );
        }
    };
}

TestManagerContainer._managedhub_onpublish_returnvalue = function( test, hub )
{
    hub.subscribe( "test.topic",
        function( topic, data ) {
            test.sendMsg( data + ":manager" );
        }
    );
    test.onMsg = function( data ) {
        if ( data == "publish" ) {
            hub.publish( "test.topic", "manager" );
        }
    };
}

/**********************************************************************/
/**********************************************************************/

TestManagerContainer._hub_subscribe_badparams = function( test, hub )
{
    // test with no params
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "subscribe",                                                // function name
        null,                                                       // args
        "no params",
        test
    );
    
    // test with no 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "subscribe",                                                // function name
        [   null,                                                   // args
            function() {}
        ],
        "no 'topic' param",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "subscribe",                                                // function name
        [   "",                                                     // args
            function() {}
        ],
        "invalid 'topic' param (1)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "subscribe",                                                // function name
        [   "a.",                                                   // args
            function() {}
        ],
        "invalid 'topic' param (2)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "subscribe",                                                // function name
        [   ".a",                                                   // args
            function() {}
        ],
        "invalid 'topic' param (3)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "subscribe",                                                // function name
        [   "a..b",                                                 // args
            function() {}
        ],
        "invalid 'topic' param (4)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "subscribe",                                                // function name
        [   "aaa.bb*cc",                                            // args
            function() {}
        ],
        "invalid 'topic' param (5)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "subscribe",                                                // function name
        [   "org.**.foo",                                           // args
            function() {}
        ],
        "invalid 'topic' param (6)",
        test
    );
    
    // test with no 'onData' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "subscribe",                                                // function name
        [   "foo",                                                  // args
            null   // null onData
        ],
        "no 'onData' param",
        test
    );
    
    test.callback( true );
}

TestManagerContainer._hub_subscribe_oncomplete = function( test, hub )
{
    // subscribe with no scope
    var sid = hub.subscribe( "hub.subscribe.oncomplete",
            function() {},
            null,
            function( item, success, error ) {
                var subID = item;
                test.assertTrue( success );
                test.assertEqual( window, this );
                test.assertEqual( window, hub.getSubscriberScope( subID ) ); // tests scope and that 'item' is a sub id
                test.callback( true, "test1" );
            }
    );
    test.assertTrue( typeof sid === "string", "subscriptionID is not a string" );
    
    // subscribe with scope
    function MyObject() {
        this.onComplete = function( item, success, error ) {
            var subID = item;
            test.assertTrue( success );
            test.assertEqual( myObject, this );
            test.assertEqual( myObject, hub.getSubscriberScope( subID ) ); // tests scope and that 'item' is a sub id
            test.callback( true, "test2" );
        };
    }
    var myObject = new MyObject();
    hub.subscribe( "hub.subscribe.oncomplete",
            function() {},
            myObject,
            myObject.onComplete
    );
    
    // subscribe to topic that should be disallowed (OpenAjax.hub.Error.NotAllowed)
    hub.subscribe( "hub.subscribe.oncomplete.xxxx",
            function() {},
            null,
            function( item, success, error ) {
                test.assertFalse( success );
                test.assertEqual( OpenAjax.hub.Error.NotAllowed, error );
                test.assertEqual( window, this );
                test.callback( true, "test3" );
            }
    );
}

TestManagerContainer._hub_subscribe_ondata = function( test, hub )
{
    // subscribe with no scope and no subscriberData
    hub.subscribe( "hub.subscribe.ondata.null",
            function( topic, data, subscriberData ) {
                test.assertEqual( "hub.subscribe.ondata.null", topic );
                test.assertEqual( null, data );
                test.assertTrue( typeof subscriberData === "undefined" || subscriberData == null );
                test.callback( true, "test1" );
            }
    );
    
    // subscribe with no scope and a String subscriberData
    var subData1 = "This is a string!";
    hub.subscribe( "hub.subscribe.ondata.str",
            function( topic, data, subscriberData ) {
                test.assertEqual( "hub.subscribe.ondata.str", topic );
                test.assertTrue( typeof data == "string" );
                test.assertEqual( "The quick brown fox jumps over the lazy dog.", data );
                test.assertEqual( subData1, subscriberData );
                test.callback( true, "test2" );
            },
            null,
            null,
            subData1
    );
    
    // subscribe with scope and an Object subscriberData
    var subData2 = { height: "200px", margin: 10 };
    function MyObject() {
        this.onData = function( topic, data, subscriberData ) {
            test.assertEqual( "hub.subscribe.ondata.obj", topic );
            test.assertTrue( typeof data == "object" );
            test.assertEqual( { foo: "bar", index: 201 }, data );
            test.assertEqual( subData2, subscriberData );
            test.callback( true, "test3" );
        };
    }
    var myObject = new MyObject();
    hub.subscribe( "hub.subscribe.ondata.obj",
            myObject.onData,
            myObject,
            null,
            subData2
    );
    
    // subscribe to topic that should be disallowed -- onData should not be
    // called
    hub.subscribe( "hub.subscribe.ondata.xxxx",
            function( topic, data, subscriberData ) {
                test.errback( "onData should not be called" );
            }
    );
}

TestManagerContainer._hub_publish_badparams = function( test, hub )
{
    // test with no params
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "publish",                                                  // function name
        null,                                                       // args
        "no params",
        test
    );
    
    // test with no 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "publish",                                                  // function name
        [   null,                                                   // args
            "data"
        ],
        "no 'topic' param",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "publish",                                                  // function name
        [   "",                                                     // args
            "data"
        ],
        "invalid 'topic' param (1)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "publish",                                                  // function name
        [   "a.",                                                   // args
            "data"
        ],
        "invalid 'topic' param (2)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "publish",                                                  // function name
        [   ".a",                                                   // args
            "data"
        ],
        "invalid 'topic' param (3)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "publish",                                                  // function name
        [   "a..b",                                                 // args
            "data"
        ],
        "invalid 'topic' param (4)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "publish",                                                  // function name
        [   "aaa.*",                                                // args
            "data"
        ],
        "invalid 'topic' param (5)",
        test
    );
    
    // test with invalid 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hub,                                                        // scope
        "publish",                                                  // function name
        [   "**",                                                   // args
            "data"
        ],
        "invalid 'topic' param (6)",
        test
    );
    
    test.callback( true );
}

TestManagerContainer._hub_unsubscribe = function( test, hub )
{
    //----- SETUP -----//
    
    var sid1 = hub.subscribe( "hub.unsub.topic", subOnData, null, subOnComplete );
    var sid2 = hub.subscribe( "hub.unsub.topic", subOnData, null, subOnComplete );

    
    //----- TESTS -----//
    
    var oncomp_count = 0;
    function subOnComplete( item, success, error ) {
        setTimeout ( function() {
                oncomp_count++;
                if ( oncomp_count == 2 ) {
                    // we are subscribed -- start stage 1
                    stage1();
                }
            }, 0
        );
    }
    
    var unsubscribed = false;
    var ondata_count = 0;
    function subOnData( topic, data ) {
        test.assertFalse( unsubscribed, "onData called after unsubscribe" );
        test.assertEqual( "hello", data );
        ondata_count++;
        if ( ondata_count == 2 ) {
            // we get called twice, for each subscription -- start stage 2
            setTimeout( function() {
                    stage2();
                }, 0
            );
        }
    }
    
    function stage1() {
        hub.publish( "hub.unsub.topic", "hello" );
    }
    
    function stage2() {
        // test for BadParameters...

        // test with no 'subscriptionID' param
        testHelper.assertErrorMsg(
            OpenAjax.hub.Error.BadParameters,                           // expected error msg
            hub,                                                        // scope
            "unsubscribe",                                              // function name
            [ null ],                                                   // args
            "no 'subscriptionID' param",
            test
        );
        
        
        // test 'onComplete' and 'scope'
        
        // unsubscribe with no scope
        hub.unsubscribe( sid1,
                function( item, success, error ) {
                    test.assertTrue( success );
                    test.assertEqual( window, this );
                }
        );
        
        // unsubscribe with a scope
        function MyObject() {
            this.onComplete = function( item, success, error ) {
                test.assertTrue( success );
                test.assertEqual( myObject, this );
            }
        }
        var myObject = new MyObject();
        hub.unsubscribe( sid2, myObject.onComplete, myObject );
        
        
        // test that subscribe's onData doesn't get called after having
        // unsubscribed
        unsubscribed = true;
        hub.publish( "hub.unsub.topic", "goodbye" );
        
        
        // test that unsubscribing from already subscribed ID throws error
        testHelper.assertErrorMsg(
            OpenAjax.hub.Error.NoSubscription,                          // expected error msg
            hub,                                                        // scope
            "unsubscribe",                                              // function name
            [ sid1 ],                                                   // args
            "unsubscribing from already unsubscribed ID",
            test
        );
        // test that unsubscribing from invalid ID throws error
        testHelper.assertErrorMsg(
            OpenAjax.hub.Error.NoSubscription,                          // expected error msg
            hub,                                                        // scope
            "unsubscribe",                                              // function name
            [ "nonsense" ],                                             // args
            "unsubscribing from invalid ID",
            test
        );
        
        test.callback( true );
    }
}

TestManagerContainer._hub_getsubscriberdata = function( test, hub )
{
    // subscribe with no scope and no subscriberData
    var sub1 = hub.subscribe( "hub.getsubscriberdata.null",
            function() {}
    );
    
    // subscribe with no scope and a String subscriberData
    var subData2 = "This is a string!";
    var sub2 = hub.subscribe( "hub.getsubscriberdata.str",
            function() {},
            null,
            null,
            subData2
    );
    
    // subscribe with scope and an Object subscriberData
    var subData3 = { height: "200px", margin: 10 };
    function MyObject() {
    }
    var myObject = new MyObject();
    var sub3 = hub.subscribe( "hub.getsubscriberdata.obj",
            function() {},
            myObject,
            null,
            subData3
    );
    
    // test getSubscriberData
    var sd = hub.getSubscriberData( sub1 );
    test.assertTrue( typeof sd === "undefined" || sd == null );
    test.assertEqual( subData2, hub.getSubscriberData( sub2 ) );
    test.assertEqual( subData3, hub.getSubscriberData( sub3 ) );
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.NoSubscription,                          // expected error msg
        hub,                                                        // scope
        "getSubscriberData",                                        // function name
        [ "nonsense" ],                                             // args
        "call getSubscriberData with invalid ID",
        test
    );
    
    // test getSubscriberScope
    test.assertEqual( window, hub.getSubscriberScope( sub1 ) );
    test.assertEqual( window, hub.getSubscriberScope( sub2 ) );
    test.assertEqual( myObject, hub.getSubscriberScope( sub3 ) );
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.NoSubscription,                          // expected error msg
        hub,                                                        // scope
        "getSubscriberScope",                                       // function name
        [ "nonsense" ],                                             // args
        "call getSubscriberScope with invalid ID",
        test
    );
    
    test.callback( true );
}

TestManagerContainer._hub_isconnected = function( test, hub )
{
    function Tester( test, hub ) {
        this.test = test;
        
        this.run = function() {
            // now we are connected -- pubsub should work
            this.testConnected();
            
            hub.disconnect();
            
            // now we have disconnected -- test disconnected state again
            this.testDisconnected2();

            this.test.callback( true );
        }
        
        this.testDisconnected = function() {
            this.test.assertFalse( hub.isConnected() );
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                hub,                                                    // scope
                "subscribe",                                            // function name
                [   "hub.isconnected",                                  // args
                    function() {}
                ],
                "call subscribe() when not connected",
                this.test
            );
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                hub,                                                    // scope
                "publish",                                              // function name
                [   "hub.isconnected",                                  // args
                    null
                ],
                "call publish() when not connected",
                this.test
            );
        }
        
        this.testDisconnected2 = function() {
            this.testDisconnected();
            
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                hub,                                                    // scope
                "getSubscriberData",                                    // function name
                [ this.sid ],                                           // args
                "call getSubscriberData() when not connected",
                this.test
            );
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                hub,                                                    // scope
                "getSubscriberScope",                                   // function name
                [ this.sid ],                                           // args
                "call getSubscriberScope() when not connected",
                this.test
            );
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                hub,                                                    // scope
                "unsubscribe",                                          // function name
                [ this.sid ],                                           // args
                "call unsubscribe() when not connected",
                this.test
            );
        }
    
        this.testConnected = function() {
            this.test.assertTrue( hub.isConnected() );
            
            try {
                this.sid = hub.subscribe( "hub.isconnected",
                        function() {}, this, null,
                        "I am subscriber data!" );
                hub.publish( "hub.isconnected", "hello" );
            } catch( e ) {
                this.test.errback( e );
            }
        }
    }
    
    new Tester( test, hub ).run();
}


TestManagerContainer._managedhub_onpublish = function( test, hub )
{
    hub.subscribe( "test.second", function() {} );
    test.onMsg = function( data ) {
        if ( data == "publish" ) {
            hub.publish( "test.first", "goodbye" );
        }
    };
}

TestManagerContainer._pubsub_client = function( test, hub )
{
    test.onMsg = function( data ) {
		var parts = data.split(":");
		var msg = parts[0];
		var param = parts[1];
        switch( msg ) {
            case "runscript":
                runscript(TestURLParams.testobjname);
                break;
        }
    };

    function runscript(scriptname) {
		// Invoke the "run" function from the global object named in string "scriptname"
		var func = window[scriptname]["run"];
		func.call(test, 0);

    }

	test.hubClient = hub;
	test.sendMsg( [ "start" ] );
}


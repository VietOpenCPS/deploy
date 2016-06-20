var TestInlineContainer = function() {}

TestInlineContainer.createContainerForTest = function( testName, hub, clientID, params )
{
    // first, create container
    var container = new OpenAjax.hub.InlineContainer( hub, clientID, params );
    
    // next, create hub client -- use a setTimeout so that we can return the
    // container object back to the test before creating the hub client, which
    // will invoke container callbacks (such as onConnect, etc)
    setTimeout( function() {
        TestInlineContainer._createHubClientForTest( testName, container );
    }, 0 );
    
    return container;
}

TestInlineContainer._createHubClientForTest = function( testName, container )
{
    new TestHubClient( "inline", function( test ) {
        TestInlineContainer[ "_" + testName ]( test, container );
    });
}

TestInlineContainer._createInlineHubClient = function( params )
{
    return new OpenAjax.hub.InlineHubClient( params );
}

/**********************************************************************/
/**********************************************************************/

TestInlineContainer._container_connect = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
}

TestInlineContainer._container_disconnect = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect( function() {
        setTimeout( function() {
            hubClient.disconnect();
        }, 0);
    });
}

TestInlineContainer._container_getpartnerorigin = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    
    hubClient.connect( function() {
        hubClient.disconnect( function() {
            hubClient.connect();
        });
    });
}

/**********************************************************************/
/**********************************************************************/

TestInlineContainer._hubclient_badparams = function( test, container )
{
    // test with missing "params" param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        TestInlineContainer,                                        // scope
        "_createInlineHubClient",                                   // function name
        null,                                                       // args
        "missing 'params' param",
        test
    );

    // test with missing "params.HubClient" param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        TestInlineContainer,                                        // scope
        "_createInlineHubClient",                                   // function name
        [   {   InlineHubClient: {                                  // args
                    container: container
                }
            }
        ],
        "missing 'params.HubClient' param",
        test
    );

    // test with missing "params.HubClient.onSecurityAlert" param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        TestInlineContainer,                                        // scope
        "_createInlineHubClient",                                   // function name
        [   {   HubClient: {},                                      // args
                InlineHubClient: {
                    container: container
                }
            }
        ],
        "missing 'params.HubClient.onSecurityAlert' param",
        test
    );

    // test with missing "params.InlineHubClient" param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        TestInlineContainer,                                        // scope
        "_createInlineHubClient",                                   // function name
        [   {   HubClient: {                                        // args
                    onSecurityAlert: function() {}
                }
            }
        ],
        "missing 'params.InlineHubClient' param",
        test
    );

    // test with missing "params.InlineHubClient.container" param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        TestInlineContainer,                                        // scope
        "_createInlineHubClient",                                   // function name
        [   {   HubClient: {                                        // args
                    onSecurityAlert: function() {}
                },
                InlineHubClient: {}
            }
        ],
        "missing 'params.InlineHubClient.container' param",
        test
    );

    test.callback( true );
}

TestInlineContainer._hubclient_connect1 = function( test, container )
{
    // Create an InlineHubClient with no "scope" param -- should
    // default to "window".
    var hubClient;
    
    function onHubClientConnect( client, success, error ) {
        if ( success ) {
            test.assertEqual( hubClient, client );
            test.assertEqual( window, this );
            test.callback( true, "connect1" );  // test succeeded
        } else {
            test.callback( false, error );
        }
    }
    function onHubClientSecurityAlert( source, alertType ) {
        test.errback( "security alert in inline client: " + alertType );
    }
    
    try {
        hubClient = new OpenAjax.hub.InlineHubClient({
              HubClient: {
                  onSecurityAlert: onHubClientSecurityAlert,
                  log: test.log
              },
              InlineHubClient: {
                  container: container
              }
        });
        hubClient.connect( onHubClientConnect );
    } catch( e ) {
        test.errback( "inline hub client init and connect failed: " + e );
    }
}

TestInlineContainer._hubclient_connect2 = function( test, container )
{
    // Create an InlineHubClient with a "scope" param
    var hubClient;
    var myObject;
    
    var MyObject = function()
    {
        this.onHubClientConnect = function( client, success, error )
        {
            if ( success ) {
                test.assertEqual( hubClient, client );
                test.assertEqual( myObject, this );
                test.callback( true, "connect2" );  // test succeeded
            } else {
                test.callback( false, error );
            }
        }
        
        this.onHubClientSecurityAlert = function( source, alertType )
        {
            test.errback( "security alert in inline client: " + alertType );
        }
    }
    
    myObject = new MyObject();
    
    try {
        hubClient = new OpenAjax.hub.InlineHubClient({
              HubClient: {
                  onSecurityAlert: myObject.onHubClientSecurityAlert,
                  scope: myObject,
                  log: test.log
              },
              InlineHubClient: {
                  container: container
              }
        });
        hubClient.connect( myObject.onHubClientConnect, myObject );
    } catch( e ) {
        test.errback( "inline hub client init and connect failed: " + e );
    }
}

// XXX need test for a connect() call that fails and returns
//     success == false in onConnect()

TestInlineContainer._hubclient_connect3 = function( test, container )
{
    function onHubClientSecurityAlert( source, alertType ) {
        test.errback( "security alert in inline client: " + alertType );
    }

    var hubClient = new OpenAjax.hub.InlineHubClient({
          HubClient: {
              onSecurityAlert: onHubClientSecurityAlert,
              log: test.log
          },
          InlineHubClient: {
              container: container
          }
    });
    
    hubClient.connect( function( client, success, error ) {
        test.assertTrue( success );
        
        // now call connect() again -- should throw a Duplicate error
        testHelper.assertErrorMsg(
            OpenAjax.hub.Error.Duplicate,                           // expected error msg
            hubClient,                                              // scope
            "connect",                                              // function name
            null,                                                   // args
            "call HubClient.connect() while already connected",
            test
        );

        test.callback( true );
    });
}

TestInlineContainer._hubclient_disconnect1 = function( test, container )
{
    // Create an InlineHubClient with no "scope" param -- should
    // default to "window".
    var hubClient;
    
    function onHubClientConnect( client, success, error ) {
        test.assertTrue( success, "hub client connect failed" );
        setTimeout(
            function() {
                // now try to call disconnect
                try {
                    hubClient.disconnect( onHubClientDisconnect );
                } catch( e ) {
                    test.errback( "inline hub client disconnect failed: " + e );
                }
            },
            0
        );
    }
    function onHubClientDisconnect( client, success, error ) {
        if ( success ) {
            test.assertEqual( hubClient, client );
            test.assertEqual( window, this );
            test.callback( true, "client1" );  // test succeeded
        } else {
            test.errback( error );
        }
    }
    function onHubClientSecurityAlert( source, alertType ) {
        test.errback( "security alert in inline client: " + alertType );
    }
    
    try {
        hubClient = new OpenAjax.hub.InlineHubClient({
              HubClient: {
                  onSecurityAlert: onHubClientSecurityAlert,
                  log: test.log
              },
              InlineHubClient: {
                  container: container
              }
        });
        hubClient.connect( onHubClientConnect );
    } catch( e ) {
        test.errback( "inline hub client init and connect failed: " + e );
    }
}

TestInlineContainer._hubclient_disconnect2 = function( test, container )
{
    // Create an InlineHubClient with a "scope" param
    var hubClient;
    var myObject;
    
    var MyObject = function()
    {
        this.onHubClientConnect = function( client, success, error )
        {
            test.assertTrue( success, "hub client connect failed" );
            setTimeout(
                function() {
                    // now try to call disconnect
                    try {
                        hubClient.disconnect( myObject.onHubClientDisconnect, myObject );
                    } catch( e ) {
                        test.errback( "inline hub client disconnect failed: " + e );
                    }
                },
                0
            );
        }
        
        this.onHubClientDisconnect = function( client, success, error ) {
            if ( success ) {
                test.assertEqual( hubClient, client );
                test.assertEqual( myObject, this );
                test.callback( true, "client2" );  // test succeeded
            } else {
                test.errback( error );
            }
        }

        this.onHubClientSecurityAlert = function( source, alertType )
        {
            test.errback( "security alert in inline client: " + alertType );
        }
    }
    
    myObject = new MyObject();
    
    try {
        hubClient = new OpenAjax.hub.InlineHubClient({
              HubClient: {
                  onSecurityAlert: myObject.onHubClientSecurityAlert,
                  scope: myObject,
                  log: test.log
              },
              InlineHubClient: {
                  container: container
              }
        });
        hubClient.connect( myObject.onHubClientConnect, myObject );
    } catch( e ) {
        test.errback( "inline hub client init and connect failed: " + e );
    }
}

TestInlineContainer._hubclient_disconnect3 = function( test, container )
{
    function onHubClientSecurityAlert( source, alertType ) {
        test.errback( "security alert in inline client: " + alertType );
    }

    var hubClient = new OpenAjax.hub.InlineHubClient({
          HubClient: {
              onSecurityAlert: onHubClientSecurityAlert,
              log: test.log
          },
          InlineHubClient: {
              container: container
          }
    });
    
    hubClient.connect( function( client, success, error ) {
        test.assertTrue( success );
        
        hubClient.disconnect( function( client, success, error ) {
            test.assertTrue( success );
            
            // now call disconnect() again -- should throw a Disconnected error
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                hubClient,                                              // scope
                "disconnect",                                           // function name
                null,                                                   // args
                "call HubClient.disconnect() while already disconnected",
                test
            );

            test.callback( true );
        });
    });
}

TestInlineContainer._hubclient_disconnect4 = function( test, container )
{
    function onHubClientSecurityAlert( source, alertType ) {
        test.errback( "security alert in iframe client: " + alertType );
    }

    var hubClient = new OpenAjax.hub.InlineHubClient({
          HubClient: {
              onSecurityAlert: onHubClientSecurityAlert,
              log: test.log
          },
          InlineHubClient: {
              container: container
          }
    });
    
    hubClient.connect( onHubClientConnect );


    function onHubClientConnect( item, success, error )
    {
        test.assertTrue( success );
        
        var id = hubClient.getClientID();
        hubClient.subscribe( "test.disconnect",
                function( topic, data ) {               // onData
                    test.sendMsg({
                        r: true,
                        i: id,
                        m: data
                    });
                },
                null,                                   // scope
                function( item, success, errCode ) {    // onComplete
                    test.assertTrue( success );
                    test.sendMsg({
                        r: true,
                        i: id,
                        m: "subscribed"
                    });
                }
        );
    }
}

TestInlineContainer._hubclient_disconnect5 = function( test, container )
{
    function onHubClientSecurityAlert( source, alertType ) {
        test.errback( "security alert in iframe client: " + alertType );
    }

    var hubClient = new OpenAjax.hub.InlineHubClient({
          HubClient: {
              onSecurityAlert: onHubClientSecurityAlert,
              log: test.log
          },
          InlineHubClient: {
              container: container
          }
    });
    
    hubClient.connect( onHubClientConnect );
    test.onMsg = onTestMsg;


    function onHubClientConnect( item, success, error )
    {
        test.assertTrue( success );
        
        var id = hubClient.getClientID();
        hubClient.subscribe( "test.disconnect",
                function( topic, data ) {               // onData
                    test.sendMsg({
                        r: true,
                        i: id,
                        m: data
                    });
                },
                null,                                   // scope
                function( item, success, errCode ) {    // onComplete
                    test.assertTrue( success );
                    test.sendMsg({
                        r: true,
                        i: id,
                        m: "subscribed"
                    });
                }
        );
    }

    function onTestMsg( data )
    {
        switch ( data ) {
            case "phase3":
                hubClient.disconnect(
                    function( item, success, errCode ) {    // onComplete
                        test.assertTrue( success );
                        hubClient.connect( onHubClientReconnect );
                    }
                );
                break;
        }
    }
    
    // client connects after disconnect
    function onHubClientReconnect( item, success, error )
    {
        // At this point, since the client has disconnected, there are no
        // subscriptions associated with this client.
        
        // Let test know where we are
        test.sendMsg({
            r: true,
            i: hubClient.getClientID(),
            m: "reconnected"
        });
    }
}

// XXX need test for a disconnect() call that fails and returns
//     success == false in onConnect()

TestInlineContainer._hubclient_reconnect = function( test, container )
{
    var hubClient;
    var connectedOnce = false;
    
    function onHubClientConnect( client, success, error ) {
        test.assertTrue( success, "hub client connect failed" );
        
        if ( ! connectedOnce ) {
            connectedOnce = true;
            setTimeout(
                function() {
                    // now try to call disconnect
                    try {
                        hubClient.disconnect( onHubClientDisconnect );
                    } catch( e ) {
                        test.errback( "inline hub client disconnect failed: " + e );
                    }
                },
                0
            );
        } else {
            // connecting for a second time...
            try {
                hubClient.publish( "client.reconnect", "after_reconnect" );
            } catch( e ) {}
        }
    }
    function onHubClientDisconnect( client, success, error ) {
        try {
            hubClient.publish( "client.reconnect", "after_disconnect" );
        } catch( e ) {}
        
        setTimeout(
            function() {
                try {
                    hubClient.connect( onHubClientConnect );
                } catch( e ) {
                    test.errback( "inline hub client reconnect failed: " + e );
                }
            }
        );
    }
    function onHubClientSecurityAlert( source, alertType ) {
        test.errback( "security alert in inline client: " + alertType );
    }
    
    hubClient = new OpenAjax.hub.InlineHubClient({
          HubClient: {
              onSecurityAlert: onHubClientSecurityAlert,
              log: test.log
          },
          InlineHubClient: {
              container: container
          }
    });
    hubClient.connect( onHubClientConnect );
}

TestInlineContainer._hubclient_getpartnerorigin = function( test, container )
{
    test.onMsg = function( data ) {
        switch( data ) {
            case "stage2":
                stage2();
                break;
            case "stage3":
                stage3();
                break;
            case "stage4":
                stage4();
                break;
        }
    };
    
    var hubClient;
    
    function stage1() {
        hubClient = new OpenAjax.hub.InlineHubClient({
              HubClient: {
                  onSecurityAlert: function() {},
                  log: test.log
              },
              InlineHubClient: {
                  container: container
              }
        });
        
        test.sendMsg( [ "stage1", hubClient.getPartnerOrigin() ] );
    }
    
    function stage2() {
        hubClient.connect( function( item, success, error ) {
            test.sendMsg( [ "stage2", hubClient.getPartnerOrigin() ] );
        });
    }
    
    function stage3() {
        hubClient.disconnect( function( item, success, error ) {
            test.sendMsg( [ "stage3", hubClient.getPartnerOrigin() ] );
        });
    }
    
    function stage4() {
        // reconnect
        hubClient.connect( function( item, success, error ) {
            test.sendMsg( [ "stage4", hubClient.getPartnerOrigin() ] );
        });
    }
    
    // start tests
    stage1();
}

TestInlineContainer._hubclient_getclientid = function( test, container )
{
    function onHubClientSecurityAlert( source, alertType ) {
        test.errback( "security alert in inline client: " + alertType );
    }

    var hubClient = new OpenAjax.hub.InlineHubClient({
          HubClient: {
              onSecurityAlert: onHubClientSecurityAlert,
              log: test.log
          },
          InlineHubClient: {
              container: container
          }
    });
    
    hubClient.connect();
    
    try {
        test.sendMsg( hubClient.getClientID() );
    } catch( e ) {
        test.errback( e );
    }
}



/**********************************************************************/
/**********************************************************************/

TestInlineContainer._managedhub_onsubscribe = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect( function() {
        hubClient.subscribe( "test.inline", function() {} );
    } );
}

TestInlineContainer._managedhub_onpublish = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect( function() {
        hubClient.subscribe( "test.first", function() {} );
        test.onMsg = function( data ) {
            if ( data == "publish" ) {
                hubClient.publish( "test.second", "hello" );
            }
        };
    });
}

TestInlineContainer._managedhub_onunsubscribe = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect( function() {
        var sid = hubClient.subscribe( "test.inline", function() {} );
        test.onMsg = function( data ) {
            if ( data == "unsubscribe" ) {
                hubClient.unsubscribe( sid );
            }
        };
    });
}

TestInlineContainer._managedhub_onsubscribe_returnvalue = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect( function() {
        hubClient.subscribe( "test.topic", function() {} );
        test.onMsg = function( data ) {
            if ( data == "publish" ) {
                hubClient.publish( "test.topic", "I am an inline hub client!" );
            }
        };
    });
}

TestInlineContainer._managedhub_onpublish_returnvalue = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect( function() {
        hubClient.subscribe( "test.topic",
            function( topic, data ) {
                test.sendMsg( data + ":inline" );
            }
        );
        test.onMsg = function( data ) {
            if ( data == "publish" ) {
                hubClient.publish( "test.topic", "inline" );
            }
        };
    });
}

TestInlineContainer._managedhub_sameid1 = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    hubClient.subscribe(
        "test.client2",
        function( topic, data ) {
            test.assertEqual( "test.client2", topic );
            test.assertEqual( "alpha", data );
            test.callback( true, "alphaClient1" );
        }
    );
}

TestInlineContainer._managedhub_sameid2 = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    hubClient.subscribe(
        "test.client2",
        function( topic, data ) {
            test.assertEqual( "test.client2", topic );
            test.assertEqual( "beta", data );
            test.callback( true, "betaClient1" );
        }
    );
}

/**********************************************************************/
/**********************************************************************/

TestInlineContainer._hub_subscribe_badparams = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    // test with no params
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hubClient,                                                  // scope
        "subscribe",                                                // function name
        null,                                                       // args
        "no params",
        test
    );
    
    // test with no 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
        "subscribe",                                                // function name
        [   "foo",                                                  // args
            null   // null onData
        ],
        "no 'onData' param",
        test
    );
    
    test.callback( true );
}

TestInlineContainer._hub_subscribe_oncomplete = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    // subscribe with no scope
    var sid = hubClient.subscribe( "hub.subscribe.oncomplete",
            function() {},
            null,
            function( item, success, error ) {
                var subID = item;
                test.assertTrue( success );
                test.assertEqual( window, this );
                test.assertEqual( window, hubClient.getSubscriberScope( subID ) ); // tests scope and that 'item' is a sub id
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
            test.assertEqual( myObject, hubClient.getSubscriberScope( subID ) ); // tests scope and that 'item' is a sub id
            test.callback( true, "test2" );
        };
    }
    var myObject = new MyObject();
    hubClient.subscribe( "hub.subscribe.oncomplete",
            function() {},
            myObject,
            myObject.onComplete
    );
    
    // subscribe to topic that should be disallowed (OpenAjax.hub.Error.NotAllowed)
    hubClient.subscribe( "hub.subscribe.oncomplete.xxxx",
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

TestInlineContainer._hub_subscribe_ondata = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    // subscribe with no scope and no subscriberData
    hubClient.subscribe( "hub.subscribe.ondata.null",
            function( topic, data, subscriberData ) {
                test.assertEqual( "hub.subscribe.ondata.null", topic );
                test.assertEqual( null, data );
                test.assertTrue( typeof subscriberData === "undefined" || subscriberData == null );
                test.callback( true, "test1" );
            }
    );
    
    // subscribe with no scope and a String subscriberData
    var subData1 = "This is a string!";
    hubClient.subscribe( "hub.subscribe.ondata.str",
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
    hubClient.subscribe( "hub.subscribe.ondata.obj",
            myObject.onData,
            myObject,
            null,
            subData2
    );
    
    // subscribe to topic that should be disallowed -- onData should not be
    // called
    hubClient.subscribe( "hub.subscribe.ondata.xxxx",
            function( topic, data, subscriberData ) {
                test.errback( "onData should not be called" );
            }
    );
}

TestInlineContainer._hub_publish_badparams = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    // test with no params
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hubClient,                                                  // scope
        "publish",                                                  // function name
        null,                                                       // args
        "no params",
        test
    );
    
    // test with no 'topic' param
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.BadParameters,                           // expected error msg
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
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
        hubClient,                                                  // scope
        "publish",                                                  // function name
        [   "**",                                                   // args
            "data"
        ],
        "invalid 'topic' param (6)",
        test
    );
    
    test.callback( true );
}

TestInlineContainer._hub_unsubscribe = function( test, container )
{
    //----- SETUP -----//
    
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    var sid1 = hubClient.subscribe( "hub.unsub.topic", subOnData, null, subOnComplete );
    var sid2 = hubClient.subscribe( "hub.unsub.topic", subOnData, null, subOnComplete );

    
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
        hubClient.publish( "hub.unsub.topic", "hello" );
    }
    
    function stage2() {
        // test for BadParameters...

        // test with no 'subscriptionID' param
        testHelper.assertErrorMsg(
            OpenAjax.hub.Error.BadParameters,                           // expected error msg
            hubClient,                                                  // scope
            "unsubscribe",                                              // function name
            [ null ],                                                   // args
            "no 'subscriptionID' param",
            test
        );
        
        
        // test 'onComplete' and 'scope'
        
        // unsubscribe with no scope
        hubClient.unsubscribe( sid1,
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
        hubClient.unsubscribe( sid2, myObject.onComplete, myObject );
        
        
        // test that subscribe's onData doesn't get called after having
        // unsubscribed
        unsubscribed = true;
        hubClient.publish( "hub.unsub.topic", "goodbye" );
        
        
        // test that unsubscribing from already subscribed ID throws error
        testHelper.assertErrorMsg(
            OpenAjax.hub.Error.NoSubscription,                          // expected error msg
            hubClient,                                                  // scope
            "unsubscribe",                                              // function name
            [ sid1 ],                                                   // args
            "unsubscribing from already unsubscribed ID",
            test
        );
        // test that unsubscribing from invalid ID throws error
        testHelper.assertErrorMsg(
            OpenAjax.hub.Error.NoSubscription,                          // expected error msg
            hubClient,                                                  // scope
            "unsubscribe",                                              // function name
            [ "nonsense" ],                                             // args
            "unsubscribing from invalid ID",
            test
        );
        
        test.callback( true );
    }
}

TestInlineContainer._hub_getsubscriberdata = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    // subscribe with no scope and no subscriberData
    var sub1 = hubClient.subscribe( "hub.getsubscriberdata.null",
            function() {}
    );
    
    // subscribe with no scope and a String subscriberData
    var subData2 = "This is a string!";
    var sub2 = hubClient.subscribe( "hub.getsubscriberdata.str",
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
    var sub3 = hubClient.subscribe( "hub.getsubscriberdata.obj",
            function() {},
            myObject,
            null,
            subData3
    );
    
    // test getSubscriberData
    var sd = hubClient.getSubscriberData( sub1 );
    test.assertTrue( typeof sd === "undefined" || sd == null );
    test.assertEqual( subData2, hubClient.getSubscriberData( sub2 ) );
    test.assertEqual( subData3, hubClient.getSubscriberData( sub3 ) );
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.NoSubscription,                          // expected error msg
        hubClient,                                                  // scope
        "getSubscriberData",                                        // function name
        [ "nonsense" ],                                             // args
        "call getSubscriberData with invalid ID",
        test
    );
    
    // test getSubscriberScope
    test.assertEqual( window, hubClient.getSubscriberScope( sub1 ) );
    test.assertEqual( window, hubClient.getSubscriberScope( sub2 ) );
    test.assertEqual( myObject, hubClient.getSubscriberScope( sub3 ) );
    testHelper.assertErrorMsg(
        OpenAjax.hub.Error.NoSubscription,                          // expected error msg
        hubClient,                                                  // scope
        "getSubscriberScope",                                       // function name
        [ "nonsense" ],                                             // args
        "call getSubscriberScope with invalid ID",
        test
    );
    
    test.callback( true );
}

TestInlineContainer._hub_isconnected = function( test, container )
{
    function Tester( test, container ) {
        this.test = test;
        
        this.run = function() {
            this.hubClient = new OpenAjax.hub.InlineHubClient({
                    HubClient: {
                        onSecurityAlert: function() {}
                    },
                    InlineHubClient: {
                        container: container
                    }
            });

            // test before we call connect
            this.testDisconnected();

            this.hubClient.connect();

            // now we are connected -- pubsub should work
            this.testConnected();
            
            this.hubClient.disconnect();
            
            // now we have disconnected -- test disconnected state again
            this.testDisconnected2();

            this.test.callback( true );
        }
        
        this.testDisconnected = function() {
            this.test.assertFalse( this.hubClient.isConnected() );
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                this.hubClient,                                         // scope
                "subscribe",                                            // function name
                [   "hub.isconnected",                                  // args
                    function() {}
                ],
                "call subscribe() when not connected",
                this.test
            );
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                this.hubClient,                                         // scope
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
                this.hubClient,                                         // scope
                "getSubscriberData",                                    // function name
                [ this.sid ],                                           // args
                "call getSubscriberData() when not connected",
                this.test
            );
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                this.hubClient,                                         // scope
                "getSubscriberScope",                                   // function name
                [ this.sid ],                                           // args
                "call getSubscriberScope() when not connected",
                this.test
            );
            testHelper.assertErrorMsg(
                OpenAjax.hub.Error.Disconnected,                        // expected error msg
                this.hubClient,                                         // scope
                "unsubscribe",                                          // function name
                [ this.sid ],                                           // args
                "call unsubscribe() when not connected",
                this.test
            );
        }
    
        this.testConnected = function() {
            this.test.assertTrue( this.hubClient.isConnected() );
            
            try {
                this.sid = this.hubClient.subscribe( "hub.isconnected",
                        function() {}, this, null,
                        "I am subscriber data!" );
                this.hubClient.publish( "hub.isconnected", "hello" );
            } catch( e ) {
                this.test.errback( e );
            }
        }
    }
    
    new Tester( test, container ).run();
}

TestInlineContainer._hub_getscope1 = function( test, container )
{
    // create a client with no scope
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    test.assertEqual( window, hubClient.getScope() );
    
    test.callback( true, "client1" );
}

TestInlineContainer._hub_getscope2 = function( test, container )
{
    // create a client with a scope
    function MyObject() {
        this.onComplete = function( item, success, error ) {
            test.assertTrue( success );
            test.assertEqual( myObject, hubClient.getScope() );
            test.callback( true, "client2" );
        }
    }
    var myObject = new MyObject();
    
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {},
                scope: myObject
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect( myObject.onComplete, myObject );
}

TestInlineContainer._hub_getparams = function( test, container )
{
    var params = {
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    };
    var hubClient = new OpenAjax.hub.InlineHubClient( params );
    hubClient.connect();
    
    test.assertEqual( params, hubClient.getParameters(), "getParameters() didn't returned expected object" );
    test.callback( true );
}

TestInlineContainer._pub_queue = function( test, container )
{
    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
    hubClient.connect();
    
    var a1_hit = false;
    function onData( topic, data ) {
        if ( data == "A1" ) {
            a1_hit = true;
            hubClient.publish( "pub.queue.topic2", "A2" );
        } else if ( data == "A2" ) {
            // if publishes are properly ordered, then we should get "A1" before
            // we get "A2"
            test.assertTrue( a1_hit, "received 'A2' pub event before 'A1'" );
            test.callback( true, hubClient.getClientID() );
        }
    }
    hubClient.subscribe( "pub.queue.topic1", onData );
    hubClient.subscribe( "pub.queue.topic2", onData );

    test.onMsg = function( data ) {
        var expectedMsg = "publish." + hubClient.getClientID();
        if ( data == expectedMsg ) {
            hubClient.publish( "pub.queue.topic1", "A1" );
        }
    };
}

TestInlineContainer._pubsub_client = function( test, container )
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

    var hubClient = new OpenAjax.hub.InlineHubClient({
            HubClient: {
                onSecurityAlert: function() {}
            },
            InlineHubClient: {
                container: container
            }
    });
	test.hubClient = hubClient;
    hubClient.connect( function( item, success, error ) {
		test.sendMsg( [ "start" ] );
    });
}

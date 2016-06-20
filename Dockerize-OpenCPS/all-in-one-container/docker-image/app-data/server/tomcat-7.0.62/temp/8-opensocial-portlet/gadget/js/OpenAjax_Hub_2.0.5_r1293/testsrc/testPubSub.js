/*******************************************************************************
 * testPubSub.js:
 *      Component of the DOH-based test suite for the OpenAjax Hub.
 *
 *      JavaScript logic for the unit test for routines having to do with managing event
 *      publishing and event subscribing. (The "event hub" or "topic bus".)
 *      [ This is a port of the Hub 1.0 testcases found in _TestPubSub.js. ]
 *
 * Copyright 2008 OpenAjax Alliance
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at http://www.apache.org/licenses/LICENSE-2.0 . Unless 
 * required by applicable law or agreed to in writing, software distributed 
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *
 ******************************************************************************/

///////////////////////////////////////////////////

var js1_1_1 = {
	f1: function() {
        this.print( "publishing to no subscribers" );
        this.hubClient.publish("example.event", "");

		// Tell test harness that test case has completed its work.
		this.sendMsg("testlogiccompleted");
	}
};

/***********************************************************************
 *  js1_1_2
 **********************************************************************/

var js1_1_2 = {
	f1: function() {
		// "this" is a hubClient
        this.print( "subscribing to example.event (0)" );
        this.hubClient.subscribe( "example.event", js1_1_2._subCB0, this, js1_1_2._cb0 );
	},
    _subCB0: function( topic, data )
    {
        this.appendResult(", subCB0: " + topic + ", " + data);
        return;
    },
    
    _cb0: function( subscriptionID, success, errCode )
    {
        if ( !success ) {
            this.d.errback( new Error( this.name + ": subscribe to example.event (0) failed") );
            return;
        }
        this.sub0 = subscriptionID;

        var subscriberData = "mySubscriberData";
        function subCB1( topic, data ) {
            this.appendResult(", subCB1: " + topic + ", " + data + ", " + subscriberData);
            return;
        }

        this.print( "subscribing to example.event (1)" );
        this.hubClient.subscribe( "example.event", subCB1, this, js1_1_2._cb1 );
    },
    
    _cb1: function( subscriptionID, success, errCode )
    {
        if ( !success ) {
            this.d.errback( new Error( this.name + ": subscribe to example.event (1) failed") );
            return;
        }
        this.sub1 = subscriptionID;

        this.print( "publishing to example.event" );
        this.appendResult("publishing");
        this.hubClient.publish( "example.event", "myDATA" );
        this.appendResult(", published");
        this.print( "published to example.event" );

		// Tell test harness that test case has completed its work.
		this.sendMsg("testlogiccompleted");
    }
};

/***********************************************************************
 *  js1_2_1
 **********************************************************************/

var js1_2_1 = {

    events: [
        { s: "abc", p: "abc", ex: false, ok: true },
        { s: "abc", p: "def", ex: false, ok: false },
        { s: "abc", p: "ab", ex: false, ok: false },
        { s: "*", p: "abc", ex: false, ok: true },
        { s: "**", p: "abc", ex: false, ok: true },
        { s: "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", p: "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", ex: false, ok: true },
        { s: "**", p: "abc.def.ghi", ex: false, ok: true },
        { s: "*", p: "abc.def", ex: false, ok: false },
        { s: "a", p: "a", ex: false, ok: true },
        { s: "**", p: "abc", ex: false, ok: true },
        { s: "com.tibco", p: "com.tibco", ex: false, ok: true },
        { s: "com.*", p: "com.tibco", ex: false, ok: true },
        { s: "*.tibco", p: "com.tibco", ex: false, ok: true },
        { s: "*.*", p: "com.tibco", ex: false, ok: true },
        { s: "*.**", p: "com.tibco", ex: false, ok: true },
        { s: "com.tibco", p: "com.tibco.foo", ex: false, ok: false },
        { s: "com.tibco", p: "com", ex: false, ok: false },
        { s: "com.tibco", p: "com.tibco", ex: false, ok: true },
        { s: "a.b.c", p: "a.b.c", ex: false, ok: true },
        { s: "a.b.*", p: "a.b.c", ex: false, ok: true },
        { s: "a.*.c", p: "a.b.c", ex: false, ok: true },
        { s: "*.b.c", p: "a.b.c", ex: false, ok: true },
        { s: "*.*.c", p: "a.b.c", ex: false, ok: true },
        { s: "a.*.*", p: "a.b.c", ex: false, ok: true },
        { s: "*.*.*", p: "a.b.c", ex: false, ok: true },
        { s: "*.**", p: "a.b.c", ex: false, ok: true },
        { s: "a.b.c", p: "a.b.c", ex: false, ok: true },
        { s: "a.b.c.d.e.f.g.h.i.j", p: "a.b.c.d.e.f.g.h.i.j", ex: false, ok: true },
        { s: "a.**", p: "a.b.c.d.e.f.g.h.i.j", ex: false, ok: true },
        { s: "aa.*.cc.*.e.f.g.h.i.j", p: "aa.b.cc.d.e.f.g.h.i.j", ex: false, ok: true },
        { s: "1", p: "1", ex: false, ok: true },
        { s: "*", p: "1", ex: false, ok: true },
        { s: "1.0", p: "1.0", ex: false, ok: true },
        { s: "1.0.5", p: "1.0.5", ex: false, ok: true },
        { s: "1.0.*", p: "1.0.5", ex: false, ok: true },
        { s: "*.1.0", p: "1.1.0", ex: false, ok: true },
        { s: "false", p: "false", ex: false, ok: true },
        { s: "false.true", p: "false.true", ex: false, ok: true },
        { s: "return", p: "return", ex: false, ok: true },
        { s: "x.length", p: "x.length", ex: false, ok: true },
        { s: "function", p: "function", ex: false, ok: true },
        { s: "null", p: "null", ex: false, ok: true },
        { s: "*", p: "null", ex: false, ok: true },
        { s: "this", p: "this", ex: false, ok: true },
        { s: "*", p: "this", ex: false, ok: true },
        { s: "abc=", p: "abc=", ex: false, ok: true },
        { s: "二.重.橋", p: "二.重.橋", ex: false, ok: true },
        { s: "*.重.橋", p: "二.重.橋", ex: false, ok: true },
        { s: "二.*.橋", p: "二.重.橋", ex: false, ok: true },
        { s: "二.**", p: "二.重.橋", ex: false, ok: true },
        { s: "**", p: "二.重.橋", ex: false, ok: true },
        { s: "$", p: "$", ex: false, ok: true },
        { s: "a/b.c/d", p: "a/b.c/d", ex: false, ok: true }, 
        { s: "[.]", p: "[.]", ex: false, ok: true },
        { s: "^.&", p: "^.&", ex: false, ok: true },
        { s: "@.%.#.).(,;.A", p: "@.%.#.).(,;.A", ex: false, ok: true },
        { s: "A.B.C", p: "a.b.c", ex: false, ok: false },
        { s: "a.b.c", p: "A.B.C", ex: false, ok: false }
    ],

    expectedResult: [
		"1.2.1: start, ",
		"OK: cb: abc, ", "OK: completed 0, ", "OK: completed 1, ", "OK: completed 2, ",
        "OK: cb: abc, ", "OK: completed 3, ",
        "OK: cb: abc, ", "OK: completed 4, ",
        "OK: cb: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, ",
        "OK: completed 5, ", "OK: cb: abc.def.ghi, ", "OK: completed 6, ", "OK: completed 7, ", "OK: cb: a, ",
        "OK: completed 8, ", "OK: cb: abc, ", "OK: completed 9, ", "OK: cb: com.tibco, ", "OK: completed 10, ",
        "OK: cb: com.tibco, ", "OK: completed 11, ",
        "OK: cb: com.tibco, ", "OK: completed 12, ", "OK: cb: com.tibco, ", "OK: completed 13, ", "OK: cb: com.tibco, ",
        "OK: completed 14, ", "OK: completed 15, ", "OK: completed 16, ", "OK: cb: com.tibco, ", "OK: completed 17, ",
        "OK: cb: a.b.c, ", "OK: completed 18, ", "OK: cb: a.b.c, ", "OK: completed 19, ", "OK: cb: a.b.c, ", "OK: completed 20, ",
        "OK: cb: a.b.c, ", "OK: completed 21, ", "OK: cb: a.b.c, ", "OK: completed 22, ", "OK: cb: a.b.c, ", "OK: completed 23, ",
        "OK: cb: a.b.c, ", "OK: completed 24, ", "OK: cb: a.b.c, ", "OK: completed 25, ", "OK: cb: a.b.c, ", "OK: completed 26, ",
        "OK: cb: a.b.c.d.e.f.g.h.i.j, ", "OK: completed 27, ", "OK: cb: a.b.c.d.e.f.g.h.i.j, ", "OK: completed 28, ",
        "OK: cb: aa.b.cc.d.e.f.g.h.i.j, ", "OK: completed 29, ",
        "OK: cb: 1, ", "OK: completed 30, ", "OK: cb: 1, ",
        "OK: completed 31, ", "OK: cb: 1.0, ", "OK: completed 32, ", "OK: cb: 1.0.5, ", "OK: completed 33, ", "OK: cb: 1.0.5, ",
        "OK: completed 34, ", "OK: cb: 1.1.0, ", "OK: completed 35, ", "OK: cb: false, ", "OK: completed 36, ", "OK: cb: false.true, ",
        "OK: completed 37, ", "OK: cb: return, ", "OK: completed 38, ", "OK: cb: x.length, ", "OK: completed 39, ",
        "OK: cb: function, ", "OK: completed 40, ", "OK: cb: null, ", "OK: completed 41, ", "OK: cb: null, ",
        "OK: completed 42, ", "OK: cb: this, ", "OK: completed 43, ", "OK: cb: this, ", "OK: completed 44, ", "OK: cb: abc=, ", "OK: completed 45, ",
        "OK: cb: 二.重.橋, ", "OK: completed 46, " ,
        "OK: cb: 二.重.橋, ", "OK: completed 47, " ,
        "OK: cb: 二.重.橋, ", "OK: completed 48, " ,
        "OK: cb: 二.重.橋, ", "OK: completed 49, " ,
        "OK: cb: 二.重.橋, ", "OK: completed 50, " ,
        "OK: cb: $, ", "OK: completed 51, " ,
        "OK: cb: a/b.c/d, ", "OK: completed 52, " ,
        "OK: cb: [.], ", "OK: completed 53, " ,
        "OK: cb: ^.&, ", "OK: completed 54, " ,
        "OK: cb: @.%.#.).(,;.A, ", "OK: completed 55, " ,
        "OK: completed 56, "  ,
        "OK: completed 57, "
	],

	f1: function(scriptnum) {
		var i = scriptnum;
		this.i = i;
        try {
			if (i == 0) {
				this.hubClient.subscribe( "js1_2_1.unsubscribe", js1_2_1._subCBControl, this, js1_2_1._cbControl );
			}
            this.sub = null;
            this.hubClient.subscribe( js1_2_1.events[i].s, js1_2_1._subCB, this, js1_2_1._cb );
        } catch( err ) {
            js1_2_1._handleException( err );
        }
	},
    _subCBControl: function( topic, subID )
    {
		this.hubClient.unsubscribe( subID, js1_2_1._unsubCB, this );
		this.sub = null;
    },
    _cbControl: function( subscriptionID, success, errCode )
    {
        if ( !success ) {
            js1_2_1._handleException( new Error( "subscribe to " + js1_2_1.events[ this.i ].s + " failed" ) );
        }
    },
    _subCB: function( topic, data )
    {
		// When running these tests against the UnmanagedHub, the UnmanagedHub and
		// the test case (with its private control.* messages) shared the same event space.
		// Ignore any messages that begin with "control."
		if (topic.substr(0,8) != "control.") {
			this.appendResult("OK: cb: " + topic + ", ");
		}
        return;
    },
    
    _cb: function( subscriptionID, success, errCode )
    {
        if ( !success ) {
            js1_2_1._handleException( new Error( "subscribe to " + js1_2_1.events[ this.i ].s + " failed" ) );
        } else {
            this.sub = subscriptionID;
        
            try {
                var i = this.i;
                this.hubClient.publish( js1_2_1.events[i].p, {} );

				// Because of iframe async delivery, move the unsubscribe logic
				// into a callback function so that the unsubscribe happens
				// after the subscribe callback is invoked for the preceding publish event.
					//this.hubClient.unsubscribe( this.sub, js1_2_1._unsubCB, this );
					//this.sub = null;
                this.hubClient.publish( "js1_2_1.unsubscribe", subscriptionID );

                if( js1_2_1.events[i].ex == false ) {
                    this.appendResult("OK: completed " + i + ", ");
                } else {
                    this.appendResult("ERROR: subscribe should have failed on " + i + ", ");
				}
				if (i == (js1_2_1.events.length-1) ) {
					var that = this;
					setTimeout( function() {
						// Tell test harness that test case has completed its work.
						that.sendMsg("testlogiccompleted");
					}, 0 );
				}
            } catch( err ) {
                js1_2_1._handleException( err );
            }
        }

    },
    
    _handleException: function( err )
    {
        var i = this.i;
        if ( js1_2_1.events[i].ex == true ) {
            this.appendResult("OK: expected exception on iteration " + i + ": " + err.message + ", ");
        } else {
            this.appendResult("ERROR: on iteration " + i + ": " + err.message + ", ");
        }
        
        if ( this.sub != null ) {
            this.hubClient.unsubscribe( this.sub, js1_2_1._unsubCB, this );
        }
    },
    
    _unsubCB: function( subscriptionID, success, errCode )
    {
        if ( !success ) {
            this.sub = null;  // prevent infinite unsubscribe loop in _handleException
            js1_2_1._handleException( new Error( "unsubscribe to " + js1_2_1.events[ this.i ].s + " failed" ) );
        }
    }

};

/***********************************************************************
 *  js1_3_1
 **********************************************************************/

var js1_3_1 = {

    events: [
        { i: 0, e: "A" },
        { i: 1, e: "A.A" },
        { i: 2, e: "A.A.A" },
        { i: 3, e: "A.A.B" },
        { i: 4, e: "A.B" },
        { i: 5, e: "A.B.A" },
        { i: 6, e: "A.B.B" },
        { i: 12, e: "B.B.B" },
        { i: 11, e: "B.B" },
        { i: 7, e: "B" },
        { i: 8, e: "B.A" },
        { i: 9, e: "B.A.A" },
        { i: 10, e: "B.A.B" },
        { i: 17, e: "B.B.A" }
    ],

	expectedResult: [
		[],
		["OK: 13 subscribed B.B.B.X.Y, ","OK: cb: B.B.B.X.Y, ","OK: published B.B.B.X.Y, ","OK: unsubscribed 13, "],
		["OK: cb: B.B.B, ","OK: published B.B.B (expect to have received callback), "],
		["OK: 13 subscribed B.B.B.M.N, ","OK: 14 subscribed B.B.B.M.P, "],
		["OK: unsubscribed 13, ","OK: cb: B.B.B.M.P, ","OK: published B.B.B.M.P (expect to have received callback), "],
		["OK: cb: B.A, ","OK: published B.A, "],
		["OK: 15 and 16 subscribed A.A.A, ","OK: cb: A.A.A, ","OK: cb: A.A.A#1, ","OK: cb: A.A.A#2, ","OK: published to A.A.A (expect to have gotten 3 callbacks), "],
		["OK: unsubscribed 15, ","OK: cb: A.A.A, ","OK: cb: A.A.A#2, ","OK: published to A.A.A (expect to have gotten 2 callbacks), "],
		["OK: unsubscribed 2, ","OK: cb: A.A.A#2, ","OK: published to A.A.A (expect to have gotten 1 callback), "],
		["OK: unsubscribed 16, ","OK: published to A.A.A (expect to have gotten ZERO callbacks), "],
		[]
	],

	onComplete: function( subscriptionID, success, errCode ) {
        if ( !success ) {
            throw new Error( this.test.name + ": subscribe to " + this.subscriberData + " failed" );
        }
        js1_3_1.sub[ this.id ] = subscriptionID;
        js1_3_1.this_obj[ this.id ] = this;
    },

	cb: function(event, message, subscriberData) {
		if(subscriberData == "B.B.B.X.Y") {
			// created the leaf subscription
			this.test.appendToResultArray(this.test.scriptnum, "OK: cb: B.B.B.X.Y, ");
		}
		else if(subscriberData == "B.B.B") {
			// removed the leaf subscription, peeling branch back to
			// B.B.B. The B.B.B subscription remained intact.
			this.test.appendToResultArray(this.test.scriptnum, "OK: cb: B.B.B, ");
		}
		else if(subscriberData == "B.B.B.M.P") {
			// removed the leaf subscription B.B.B.M.N, peeling branch 
			// back to B.B.B.M The B.B.B.M subscription remained intact
			// because of the other subscripton to B.B.B.M.P
			this.test.appendToResultArray(this.test.scriptnum, "OK: cb: B.B.B.M.P, ");
		}
		else if(subscriberData == "B.A") {
			// Tests intermediate node, rather than leaf node
			// not a leaf. 
			this.test.appendToResultArray(this.test.scriptnum, "OK: cb: B.A, ");
		}
		else if((subscriberData == "A.A.A") || (subscriberData == "A.A.A#1") || (subscriberData == "A.A.A#2")) {
			// Tests intermediate node, rather than leaf node. Expect 3 callbacks
			this.test.appendToResultArray(this.test.scriptnum, "OK: cb: " + subscriberData + ", ");
		}
		return;
	},

	f1: function(scriptnum) {
		this.scriptnum = scriptnum;

		if (scriptnum == 0) {
			js1_3_1.sub = [];
			js1_3_1.this_obj = [];
			for ( var i = 0; i < js1_3_1.events.length; i++ ) {
				var data1 = {};
				data1.id = js1_3_1.events[i].i;
				data1.subscriberData = js1_3_1.events[i].e;
				data1.test = this;
				this.hubClient.subscribe( js1_3_1.events[i].e, js1_3_1.cb, data1, js1_3_1.onComplete, js1_3_1.events[i].e );
			}

		} else if (scriptnum == 1) {
			// subscribe to leaf node, publish to it, unsubscribe from it
			var data2 = {
				id: 13,
				subscriberData: "B.B.B.X.Y",
				test: this
			};
			this.hubClient.subscribe("B.B.B.X.Y", js1_3_1.cb, data2, js1_3_1.onComplete, data2.subscriberData);
			this.appendToResultArray(scriptnum,"OK: 13 subscribed B.B.B.X.Y, ");
			this.hubClient.publish("B.B.B.X.Y", {});
			this.appendToResultArray(scriptnum,"OK: published B.B.B.X.Y, ");
			// unsubscribe asynchronously so that js1_3_1.sub[13] will have a value before async is called
			var that = this;
			setTimeout(function() {
				that.hubClient.unsubscribe(js1_3_1.sub[13]);
			} , 0);
			this.appendToResultArray(scriptnum,"OK: unsubscribed 13, ");

		} else if (scriptnum == 2) {
			// publish to what is now the leaf node after the unsubscribe of its last descendant
			this.hubClient.publish("B.B.B", {});
			this.appendToResultArray(scriptnum,"OK: published B.B.B (expect to have received callback), ");

		} else if (scriptnum == 3) {
			// subscribe to two leaf nodes on separate branches below this node
			var data3 = {
				id: 13,
				subscriberData: "B.B.B.M.N",
				test: this
			};
			this.hubClient.subscribe("B.B.B.M.N", js1_3_1.cb, data3, js1_3_1.onComplete, data3.subscriberData);
			this.appendToResultArray(scriptnum,"OK: 13 subscribed B.B.B.M.N, ");
			var data4 = {
				id: 14,
				subscriberData: "B.B.B.M.P",
				test: this
			};
			this.hubClient.subscribe("B.B.B.M.P", js1_3_1.cb, data4, js1_3_1.onComplete, data4.subscriberData);
			this.appendToResultArray(scriptnum,"OK: 14 subscribed B.B.B.M.P, ");

		} else if (scriptnum == 4) {
			// unsubscribe from one of the two leaf nodes, causing that branch to
			// be rolled back but not affecting the other branch. Then publish to
			// the other branch to confirm that it still exists.
			this.hubClient.unsubscribe(js1_3_1.sub[13]);
			this.appendToResultArray(scriptnum,"OK: unsubscribed 13, ");
			this.hubClient.publish("B.B.B.M.P", {});
			this.appendToResultArray(scriptnum,"OK: published B.B.B.M.P (expect to have received callback), ");

		} else if (scriptnum == 5) {
			// Now publish to an intermediate node
			this.hubClient.publish("B.A", {});
			this.appendToResultArray(scriptnum,"OK: published B.A, ");

		} else if (scriptnum == 6) {
			// Now create several additional subscriptions to a leaf node
			var data5 = {
				id: 15,
				subscriberData: "A.A.A#1",
				test: this
			};
			this.hubClient.subscribe("A.A.A", js1_3_1.cb, data5, js1_3_1.onComplete, data5.subscriberData); // #2
			var data6 = {
				id: 16,
				subscriberData: "A.A.A#2",
				test: this
			};
			this.hubClient.subscribe("A.A.A", js1_3_1.cb, data6, js1_3_1.onComplete, data6.subscriberData); // #3
			this.appendToResultArray(scriptnum,"OK: 15 and 16 subscribed A.A.A, ");
			this.hubClient.publish("A.A.A", {});
			this.appendToResultArray(scriptnum,"OK: published to A.A.A (expect to have gotten 3 callbacks), ");

		} else if (scriptnum == 7) {
			// Unsubscribe the 2nd (middle) one
			this.hubClient.unsubscribe(js1_3_1.sub[15]);
			this.appendToResultArray(scriptnum,"OK: unsubscribed 15, ");
			this.hubClient.publish("A.A.A", {});
			this.appendToResultArray(scriptnum,"OK: published to A.A.A (expect to have gotten 2 callbacks), ");

		} else if (scriptnum == 8) {
			// Unsubscribe the 1st one
			this.hubClient.unsubscribe(js1_3_1.sub[2]);
			this.appendToResultArray(scriptnum,"OK: unsubscribed 2, ");
			this.hubClient.publish("A.A.A", {});
			this.appendToResultArray(scriptnum,"OK: published to A.A.A (expect to have gotten 1 callback), ");

		} else if (scriptnum == 9) {		
			// Unsubscribe the 3rd (last) one
			this.hubClient.unsubscribe(js1_3_1.sub[16]);
			this.appendToResultArray(scriptnum,"OK: unsubscribed 16, ");
			this.hubClient.publish("A.A.A", {});
			this.appendToResultArray(scriptnum,"OK: published to A.A.A (expect to have gotten ZERO callbacks), ");

		} else if (scriptnum == 10) {
			this.hubClient.unsubscribe(js1_3_1.sub[0]);
			this.hubClient.unsubscribe(js1_3_1.sub[1]);
			this.hubClient.unsubscribe(js1_3_1.sub[3]);
			this.hubClient.unsubscribe(js1_3_1.sub[4]);
			this.hubClient.unsubscribe(js1_3_1.sub[5]);
			this.hubClient.unsubscribe(js1_3_1.sub[6]);
			this.hubClient.unsubscribe(js1_3_1.sub[7]);
			this.hubClient.unsubscribe(js1_3_1.sub[8]);
			this.hubClient.unsubscribe(js1_3_1.sub[9]);
			this.hubClient.unsubscribe(js1_3_1.sub[10]);
			this.hubClient.unsubscribe(js1_3_1.sub[11]);
			this.hubClient.unsubscribe(js1_3_1.sub[12]);
			this.hubClient.unsubscribe(js1_3_1.sub[14]);
			this.hubClient.unsubscribe(js1_3_1.sub[17]);

			// Tell test harness that test case has completed its work.
			this.sendMsg("testlogiccompleted");
		}
	}
}

/***********************************************************************
 *  js2_2
 **********************************************************************/
var js2_2 = {

	f1: function(scriptnum) {
		this.scriptnum = scriptnum;

		if (scriptnum == 0) {
			this.hubClient.subscribe( "js2_2.finished", js2_2._subCBControl, this );

			this.hubClient.subscribe("alef", js2_2._subCB, this, function() {}, "alef");
			this.hubClient.subscribe("alef.bet", js2_2._subCB, this, function() {}, "alef.bet");
			this.hubClient.subscribe("alef.bet.gimel", js2_2._subCB, this, function() {}, "alef.bet.gimel");
			this.hubClient.subscribe("*.bet.gimel", js2_2._subCB, this, function() {}, "*.bet.gimel");
			this.hubClient.subscribe("alef.*.gimel", js2_2._subCB, this, function() {}, "alef.*.gimel");
			this.hubClient.subscribe("alef.bet.*", js2_2._subCB, this, function() {}, "alef.bet.*");
			this.hubClient.subscribe("*.*.gimel", js2_2._subCB, this, function() {}, "*.*.gimel");
			this.hubClient.subscribe("*.*.gimel", js2_2._subCB, this, function() {}, "*.*.gimel (2)");	// 2nd
			this.hubClient.subscribe("alef.*.*", js2_2._subCB, this, function() {}, "alef.*.*");
			this.hubClient.subscribe("*.*.*", js2_2._subCB, this, function() {}, "*.*.*");
			this.hubClient.subscribe("*", js2_2._subCB, this, function() {}, "*");
			this.hubClient.subscribe("*.*", js2_2._subCB, this, function() {}, "*.*");
			this.hubClient.subscribe("alef.bet.**", js2_2._subCB, this, function() {}, "alef.bet.**");
			this.hubClient.subscribe("alef.**", js2_2._subCB, this, function() {}, "alef.**");
			this.hubClient.subscribe("**", js2_2._subCB, this, function() {}, "**");
			this.hubClient.subscribe("*.bet.**", js2_2._subCB, this, function() {}, "*.bet.**");
			this.hubClient.subscribe("alef.bet.gimel", js2_2._subCB, this, function() {}, "alef.bet.gimel (2)");	// 2nd
			this.hubClient.subscribe("*.**", js2_2._subCB, this, function() {}, "*.**");
			this.hubClient.subscribe("*.**", js2_2._subCB, this, function() {}, "*.** (2)");		// 2nd
			this.hubClient.subscribe("chet.tet.yud", js2_2._subCB, this, function() {}, "chet.tet.yud");

			this.appendToResultArray(0, "OK: publish alef (expect 3 callbacks), ");
			this.hubClient.publish("alef", 0);
			this.appendToResultArray(1, "OK: publish bet (expect 2 callbacks), ");
			this.hubClient.publish("bet", 1);
			this.appendToResultArray(2, "OK: publish alef.bet (expect 6 callbacks), ");
			this.hubClient.publish("alef.bet", 2);
			this.appendToResultArray(3, "OK: publish alef.gimel (expect 5 callbacks), ");
			this.hubClient.publish("alef.gimel", 3);
			this.appendToResultArray(4, "OK: publish alef.bet.gimel (expect 15 callbacks), ");
			this.hubClient.publish("alef.bet.gimel", 4);
			this.appendToResultArray(5, "OK: publish alef.bet.gimel.dalet (expect 6 callbacks), ");
			this.hubClient.publish("alef.bet.gimel.dalet", 5);
			this.appendToResultArray(6, "OK: publish dalet.bet.gimel (expect 8 callbacks), ");
			this.hubClient.publish("dalet.bet.gimel", 6);
			this.appendToResultArray(7, "OK: publish lamed.mem.gimel (expect 6 callbacks), ");
			this.hubClient.publish("lamed.mem.gimel", 7);
			this.appendToResultArray(8, "OK: publish alef.dalet (expect 5 callbacks), ");
			this.hubClient.publish("alef.dalet", 8);
			this.appendToResultArray(9, "OK: publish lamed.mem.nun.samekh (expect 3 callbacks), ");
			this.hubClient.publish("lamed.mem.nun.samekh", 9);

			this.hubClient.publish("js2_2.finished", null);
		}
	},

	expectedResult: [["OK: publish alef (expect 3 callbacks), ","OK: cb: for alef, ","OK: cb: for *, ","OK: cb: for **, "],
		["OK: publish bet (expect 2 callbacks), ","OK: cb: for *, ","OK: cb: for **, "],
		["OK: publish alef.bet (expect 6 callbacks), ","OK: cb: for alef.bet, ","OK: cb: for alef.**, ",
			"OK: cb: for *.*, ","OK: cb: for *.**, ","OK: cb: for *.** (2), ","OK: cb: for **, "],
		["OK: publish alef.gimel (expect 5 callbacks), ","OK: cb: for alef.**, ","OK: cb: for *.*, ",
			"OK: cb: for *.**, ","OK: cb: for *.** (2), ","OK: cb: for **, "],
		["OK: publish alef.bet.gimel (expect 15 callbacks), ",
			"OK: cb: for alef.bet.gimel, ","OK: cb: for alef.bet.gimel (2), ","OK: cb: for alef.bet.*, ",
			"OK: cb: for alef.bet.**, ","OK: cb: for alef.*.gimel, ","OK: cb: for alef.*.*, ","OK: cb: for alef.**, ",
			"OK: cb: for *.bet.gimel, ","OK: cb: for *.bet.**, ","OK: cb: for *.*.gimel, ","OK: cb: for *.*.gimel (2), ",
			"OK: cb: for *.*.*, ","OK: cb: for *.**, ","OK: cb: for *.** (2), ","OK: cb: for **, "],
		["OK: publish alef.bet.gimel.dalet (expect 6 callbacks), ","OK: cb: for alef.bet.**, ","OK: cb: for alef.**, ",
			"OK: cb: for *.bet.**, ","OK: cb: for *.**, ","OK: cb: for *.** (2), ","OK: cb: for **, "],
		["OK: publish dalet.bet.gimel (expect 8 callbacks), ","OK: cb: for *.bet.gimel, ","OK: cb: for *.bet.**, ",
			"OK: cb: for *.*.gimel, ",
			"OK: cb: for *.*.gimel (2), ","OK: cb: for *.*.*, ","OK: cb: for *.**, ","OK: cb: for *.** (2), ",
			"OK: cb: for **, "],
		["OK: publish lamed.mem.gimel (expect 6 callbacks), ","OK: cb: for *.*.gimel, ",
			"OK: cb: for *.*.gimel (2), ","OK: cb: for *.*.*, ","OK: cb: for *.**, ","OK: cb: for *.** (2), ",
			"OK: cb: for **, "],
		["OK: publish alef.dalet (expect 5 callbacks), ","OK: cb: for alef.**, ","OK: cb: for *.*, ",
			"OK: cb: for *.**, ","OK: cb: for *.** (2), ","OK: cb: for **, "],
		["OK: publish lamed.mem.nun.samekh (expect 3 callbacks), ",
			"OK: cb: for *.**, ","OK: cb: for *.** (2), ","OK: cb: for **, "]
	],
       
    onCompleteCB: function( subscriptionID, success, errCode ) {
        if ( !success ) {
            this.appendToResultArray(this.id, ", ERROR: subscribe for " + this.subscriberData + " failed");
        }
    },
            
    _subCB: function( topic, data, subscriberData )
    {
		if (topic !== "js2_2.finished") {
			this.appendToResultArray(data, "OK: cb: for " + subscriberData + ", ");
		}
    },

    _subCBControl: function( topic, data )
    {
		// Tell test harness that test case has completed its work.
		this.sendMsg("testlogiccompleted");
    }
}

/***********************************************************************
 *  js3_1
 **********************************************************************/

var js3_1 = {};

js3_1.expectedResult = ["OK: begin pub.same, OK: end pub.same, ",
		"OK: begin pub.other, OK: end pub.other, ",
		"OK: begin sub.same, OK: end sub.same, ",
		"OK: begin sub.other, OK: end sub.other, ",
		"OK: begin unsub.same, OK: end unsub.same, ",
		"OK: begin unsub.other, OK: end unsub.other, ",
		"OK: begin unsub.this, OK: end unsub.this, ",
		"OK: begin sub.pub.same, OK: end sub.pub.same, ",
		"OK: begin sub.pub.other, OK: end sub.pub.other, "];

js3_1.cbPubSame = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		/* setup is OK */  
	} else if(message.step == "fire") { 
		js3_1.indirect_publish.call(this, subject, { step: "check" });
	} else if(message.step == "check") {
		/* message received */
	} else {
		this.appendToResultArray(this.scriptnum, "ERROR: invalid step " + message.step + ", ");
	}
	this.incrementCounterArray(this.scriptnum, message.step + subscriberData);
	return;
}

js3_1.cbPubOther = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		/* setup is OK */
	} else if(message.step == "fire") {
		js3_1.indirect_publish.call(this, "pub.other.target", { step: "check" });
	} else if(message.step == "check") {
		/* message received */
	} else {
		this.appendToResultArray(this.scriptnum, "ERROR: invalid step " + message.step + ", ");	
	}
	this.incrementCounterArray(this.scriptnum, message.step + subscriberData);
	return;
}

js3_1.cbSubSame = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		/* setup is OK */
	} else if(message.step == "fire") {
		js3_1.indirect_subscribe.call(this, subject, js3_1.cbSubSame, this, js3_1.onComplete_subSubSameSubjectTarget, "_target");
	} else if(message.step == "check") {
		/* message received */
	} else  {
		this.appendToResultArray(this.scriptnum, "ERROR: invalid step " + message.step + ", ");	
	}
	this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
	return;
}

js3_1.cbSubOther = function(subject, message, subscriberData) {
	if(message.step == "setup") { 
		/* setup is OK */
	} else if(message.step == "fire") {
		js3_1.indirect_subscribe.call(this, "sub.other.target", js3_1.cbSubOther, this, js3_1.onComplete_subSubOtherSubjectTarget_2, "_target");
	} else if(message.step == "check") {
		/* message received */
	} else  {
		this.appendToResultArray(this.scriptnum, "ERROR: invalid step " + message.step + ", ");	
	}
	this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
	return;
}

js3_1.cbUnsubSame = function(subject, message, subscriberData) {
	if(message.step == "setup") { 
		/* setup is OK */
		this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
	} else if(message.step == "fire") {
		if(subscriberData == "_trigger") {
			js3_1.indirect_unsubscribe.call(this, this.subUnsubSameSubjectTarget);
			this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
		}
	} else if(message.step == "check") { 
		/* message received */ 
		this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
	} else {
		this.appendToResultArray(this.scriptnum, "ERROR: invalid step " + message.step + ", ");	
		this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
	}
	return;
}

js3_1.cbUnsubOther = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		/* setup is OK */
	} else if(message.step == "fire") {
		js3_1.indirect_unsubscribe.call(this, this.subUnsubOtherTarget);
	} else if(message.step == "check") {
		/* message received */
	} else {
		this.appendToResultArray(this.scriptnum, "ERROR: invalid step " + message.step + ", ");	
	}
	this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
	return;
}

js3_1.cbUnsubThis = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		/* setup is OK */
	} else if(message.step == "fire") {
		js3_1.indirect_unsubscribe.call(this, this.subUnsubThis);
	} else if(message.step == "check") {
		/* message received */
	} else {
		this.appendToResultArray(this.scriptnum, "ERROR: invalid step " + message.step + ", ");	
	}
	this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
	return;
}

js3_1.cbSubPubSame = function(subject, message, subscriberData) {
	if(message.step == "setup")  
		{ /* setup is OK */ }
	else if(message.step == "fire") {
		js3_1.indirect_subscribe.call(this, subject, js3_1.cbSubPubSame, this, js3_1.onComplete_subSubPubSameSubjectTarget, "_target");
		js3_1.indirect_publish.call(this, subject, { step: "check1" });
	}
	else if(message.step == "check1") 
		{ /* message received. should be received ONCE FOR _trigger & ONCE FOR _target. */ }
	else if(message.step == "check2") 
		{ /* message received. should be received ONCE FOR _trigger & ONCE FOR _target. */ }
	else
		this.appendToResultArray(this.scriptnum, "ERROR: invalid step " + message.step + ", ");	
	this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
	return;
}

js3_1.cbSubPubOther = function(subject, message, subscriberData) {
	var pubSubject = "sub.pub.other.target";
	if(message.step == "setup")  
		{ /* setup is OK */ }
	else if(message.step == "fire") {
		js3_1.indirect_subscribe.call(this, pubSubject, js3_1.cbSubPubOther, this, js3_1.onComplete_subSubPubOtherSubjectTarget_2, "_target");
		js3_1.indirect_publish.call(this, pubSubject, { step: "check1" });
	}
	else if(message.step == "check1") 
		{ /* message received. should be received ONCE FOR _target ONLY. */ }
	else if(message.step == "check2") 
		{ /* message received. should be received ONCE FOR _target ONLY. */ }
	else  
		this.appendToResultArray(this.scriptnum, "ERROR: invalid step " + message.step + ", ");	
	this.incrementCounterArray(this.scriptnum, message.step  + subscriberData);
	return;
}

// Timed publish/subscribe/unsubscribe routines. The main body of the test case doesn't call Hub APIs directly
// but instead sends a message through the Hub to this callback which then calls publish().
// This is key to making sure that particular actions in this test case happen in a particular order.
js3_1.indirect_publish = function(topic, data) {
	js3_1.publishcounter++;
	this.hubClient.publish("js3_1.timedpublish", {topic:topic, data:data});
}
js3_1.timedPublishCB = function( topic, data, subscriberData ) {
	this.hubClient.publish(data.topic, data.data);
}
js3_1.subscribecounter = 0;
js3_1.subscribedata = [];
js3_1.indirect_subscribe = function(topic, onData, scope, onComplete, subscriberData) {
	var counter = js3_1.subscribecounter;
	js3_1.subscribedata[counter] = {topic:topic, onData:onData, scope:scope, onComplete:onComplete, subscriberData:subscriberData};	
	this.hubClient.publish("js3_1.timedsubscribe", counter);
	js3_1.subscribecounter++;
}
js3_1.timedSubscribeCB = function( topic, data, subscriberData ) {
	var o = js3_1.subscribedata[data];
	this.hubClient.subscribe(o.topic, o.onData, o.scope, o.onComplete, o.subscriberData);
}
js3_1.indirect_unsubscribe = function(subscriptionID) {
	this.hubClient.publish("js3_1.timedunsubscribe", subscriptionID);
}
js3_1.timedUnsubscribeCB = function( topic, data, subscriberData ) {
	this.hubClient.unsubscribe(data); // data=subscriptionID
}
js3_1.indirect_sendMsg = function( msg ) {
	var that = this;
	that.hubClient.publish("js3_1.timedsendMsg", msg);
}
js3_1.indirect_sendMsg_CB = function( topic, data, subscriberData ) {
	this.sendMsg(data); // data=msg
}

// The following onComplete functions capture the subscriber ID for various subscriptions.
js3_1.onComplete_subPubSameSubjectTrigger = function( subscriptionID, success, errCode ) {
	this.subPubSameSubjectTrigger = subscriptionID;
}
js3_1.onComplete_subPubOtherSubjectTrigger = function( subscriptionID, success, errCode ) {
	this.subPubOtherSubjectTrigger = subscriptionID;
}
js3_1.onComplete_subPubOtherSubjectTarget_1 = function( subscriptionID, success, errCode ) {
	this.subPubOtherSubjectTarget_1 = subscriptionID;
}
js3_1.onComplete_subSubSameSubjectTrigger_1 = function( subscriptionID, success, errCode ) {
	this.subSubSameSubjectTrigger_1 = subscriptionID;
}
js3_1.onComplete_subSubOtherSubjectTrigger = function( subscriptionID, success, errCode ) {
	this.subSubOtherSubjectTrigger = subscriptionID;
}
js3_1.onComplete_subUnsubSameSubjectTrigger = function( subscriptionID, success, errCode ) {
	this.subUnsubSameSubjectTrigger = subscriptionID;
}
js3_1.onComplete_subUnsubSameSubjectTarget = function( subscriptionID, success, errCode ) {
	this.subUnsubSameSubjectTarget = subscriptionID;
}
js3_1.onComplete_subUnsubOtherTrigger = function( subscriptionID, success, errCode ) {
	this.subUnsubOtherTrigger = subscriptionID;
}
js3_1.onComplete_subUnsubOtherTarget = function( subscriptionID, success, errCode ) {
	this.subUnsubOtherTarget = subscriptionID;
}
js3_1.onComplete_subUnsubThis = function( subscriptionID, success, errCode ) {
	this.subUnsubThis = subscriptionID;
}
js3_1.onComplete_subSubSameSubjectTrigger_2 = function( subscriptionID, success, errCode ) {
	this.subSubSameSubjectTrigger_2 = subscriptionID;
}
js3_1.onComplete_subSubOtherSubjectTarget_1 = function( subscriptionID, success, errCode ) {
	this.subSubOtherSubjectTarget_1 = subscriptionID;
}
js3_1.onComplete_subSubPubOtherSubjectTarget_2 = function( subscriptionID, success, errCode ) {
	this.subSubPubOtherSubjectTarget_2 = subscriptionID;
}
js3_1.onComplete_subSubSameSubjectTarget = function( subscriptionID, success, errCode ) {
	this.subSubSameSubjectTarget = subscriptionID;
}
js3_1.onComplete_subSubOtherSubjectTarget_2 = function( subscriptionID, success, errCode ) {
	this.subSubOtherSubjectTarget_2 = subscriptionID;
}
js3_1.onComplete_subSubPubSameSubjectTarget = function( subscriptionID, success, errCode ) {
	this.subSubPubSameSubjectTarget = subscriptionID;
}


js3_1.run = function(scriptnum) {
	this.scriptnum = scriptnum;
	var that = this;

	if (scriptnum == 0) {
		// The various calls to publish()/etc need to go through the timedPublish/etc
		// callback to make sure that the events in the test case happen in a particular
		// order.
		this.hubClient.subscribe("js3_1.timedpublish", js3_1.timedPublishCB, this);
		this.hubClient.subscribe("js3_1.timedsubscribe", js3_1.timedSubscribeCB, this);
		this.hubClient.subscribe("js3_1.timedunsubscribe", js3_1.timedUnsubscribeCB, this);
		this.hubClient.subscribe("js3_1.timedsendMsg", js3_1.indirect_sendMsg_CB, this);

		// In callback for topic X, publish on topic X
		this.appendToResultArray(scriptnum, "OK: begin pub.same, "); 
		js3_1.indirect_subscribe.call(this, "pub.same", js3_1.cbPubSame, this, js3_1.onComplete_subPubSameSubjectTrigger, "");
		js3_1.indirect_publish.call(this, "pub.same", { step: "setup" });
		setTimeout(function() {
			js3_1.indirect_publish.call(that, "pub.same", { step: "fire" });
			setTimeout(function() {
				that.appendToResultArray(scriptnum, "OK: end pub.same, "); 
				js3_1.indirect_sendMsg.call(that, "ready_for_next_command");
			}, 100);
		}, 100);

	} else if (scriptnum == 1) {
		this.appendToResultArray(scriptnum, "OK: begin pub.other, "); 
		js3_1.indirect_subscribe.call(this, "pub.other.trigger", js3_1.cbPubOther, this, js3_1.onComplete_subPubOtherSubjectTrigger, "_trigger");
		js3_1.indirect_subscribe.call(this, "pub.other.target", js3_1.cbPubOther, this, js3_1.onComplete_subPubOtherSubjectTarget_1, "_target");
		js3_1.indirect_publish.call(this, "pub.other.trigger", { step: "setup" });
		setTimeout(function() {
			js3_1.indirect_publish.call(that, "pub.other.target", { step: "setup" });
			setTimeout(function() {
				js3_1.indirect_publish.call(that, "pub.other.trigger", { step: "fire" });
				setTimeout(function() {
					that.appendToResultArray(scriptnum, "OK: end pub.other, "); 
					js3_1.indirect_sendMsg.call(that, "ready_for_next_command");
				}, 100);
			}, 100);
		}, 100);

	} else if (scriptnum == 2) {
		// In callback for topic X, subscribe to topic X	
		this.appendToResultArray(scriptnum, "OK: begin sub.same, "); 
		js3_1.indirect_subscribe.call(this, "sub.same", js3_1.cbSubSame, this, js3_1.onComplete_subSubSameSubjectTrigger_1, "_trigger");
		js3_1.indirect_publish.call(this, "sub.same", { step: "setup" }); 
		setTimeout(function() {
			js3_1.indirect_publish.call(that, "sub.same", { step: "fire" });
			setTimeout(function() {
				js3_1.indirect_publish.call(that, "sub.same", { step: "check" });
				setTimeout(function() {
					that.appendToResultArray(scriptnum, "OK: end sub.same, "); 
					js3_1.indirect_sendMsg.call(that, "ready_for_next_command");
				}, 100);
			}, 100);
		}, 100);
		
	} else if (scriptnum == 3) {
		// In callback for topic X, subscribe to topic Y	
		this.appendToResultArray(scriptnum, "OK: begin sub.other, "); 
		js3_1.indirect_subscribe.call(this, "sub.other.trigger", js3_1.cbSubOther, this, js3_1.onComplete_subSubOtherSubjectTrigger, "_trigger");
		js3_1.indirect_publish.call(this, "sub.other.trigger", { step: "setup" }); 		
		setTimeout(function() {
			js3_1.indirect_publish.call(that, "sub.other.target", { step: "setup" }); 		
			setTimeout(function() {
				js3_1.indirect_publish.call(that, "sub.other.trigger", { step: "fire" });
				setTimeout(function() {
					js3_1.indirect_publish.call(that, "sub.other.trigger", { step: "check" });
					setTimeout(function() {
						js3_1.indirect_publish.call(that, "sub.other.target", { step: "check" });
						setTimeout(function() {
							that.appendToResultArray(scriptnum, "OK: end sub.other, "); 
							js3_1.indirect_sendMsg.call(that, "ready_for_next_command");
						}, 100);
					}, 100);
				}, 100);
			}, 100);
		}, 100);
		
	} else if (scriptnum == 4) {
		// In callback for topic X, cancel another subscription to the same topic X
		this.appendToResultArray(scriptnum, "OK: begin unsub.same, "); 
		js3_1.indirect_subscribe.call(this, "unsub.same", js3_1.cbUnsubSame, this, js3_1.onComplete_subUnsubSameSubjectTrigger, "_trigger");
		js3_1.indirect_subscribe.call(this, "unsub.same", js3_1.cbUnsubSame, this, js3_1.onComplete_subUnsubSameSubjectTarget, "_target");
		js3_1.indirect_publish.call(this, "unsub.same", { step: "setup" });
		setTimeout(function() {
			js3_1.indirect_publish.call(that, "unsub.same", { step: "fire" });
			setTimeout(function() {
				js3_1.indirect_publish.call(that, "unsub.same", { step: "check" });
				setTimeout(function() {
					that.appendToResultArray(scriptnum, "OK: end unsub.same, "); 
					js3_1.indirect_sendMsg.call(that, "ready_for_next_command");
				}, 100);
			}, 100);
		}, 100);
	
	} else if (scriptnum == 5) {
		// In callback for topic X, cancel a subscription to a different topic Y
		this.appendToResultArray(scriptnum, "OK: begin unsub.other, "); 
		js3_1.indirect_subscribe.call(this, "unsub.other.trigger", js3_1.cbUnsubOther, this, js3_1.onComplete_subUnsubOtherTrigger, "_trigger");
		js3_1.indirect_subscribe.call(this, "unsub.other.target", js3_1.cbUnsubOther, this, js3_1.onComplete_subUnsubOtherTarget, "_target");
		js3_1.indirect_publish.call(this, "unsub.other.trigger", { step: "setup" }); 		
		setTimeout(function() {
			js3_1.indirect_publish.call(that, "unsub.other.target", { step: "setup" }); 		
			setTimeout(function() {
				js3_1.indirect_publish.call(that, "unsub.other.trigger", { step: "fire" });
				setTimeout(function() {
					js3_1.indirect_publish.call(that, "unsub.other.trigger", { step: "check" });
					setTimeout(function() {
						js3_1.indirect_publish.call(that, "unsub.other.target", { step: "check" });
						setTimeout(function() {
							that.appendToResultArray(scriptnum, "OK: end unsub.other, "); 
							js3_1.indirect_sendMsg.call(that, "ready_for_next_command");
						}, 100);
					}, 100);
				}, 100);
			}, 100);
		}, 100);

	} else if (scriptnum == 6) {
		// In callback for topic X, cancel this same subscription 
		this.appendToResultArray(scriptnum, "OK: begin unsub.this, "); 
		js3_1.indirect_subscribe.call(this, "unsub.this", js3_1.cbUnsubThis, this, js3_1.onComplete_subUnsubThis, "");
		js3_1.indirect_publish.call(this, "unsub.this", { step: "setup" }); 		
		setTimeout(function() {
			js3_1.indirect_publish.call(that, "unsub.this", { step: "fire" });
			setTimeout(function() {
				js3_1.indirect_publish.call(that, "unsub.this", { step: "check" });
				setTimeout(function() {
					that.appendToResultArray(scriptnum, "OK: end unsub.this, "); 
					js3_1.indirect_sendMsg.call(that, "ready_for_next_command");
				}, 100);
			}, 100);
		}, 100);

	} else if (scriptnum == 7) {
		// In callback for topic X, subscribe to X and publish to X
		this.appendToResultArray(scriptnum, "OK: begin sub.pub.same, "); 
		js3_1.indirect_subscribe.call(this, "sub.pub.same", js3_1.cbSubPubSame, this, js3_1.onComplete_subSubSameSubjectTrigger_2, "_trigger");
		js3_1.indirect_publish.call(this, "sub.pub.same", { step: "setup" }); 		
		setTimeout(function() {
			js3_1.indirect_publish.call(that, "sub.pub.same", { step: "fire" });
			setTimeout(function() {
				js3_1.indirect_publish.call(that, "sub.pub.same", { step: "check2" });
				setTimeout(function() {
					that.appendToResultArray(scriptnum, "OK: end sub.pub.same, "); 
					js3_1.indirect_sendMsg.call(that, "ready_for_next_command");
				}, 100);
			}, 100);
		}, 100);

	} else if (scriptnum == 8) {
		this.appendToResultArray(scriptnum, "OK: begin sub.pub.other, "); 
		js3_1.indirect_subscribe.call(this, "sub.pub.other.trigger", js3_1.cbSubPubOther, this, js3_1.onComplete_subSubOtherSubjectTarget_1, "_trigger");
		js3_1.indirect_publish.call(this, "sub.pub.other.trigger", { step: "setup" }); 		
		setTimeout(function() {
			js3_1.indirect_publish.call(that, "sub.pub.other.target", { step: "setup" }); 		
			setTimeout(function() {
				js3_1.indirect_publish.call(that, "sub.pub.other.trigger", { step: "fire" });
				setTimeout(function() {
					js3_1.indirect_publish.call(that, "sub.pub.other.trigger", { step: "check2" });
					setTimeout(function() {
						js3_1.indirect_publish.call(that, "sub.pub.other.target", { step: "check2" });
						setTimeout(function() {
							that.appendToResultArray(scriptnum, "OK: end sub.pub.other, "); 
							js3_1.indirect_sendMsg.call(that, "ready_for_next_command");
						}, 100);
					}, 100);
				}, 100);
			}, 100);
		}, 100);

	} else if (scriptnum == 9) {
		// Tell test harness that test case has completed its work.
		js3_1.indirect_sendMsg.call(this, "testlogiccompleted");
	}
}




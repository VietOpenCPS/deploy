/*******************************************************************************
 * test_pubsub_1_2_1.js:
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

/***********************************************************************
 *  js1_2_1
 **********************************************************************/

var js1_2_1 = {
	name: "1.2.1",
	description: "Event unit tests",
	sub: null,
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
	result: "",
	expectedResult: "1.2.1: start, OK: cb: abc, OK: completed 0, OK: completed 1, OK: completed 2, "+
		"OK: cb: abc, OK: completed 3, "+
		"OK: cb: abc, OK: completed 4, "+
		"OK: cb: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, "+
		"OK: completed 5, OK: cb: abc.def.ghi, OK: completed 6, OK: completed 7, OK: cb: a, "+
		"OK: completed 8, OK: cb: abc, OK: completed 9, OK: cb: com.tibco, OK: completed 10, "+
		"OK: cb: com.tibco, OK: completed 11, "+


		"OK: cb: com.tibco, OK: completed 12, OK: cb: com.tibco, OK: completed 13, OK: cb: com.tibco, "+
		"OK: completed 14, OK: completed 15, OK: completed 16, OK: cb: com.tibco, OK: completed 17, "+
		"OK: cb: a.b.c, OK: completed 18, OK: cb: a.b.c, OK: completed 19, OK: cb: a.b.c, OK: completed 20, "+
		"OK: cb: a.b.c, OK: completed 21, OK: cb: a.b.c, OK: completed 22, OK: cb: a.b.c, OK: completed 23, "+
		"OK: cb: a.b.c, OK: completed 24, OK: cb: a.b.c, OK: completed 25, OK: cb: a.b.c, OK: completed 26, "+
		"OK: cb: a.b.c.d.e.f.g.h.i.j, OK: completed 27, OK: cb: a.b.c.d.e.f.g.h.i.j, OK: completed 28, "+
		"OK: cb: aa.b.cc.d.e.f.g.h.i.j, OK: completed 29, "+


		"OK: cb: 1, OK: completed 30, OK: cb: 1, "+
		"OK: completed 31, OK: cb: 1.0, OK: completed 32, OK: cb: 1.0.5, OK: completed 33, OK: cb: 1.0.5, "+
		"OK: completed 34, OK: cb: 1.1.0, OK: completed 35, OK: cb: false, OK: completed 36, OK: cb: false.true, "+
		"OK: completed 37, OK: cb: return, OK: completed 38, OK: cb: x.length, OK: completed 39, "+
		"OK: cb: function, OK: completed 40, OK: cb: null, OK: completed 41, OK: cb: null, "+
		"OK: completed 42, OK: cb: this, OK: completed 43, OK: cb: this, OK: completed 44, OK: cb: abc=, OK: completed 45, "+
		"OK: cb: 二.重.橋, OK: completed 46, " +
		"OK: cb: 二.重.橋, OK: completed 47, " +
		"OK: cb: 二.重.橋, OK: completed 48, " +
		"OK: cb: 二.重.橋, OK: completed 49, " +
		"OK: cb: 二.重.橋, OK: completed 50, " +
		"OK: cb: $, OK: completed 51, " +
		"OK: cb: a/b.c/d, OK: completed 52, " +
		"OK: cb: [.], OK: completed 53, " +
		"OK: cb: ^.&, OK: completed 54, " +
		"OK: cb: @.%.#.).(,;.A, OK: completed 55, " +
		"OK: completed 56, "  +
		"OK: completed 57, "
}

js1_2_1.cb = function(event, message, subscriberData) {
	// Ignore the next/finish orchestration events which might come here due to wildcard subscriptions
	if (event !== "js1_2_1.nextEvent" && event !== "js1_2_1.finish") {
		this.result += ("OK: cb: " + event + ", ");
	}
	return;
}

js1_2_1.run = function() {
	this.result = "1.2.1: start, ";
	this.hubClient.subscribe("js1_2_1.finish", js1_2_1.finish_cb, this, function( subscriptionID, success, errCode ) {
		this.hubClient.subscribe("js1_2_1.nextEvent", js1_2_1.nextEvent_cb, this, function( subscriptionID, success, errCode ) {
			this.hubClient.publish("js1_2_1.nextEvent", {eventIndex:0, subscriptionID: ""});
		});
	});

}

js1_2_1.nextEvent_cb = function(event, message, subscriberData) {
	var i = message.eventIndex;
	var subID = message.subscriptionID;
	if (i == 0) {
		this.hubClient.subscribe(js1_2_1.events[i].s, js1_2_1.cb, this, function( subscriptionID, success, errCode ) {
			var new_subID = subscriptionID;
			this.hubClient.publish(js1_2_1.events[i].p, {});
			if ((i+1) < js1_2_1.events.length) {
				this.hubClient.publish("js1_2_1.nextEvent", {eventIndex:i+1, subscriptionID: new_subID});
			} else {
				this.hubClient.publish("js1_2_1.finish", null);
			}
		}, null);
	} else {
		this.hubClient.unsubscribe(subID, function( subscriptionID, success, errCode ) {
			this.result += ("OK: completed " + (i-1) + ", ");
			if (i < js1_2_1.events.length) {
				this.hubClient.subscribe(js1_2_1.events[i].s, js1_2_1.cb, this, function( subscriptionID, success, errCode ) {
					var new_subID = subscriptionID;
					this.hubClient.publish(js1_2_1.events[i].p, {});
						this.hubClient.publish("js1_2_1.nextEvent", {eventIndex:i+1, subscriptionID: new_subID});
				}, null);
			} else {
				this.hubClient.publish("js1_2_1.finish", null);
			}
		}, this);
	}
}

js1_2_1.finish_cb = function(event, message, subscriberData) {
	if (this.result == js1_2_1.expectedResult) {
		this.sendMsg( ["done"] );
	} else {
		this.sendMsg( ["error", "Incorrect final results for pubsub js1_2_1"] );
	}
}

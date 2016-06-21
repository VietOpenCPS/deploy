/*******************************************************************************
 * test_pubsub_2_2.js:
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
 *  js2_2
 **********************************************************************/

var js2_2 = {
	name: "2.2",
	description: "Publish and subscribe: wildcards",
	expectedResult: "2.2: start, OK: publish alef (expect 3 callbacks), OK: cb: for alef, OK: cb: for *, "+
		"OK: cb: for **, OK: publish bet (expect 2 callbacks), OK: cb: for *, OK: cb: for **, "+
		"OK: publish alef.bet (expect 6 callbacks), OK: cb: for alef.bet, OK: cb: for alef.**, "+
		"OK: cb: for *.*, OK: cb: for *.**, OK: cb: for *.** (2), OK: cb: for **, "+
		"OK: publish alef.gimel (expect 5 callbacks), OK: cb: for alef.**, OK: cb: for *.*, "+
		"OK: cb: for *.**, OK: cb: for *.** (2), OK: cb: for **, OK: publish alef.bet.gimel (expect 15 callbacks), "+
		"OK: cb: for alef.bet.gimel, OK: cb: for alef.bet.gimel (2), OK: cb: for alef.bet.*, "+
		"OK: cb: for alef.bet.**, OK: cb: for alef.*.gimel, OK: cb: for alef.*.*, OK: cb: for alef.**, "+
		"OK: cb: for *.bet.gimel, OK: cb: for *.bet.**, OK: cb: for *.*.gimel, OK: cb: for *.*.gimel (2), "+
		"OK: cb: for *.*.*, OK: cb: for *.**, OK: cb: for *.** (2), OK: cb: for **, "+
		"OK: publish alef.bet.gimel.dalet (expect 6 callbacks), OK: cb: for alef.bet.**, OK: cb: for alef.**, "+
		"OK: cb: for *.bet.**, OK: cb: for *.**, OK: cb: for *.** (2), OK: cb: for **, "+
		"OK: publish dalet.bet.gimel (expect 8 callbacks), OK: cb: for *.bet.gimel, OK: cb: for *.bet.**, "+
		"OK: cb: for *.*.gimel, "+
		"OK: cb: for *.*.gimel (2), OK: cb: for *.*.*, OK: cb: for *.**, OK: cb: for *.** (2), "+
		"OK: cb: for **, OK: publish lamed.mem.gimel (expect 6 callbacks), OK: cb: for *.*.gimel, "+
		"OK: cb: for *.*.gimel (2), OK: cb: for *.*.*, OK: cb: for *.**, OK: cb: for *.** (2), "+
		"OK: cb: for **, OK: publish alef.dalet (expect 5 callbacks), OK: cb: for alef.**, OK: cb: for *.*, "+
		"OK: cb: for *.**, OK: cb: for *.** (2), OK: cb: for **, OK: publish lamed.mem.nun.samekh (expect 3 callbacks), "+
		"OK: cb: for *.**, OK: cb: for *.** (2), OK: cb: for **, "
}


js2_2.setup = function() {
	var that = this;

	js2_2.check_subs_obj = {};
	this.hubClient.subscribe("alef", js2_2.cb, null, function(){js2_2.check_subs.call(that,0);}, "alef");
	this.hubClient.subscribe("alef.bet", js2_2.cb, null, function(){js2_2.check_subs.call(that,1);}, "alef.bet");
	this.hubClient.subscribe("alef.bet.gimel", js2_2.cb, null, function(){js2_2.check_subs.call(that,2);}, "alef.bet.gimel");
	this.hubClient.subscribe("*.bet.gimel", js2_2.cb, null, function(){js2_2.check_subs.call(that,3);}, "*.bet.gimel");
	this.hubClient.subscribe("alef.*.gimel", js2_2.cb, null, function(){js2_2.check_subs.call(that,4);}, "alef.*.gimel");
	this.hubClient.subscribe("alef.bet.*", js2_2.cb, null, function(){js2_2.check_subs.call(that,5);}, "alef.bet.*");
	this.hubClient.subscribe("*.*.gimel", js2_2.cb, null, function(){js2_2.check_subs.call(that,6);}, "*.*.gimel");
	this.hubClient.subscribe("*.*.gimel", js2_2.cb, null, function(){js2_2.check_subs.call(that,7);}, "*.*.gimel (2)");	// 2nd
	this.hubClient.subscribe("alef.*.*", js2_2.cb, null, function(){js2_2.check_subs.call(that,8);}, "alef.*.*");
	this.hubClient.subscribe("*.*.*", js2_2.cb, null, function(){js2_2.check_subs.call(that,9);}, "*.*.*");
	this.hubClient.subscribe("*", js2_2.cb, null, function(){js2_2.check_subs.call(that,10);}, "*");
	this.hubClient.subscribe("*.*", js2_2.cb, null, function(){js2_2.check_subs.call(that,11);}, "*.*");
	this.hubClient.subscribe("alef.bet.**", js2_2.cb, null, function(){js2_2.check_subs.call(that,12);}, "alef.bet.**");
	this.hubClient.subscribe("alef.**", js2_2.cb, null, function(){js2_2.check_subs.call(that,13);}, "alef.**");
	this.hubClient.subscribe("**", js2_2.cb, null, function(){js2_2.check_subs.call(that,14);}, "**");
	this.hubClient.subscribe("*.bet.**", js2_2.cb, null, function(){js2_2.check_subs.call(that,15);}, "*.bet.**");
	this.hubClient.subscribe("alef.bet.gimel", js2_2.cb, null, function(){js2_2.check_subs.call(that,16);}, "alef.bet.gimel (2)");	// 2nd
	this.hubClient.subscribe("*.**", js2_2.cb, null, function(){js2_2.check_subs.call(that,17);}, "*.**");
	this.hubClient.subscribe("*.**", js2_2.cb, null, function(){js2_2.check_subs.call(that,18);}, "*.** (2)");		// 2nd
	this.hubClient.subscribe("chet.tet.yud", js2_2.cb, null, function(){js2_2.check_subs.call(that,19);}, "chet.tet.yud");

	return;
}

// Don't start the test case's main logic until initial subscriptions have all been consummated
js2_2.check_subs = function(idx) {
	var obj = js2_2.check_subs_obj;
	obj[idx] = true;
	for (var i=0; i<20; i++) {
		if(obj[i] !== true) {
			return;
		}
	}
	js2_2.runtests.call(this);
}

js2_2.runtests = function() {
	js2_2.result.push("OK: publish alef (expect 3 callbacks), ");
	this.hubClient.publish("alef", null);
	js2_2.result.push("OK: publish bet (expect 2 callbacks), ");
	this.hubClient.publish("bet", null);
	js2_2.result.push("OK: publish alef.bet (expect 6 callbacks), ");
	this.hubClient.publish("alef.bet", null);
	js2_2.result.push("OK: publish alef.gimel (expect 5 callbacks), ");
	this.hubClient.publish("alef.gimel", null);
	js2_2.result.push("OK: publish alef.bet.gimel (expect 15 callbacks), ");
	this.hubClient.publish("alef.bet.gimel", null);
	js2_2.result.push("OK: publish alef.bet.gimel.dalet (expect 6 callbacks), ");
	this.hubClient.publish("alef.bet.gimel.dalet", null);
	js2_2.result.push("OK: publish dalet.bet.gimel (expect 8 callbacks), ");
	this.hubClient.publish("dalet.bet.gimel", null);
	js2_2.result.push("OK: publish lamed.mem.gimel (expect 6 callbacks), ");
	this.hubClient.publish("lamed.mem.gimel", null);
	js2_2.result.push("OK: publish alef.dalet (expect 5 callbacks), ");
	this.hubClient.publish("alef.dalet", null);
	js2_2.result.push("OK: publish lamed.mem.nun.samekh (expect 3 callbacks), ");
	this.hubClient.publish("lamed.mem.nun.samekh", null);
	this.hubClient.publish("js2_2.finish", null);
}

js2_2.cb = function(event, message, subscriberData) {
	//Ignore any test case orchestration events
	if(event == "js2_2.finish") {
		return;
	}
	js2_2.result.push("OK: cb: for " + subscriberData + ", ");
	return;
}

js2_2.run = function() {
	js2_2.result = [];
	js2_2.result.push("2.2: start, ");
	this.hubClient.subscribe("js2_2.finish", js2_2.finishCB, this, function( subscriptionID, success, errCode ) {
		js2_2.setup.call(this);
	});
}

js2_2.finishCB = function(event, message, subscriberData) {
	var match = true;
	var result_length = 0;
	for (var i=0; i<js2_2.result.length; i++) {
		result_length += js2_2.result[i].length;
	}
	if (result_length != js2_2.expectedResult.length) {
		match = false;
	}
	for (var i=0; i<js2_2.result.length; i++) {
		var resultString = js2_2.result[i];
		if (js2_2.expectedResult.indexOf(resultString) == -1) {
			match = false;
		}
	}
	if (match === true) {
		this.sendMsg( ["done"] );
	} else {
		this.sendMsg( ["error", "Incorrect final results for pubsub js2_2"] );
	}
}

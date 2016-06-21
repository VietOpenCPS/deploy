/*******************************************************************************
 * test_pubsub_1_3_1.js:
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
 *  js1_3_1
 **********************************************************************/

var js1_3_1 = {
	name: "1.3.1",
	description: "Multiple subscriptions",
	sub: [],
	result: "",
	expectedResult: "1.3.1: start, OK: setup: completed, OK: 13 subscribed B.B.B.X.Y, OK: cb: B.B.B.X.Y, OK: published B.B.B.X.Y, OK: unsubscribed 13, OK: cb: B.B.B, OK: published B.B.B (expect to have received callback), OK: 13 subscribed B.B.B.M.N, OK: 14 subscribed B.B.B.M.P, OK: unsubscribed 13, OK: cb: B.B.B.M.P, OK: published B.B.B.M.P (expect to have received callback), OK: cb: B.A, OK: published B.A, OK: 15 and 16 subscribed A.A.A, OK: cb: A.A.A, OK: cb: A.A.A#1, OK: cb: A.A.A#2, OK: published to A.A.A (expect to have gotten 3 callbacks), OK: unsubscribed 15, OK: cb: A.A.A, OK: cb: A.A.A#2, OK: published to A.A.A (expect to have gotten 2 callbacks), OK: unsubscribed 2, OK: cb: A.A.A#2, OK: published to A.A.A (expect to have gotten 1 callback), OK: unsubscribed 16, OK: published to A.A.A (expect to have gotten ZERO callbacks), "
}
js1_3_1.cb = function(event, message, subscriberData) {
	//Ignore any test case orchestration events
	if(event == "js1_3_1.nextStep" || event == "js1_3_1.finish") {
		return;
	}
	if(subscriberData == "B.B.B.X.Y") {
		// created the leaf subscription
		js1_3_1.result.push("OK: cb: B.B.B.X.Y, ");
	}
	else if(subscriberData == "B.B.B") {
		// removed the leaf subscription, peeling branch back to
		// B.B.B. The B.B.B subscription remained intact.
		js1_3_1.result.push("OK: cb: B.B.B, ");
	}
	else if(subscriberData == "B.B.B.M.P") {
		// removed the leaf subscription B.B.B.M.N, peeling branch 
		// back to B.B.B.M The B.B.B.M subscription remained intact
		// because of the other subscripton to B.B.B.M.P
		js1_3_1.result.push("OK: cb: B.B.B.M.P, ");
	}
	else if(subscriberData == "B.A") {
		// Tests intermediate node, rather than leaf node
		// not a leaf. 
		js1_3_1.result.push("OK: cb: B.A, ");
	}
	else if((subscriberData == "A.A.A") || (subscriberData == "A.A.A#1") || (subscriberData == "A.A.A#2")) {
		// Tests intermediate node, rather than leaf node. Expect 3 callbacks
		js1_3_1.result.push("OK: cb: " + subscriberData + ", ");
	}
	return;
}

js1_3_1.setup = function() {
	var that = this;

	js1_3_1.check_subs_obj = {};
	js1_3_1.sub[0] = this.hubClient.subscribe("A", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 0); 
	}, "A");
	js1_3_1.sub[1] = this.hubClient.subscribe("A.A", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 1); 
	}, "A.A");
	js1_3_1.sub[2] = this.hubClient.subscribe("A.A.A", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 2); 
	}, "A.A.A");
	js1_3_1.sub[3] = this.hubClient.subscribe("A.A.B", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 3); 
	}, "A.A.B");
	js1_3_1.sub[4] = this.hubClient.subscribe("A.B", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 4); 
	}, "A.B");
	js1_3_1.sub[5] = this.hubClient.subscribe("A.B.A", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 5); 
	}, "A.B.A");
	js1_3_1.sub[6] = this.hubClient.subscribe("A.B.B", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 6); 
	}, "A.B.B");
	js1_3_1.sub[12] = this.hubClient.subscribe("B.B.B", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 12); 
	}, "B.B.B");
	js1_3_1.sub[11] = this.hubClient.subscribe("B.B", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 11); 
	}, "B.B");
	js1_3_1.sub[7] = this.hubClient.subscribe("B", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 7); 
	}, "B");
	js1_3_1.sub[8] = this.hubClient.subscribe("B.A", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 8); 
	}, "B.A");
	js1_3_1.sub[9] = this.hubClient.subscribe("B.A.A", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 9); 
	}, "B.A.A");
	js1_3_1.sub[10] = this.hubClient.subscribe("B.A.B", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 10); 
	}, "B.A.B");
	js1_3_1.sub[17] = this.hubClient.subscribe("B.B.A", js1_3_1.cb, null, function() { 
		js1_3_1.check_subs.call(that, 17); 
	}, "B.B.A");
	return;
}

// Don't start the test case's main logic until initial subscriptions have all been consummated
js1_3_1.check_subs = function(idx) {
	var obj = js1_3_1.check_subs_obj;
	obj[idx] = true;
	var needed = [0,1,2,3,4,5,6,12,11,7,8,9,10,17];
	for (var i=0; i<needed.length; i++) {
		if(obj[needed[i]] !== true) {
			return;
		}
	}
	js1_3_1.result.push("OK: setup: completed, ");
	js1_3_1.runtests.call(this);
}

js1_3_1.runtests = function() {
	this.hubClient.publish("js1_3_1.nextStep", 0);
}

js1_3_1.runtest_0 = function() {
	var that = this;

	// subscribe to leaf node, publish to it, unsubscribe from it
	js1_3_1.sub[13] = that.hubClient.subscribe("B.B.B.X.Y", js1_3_1.cb, null, function() {
		js1_3_1.result.push("OK: 13 subscribed B.B.B.X.Y, ");
		that.hubClient.publish("B.B.B.X.Y", {});
		js1_3_1.result.push("OK: published B.B.B.X.Y, ");

		that.hubClient.publish("js1_3_1.nextStep", 1);
	}, "B.B.B.X.Y");
}


js1_3_1.runtest_1 = function() {
	var that = this;

	that.hubClient.unsubscribe(js1_3_1.sub[13], function() {
		js1_3_1.result.push("OK: unsubscribed 13, ");

		// publish to what is now the leaf node after the unsubscribe of its last descendant
		that.hubClient.publish("B.B.B", {});
		js1_3_1.result.push("OK: published B.B.B (expect to have received callback), ");

		that.hubClient.publish("js1_3_1.nextStep", 2);
	});
}


js1_3_1.runtest_2 = function() {
	var that = this;

	// subscribe to two leaf nodes on separate branches below that node
	js1_3_1.sub[13] = that.hubClient.subscribe("B.B.B.M.N", js1_3_1.cb, null, function() {
		js1_3_1.result.push("OK: 13 subscribed B.B.B.M.N, ");

		that.hubClient.publish("js1_3_1.nextStep", 3);
	}, "B.B.B.M.N");
}

js1_3_1.runtest_3 = function() {
	var that = this;

	js1_3_1.sub[14] = that.hubClient.subscribe("B.B.B.M.P", js1_3_1.cb, null, function() {
		js1_3_1.result.push("OK: 14 subscribed B.B.B.M.P, ");

		that.hubClient.publish("js1_3_1.nextStep", 4);
	}, "B.B.B.M.P");
}

js1_3_1.runtest_4 = function() {
	var that = this;

	// unsubscribe from one of the two leaf nodes, causing that branch to
	// be rolled back but not affecting the other branch. Then publish to
	// the other branch to confirm that it still exists.
	that.hubClient.unsubscribe(js1_3_1.sub[13], function() {
		js1_3_1.result.push("OK: unsubscribed 13, ");
		that.hubClient.publish("B.B.B.M.P", {});
		js1_3_1.result.push("OK: published B.B.B.M.P (expect to have received callback), ");
	
		// Now publish to an intermediate node
		that.hubClient.publish("B.A", {});
		js1_3_1.result.push("OK: published B.A, ");

		that.hubClient.publish("js1_3_1.nextStep", 5);
	});
}

js1_3_1.runtest_5 = function() {
	var that = this;

	// Now create several additional subscriptions to a leaf node
	js1_3_1.sub[15] = that.hubClient.subscribe("A.A.A", js1_3_1.cb, null, function() {
		js1_3_1.sub[16] = that.hubClient.subscribe("A.A.A", js1_3_1.cb, null, function() {
			js1_3_1.result.push("OK: 15 and 16 subscribed A.A.A, ");
			that.hubClient.publish("A.A.A", {});
			js1_3_1.result.push("OK: published to A.A.A (expect to have gotten 3 callbacks), ");

			that.hubClient.publish("js1_3_1.nextStep", 6);
		}, "A.A.A#2"); // #3
	}, "A.A.A#1"); // #2
}

js1_3_1.runtest_6 = function() {
	var that = this;

	// Unsubscribe the 2nd (middle) one
	that.hubClient.unsubscribe(js1_3_1.sub[15], function() {
		js1_3_1.result.push("OK: unsubscribed 15, ");
		that.hubClient.publish("A.A.A", {});
		js1_3_1.result.push("OK: published to A.A.A (expect to have gotten 2 callbacks), ");

		that.hubClient.publish("js1_3_1.nextStep", 7);
	});
}

js1_3_1.runtest_7 = function() {
	var that = this;

	// Unsubscribe the 1st one
	that.hubClient.unsubscribe(js1_3_1.sub[2], function() {
		js1_3_1.result.push("OK: unsubscribed 2, ");
		that.hubClient.publish("A.A.A", {});
		js1_3_1.result.push("OK: published to A.A.A (expect to have gotten 1 callback), ");

		that.hubClient.publish("js1_3_1.nextStep", 8);
	});
}

js1_3_1.runtest_8 = function() {
	var that = this;

	// Unsubscribe the 3rd (last) one
	that.hubClient.unsubscribe(js1_3_1.sub[16], function() {
		js1_3_1.result.push("OK: unsubscribed 16, ");
		that.hubClient.publish("A.A.A", {});
		js1_3_1.result.push("OK: published to A.A.A (expect to have gotten ZERO callbacks), ");

		js1_3_1.cleanup.call(that);
	});
}

js1_3_1.cleanup = function() {
	var that = this;

	this.hubClient.unsubscribe(js1_3_1.sub[0], function() { js1_3_1.check_unsubs.call(that, 0); });
	this.hubClient.unsubscribe(js1_3_1.sub[1], function() { js1_3_1.check_unsubs.call(that, 1); });
	this.hubClient.unsubscribe(js1_3_1.sub[3], function() { js1_3_1.check_unsubs.call(that, 3); });
	this.hubClient.unsubscribe(js1_3_1.sub[4], function() { js1_3_1.check_unsubs.call(that, 4); });
	this.hubClient.unsubscribe(js1_3_1.sub[5], function() { js1_3_1.check_unsubs.call(that, 5); });
	this.hubClient.unsubscribe(js1_3_1.sub[6], function() { js1_3_1.check_unsubs.call(that, 6); });
	this.hubClient.unsubscribe(js1_3_1.sub[7], function() { js1_3_1.check_unsubs.call(that, 7); });
	this.hubClient.unsubscribe(js1_3_1.sub[8], function() { js1_3_1.check_unsubs.call(that, 8); });
	this.hubClient.unsubscribe(js1_3_1.sub[9], function() { js1_3_1.check_unsubs.call(that, 9); });
	this.hubClient.unsubscribe(js1_3_1.sub[10], function() { js1_3_1.check_unsubs.call(that, 10); });
	this.hubClient.unsubscribe(js1_3_1.sub[11], function() { js1_3_1.check_unsubs.call(that, 11); });
	this.hubClient.unsubscribe(js1_3_1.sub[12], function() { js1_3_1.check_unsubs.call(that, 12); });
	this.hubClient.unsubscribe(js1_3_1.sub[14], function() { js1_3_1.check_unsubs.call(that, 14); });
	this.hubClient.unsubscribe(js1_3_1.sub[17], function() { js1_3_1.check_unsubs.call(that, 17); });
}

// Don't end the test case until cleanup unsubscriptions have all been consummated
js1_3_1.check_unsubs = function(idx) {
	var obj = js1_3_1.check_subs_obj;
	obj[idx] = true;
	var needed = [0,1,3,4,5,6,7,8,9,10,11,12,14,17];
	for (var i=0; i<needed.length; i++) {
		if(obj[needed[i]] !== true) {
			return;
		}
	}
	this.hubClient.publish("js1_3_1.finish", null);
}

js1_3_1.run = function() {
	js1_3_1.result = ["1.3.1: start, "];
	this.hubClient.subscribe("js1_3_1.finish", js1_3_1.finishCB, this, function( subscriptionID, success, errCode ) {
		this.hubClient.subscribe("js1_3_1.nextStep", js1_3_1.nextStepCB, this, function( subscriptionID, success, errCode ) {
			js1_3_1.setup.call(this);
		});
	});
}

js1_3_1.nextStepCB = function(event, message, subscriberData) {
	var func = js1_3_1["runtest_"+message];
	func.call(this);
}

js1_3_1.finishCB = function(event, message, subscriberData) {
	var match = true;
	var result_length = 0;
	for (var i=0; i<js1_3_1.result.length; i++) {
		result_length += js1_3_1.result[i].length;
	}
	if (result_length != js1_3_1.expectedResult.length) {
		match = false;
	}
	for (var i=0; i<js1_3_1.result.length; i++) {
		var resultString = js1_3_1.result[i];
		if (js1_3_1.expectedResult.indexOf(resultString) == -1) {
			match = false;
		}
	}
	if (match === true) {
		this.sendMsg( ["done"] );
	} else {
		this.sendMsg( ["error", "Incorrect final results for pubsub js1_3_1"] );
	}
}

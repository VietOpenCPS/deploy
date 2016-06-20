/*******************************************************************************
 * test_pubsub_1_1.js:
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
 *  js1_1
 *	(Corresponds to the following Hub 1.0 pubsub tests: 1.1.1, 1.1.2, 1.1.3, 4.1, 4.2)
 **********************************************************************/

var js1_1 = {
	name: "1.1",
	description: "Simply publish unit tests"
}

js1_1.run = function() {
	var that = this;

	js1_1.expectedResult =
		"1.1.1: start, OK: will publish to nobody, OK: published to nobody, "
		+ "1.1.2: start, subscribed to example.event.1.1.2 (cb0), subscribed to example.event.1.1.2 (cb1), publish to example.event.1.1.2, cb0: example.event.1.1.2, [object Object], null, cb1: example.event.1.1.2, [object Object], mySubscriberData, published to example.event.1.1.2, "
		+ "1.1.3: start, OK: subscribed, OK: publish, OK: cb2: got the correct subscriberData, OK: published, "
		+ "4.1: start, OK: subscribed, OK: cb: example.subject.4.1, 4.1, undefined, OK: cb: example.subject.4.1, 4.1, null, OK: cb: example.subject.4.1, 4.1, subdata, OK: published, "
/* We aren't supporting refOrName in Hub 2.0, so comment out the 4.2 logic */
//		+ "4.2: start, OK: subscribed, OK: js1_1_cb1: example.subject.4.2, 4.2, OK: js1_1_cb1: example.subject.4.2, 4.2, OK: js1_1_cb1: example.subject.4.2, 4.2, OK: js1_1.cb2: example.subject.4.2, 4.2, OK: js1_1_cb3b: example.subject.4.2, 4.2, OK: js1_1.cb4b: example.subject.4.2, 4.2, OK: published, "

		;

	this.hubClient.subscribe("js1_1.finish", js1_1.finishCB, this, function( subscriptionID, success, errCode ) {


		// This is the testing logic from the 1.1.1 test case from the Hub 1.0 test suite
		js1_1.result = [];
		js1_1.result.push("1.1.1: start, ");
		js1_1.result.push("OK: will publish to nobody, ");
		that.hubClient.publish("example.event.1.1.1", {});
		js1_1.result.push("OK: published to nobody, ");	

		// This is the testing logic from the 1.1.2 test case from the Hub 1.0 test suite
		js1_1.result.push("1.1.2: start, ");		
		js1_1.sub0 = that.hubClient.subscribe("example.event.1.1.2", js1_1.cb0, null, function() {
			js1_1.result.push("subscribed to example.event.1.1.2 (cb0), ");		
			js1_1.sub1 = that.hubClient.subscribe("example.event.1.1.2", js1_1.cb1, null, function() {
				js1_1.result.push("subscribed to example.event.1.1.2 (cb1), ");
				js1_1.result.push("publish to example.event.1.1.2, ");
				that.hubClient.publish("example.event.1.1.2", {});
				js1_1.result.push("published to example.event.1.1.2, ");

				// This is the testing logic from the 1.1.3 test case from the Hub 1.0 test suite
 				js1_1.result.push("1.1.3: start, ");
				js1_1.sub2 = that.hubClient.subscribe("example.event.1.1.3", js1_1.cb2, null, function() {
					js1_1.result.push("OK: subscribed, ");
					js1_1.result.push("OK: publish, ");
 					that.hubClient.publish("example.event.1.1.3", {});
					js1_1.result.push("OK: published, ");

					// This is the testing logic from the 4.1 test case from the Hub 1.0 test suite
					js1_1.result.push("4.1: start, ");
					that.somefunkyproperty = "funkiness";
					that.hubClient.subscribe("example.subject.4.1", js1_1.cb3, that, function() {
						that.hubClient.subscribe("example.subject.4.1", js1_1.cb3, that, function() {
							that.hubClient.subscribe("example.subject.4.1", js1_1.cb3, that, function() {
								js1_1.result.push("OK: subscribed, "); 
								that.hubClient.publish("example.subject.4.1", "4.1");
								js1_1.result.push("OK: published, "); 

/* We aren't supporting refOrName in Hub 2.0 */
//								// This is the testing logic from the 4.2 test case from the Hub 1.0 test suite
//								js1_1.result.push("4.2: start, ");
//								that.hubClient.subscribe("example.subject.4.2", "t4_2_cb1");
//								// Use setTimeout here because we are testing the absence of the 3rd parameter 
//								// in above subscribe call. Therefore, can't use the onComplete (4th) param.
//								setTimeout(function() {
//
//									that.hubClient.subscribe("example.subject.4.2", "t4_2_cb1", null, function() {
//										that.hubClient.subscribe("example.subject.4.2", "t4_2_cb1", window, function() {
//											that.hubClient.subscribe("example.subject.4.2", "t4_2_cb2", js1_1, function() {
//												// The following two subscriptions will verify late binding.
//												// The function definitions will change after subscribe() is called.
//												that.hubClient.subscribe("example.subject.4.2", "t4_2_cb3a", null, function() {
//													that.hubClient.subscribe("example.subject.4.2", "t4_2_cb4a", js1_1, function() {
//														// This is where the function definitions are changed.
//														t4_2_cb3a = t4_2_cb3b;
//														js1_1.t4_2_cb4a = js1_1.t4_2_cb4b;
//														js1_1.result.push("OK: subscribed, "); 
//														that.hubClient.publish("example.subject.4.2", "4.2");
//														js1_1.result.push("OK: published, "); 
//
//														// Publish an event that will take us to result checking logic and termination
//														that.hubClient.publish("js1_1.finish", {});
//													});
//												});
//											});
//										});
//									});
//								}, 250); /* Assume the subscribe can be processing in 1/4 second
//								/* End of 4.2 logic */

/* Remove the following "finish" callback if ever restoring test 4.2 */
								// Publish an event that will take us to result checking logic and termination
								that.hubClient.publish("js1_1.finish", {});


							}, "subdata"); 
						}, null); 
					});
					/* End of 4.1 logic */

				}, {a:1,b:"b"});
				/* End of 1.1.3 logic */

			}, "mySubscriberData");
		}, null);
		/* End of 1.1.2 logic */

	});
}

js1_1.cb0 = function(event, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (event ==="js1_1.finish") {
		return;
	}
	js1_1.result.push("cb0: " + event + ", " + message + ", " + subscriberData + ", ");
}

js1_1.cb1 = function(event, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (event ==="js1_1.finish") {
		return;
	}
	js1_1.result.push("cb1: " + event + ", " + message + ", " + subscriberData + ", ");
}

js1_1.cb2 = function(event, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (event ==="js1_1.finish") {
		return;
	}
	if (subscriberData.a === 1 && subscriberData.b === "b") {
		js1_1.result.push("OK: cb2: got the correct subscriberData, ");
	} else {
		js1_1.result.push("ERROR: cb2: wrong subscriberData, ");
	}
}

js1_1.cb3 = function(subject, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (subject ==="js1_1.finish") {
		return;
	}
	if (!this.somefunkyproperty) {
		js1_1.result.push("cb: ERROR. no name property on this object, ");
	} else if (this.somefunkyproperty != "funkiness") {
		js1_1.result.push("cb: ERROR. incorrect value for this.name. value was: "+this.name+", ");
	} else {
		js1_1.result.push("OK: cb: " + subject + ", " + message + ", " + subscriberData + ", ");
	}
	return;
}

// Note that this callback is a property of "window" object
t4_2_cb1 = function(subject, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (subject ==="js1_1.finish") {
		return;
	}
	js1_1.result.push("OK: js1_1_cb1: " + subject + ", " + message + ", ");
	return;
}
// Note that this callback is a property of "js1_1" object
js1_1.t4_2_cb2 = function(subject, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (subject ==="js1_1.finish") {
		return;
	}
	js1_1.result.push("OK: js1_1.cb2: " + subject + ", " + message + ", ");
	return;
}
// Note that this callback is a property of "window" object
t4_2_cb3a = function(subject, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (subject ==="js1_1.finish") {
		return;
	}
	js1_1.result.push("ERROR: original js1_1_cb3a function should not get invoked, ");
	return;
}
t4_2_cb3b = function(subject, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (subject ==="js1_1.finish") {
		return;
	}
	js1_1.result.push("OK: js1_1_cb3b: " + subject + ", " + message + ", ");
	return;
}
// Note that this callback is a property of "js1_1" object
js1_1.t4_2_cb4a = function(subject, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (subject ==="js1_1.finish") {
		return;
	}
	js1_1.result.push("ERROR: original js1_1.cb4a function should not get invoked, ");
	return;
}
js1_1.t4_2_cb4b = function(subject, message, subscriberData) {
	// Ignore events having to do with test case orchestration
	if (subject ==="js1_1.finish") {
		return;
	}
	js1_1.result.push("OK: js1_1.cb4b: " + subject + ", " + message + ", ");
	return;
}

js1_1.finishCB = function(event, message, subscriberData) {
	var match = true;
	var result_str = "";
	var result_length = 0;
	for (var i=0; i<js1_1.result.length; i++) {
		result_str += js1_1.result[i];
		result_length += js1_1.result[i].length;
	}
	if (result_length != js1_1.expectedResult.length) {
		match = false;
	}
	for (var i=0; i<js1_1.result.length; i++) {
		var resultString = js1_1.result[i];
		if (js1_1.expectedResult.indexOf(resultString) == -1) {
			match = false;
		}
	}
	if (match === true) {
		this.sendMsg( ["done"] );
	} else {
		this.sendMsg( ["error", "Incorrect final results for pubsub js1_1"] );
	}
}

/*******************************************************************************
 * test_pubsub_3_1.js:
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
 *  js3_1
 **********************************************************************/

var js3_1 = {};
js3_1_0 = {};
js3_1_1 = {};
js3_1_2 = {};
js3_1_3 = {};
js3_1_4 = {};
js3_1_5 = {};
js3_1_6 = {};
js3_1_7 = {};
js3_1_8 = {};

//////////////////////////////////////////////////////

js3_1_0.run = function(scriptnum) {
	js3_1_0.scriptnum = scriptnum;
	js3_1_0.subscribe = {};
	js3_1_0.setup = {};
	js3_1_0.fire = {};
	js3_1_0.check = {};

	// In callback for topic X, publish on topic X	
	this.hubClient.subscribe("pub.same", js3_1.cbPubSame, this, function( subscriptionID, success, errCode ) {
		js3_1_0.do_setup.call(this, "_trigger");
	}, "_trigger");
}

js3_1.cbPubSame = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		js3_1_0.do_fire.call(this, subscriberData);
	} else if(message.step == "fire") { 
		js3_1_0.do_check.call(this, subscriberData);
	} else if(message.step == "check") {
		js3_1_0.do_finish.call(this, subscriberData);
	} else {
		this.sendMsg( ["error", "ERROR: invalid step " + message.step + ", " ] );
	}
	return;
}

js3_1_0.do_setup = function(subscriberName) {
	js3_1_0.subscribe[subscriberName] = true;
	if (js3_1_0.subscribe["_trigger"] === true) {
		this.hubClient.publish("pub.same", { step: "setup" }); 
	}
}

js3_1_0.do_fire = function(data) {
	js3_1_0.setup[data] = true;
	if (js3_1_0.setup["_trigger"] === true) {
		this.hubClient.publish("pub.same", { step: "fire" });
	}
}

js3_1_0.do_check = function(data) {
	js3_1_0.fire[data] = true;
	if (js3_1_0.fire["_trigger"] === true) {
		this.hubClient.publish("pub.same", { step: "check" });
	}
}

js3_1_0.do_finish = function(data) {
	js3_1_0.check[data] = true;
	if (js3_1_0.check["_trigger"] === true) {
		if (js3_1_0.setup["_trigger"] === true && 
			js3_1_0.fire["_trigger"] === true && 
			js3_1_0.check["_trigger"] === true) {
			this.sendMsg( ["done"] );
		} else {
			this.sendMsg( ["error", "Incorrect final results for pubsub 3_1.0"] );
		}
	}
}

//////////////////////////////////////////////////////

js3_1_1.run = function(scriptnum) {
	js3_1_1.scriptnum = scriptnum;
	js3_1_1.subscribe = {};
	js3_1_1.setup = {};
	js3_1_1.fire = {};
	js3_1_1.check = {};

	// In callback for topic X, subscribe to topic X	
	this.hubClient.subscribe("pub.other.trigger", js3_1.cbPubOther, this, function( subscriptionID, success, errCode ) {
		js3_1_1.do_setup.call(this, "_trigger");
	}, "_trigger");
	this.hubClient.subscribe("pub.other.target", js3_1.cbPubOther, this, function( subscriptionID, success, errCode ) {
		js3_1_1.do_setup.call(this, "_target");
	}, "_target");
}

js3_1.cbPubOther = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		js3_1_1.do_fire.call(this, subscriberData);
	} else if(message.step == "fire") {
		js3_1_1.do_check.call(this, subscriberData);
	} else if(message.step == "check") {
		js3_1_1.do_finish.call(this, subscriberData);
	} else {
		this.sendMsg( ["error", "ERROR: invalid step " + message.step + ", " ] );
	}
	return;
}

js3_1_1.do_setup = function(subscriberName) {
	js3_1_1.subscribe[subscriberName] = true;
	if (js3_1_1.subscribe["_trigger"] === true && js3_1_1.subscribe["_target"] === true) {
		this.hubClient.publish("pub.other.trigger", { step: "setup" }); 
		this.hubClient.publish("pub.other.target", { step: "setup" }); 
	}
}

js3_1_1.do_fire = function(data) {
	js3_1_1.setup[data] = true;
	if (js3_1_1.setup["_trigger"] === true && js3_1_1.setup["_target"] === true) {
		this.hubClient.publish("pub.other.trigger", { step: "fire" });
	}
}

js3_1_1.do_check = function(data) {
	js3_1_1.fire[data] = true;
	if (js3_1_1.fire["_trigger"] === true) {
		this.hubClient.publish("pub.other.target", { step: "check" });
	}
}

js3_1_1.do_finish = function(data) {
	js3_1_1.check[data] = true;
	if (js3_1_1.check["_target"] === true) {
		if (js3_1_1.setup["_trigger"] === true && js3_1_1.setup["_target"] === true &&
			js3_1_1.fire["_trigger"] === true && typeof js3_1_1.fire["_target"] === "undefined" &&
			typeof js3_1_1.check["_trigger"] === "undefined" && js3_1_1.check["_target"] === true) {
			this.sendMsg( ["done"] );
		} else {
			this.sendMsg( ["error", "Incorrect final results for pubsub 3_1.1"] );
		}
	}
}

//////////////////////////////////////////////////////

js3_1_2.run = function(scriptnum) {
	js3_1_2.scriptnum = scriptnum;
	js3_1_2.subscribe = {};
	js3_1_2.setup = {};
	js3_1_2.fire = {};
	js3_1_2.check = {};

	// In callback for topic X, subscribe to topic X	
	this.hubClient.subscribe("sub.same", js3_1.cbSubSame, this, function( subscriptionID, success, errCode ) {
		js3_1_2.do_setup.call(this, "_trigger");
	}, "_trigger");
}

js3_1.cbSubSame = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		js3_1_2.do_fire.call(this, subscriberData);
	} else if(message.step == "fire") {
		this.hubClient.subscribe(subject, js3_1.cbSubSame, this, function( subscriptionID, success, errCode ) {
			js3_1_2.do_check.call(this, subscriberData);
		}, "_target");
	} else if(message.step == "check") {
		js3_1_2.do_finish.call(this, subscriberData);
	} else  {
		this.sendMsg( ["error", "ERROR: invalid step " + message.step + ", " ] );	
	}
	return;
}

js3_1_2.do_setup = function(subscriberName) {
	js3_1_2.subscribe[subscriberName] = true;
	if (js3_1_2.subscribe["_trigger"] === true) {
		this.hubClient.publish("sub.same", { step: "setup" }); 
	}
}

js3_1_2.do_fire = function(data) {
	js3_1_2.setup[data] = true;
	if (js3_1_2.setup["_trigger"] === true) {
		this.hubClient.publish("sub.same", { step: "fire" });
	}
}

js3_1_2.do_check = function(data) {
	js3_1_2.fire[data] = true;
	if (js3_1_2.fire["_trigger"] === true) {
		this.hubClient.publish("sub.same", { step: "check" });
	}
}

js3_1_2.do_finish = function(data) {
	js3_1_2.check[data] = true;
	if (js3_1_2.check["_trigger"] === true && js3_1_2.check["_target"] === true) {
		if (js3_1_2.setup["_trigger"] === true && typeof js3_1_2.setup["_target"] === "undefined" &&
			js3_1_2.fire["_trigger"] === true && typeof js3_1_2.fire["_target"] === "undefined" &&
			js3_1_2.check["_trigger"] === true && js3_1_2.check["_target"] === true) {
			this.sendMsg( ["done"] );
		} else {
			this.sendMsg( ["error", "Incorrect final results for pubsub 3_1.2"] );
		}
	}
}

//////////////////////////////////////////////////////

js3_1_3.run = function(scriptnum) {
	js3_1_3.scriptnum = scriptnum;
	js3_1_3.subscribe = {};
	js3_1_3.setup = {};
	js3_1_3.fire = {};
	js3_1_3.check = {};

	// In callback for topic X, subscribe to topic Y	
	this.hubClient.subscribe("sub.other.trigger", js3_1.cbSubOther, this, function( subscriptionID, success, errCode ) {
		js3_1_3.do_setup.call(this, "_trigger");
	}, "_trigger");
}

js3_1.cbSubOther = function(subject, message, subscriberData) {
	if(message.step == "setup") { 
		js3_1_3.do_fire.call(this, subscriberData);
	} else if(message.step == "fire") {
		this.hubClient.subscribe("sub.other.target", js3_1.cbSubOther, this, function( subscriptionID, success, errCode ) {
			js3_1_3.do_check.call(this, subscriberData);
		}, "_target");
	} else if(message.step == "check") {
		js3_1_3.do_finish.call(this, subscriberData);
	} else  {
		this.sendMsg( ["error", "ERROR: invalid step " + message.step + ", " ] );	
	}
	return;
}

js3_1_3.do_setup = function(subscriberName) {
	js3_1_3.subscribe[subscriberName] = true;
	if (js3_1_3.subscribe["_trigger"] === true) {
		this.hubClient.publish("sub.other.trigger", { step: "setup" }); 
		this.hubClient.publish("sub.other.target", { step: "setup" }); 
	}
}

js3_1_3.do_fire = function(data) {
	js3_1_3.setup[data] = true;
	if (js3_1_3.setup["_trigger"] === true) {
		this.hubClient.publish("sub.other.trigger", { step: "fire" });
	}
}

js3_1_3.do_check = function(data) {
	js3_1_3.fire[data] = true;
	if (js3_1_3.fire["_trigger"] === true) {
		this.hubClient.publish("sub.other.trigger", { step: "check" });
		this.hubClient.publish("sub.other.target", { step: "check" });
	}
}

js3_1_3.do_finish = function(data) {
	js3_1_3.check[data] = true;
	if (js3_1_3.check["_trigger"] === true && js3_1_3.check["_target"] === true) {
		if (js3_1_3.setup["_trigger"] === true && typeof js3_1_3.setup["_target"] === "undefined" &&
			js3_1_3.fire["_trigger"] === true && typeof js3_1_3.fire["_target"] === "undefined" &&
			js3_1_3.check["_trigger"] === true && js3_1_3.check["_target"] === true) {
			this.sendMsg( ["done"] );
		} else {
			this.sendMsg( ["error", "Incorrect final results for pubsub 3_1.3"] );
		}
	}
}

//////////////////////////////////////////////////////

js3_1_4.run = function(scriptnum) {
	js3_1_4.scriptnum = scriptnum;
	js3_1_4.subscribe = {};
	js3_1_4.setup = {};
	js3_1_4.fire = {};
	js3_1_4.check = {};

	// In callback for topic X, cancel another subscription to the same topic X
	this.hubClient.subscribe("unsub.same", js3_1.cbUnsubSame, this, function( subscriptionID, success, errCode ) {
		js3_1_4.do_setup.call(this, "_trigger");
	}, "_trigger");
	this.hubClient.subscribe("unsub.same", js3_1.cbUnsubSame, this, function( subscriptionID, success, errCode ) {
		this.subUnsubSameSubjectTarget = subscriptionID;
		js3_1_4.do_setup.call(this, "_target");
	}, "_target");
}

js3_1.cbUnsubSame = function(subject, message, subscriberData) {
	if(message.step == "setup") { 
		js3_1_4.do_fire.call(this, subscriberData);
	} else if(message.step == "fire") {
		if(subscriberData == "_trigger") {
			this.hubClient.unsubscribe(this.subUnsubSameSubjectTarget, function( subscriptionID, success, errCode ) {
				js3_1_4.do_check.call(this, subscriberData);	
			}, this);
		}
	} else if(message.step == "check") { 
		js3_1_4.do_finish.call(this, subscriberData);
	} else {
		this.sendMsg( ["error", "ERROR: invalid step " + message.step + ", " ] );	
	}
	return;
}

js3_1_4.do_setup = function(subscriberName) {
	js3_1_4.subscribe[subscriberName] = true;
	if (js3_1_4.subscribe["_trigger"] === true && js3_1_4.subscribe["_target"] === true) {
		this.hubClient.publish("unsub.same", { step: "setup" }); 
	}
}

js3_1_4.do_fire = function(data) {
	js3_1_4.setup[data] = true;
	if (js3_1_4.setup["_trigger"] === true && js3_1_4.setup["_target"] === true) {
		this.hubClient.publish("unsub.same", { step: "fire" });
	}
}

js3_1_4.do_check = function(data) {
	js3_1_4.fire[data] = true;
	if (js3_1_4.fire["_trigger"] === true) {
		this.hubClient.publish("unsub.same", { step: "check" });
	}
}

js3_1_4.do_finish = function(data) {
	js3_1_4.check[data] = true;
	if (js3_1_4.check["_trigger"] === true) {
		if (js3_1_4.setup["_trigger"] === true && js3_1_4.setup["_target"] === true &&
			js3_1_4.fire["_trigger"] === true && typeof js3_1_4.fire["_target"] === "undefined" &&
			js3_1_4.check["_trigger"] === true && typeof js3_1_4.check["_target"] === "undefined") {
			this.sendMsg( ["done"] );
		} else {
			this.sendMsg( ["error", "Incorrect final results for pubsub 3_1.4"] );
		}
	}
}

//////////////////////////////////////////////////////

js3_1_5.run = function(scriptnum) {
	js3_1_5.scriptnum = scriptnum;
	js3_1_5.subscribe = {};
	js3_1_5.setup = {};
	js3_1_5.fire = {};
	js3_1_5.check = {};

	// In callback for topic X, cancel a subscription to a different topic Y
	this.hubClient.subscribe("unsub.other.trigger", js3_1.cbUnsubOther, this, function( subscriptionID, success, errCode ) {
		js3_1_5.do_setup.call(this, "unsub.other.trigger");
	}, "_trigger");
	this.hubClient.subscribe("unsub.other.target", js3_1.cbUnsubOther, this, function( subscriptionID, success, errCode ) {
		this.subUnsubOtherTarget = subscriptionID;
		js3_1_5.do_setup.call(this, "unsub.other.target");
	}, "_target");
}

js3_1.cbUnsubOther = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		js3_1_5.do_fire.call(this, subject);
	} else if(message.step == "fire") {
		this.hubClient.unsubscribe(this.subUnsubOtherTarget, function( subscriptionID, success, errCode ) {
			js3_1_5.do_check.call(this, subject);	
		}, this);
	} else if(message.step == "check") {
		js3_1_5.do_finish.call(this, subject);
	} else {
		this.sendMsg( ["error", "ERROR: invalid step " + message.step + ", " ] );	
	}
	return;
}

js3_1_5.do_setup = function(subscriberName) {
	js3_1_5.subscribe[subscriberName] = true;
	if (js3_1_5.subscribe["unsub.other.trigger"] === true && js3_1_5.subscribe["unsub.other.target"] === true) {
		this.hubClient.publish("unsub.other.trigger", { step: "setup" }); 
		this.hubClient.publish("unsub.other.target", { step: "setup" });
	}
}

js3_1_5.do_fire = function(data) {
	js3_1_5.setup[data] = true;
	if (js3_1_5.setup["unsub.other.trigger"] === true && js3_1_5.setup["unsub.other.target"] === true) {
		this.hubClient.publish("unsub.other.trigger", { step: "fire" });
	}
}

js3_1_5.do_check = function(data) {
	js3_1_5.fire[data] = true;
	if (js3_1_5.fire["unsub.other.trigger"] === true) {
		this.hubClient.publish("unsub.other.trigger", { step: "check" });
		this.hubClient.publish("unsub.other.target", { step: "check" });
	}
}


js3_1_5.do_finish = function(data) {
	js3_1_5.check[data] = true;
	if (js3_1_5.check["unsub.other.trigger"] === true) {
		if (js3_1_5.setup["unsub.other.trigger"] === true && js3_1_5.setup["unsub.other.target"] === true &&
			js3_1_5.fire["unsub.other.trigger"] === true && typeof js3_1_5.fire["unsub.other.target"] === "undefined" &&
			js3_1_5.check["unsub.other.trigger"] === true && typeof js3_1_5.check["unsub.other.target"] === "undefined") {
			this.sendMsg( ["done"] );
		} else {
			this.sendMsg( ["error", "Incorrect final results for pubsub 3_1.5"] );
		}
	}
}

//////////////////////////////////////////////////////

js3_1_6.run = function(scriptnum) {

	this.scriptnum = scriptnum;
	js3_1_6.subscribe = {};
	js3_1_6.setup = {};
	js3_1_6.fire = {};
	js3_1_6.check = {};

	// In callback for topic X, cancel this same subscription 
	this.hubClient.subscribe("unsub.this", js3_1.cbUnsubThis, this, function( subscriptionID, success, errCode ) {
		this.subUnsubThis = subscriptionID;
		js3_1_6.do_setup.call(this, "unsub.this");
	}, "");
}

js3_1.cbUnsubThis = function(subject, message, subscriberData) {
	if(message.step == "setup") {
		js3_1_6.do_fire.call(this, subject);
	} else if(message.step == "fire") {
		this.hubClient.unsubscribe(this.subUnsubThis, function( subscriptionID, success, errCode ) {
			js3_1_6.do_check.call(this, subject);	
		}, this);
	} else if(message.step == "check") {
		this.sendMsg( ["error", "ERROR " + message.step + " should not happen, " ] );	
	} else {
		this.sendMsg( ["error", "ERROR: invalid step " + message.step + ", " ] );	
	}
	return;
}

js3_1_6.do_setup = function(subscriberName) {
	js3_1_6.subscribe[subscriberName] = true;
	if (js3_1_6.subscribe["unsub.this"] === true) {
		this.hubClient.publish("unsub.this", { step: "setup" }); 		
	}
}

js3_1_6.do_fire = function(data) {
	js3_1_6.setup[data] = true;
	if (js3_1_6.setup["unsub.this"] === true) {
		this.hubClient.publish("unsub.this", { step: "fire" });
	}
}

js3_1_6.do_check = function(data) {
	js3_1_6.fire[data] = true;
	if (js3_1_6.fire["unsub.this"] === true) {
		this.hubClient.publish("unsub.this", { step: "check" });
		js3_1_6.do_finish.call(this, null);
	}
}

js3_1_6.do_finish = function(data) {
	if (js3_1_6.setup["unsub.this"] === true && 
		js3_1_6.fire["unsub.this"] === true && 
		typeof js3_1_6.check["unsub.this"] === "undefined") {
		this.sendMsg( ["done"] );
	} else {
		this.sendMsg( ["error", "Incorrect final results for pubsub 3_1.6"] );
	}
}


//////////////////////////////////////////////////////

js3_1_7.run = function(scriptnum) {
	this.scriptnum = scriptnum;
	js3_1_7.subscribe = {};
	js3_1_7.setup = {};
	js3_1_7.fire = {};
	js3_1_7.check = {};

	// In callback for topic X, subscribe to X and publish to X
	this.hubClient.subscribe("sub.pub.same", js3_1.cbSubPubSame, this, function( subscriptionID, success, errCode ) {
		js3_1_7.do_setup.call(this, "_trigger");
	}, "_trigger");
}

js3_1.cbSubPubSame = function(subject, message, subscriberData) {
	if(message.step == "setup")  
		js3_1_7.do_fire.call(this, subscriberData);
	else if(message.step == "fire") {
		this.hubClient.subscribe(subject, js3_1.cbSubPubSame, this, function( subscriptionID, success, errCode ) {
			js3_1_7.do_check.call(this, subscriberData);	
		}, "_target");
	} else if(message.step == "check1") {
		/* message received. should be received ONCE FOR _trigger & ONCE FOR _target. */ 
		js3_1_7.do_finish.call(this, message.step+subscriberData);	
	} else if(message.step == "check2") {
		/* message received. should be received ONCE FOR _trigger & ONCE FOR _target. */
		js3_1_7.do_finish.call(this, message.step+subscriberData);	
	} else
		this.sendMsg( ["error", "ERROR: invalid step " + message.step + ", " ] );	
	return;
}


js3_1_7.do_setup = function(subscriberData) {
	js3_1_7.subscribe[subscriberData] = true;
	if (js3_1_7.subscribe["_trigger"] === true) {
		this.hubClient.publish("sub.pub.same", { step: "setup" }); 		
	}
}

js3_1_7.do_fire = function(data) {
	js3_1_7.setup[data] = true;
	if (js3_1_7.setup["_trigger"] === true) {
		this.hubClient.publish("sub.pub.same", { step: "fire" });
	}
}

js3_1_7.do_check = function(data) {
	js3_1_7.fire[data] = true;
	if (js3_1_7.fire["_trigger"] === true) {
		this.hubClient.publish("sub.pub.same", { step: "check1" });
		this.hubClient.publish("sub.pub.same", { step: "check2" });
	}
}


js3_1_7.do_finish = function(data) {
	js3_1_7.check[data] = true;
	if (js3_1_7.check["check1_trigger"] === true && js3_1_7.check["check1_target"] === true && 
		js3_1_7.check["check2_trigger"] === true && js3_1_7.check["check2_target"] === true) {
		if (js3_1_7.setup["_trigger"] === true && typeof js3_1_7.setup["_target"] === "undefined" &&
			js3_1_7.fire["_trigger"] === true && typeof js3_1_7.fire["_target"] === "undefined" &&
			js3_1_7.check["check1_trigger"] === true && js3_1_7.check["check1_target"] === true && 
			js3_1_7.check["check2_trigger"] === true && js3_1_7.check["check2_target"] === true) {
			this.sendMsg( ["done"] );
		} else {
			this.sendMsg( ["error", "Incorrect final results for pubsub 3_1.7"] );
		}
	}
}

//////////////////////////////////////////////////////

js3_1_8.run = function(scriptnum) {

	js3_1_8.scriptnum = scriptnum;
	js3_1_8.subscribe = {};
	js3_1_8.setup = {};
	js3_1_8.fire = {};
	js3_1_8.check = {};

	this.hubClient.subscribe("sub.pub.other.trigger", js3_1.cbSubPubOther, this, function( subscriptionID, success, errCode ) {
		js3_1_8.do_setup.call(this, "sub.pub.other.trigger");
	}, "_trigger");
}

js3_1.cbSubPubOther = function(subject, message, subscriberData) {
	var pubSubject = "sub.pub.other.target";
	if(message.step == "setup")  
		js3_1_8.do_fire.call(this, subject);
	else if(message.step == "fire") {
		this.hubClient.subscribe(pubSubject, js3_1.cbSubPubOther, this, function( subscriptionID, success, errCode ) {
			js3_1_8.do_check.call(this, subject);
		}, "_target");
	} else if(message.step == "check1") {
		/* message received. should be received ONCE FOR _target ONLY. */ 
		js3_1_8.do_finish.call(this, message.step+subscriberData);	
	} else if(message.step == "check2") {
		/* message received. should be received ONCE FOR _target ONLY. */
		js3_1_8.do_finish.call(this, message.step+subscriberData);	
	} else
		this.sendMsg( ["error", "ERROR: invalid step " + message.step + ", " ] );	
	return;
}

js3_1_8.do_setup = function(subscriberName) {
	js3_1_8.subscribe[subscriberName] = true;
	if (js3_1_8.subscribe["sub.pub.other.trigger"] === true) {
		this.hubClient.publish("sub.pub.other.trigger", { step: "setup" }); 		
		this.hubClient.publish("sub.pub.other.target", { step: "setup" }); 		
	}
}

js3_1_8.do_fire = function(data) {
	js3_1_8.setup[data] = true;
	if (js3_1_8.setup["sub.pub.other.trigger"] === true) {
		this.hubClient.publish("sub.pub.other.trigger", { step: "fire" });
	}
}

js3_1_8.do_check = function(subject) {
	js3_1_8.fire[subject] = true;
	if (js3_1_8.fire["sub.pub.other.trigger"] === true) {
		this.hubClient.publish("sub.pub.other.target", { step: "check1" });
		this.hubClient.publish("sub.pub.other.trigger", { step: "check2" });
		this.hubClient.publish("sub.pub.other.target", { step: "check2" });
	}
}

js3_1_8.do_finish = function(data) {
	js3_1_8.check[data] = true;
	if (js3_1_8.check["check1_target"] === true && 
		js3_1_8.check["check2_trigger"] === true && js3_1_8.check["check2_target"] === true) {
		if (js3_1_8.setup["sub.pub.other.trigger"] === true && typeof js3_1_8.setup["sub.pub.other.target"] === "undefined" &&
			js3_1_8.fire["sub.pub.other.trigger"] === true && typeof js3_1_8.fire["sub.pub.other.target"] === "undefined" &&
			typeof js3_1_8.check["check1_trigger"] === "undefined" && js3_1_8.check["check1_target"] === true && 
			js3_1_8.check["check2_trigger"] === true && js3_1_8.check["check2_target"] === true) {
			this.sendMsg( ["done"] );
		} else {
			this.sendMsg( ["error", "Incorrect final results for pubsub 3_1.8"] );
		}
	}
}

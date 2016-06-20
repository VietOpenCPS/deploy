/*******************************************************************************
 * test_longmsg.js:
 *      Component of the DOH-based test suite for the OpenAjax Hub.
 *
 *      JavaScript logic for the unit test for routines having to do with managing event
 *      publishing and event subscribing. (The "event hub" or "topic bus".)
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
 *  longmsg
 *
 *  Test that long messages can be published.  This is of particular importance
 *  to the FIM implementation, where the browser has a limit to the amount of
 *  text that can be set in the URL.  FIM gets around this by splitting large
 *  messages and sending those parts, which are recombined on the receiving
 *  end.
 **********************************************************************/

var longmsg = {
	name: "longmsg",
	description: "Large message tests"
}

longmsg.run = function()
{
    var createLargeMsg = (dojo.isIE && dojo.isIE < 8) ? longmsg.createLargeMsg_join : longmsg.createLargeMsg_concat;
    this.msg1 = createLargeMsg( 2000 );
    this.msg2 = createLargeMsg( 16000 );
    
    this.hubClient.subscribe( "longmsg.message1", longmsg.onMsg, this, null, this.msg1 );
    this.hubClient.subscribe(
            "longmsg.message2",
            longmsg.onMsg,
            this,
            function( item, success, error ) {    // onComplete
                if ( ! success ) {
            		this.sendMsg( ["error", "Failed to subscribe to 'longmsg.message2'"] );
                }
                longmsg.publishMessages.call( this );
            },
            this.msg2
    );
}

longmsg.createLargeMsg_concat = function( length )
{
	var message="";
	var max=9;
	var min=0;
	for ( var j = 0; j < length; j++ ) {
		message += Math.floor( Math.random() * (max - min + 1) + min );
	}
	return message;
}

longmsg.createLargeMsg_join = function( length )
{
	var message = [];
	var max=9;
	var min=0;
	for ( var j = 0; j < length; j++ ) {
		message[ message.length ] = Math.floor( Math.random() * (max - min + 1) + min );
	}
	return message.join();
}

longmsg.publishMessages = function()
{
    this.hubClient.publish( "longmsg.message1", this.msg1 );
    this.hubClient.publish( "longmsg.message2", this.msg2 );
}

longmsg.onMsg = function( topic, data, subscriberData )
{
    var msg = (topic == "longmsg.message1") ? this.msg1 : this.msg2;

    if ( data !== subscriberData || data !== msg ) {
		this.sendMsg( ["error", "Did not receive expected data for topic'" + topic + "'"] );
    }
    this[ topic.split(".")[1] ] = true;
    if ( this.message1 && this.message2 ) {
		this.sendMsg( ["done"] );
    }
}
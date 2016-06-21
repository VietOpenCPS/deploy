/*******************************************************************************
 * testHelper.js:
 *      Component of the DOH-based test suite for the OpenAjax Hub.
 *
 *      Helper methods for creating unit tests.
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

var testHelper =
{

	// Set testHelper.config the value of the URL parameter 'config'
    setConfigFromURLParam: function() {
		this.config = null;
		var qstr = window.location.search.substr(1);
		if(qstr.length){
			var qparts = qstr.split("&");
			for(var x=0; x<qparts.length; x++){
				var tp = qparts[x].split("=");
				if(tp[0] == "config"){
					this.config = tp[1];
					break;
				}
			}
		}
    },

	// Returns root of href up to but not including 'testsrc/' 
    pathToTestsrc: function(href) {
		var teststring = '/testsrc/';
		var start = href.indexOf(teststring);
		if (start === -1) {
			throw new Error("pathToTestsrc(): href does not include substring '/testsrc/'");
		} else {
			var retval = href.substr(0,start+1);
			return retval;
		}
	},

	// Returns location of tunnelURI based on URL param 'config' (see loadHub.js for more about 'config') 
    tunnelURIFromConfigURLParam: function(pathToTestsrc) {
		var retval;

		// Extract 'config' value from URL parameter from web page's URL
		var config = null;
		var qstr = window.location.search.substr(1);
		if(qstr.length){
			var qparts = qstr.split("&");
			for(var x=0; x<qparts.length; x++){
				var tp = qparts[x].split("=");
				if(tp[0] == "config"){
					config = tp[1];
				}
			}
		}

		// Return proper location for tunnelURI based on 'config'
		if (config === "src") {
			retval = pathToTestsrc+"src/containers/iframe/rpc/rpc_relay.html";
		} else if (config === "release_all") {
			retval = pathToTestsrc+"release/all/rpc_relay.html";
		} else if (config === "release_all_separate_rpc") {
			retval = pathToTestsrc+"release/all_separate_rpc/rpc_relay.html";
		} else if (config === "release_core") {
			retval = pathToTestsrc+"release/core/rpc_relay.html";
		} else if (config === "release_core_separate_rpc") {
			retval = pathToTestsrc+"release/core_separate_rpc/rpc_relay.html";
		} else if (config === "release_unmanagedhub") {
			retval = "";	// There is no tunnel for Unmanaged Hub
		} else {
			throw new Error("tunnelURIFromConfigURLParam: Invalid or missing value for URL param 'config'");
		}
		return retval;
	},

    print: function( msg ) {
        doh.debug( this.name + ": " + msg );
    },

    // Checks that result contains everything in the expectedResults
    // array and nothing else
    checkResult: function( expectedResults ) {
        for ( var i = 0; i < expectedResults.length; i++ ) {
            var e = expectedResults[i] + ",";
            if ( this.result.indexOf( e ) == -1 ) {
                return false;
            }
        
            this.result = this.result.replace( e + " ", "" );
        }
    
        if ( this.result != "start, end" ) {
            return false;
        }
        return true;
    },

    assertErrorMsg: function( expectedErrorMsg, scope, functionName, args, hint, testHarness )
    {
        var test = testHarness || doh;
        args = args || [];  // IE doesn't seem to like null 'args'
    	try{
    		scope[functionName].apply(scope, args);
    	}catch (e){
    	    test.assertTrue( e.message == expectedErrorMsg,
    	            "assertError() failed:\n\texpected error\n\t\t"+expectedErrorMsg+"\n\tbut got\n\t\t"+e.message+"\n\n"+hint+"\n\n" );
    	    return;
    	}
    	test.assertTrue( false, "assertError() failed:\n\texpected error\n\t\t"+expectedErrorMsg+"\n\tbut no error caught\n\n"+hint+"\n\n" );
    }
};

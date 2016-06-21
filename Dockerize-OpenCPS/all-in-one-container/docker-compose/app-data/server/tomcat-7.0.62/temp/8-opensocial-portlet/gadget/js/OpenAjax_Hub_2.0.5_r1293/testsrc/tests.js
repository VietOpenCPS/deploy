/*******************************************************************************
 * tests.js:
 *      Component of the DOH-based test suite for the OpenAjax Hub.
 *
 *      This file runs the full set of automatic test files for the Hub.
 *      It first extracts the 'configs=' URL parameter to determine
 *      which configuration of the Hub should be tested.
 *      Two options:
 *          configs=src => Run tests against the files in trunk/src
 *          configs=all => Run tests against trunk/src and all release configs
 *
 *      The Hub's automatic testing uses the Dojo DOH testing framework. 
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

try{
    /* Find SCRIPT tag for the tests.js file. Extract the 'configs' param. */
    var script_elems = document.getElementsByTagName("script");
    //var path = null;
    var configs = null;
    for (var i=0;i<script_elems.length;i++) {
        var s = script_elems[i];
        var re = new RegExp("tests.js"+".*$");
        if (s.src && s.src.match(re)) {
            //var path = s.src.replace(re,'');
            var configs_array = s.src.match(/\?.*configs=([A-Za-z_]*)/);
            if (configs_array !== null) {
                configs = configs_array[1];
                break;
            }
        }
    }
    
	var configs_list;
	if (configs === "src") {
		configs_list = ["src"];
	} else if (configs === "release") {
		configs_list = ["release_all", "release_all_separate_rpc", "release_core", "release_core_separate_rpc"];
	} else if (configs === "release_all") {
		configs_list = ["release_all"];
	} else if (configs === "release_all_separate_rpc") {
		configs_list = ["release_all_separate_rpc"];
	} else if (configs === "release_core") {
		configs_list = ["release_core"];
	} else if (configs === "release_core_separate_rpc") {
		configs_list = ["release_core_separate_rpc"];
	} else if (configs === "all") {
		configs_list = ["src", "release_all", "release_all_separate_rpc", "release_core", "release_core_separate_rpc"];
	} else {
		throw new Error("Incorrect or missing URL parameter 'configs'. Must be either 'all' or 'src'.");
	}
	
    for (var i=0; i<configs_list.length; i++) {
        var config = configs_list[i];
        
        doh.registerUrl( "ContainerIface-inline-"+config, "../../../testsrc/test_container_iface.html?config=" + config + "&module=inline", 20000 );
        doh.registerUrl( "ContainerIface-iframe-"+config, "../../../testsrc/test_container_iface.html?config=" + config + "&module=iframe", 40000 );

        doh.registerUrl( "HubClientIface-inline-"+config, "../../../testsrc/test_hubclient_iface.html?config=" + config + "&module=inline", 20000 );
        doh.registerUrl( "HubClientIface-iframe-"+config, "../../../testsrc/test_hubclient_iface.html?config=" + config + "&module=iframe", 50000 );
            
        doh.registerUrl( "HubIface-manager-"+config, "../../../testsrc/test_hub_iface.html?config=" + config + "&module=manager", 20000 );
        doh.registerUrl( "HubIface-inline-"+config, "../../../testsrc/test_hub_iface.html?config=" + config + "&module=inline", 20000 );
        doh.registerUrl( "HubIface-iframe-"+config, "../../../testsrc/test_hub_iface.html?config=" + config + "&module=iframe", 40000 );
        
        doh.registerUrl( "ManagedHub-"+config, "../../../testsrc/test_managedhub_class.html?config=" + config, 30000 );
        
        doh.registerUrl( "PubSub-unmanaged-"+config, "../../../testsrc/testPubSub.html?config="+config+"&client0=unmanaged", 20000 );

        var pubsubmodules = {inline:1, iframe:1, manager:1};
        var pubsubtests = [
            {testname:"1_1",testscriptfile:"test_pubsub_1_1.js",testobjname:"js1_1"},
            {testname:"1_2_1",testscriptfile:"test_pubsub_1_2_1.js",testobjname:"js1_2_1"},
            {testname:"1_3_1",testscriptfile:"test_pubsub_1_3_1.js",testobjname:"js1_3_1"},
            {testname:"2_2",testscriptfile:"test_pubsub_2_2.js",testobjname:"js2_2"},
            {testname:"3_1_0",testscriptfile:"test_pubsub_3_1.js",testobjname:"js3_1_0"},
            {testname:"3_1_1",testscriptfile:"test_pubsub_3_1.js",testobjname:"js3_1_1"},
            {testname:"3_1_2",testscriptfile:"test_pubsub_3_1.js",testobjname:"js3_1_2"},
            {testname:"3_1_3",testscriptfile:"test_pubsub_3_1.js",testobjname:"js3_1_3"},
            {testname:"3_1_4",testscriptfile:"test_pubsub_3_1.js",testobjname:"js3_1_4"},
            {testname:"3_1_5",testscriptfile:"test_pubsub_3_1.js",testobjname:"js3_1_5"},
            {testname:"3_1_6",testscriptfile:"test_pubsub_3_1.js",testobjname:"js3_1_6"},
            {testname:"3_1_7",testscriptfile:"test_pubsub_3_1.js",testobjname:"js3_1_7"},
            {testname:"3_1_8",testscriptfile:"test_pubsub_3_1.js",testobjname:"js3_1_8"},
            {testname:"longmsg",testscriptfile:"test_pubsub_longmsg.js",testobjname:"longmsg"}
        ];
        /* Uncomment this out and modify if you want to run only a subset of the pubset tests.
        //var pubsubmodules = {iframe:1};
        var pubsubtests = [
            {testname:"1_1",testscriptfile:"test_pubsub_1_1.js",testobjname:"js1_1"}
        ];
        */
        for (var itest=0; itest<pubsubtests.length; itest++) {
            var testname = pubsubtests[itest].testname;
            var htmlfile = pubsubtests[itest].htmlfile;
            var testscriptfile = pubsubtests[itest].testscriptfile;
            var testobjname = pubsubtests[itest].testobjname;
            for (var module in pubsubmodules) {
                doh.registerUrl( "PubSub-"+testname+"-"+module+"-"+config, "../../../testsrc/test_pubsub.html?config="+config+"&module="+module+"&testname="+testname+"&testscriptfile="+testscriptfile+"&testobjname="+testobjname, 40000 );
            }
        }
        // doh.registerUrl( "testManagedHubCallbacks", "../../../testsrc/testManagedHubCallbacks.html?config="+config );

        doh.registerUrl( "IframeTests-"+config, "../../../testsrc/test_iframe.html?config="+config, 20000 );
        doh.registerUrl( "SecurityTests-"+config, "../../../testsrc/test_security.html?config="+config, 50000 );
    }
} catch( e ) {
    doh.debug( e );
}

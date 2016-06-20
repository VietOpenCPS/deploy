/*******************************************************************************
 * loadHub.js:
 *      Component of the DOH-based test suite for the OpenAjax Hub.
 *
 *      Add the correct set SCRIPT elements to the current page based
 *		on the value of URL param 'config'.
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

// Wrap logic in a closure to prevent leakage of global variables
(function() {

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

	// "loadHub_dirDepth" global variable must be set before loading this script file
	if (typeof loadHub_dirDepth == "undefined") {
		throw new Error("global variable loadHub_dirDepth must have a value before loading loadHub.js");
	}
	var dirDepth = loadHub_dirDepth; 
	var script_src_prefix = "";
	for (var i=0; i<dirDepth; i++) {
		script_src_prefix += "../";
	}


	function addScriptTag(src) {
		document.write("<scr"+"ipt type='text/javascript' src='"+script_src_prefix+src+"'></scr"+"ipt>");
	}

	if (config === "src") {
		addScriptTag("src/OpenAjax-mashup.js");
		addScriptTag("src/containers/iframe/iframe.js");
		addScriptTag("src/containers/iframe/crypto.js");
		addScriptTag("src/containers/inline/inline.js");
		addScriptTag("src/containers/iframe/json2.js");
    addScriptTag("src/containers/iframe/rpc/rpc-dependencies.js");
    addScriptTag("src/containers/iframe/rpc/fe.transport.js");
    addScriptTag("src/containers/iframe/rpc/ifpc.transport.js");
    addScriptTag("src/containers/iframe/rpc/nix.transport.js");
    addScriptTag("src/containers/iframe/rpc/rmr.transport.js");
    addScriptTag("src/containers/iframe/rpc/wpm.transport.js");
    addScriptTag("src/containers/iframe/rpc/rpc.js");
	} else if (config === "release_all") {
		addScriptTag("release/all/OpenAjaxManagedHub-all.js");
	} else if (config === "release_all_separate_rpc") {
		addScriptTag("release/all_separate_rpc/OpenAjaxManagedHub-all-oaa.js");
		addScriptTag("release/all_separate_rpc/OpenAjaxManagedHub-rpc.js");
	} else if (config === "release_core") {
		addScriptTag("release/core/OpenAjaxManagedHub-core.js");
		addScriptTag("release/core/OpenAjaxManagedHub-iframe.js");
	} else if (config === "release_core_separate_rpc") {
		addScriptTag("release/core_separate_rpc/OpenAjaxManagedHub-core.js");
		addScriptTag("release/core_separate_rpc/OpenAjaxManagedHub-iframe-oaa.js");
		addScriptTag("release/core_separate_rpc/OpenAjaxManagedHub-rpc.js");
	} else if (config === "release_unmanagedhub") {
		addScriptTag("release/unmanagedhub/OpenAjaxUnmanagedHub.js");
	} else {
		throw new Error("loadHub: Invalid or missing value for URL param 'config' (URI=" + window.location.href + ")");
	}

})();

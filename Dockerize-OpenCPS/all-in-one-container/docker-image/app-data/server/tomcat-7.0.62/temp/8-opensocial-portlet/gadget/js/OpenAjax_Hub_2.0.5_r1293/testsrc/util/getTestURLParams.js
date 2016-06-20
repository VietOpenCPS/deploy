/*******************************************************************************
 * getTestURLParams.js:
 *      Component of the DOH-based test suite for the OpenAjax Hub.
 *
 *      Look for a series of URL params. If found, set some global variables.
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

var TestURLParams = {};
TestURLParams.client0 = null;
TestURLParams.client1 = null;
TestURLParams.client2 = null;
TestURLParams.client3 = null;
TestURLParams.client4 = null;
TestURLParams.getTestURLParams = function () {
	var qstr = window.location.search.substr(1);
	if(qstr.length){
		var qparts = qstr.split("&");
		for(var x=0; x<qparts.length; x++){
			var tp = qparts[x].split("=");
			if (tp[0] == "client0") {
				TestURLParams.client0 = tp[1];
			} else if (tp[0] === "client1") {
				TestURLParams.client1 = tp[1];
			} else if (tp[0] === "client2") {
				TestURLParams.client2 = tp[1];
			} else if (tp[0] === "client3") {
				TestURLParams.client3 = tp[1];
			} else if (tp[0] === "client4") {
				TestURLParams.client4 = tp[1];
			}
		}
	}
}();

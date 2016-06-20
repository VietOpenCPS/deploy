/*******************************************************************************
 * test_release_core.js:
 *      Component of the automatic test suite for the OpenAjax Hub.
 *
 *      This file is loaded by testall.html in order to run the full set of automatic test
 *      files against all configurations of the OpenAjax Hub  (src/ and release/).
 *
 *      This file loads tests.js, with URL parameter of configs=release_core, which bring in the full
 *      test suite and run it against the release/core configuration.
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
	dojo.require("dojo.io.script");
	dojo.io.script.get({
		url:"../../../testsrc/tests.js?configs=release_core"
	});
} catch( e ) {
    doh.debug( e );
}

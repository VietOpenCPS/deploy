/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * @fileoverview External functions used by the OpenSocial RPC code.  This file
 *               is for use by OpenAjax only.
 */

    //---   from core.util/util.js   ---//

/**
 * @static
 * @class Provides general-purpose utility functions.
 * @name gadgets.util
 */

OpenAjax.gadgets.util = function() {
  /**
   * Parses URL parameters into an object.
   * @param {string} url - the url parameters to parse
   * @return {Array.<string>} The parameters as an array
   */
  function parseUrlParams(url) {
    // Get settings from url, 'hash' takes precedence over 'search' component
    // don't use document.location.hash due to browser differences.
    var query;
    var queryIdx = url.indexOf("?");
    var hashIdx = url.indexOf("#");
    if (hashIdx === -1) {
      query = url.substr(queryIdx + 1);
    } else {
      // essentially replaces "#" with "&"
      query = [url.substr(queryIdx + 1, hashIdx - queryIdx - 1), "&",
               url.substr(hashIdx + 1)].join("");
    }
    return query.split("&");
  }

  var parameters = null;
  var onLoadHandlers = [];

  return /** @scope gadgets.util */ {

    /**
     * Gets the URL parameters.
     *
     * @param {string=} opt_url Optional URL whose parameters to parse.
     *                         Defaults to window's current URL.
     * @return {Object} Parameters passed into the query string
     * @member gadgets.util
     * @private Implementation detail.
     */
    getUrlParameters : function (opt_url) {
      if (parameters !== null && typeof opt_url === "undefined") {
        // "parameters" is a cache of current window params only.
        return parameters;
      }
      var parsed = {};
      var pairs = parseUrlParams(opt_url || document.location.href);
      var unesc = window.decodeURIComponent ? decodeURIComponent : unescape;
      for (var i = 0, j = pairs.length; i < j; ++i) {
        var pos = pairs[i].indexOf('=');
        if (pos === -1) {
          continue;
        }
        var argName = pairs[i].substring(0, pos);
        var value = pairs[i].substring(pos + 1);
        // difference to IG_Prefs, is that args doesn't replace spaces in
        // argname. Unclear on if it should do:
        // argname = argname.replace(/\+/g, " ");
        value = value.replace(/\+/g, " ");
        parsed[argName] = unesc(value);
      }
      if (typeof opt_url === "undefined") {
        // Cache current-window params in parameters var.
        parameters = parsed;
      }
      return parsed;
    },

    /**
     * Registers an onload handler.
     * @param {function()} callback The handler to run
     *
     * @member gadgets.util
     */
    registerOnLoadHandler : function (callback) {
      onLoadHandlers.push(callback);
    },

    /**
     * Runs all functions registered via registerOnLoadHandler.
     * @private Only to be used by the container, not gadgets.
     */
    runOnLoadHandlers : function () {
      for (var i = 0, j = onLoadHandlers.length; i < j; ++i) {
        onLoadHandlers[i]();
      }
    },

    /**
     * Attach an event listener to given DOM element
     * 
     * @param {object} elem  DOM element on which to attach event.
     * @param {string} eventName  Event type to listen for.
     * @param {function} callback  Invoked when specified event occurs.
     * @param {boolean} useCapture  If true, initiates capture.
     */
    'attachBrowserEvent': function(elem, eventName, callback, useCapture) {
      if (elem.addEventListener) {
        elem.addEventListener(eventName, callback, useCapture);
      } else if (elem.attachEvent) {
        elem.attachEvent('on' + eventName, callback);
      }
    },

    /**
     * Remove event listener
     * 
     * @param {object} elem  DOM element from which to remove event.
     * @param {string} eventName  Event type to remove.
     * @param {function} callback  Listener to remove.
     * @param {boolean} useCapture  Specifies whether listener being removed was added with
     *                              capture enabled.
     */
    'removeBrowserEvent': function(elem, eventName, callback, useCapture) {
      if (elem.removeEventListener) {
        elem.removeEventListener(eventName, callback, useCapture);
      } else if (elem.detachEvent){
        elem.detachEvent('on' + eventName, callback);
      }
    }
  };
}();
// Initialize url parameters so that hash data is pulled in before it can be
// altered by a click.
OpenAjax.gadgets.util.getUrlParameters();


    //---   from core.json/json.js   ---//

OpenAjax.gadgets.json = OpenAjax.gadgets.json || {};
if ( ! OpenAjax.gadgets.json.stringify ) {
  OpenAjax.gadgets.json = {
    parse: function(str) {
      try {
        return window.JSON.parse(str);
      } catch (e) {
        return false;
      }
    },
    stringify: function(obj) {
      try {
        return window.JSON.stringify(obj);
      } catch (e) {
        return null;
      }
    }
  };
}


    //---   from core.log/log.js   ---//

/**
 * Log an informational message
 */
OpenAjax.gadgets.log = function(message) {
  OpenAjax.gadgets.log.logAtLevel(OpenAjax.gadgets.log.INFO, message);
};

 
/**
 * Log a warning
 */
OpenAjax.gadgets.warn = function(message) {
  OpenAjax.gadgets.log.logAtLevel(OpenAjax.gadgets.log.WARNING, message);
};

/**
 * Log an error
 */
OpenAjax.gadgets.error = function(message) {
  OpenAjax.gadgets.log.logAtLevel(OpenAjax.gadgets.log.ERROR, message);
};

/**
 * Sets the log level threshold.
 * @param {Number} logLevel - New log level threshold.
 * @static
 */
OpenAjax.gadgets.setLogLevel = function(logLevel) {
  OpenAjax.gadgets.log.logLevelThreshold_ = logLevel;
};

/**
 * Logs a log message if output console is available, and log threshold is met.
 * @param {Number} level - the level to log with. Optional, defaults to
 * @param {Object} message - The message to log
 * gadgets.log.INFO.
 * @static
 */
OpenAjax.gadgets.log.logAtLevel = function(level, message) {
  if (level < OpenAjax.gadgets.log.logLevelThreshold_ || !OpenAjax.gadgets.log._console) {
    return;
  }

  var logger;
  var gadgetconsole = OpenAjax.gadgets.log._console;

  if (level == OpenAjax.gadgets.log.WARNING && gadgetconsole.warn) {
    gadgetconsole.warn(message)
  } else if (level == OpenAjax.gadgets.log.ERROR && gadgetconsole.error) {
    gadgetconsole.error(message);
  } else if (gadgetconsole.log) {
    gadgetconsole.log(message);
  }
};

/**
 * Log level for informational logging.
 * @static
 */
OpenAjax.gadgets.log.INFO = 1;

/**
 * Log level for warning logging.
 * @static
 */
OpenAjax.gadgets.log.WARNING = 2;

/**
 * Log level for error logging.
 * @static
 */
OpenAjax.gadgets.log.ERROR = 3;

/**
 * Log level for no logging
 * @static
 */
OpenAjax.gadgets.log.NONE = 4;

/**
 * Current log level threshold.
 * @type Number
 * @private
 * @static
 */
OpenAjax.gadgets.log.logLevelThreshold_ = OpenAjax.gadgets.log.INFO;

/**
 * Console to log to
 * @private
 * @static
 */
OpenAjax.gadgets.log._console = window.console ? window.console :
                       window.opera   ? window.opera.postError : undefined;


////////////////////////////////////////////////////////////////////////////////////////////////////
//  onload handler compatibility code
////////////////////////////////////////////////////////////////////////////////////////////////////

(function() {
// XXX What if this script file (iframe.js) is dynamically loaded after the page has loaded.
if ( ! window.__isgadget ) {
    var loaded = false;
    function onload() {
        if ( ! loaded ) {
            loaded = true;
            // This is necessary for the RMR and FE transports.
            OpenAjax.gadgets.util.runOnLoadHandlers();
            // Since the page has now loaded, change registerOnLoadHandler() to immediately fire
            // callback.
            OpenAjax.gadgets.util.registerOnLoadHandler = function( callback ) {
                setTimeout( callback, 0 );
            };
            // prevent IE memory leak
            if ( window.detachEvent ) {
                window.detachEvent( "onload", onload );
            }
        }
    }
    if ( window.addEventListener ) {
        document.addEventListener( "DOMContentLoaded", onload, false );
        window.addEventListener( "load", onload, false );
    } else if ( window.attachEvent ) {
        // XXX use doScroll trick?
        window.attachEvent( "onload", onload );
    }
}
})();

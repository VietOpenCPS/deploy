var TestIframeContainer = function() {};

TestIframeContainer.createContainerForTest = function( testName, hub, clientID, params, paramsAsIs, urlparamstring )
{
    var pathToTestsrc = testHelper.pathToTestsrc(window.location.href);
    var tunnelUri = testHelper.tunnelURIFromConfigURLParam(pathToTestsrc);

    if ( ! paramsAsIs && params && params.IframeContainer ) {
        if ( ! params.IframeContainer.uri ) {
            params.IframeContainer.uri = TestIframeContainer.createIframeURI( COMPONENT1_DOMAIN + HUB20_PATH + "/testsrc/ifr/" + testName + ".html", urlparamstring );
        }
        if ( ! params.IframeContainer.tunnelURI ) {
            var channel = OpenAjax.gadgets.rpc.getRelayChannel();
            if (channel === 'wpm' || channel === 'nix') {
                params.IframeContainer.tunnelURI = tunnelUri;
            }
        }
    }
    
    return new OpenAjax.hub.IframeContainer( hub, clientID, params );
};

TestIframeContainer.createIframeURI = function( uri, urlparamstring )
{
    var config = OpenAjax.gadgets.util.getUrlParameters().config;
	var paramStr = "";
	if (config && urlparamstring) {
		paramStr = "?config=" + config + "&" + urlparamstring;
	} else if (config) {
		paramStr = "?config=" + config;
	} else if (urlparamstring) {
		paramStr = "?" + urlparamstring;
	}
    return uri + paramStr;
};


OpenAjax = {};
OpenAjax.hubspi = new (function() {
	this.register = function(provider) { 
		alert("registering provider name:" + provider.getName() + 
			" version:" + provider.getVersion());
		return true; 
	}
	this.registerClient = function(provider, clientName) { 
		alert("registering client:" + clientName + " by provider name:" + 
			provider.getName() + " version:" + provider.getVersion());
		return true;
	}
	this.publishEvent = function(clientName, topic, data) {
		alert("publishEvent:" + " clientName:" + clientName + " topic:" + topic + " data:" + data);
		return;
	}
	this.subscribeReq = function(clientName, topic, subId) {
		alert("subscribeReq:" + " clientName:" + clientName + " topic:" + topic + " subId:" + subId);
		return true;
	}
	this.unsubscribeReq = function(clientName, subId) {
		alert("unsubscribeReq:" + " clientName:" + clientName + " subId:" + subId);
		return true;
	}
})();

	
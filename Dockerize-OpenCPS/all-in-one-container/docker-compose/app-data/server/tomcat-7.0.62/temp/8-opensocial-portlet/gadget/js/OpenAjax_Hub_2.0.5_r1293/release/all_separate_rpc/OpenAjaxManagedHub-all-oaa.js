var OpenAjax=OpenAjax||{};
if(!OpenAjax.hub){
OpenAjax.hub=function(){
var _1={};
var _2="org.openajax.hub.";
return {implementer:"http://openajax.org",implVersion:"2.0.5",specVersion:"2.0",implExtraData:{},libraries:_1,registerLibrary:function(_3,_4,_5,_6){
_1[_3]={prefix:_3,namespaceURI:_4,version:_5,extraData:_6};
this.publish(_2+"registerLibrary",_1[_3]);
},unregisterLibrary:function(_7){
this.publish(_2+"unregisterLibrary",_1[_7]);
delete _1[_7];
}};
}();
OpenAjax.hub.Error={BadParameters:"OpenAjax.hub.Error.BadParameters",Disconnected:"OpenAjax.hub.Error.Disconnected",Duplicate:"OpenAjax.hub.Error.Duplicate",NoContainer:"OpenAjax.hub.Error.NoContainer",NoSubscription:"OpenAjax.hub.Error.NoSubscription",NotAllowed:"OpenAjax.hub.Error.NotAllowed",WrongProtocol:"OpenAjax.hub.Error.WrongProtocol",IncompatBrowser:"OpenAjax.hub.Error.IncompatBrowser"};
OpenAjax.hub.SecurityAlert={LoadTimeout:"OpenAjax.hub.SecurityAlert.LoadTimeout",FramePhish:"OpenAjax.hub.SecurityAlert.FramePhish",ForgedMsg:"OpenAjax.hub.SecurityAlert.ForgedMsg"};
OpenAjax.hub._debugger=function(){
};
OpenAjax.hub.ManagedHub=function(_8){
if(!_8||!_8.onPublish||!_8.onSubscribe){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
this._p=_8;
this._onUnsubscribe=_8.onUnsubscribe?_8.onUnsubscribe:null;
this._scope=_8.scope||window;
if(_8.log){
var _9=this;
this._log=function(_a){
try{
_8.log.call(_9._scope,"ManagedHub: "+_a);
}
catch(e){
OpenAjax.hub._debugger();
}
};
}else{
this._log=function(){
};
}
this._subscriptions={c:{},s:null};
this._containers={};
this._seq=0;
this._active=true;
this._isPublishing=false;
this._pubQ=[];
};
OpenAjax.hub.ManagedHub.prototype.subscribeForClient=function(_b,_c,_d){
this._assertConn();
if(this._invokeOnSubscribe(_c,_b)){
return this._subscribe(_c,this._sendToClient,this,{c:_b,sid:_d});
}
throw new Error(OpenAjax.hub.Error.NotAllowed);
};
OpenAjax.hub.ManagedHub.prototype.unsubscribeForClient=function(_e,_f){
this._unsubscribe(_f);
this._invokeOnUnsubscribe(_e,_f);
};
OpenAjax.hub.ManagedHub.prototype.publishForClient=function(_10,_11,_12){
this._assertConn();
this._publish(_11,_12,_10);
};
OpenAjax.hub.ManagedHub.prototype.disconnect=function(){
this._active=false;
for(var c in this._containers){
this.removeContainer(this._containers[c]);
}
};
OpenAjax.hub.ManagedHub.prototype.getContainer=function(_13){
var _14=this._containers[_13];
return _14?_14:null;
};
OpenAjax.hub.ManagedHub.prototype.listContainers=function(){
var res=[];
for(var c in this._containers){
res.push(this._containers[c]);
}
return res;
};
OpenAjax.hub.ManagedHub.prototype.addContainer=function(_15){
this._assertConn();
var _16=_15.getClientID();
if(this._containers[_16]){
throw new Error(OpenAjax.hub.Error.Duplicate);
}
this._containers[_16]=_15;
};
OpenAjax.hub.ManagedHub.prototype.removeContainer=function(_17){
var _18=_17.getClientID();
if(!this._containers[_18]){
throw new Error(OpenAjax.hub.Error.NoContainer);
}
_17.remove();
delete this._containers[_18];
};
OpenAjax.hub.ManagedHub.prototype.subscribe=function(_19,_1a,_1b,_1c,_1d){
this._assertConn();
this._assertSubTopic(_19);
if(!_1a){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
_1b=_1b||window;
if(!this._invokeOnSubscribe(_19,null)){
this._invokeOnComplete(_1c,_1b,null,false,OpenAjax.hub.Error.NotAllowed);
return;
}
var _1e=this;
function _1f(_20,_21,sd,_22){
if(_1e._invokeOnPublish(_20,_21,_22,null)){
try{
_1a.call(_1b,_20,_21,_1d);
}
catch(e){
OpenAjax.hub._debugger();
_1e._log("caught error from onData callback to Hub.subscribe(): "+e.message);
}
}
};
var _23=this._subscribe(_19,_1f,_1b,_1d);
this._invokeOnComplete(_1c,_1b,_23,true);
return _23;
};
OpenAjax.hub.ManagedHub.prototype.publish=function(_24,_25){
this._assertConn();
this._assertPubTopic(_24);
this._publish(_24,_25,null);
};
OpenAjax.hub.ManagedHub.prototype.unsubscribe=function(_26,_27,_28){
this._assertConn();
if(!_26){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
this._unsubscribe(_26);
this._invokeOnUnsubscribe(null,_26);
this._invokeOnComplete(_27,_28,_26,true);
};
OpenAjax.hub.ManagedHub.prototype.isConnected=function(){
return this._active;
};
OpenAjax.hub.ManagedHub.prototype.getScope=function(){
return this._scope;
};
OpenAjax.hub.ManagedHub.prototype.getSubscriberData=function(_29){
this._assertConn();
var _2a=_29.split(".");
var sid=_2a.pop();
var sub=this._getSubscriptionObject(this._subscriptions,_2a,0,sid);
if(sub){
return sub.data;
}
throw new Error(OpenAjax.hub.Error.NoSubscription);
};
OpenAjax.hub.ManagedHub.prototype.getSubscriberScope=function(_2b){
this._assertConn();
var _2c=_2b.split(".");
var sid=_2c.pop();
var sub=this._getSubscriptionObject(this._subscriptions,_2c,0,sid);
if(sub){
return sub.scope;
}
throw new Error(OpenAjax.hub.Error.NoSubscription);
};
OpenAjax.hub.ManagedHub.prototype.getParameters=function(){
return this._p;
};
OpenAjax.hub.ManagedHub.prototype._sendToClient=function(_2d,_2e,sd,_2f){
if(!this.isConnected()){
return;
}
if(this._invokeOnPublish(_2d,_2e,_2f,sd.c)){
sd.c.sendToClient(_2d,_2e,sd.sid);
}
};
OpenAjax.hub.ManagedHub.prototype._assertConn=function(){
if(!this.isConnected()){
throw new Error(OpenAjax.hub.Error.Disconnected);
}
};
OpenAjax.hub.ManagedHub.prototype._assertPubTopic=function(_30){
if(!_30||_30===""||(_30.indexOf("*")!=-1)||(_30.indexOf("..")!=-1)||(_30.charAt(0)==".")||(_30.charAt(_30.length-1)==".")){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
};
OpenAjax.hub.ManagedHub.prototype._assertSubTopic=function(_31){
if(!_31){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var _32=_31.split(".");
var len=_32.length;
for(var i=0;i<len;i++){
var p=_32[i];
if((p==="")||((p.indexOf("*")!=-1)&&(p!="*")&&(p!="**"))){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
if((p=="**")&&(i<len-1)){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
}
};
OpenAjax.hub.ManagedHub.prototype._invokeOnComplete=function(_33,_34,_35,_36,_37){
if(_33){
try{
_34=_34||window;
_33.call(_34,_35,_36,_37);
}
catch(e){
OpenAjax.hub._debugger();
this._log("caught error from onComplete callback: "+e.message);
}
}
};
OpenAjax.hub.ManagedHub.prototype._invokeOnPublish=function(_38,_39,_3a,_3b){
try{
return this._p.onPublish.call(this._scope,_38,_39,_3a,_3b);
}
catch(e){
OpenAjax.hub._debugger();
this._log("caught error from onPublish callback to constructor: "+e.message);
}
return false;
};
OpenAjax.hub.ManagedHub.prototype._invokeOnSubscribe=function(_3c,_3d){
try{
return this._p.onSubscribe.call(this._scope,_3c,_3d);
}
catch(e){
OpenAjax.hub._debugger();
this._log("caught error from onSubscribe callback to constructor: "+e.message);
}
return false;
};
OpenAjax.hub.ManagedHub.prototype._invokeOnUnsubscribe=function(_3e,_3f){
if(this._onUnsubscribe){
var _40=_3f.slice(0,_3f.lastIndexOf("."));
try{
this._onUnsubscribe.call(this._scope,_40,_3e);
}
catch(e){
OpenAjax.hub._debugger();
this._log("caught error from onUnsubscribe callback to constructor: "+e.message);
}
}
};
OpenAjax.hub.ManagedHub.prototype._subscribe=function(_41,_42,_43,_44){
var _45=_41+"."+this._seq;
var sub={scope:_43,cb:_42,data:_44,sid:this._seq++};
var _46=_41.split(".");
this._recursiveSubscribe(this._subscriptions,_46,0,sub);
return _45;
};
OpenAjax.hub.ManagedHub.prototype._recursiveSubscribe=function(_47,_48,_49,sub){
var _4a=_48[_49];
if(_49==_48.length){
sub.next=_47.s;
_47.s=sub;
}else{
if(typeof _47.c=="undefined"){
_47.c={};
}
if(typeof _47.c[_4a]=="undefined"){
_47.c[_4a]={c:{},s:null};
this._recursiveSubscribe(_47.c[_4a],_48,_49+1,sub);
}else{
this._recursiveSubscribe(_47.c[_4a],_48,_49+1,sub);
}
}
};
OpenAjax.hub.ManagedHub.prototype._publish=function(_4b,_4c,_4d){
if(this._isPublishing){
this._pubQ.push({t:_4b,d:_4c,p:_4d});
return;
}
this._safePublish(_4b,_4c,_4d);
while(this._pubQ.length>0){
var pub=this._pubQ.shift();
this._safePublish(pub.t,pub.d,pub.p);
}
};
OpenAjax.hub.ManagedHub.prototype._safePublish=function(_4e,_4f,_50){
this._isPublishing=true;
var _51=_4e.split(".");
this._recursivePublish(this._subscriptions,_51,0,_4e,_4f,_50);
this._isPublishing=false;
};
OpenAjax.hub.ManagedHub.prototype._recursivePublish=function(_52,_53,_54,_55,msg,_56){
if(typeof _52!="undefined"){
var _57;
if(_54==_53.length){
_57=_52;
}else{
this._recursivePublish(_52.c[_53[_54]],_53,_54+1,_55,msg,_56);
this._recursivePublish(_52.c["*"],_53,_54+1,_55,msg,_56);
_57=_52.c["**"];
}
if(typeof _57!="undefined"){
var sub=_57.s;
while(sub){
var sc=sub.scope;
var cb=sub.cb;
var d=sub.data;
if(typeof cb=="string"){
cb=sc[cb];
}
cb.call(sc,_55,msg,d,_56);
sub=sub.next;
}
}
}
};
OpenAjax.hub.ManagedHub.prototype._unsubscribe=function(_58){
var _59=_58.split(".");
var sid=_59.pop();
if(!this._recursiveUnsubscribe(this._subscriptions,_59,0,sid)){
throw new Error(OpenAjax.hub.Error.NoSubscription);
}
};
OpenAjax.hub.ManagedHub.prototype._recursiveUnsubscribe=function(_5a,_5b,_5c,sid){
if(typeof _5a=="undefined"){
return false;
}
if(_5c<_5b.length){
var _5d=_5a.c[_5b[_5c]];
if(!_5d){
return false;
}
this._recursiveUnsubscribe(_5d,_5b,_5c+1,sid);
if(!_5d.s){
for(var x in _5d.c){
return true;
}
delete _5a.c[_5b[_5c]];
}
}else{
var sub=_5a.s;
var _5e=null;
var _5f=false;
while(sub){
if(sid==sub.sid){
_5f=true;
if(sub==_5a.s){
_5a.s=sub.next;
}else{
_5e.next=sub.next;
}
break;
}
_5e=sub;
sub=sub.next;
}
if(!_5f){
return false;
}
}
return true;
};
OpenAjax.hub.ManagedHub.prototype._getSubscriptionObject=function(_60,_61,_62,sid){
if(typeof _60!="undefined"){
if(_62<_61.length){
var _63=_60.c[_61[_62]];
return this._getSubscriptionObject(_63,_61,_62+1,sid);
}
var sub=_60.s;
while(sub){
if(sid==sub.sid){
return sub;
}
sub=sub.next;
}
}
return null;
};
OpenAjax.hub._hub=new OpenAjax.hub.ManagedHub({onSubscribe:function(_64,_65){
return true;
},onPublish:function(_66,_67,_68,_69){
return true;
}});
OpenAjax.hub.subscribe=function(_6a,_6b,_6c,_6d){
if(typeof _6b==="string"){
_6c=_6c||window;
_6b=_6c[_6b]||null;
}
return OpenAjax.hub._hub.subscribe(_6a,_6b,_6c,null,_6d);
};
OpenAjax.hub.unsubscribe=function(_6e){
return OpenAjax.hub._hub.unsubscribe(_6e);
};
OpenAjax.hub.publish=function(_6f,_70){
OpenAjax.hub._hub.publish(_6f,_70);
};
OpenAjax.hub.registerLibrary("OpenAjax","http://openajax.org/hub","2.0",{});
}
OpenAjax.hub.InlineContainer=function(hub,_71,_72){
if(!hub||!_71||!_72||!_72.Container||!_72.Container.onSecurityAlert){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var _73=_72.Container.scope||window;
var _74=false;
var _75=[];
var _76=0;
var _77=null;
if(_72.Container.log){
var log=function(msg){
try{
_72.Container.log.call(_73,"InlineContainer::"+_71+": "+msg);
}
catch(e){
OpenAjax.hub._debugger();
}
};
}else{
log=function(){
};
}
this._init=function(){
hub.addContainer(this);
};
this.getHub=function(){
return hub;
};
this.sendToClient=function(_78,_79,_7a){
if(_74){
var sub=_75[_7a];
try{
sub.cb.call(sub.sc,_78,_79,sub.d);
}
catch(e){
OpenAjax.hub._debugger();
_77._log("caught error from onData callback to HubClient.subscribe(): "+e.message);
}
}
};
this.remove=function(){
if(_74){
_7b();
}
};
this.isConnected=function(){
return _74;
};
this.getClientID=function(){
return _71;
};
this.getPartnerOrigin=function(){
if(_74){
return window.location.protocol+"//"+window.location.hostname;
}
return null;
};
this.getParameters=function(){
return _72;
};
this.connect=function(_7c,_7d,_7e){
if(_74){
throw new Error(OpenAjax.hub.Error.Duplicate);
}
_74=true;
_77=_7c;
if(_72.Container.onConnect){
try{
_72.Container.onConnect.call(_73,this);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onConnect callback to constructor: "+e.message);
}
}
_7f(_7d,_7e,_7c,true);
};
this.disconnect=function(_80,_81,_82){
if(!_74){
throw new Error(OpenAjax.hub.Error.Disconnected);
}
_7b();
if(_72.Container.onDisconnect){
try{
_72.Container.onDisconnect.call(_73,this);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onDisconnect callback to constructor: "+e.message);
}
}
_7f(_81,_82,_80,true);
};
this.subscribe=function(_83,_84,_85,_86,_87){
_88();
_89(_83);
if(!_84){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var _8a=""+_76++;
var _8b=false;
var msg=null;
try{
var _8c=hub.subscribeForClient(this,_83,_8a);
_8b=true;
}
catch(e){
_8a=null;
msg=e.message;
}
_85=_85||window;
if(_8b){
_75[_8a]={h:_8c,cb:_84,sc:_85,d:_87};
}
_7f(_86,_85,_8a,_8b,msg);
return _8a;
};
this.publish=function(_8d,_8e){
_88();
_8f(_8d);
hub.publishForClient(this,_8d,_8e);
};
this.unsubscribe=function(_90,_91,_92){
_88();
if(typeof _90==="undefined"||_90===null){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var sub=_75[_90];
if(!sub){
throw new Error(OpenAjax.hub.Error.NoSubscription);
}
hub.unsubscribeForClient(this,sub.h);
delete _75[_90];
_7f(_91,_92,_90,true);
};
this.getSubscriberData=function(_93){
_88();
return _94(_93).d;
};
this.getSubscriberScope=function(_95){
_88();
return _94(_95).sc;
};
function _7f(_96,_97,_98,_99,_9a){
if(_96){
try{
_97=_97||window;
_96.call(_97,_98,_99,_9a);
}
catch(e){
OpenAjax.hub._debugger();
_77._log("caught error from onComplete callback: "+e.message);
}
}
};
function _7b(){
for(var _9b in _75){
hub.unsubscribeForClient(this,_75[_9b].h);
}
_75=[];
_76=0;
_74=false;
};
function _88(){
if(!_74){
throw new Error(OpenAjax.hub.Error.Disconnected);
}
};
function _8f(_9c){
if((_9c==null)||(_9c==="")||(_9c.indexOf("*")!=-1)||(_9c.indexOf("..")!=-1)||(_9c.charAt(0)==".")||(_9c.charAt(_9c.length-1)==".")){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
};
function _89(_9d){
if(!_9d){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var _9e=_9d.split(".");
var len=_9e.length;
for(var i=0;i<len;i++){
var p=_9e[i];
if((p==="")||((p.indexOf("*")!=-1)&&(p!="*")&&(p!="**"))){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
if((p=="**")&&(i<len-1)){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
}
};
function _94(_9f){
var sub=_75[_9f];
if(sub){
return sub;
}
throw new Error(OpenAjax.hub.Error.NoSubscription);
};
this._init();
};
OpenAjax.hub.InlineHubClient=function(_a0){
if(!_a0||!_a0.HubClient||!_a0.HubClient.onSecurityAlert||!_a0.InlineHubClient||!_a0.InlineHubClient.container){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var _a1=_a0.InlineHubClient.container;
var _a2=_a0.HubClient.scope||window;
if(_a0.HubClient.log){
var log=function(msg){
try{
_a0.HubClient.log.call(_a2,"InlineHubClient::"+_a1.getClientID()+": "+msg);
}
catch(e){
OpenAjax.hub._debugger();
}
};
}else{
log=function(){
};
}
this._log=log;
this.connect=function(_a3,_a4){
_a1.connect(this,_a3,_a4);
};
this.disconnect=function(_a5,_a6){
_a1.disconnect(this,_a5,_a6);
};
this.getPartnerOrigin=function(){
return _a1.getPartnerOrigin();
};
this.getClientID=function(){
return _a1.getClientID();
};
this.subscribe=function(_a7,_a8,_a9,_aa,_ab){
return _a1.subscribe(_a7,_a8,_a9,_aa,_ab);
};
this.publish=function(_ac,_ad){
_a1.publish(_ac,_ad);
};
this.unsubscribe=function(_ae,_af,_b0){
_a1.unsubscribe(_ae,_af,_b0);
};
this.isConnected=function(){
return _a1.isConnected();
};
this.getScope=function(){
return _a2;
};
this.getSubscriberData=function(_b1){
return _a1.getSubscriberData(_b1);
};
this.getSubscriberScope=function(_b2){
return _a1.getSubscriberScope(_b2);
};
this.getParameters=function(){
return _a0;
};
};
var OpenAjax=OpenAjax||{};
OpenAjax.hub=OpenAjax.hub||{};
OpenAjax.gadgets=typeof OpenAjax.gadgets==="object"?OpenAjax.gadgets:typeof gadgets==="object"?gadgets:{};
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
(function(){
if(typeof gadgets==="undefined"){
if(typeof oaaConfig==="undefined"){
var _b3=document.getElementsByTagName("script");
var _b4=/openajax(?:managedhub-(?:all|core).*|-mashup)\.js$/i;
for(var i=_b3.length-1;i>=0;i--){
var src=_b3[i].getAttribute("src");
if(!src){
continue;
}
var m=src.match(_b4);
if(m){
var _b5=_b3[i].getAttribute("oaaConfig");
if(_b5){
try{
oaaConfig=eval("({ "+_b5+" })");
}
catch(e){
}
}
break;
}
}
}
if(typeof oaaConfig!=="undefined"&&oaaConfig.gadgetsGlobal){
gadgets=OpenAjax.gadgets;
}
}
})();
if(!OpenAjax.hub.IframeContainer){
(function(){
OpenAjax.hub.IframeContainer=function(hub,_b6,_b7){
_b8(arguments);
var _b9=this;
var _ba=_b7.Container.scope||window;
var _bb=false;
var _bc={};
var _bd;
var _be;
var _bf=_b7.IframeContainer.timeout||15000;
var _c0;
if(_b7.Container.log){
var log=function(msg){
try{
_b7.Container.log.call(_ba,"IframeContainer::"+_b6+": "+msg);
}
catch(e){
OpenAjax.hub._debugger();
}
};
}else{
log=function(){
};
}
this._init=function(){
hub.addContainer(this);
_be=OpenAjax.hub.IframeContainer._rpcRouter.add(_b6,this);
_bd=_114(_b7,_ba,log);
var _c1=null;
var _c2=OpenAjax.gadgets.rpc.getRelayChannel();
if(_b7.IframeContainer.tunnelURI){
if(_c2!=="wpm"&&_c2!=="nix"){
throw new Error(OpenAjax.hub.Error.IncompatBrowser);
}
}else{
log("WARNING: Parameter 'IframeContaienr.tunnelURI' not specified. Connection will not be fully secure.");
if(_c2==="rmr"){
_c1=OpenAjax.gadgets.rpc.getOrigin(_b7.IframeContainer.uri)+"/robots.txt";
}
}
_c3();
OpenAjax.gadgets.rpc.setupReceiver(_be,_c1);
_c4();
};
this.sendToClient=function(_c5,_c6,_c7){
OpenAjax.gadgets.rpc.call(_be,"openajax.pubsub",null,"pub",_c5,_c6,_c7);
};
this.remove=function(){
_c8();
clearTimeout(_c0);
OpenAjax.gadgets.rpc.removeReceiver(_be);
var _c9=document.getElementById(_be);
_c9.parentNode.removeChild(_c9);
OpenAjax.hub.IframeContainer._rpcRouter.remove(_be);
};
this.isConnected=function(){
return _bb;
};
this.getClientID=function(){
return _b6;
};
this.getPartnerOrigin=function(){
if(_bb){
var _ca=OpenAjax.gadgets.rpc.getReceiverOrigin(_be);
if(_ca){
return (/^([a-zA-Z]+:\/\/[^:]+).*/.exec(_ca)[1]);
}
}
return null;
};
this.getParameters=function(){
return _b7;
};
this.getHub=function(){
return hub;
};
this.getIframe=function(){
return document.getElementById(_be);
};
function _b8(_cb){
var hub=_cb[0],_b6=_cb[1],_b7=_cb[2];
if(!hub||!_b6||!_b7||!_b7.Container||!_b7.Container.onSecurityAlert||!_b7.IframeContainer||!_b7.IframeContainer.parent||!_b7.IframeContainer.uri){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
};
this._handleIncomingRPC=function(_cc,_cd,_ce){
switch(_cc){
case "pub":
hub.publishForClient(_b9,_cd,_ce);
break;
case "sub":
var _cf="";
try{
_bc[_ce]=hub.subscribeForClient(_b9,_cd,_ce);
}
catch(e){
_cf=e.message;
}
return _cf;
case "uns":
var _d0=_bc[_ce];
hub.unsubscribeForClient(_b9,_d0);
delete _bc[_ce];
return _ce;
case "con":
_d1();
return true;
case "dis":
_c4();
_c8();
if(_b7.Container.onDisconnect){
try{
_b7.Container.onDisconnect.call(_ba,_b9);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onDisconnect callback to constructor: "+e.message);
}
}
return true;
}
};
this._onSecurityAlert=function(_d2){
_d3(_113[_d2]);
};
function _c3(){
var _d4=document.createElement("span");
_b7.IframeContainer.parent.appendChild(_d4);
var _d5="<iframe id=\""+_be+"\" name=\""+_be+"\" src=\"javascript:'<html></html>'\"";
var _d6="";
var _d7=_b7.IframeContainer.iframeAttrs;
if(_d7){
for(var _d8 in _d7){
switch(_d8){
case "style":
for(var _d9 in _d7.style){
_d6+=_d9+":"+_d7.style[_d9]+";";
}
break;
case "className":
_d5+=" class=\""+_d7[_d8]+"\"";
break;
default:
_d5+=" "+_d8+"=\""+_d7[_d8]+"\"";
}
}
}
_d6+="visibility:hidden;";
_d5+=" style=\""+_d6+"\"></iframe>";
_d4.innerHTML=_d5;
var _da;
if(_b7.IframeContainer.tunnelURI){
_da="&parent="+encodeURIComponent(_b7.IframeContainer.tunnelURI)+"&forcesecure=true";
}else{
_da="&oahParent="+encodeURIComponent(OpenAjax.gadgets.rpc.getOrigin(window.location.href));
}
var _db="";
if(_be!==_b6){
_db="&oahId="+_be.substring(_be.lastIndexOf("_")+1);
}
document.getElementById(_be).src=_b7.IframeContainer.uri+"#rpctoken="+_bd+_da+_db;
};
function _d1(){
function _dc(_dd){
if(_dd){
_bb=true;
clearTimeout(_c0);
document.getElementById(_be).style.visibility="visible";
if(_b7.Container.onConnect){
try{
_b7.Container.onConnect.call(_ba,_b9);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onConnect callback to constructor: "+e.message);
}
}
}
};
OpenAjax.gadgets.rpc.call(_be,"openajax.pubsub",_dc,"cmd","con");
};
function _c8(){
if(_bb){
_bb=false;
document.getElementById(_be).style.visibility="hidden";
for(var s in _bc){
hub.unsubscribeForClient(_b9,_bc[s]);
}
_bc={};
}
};
function _d3(_de){
try{
_b7.Container.onSecurityAlert.call(_ba,_b9,_de);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onSecurityAlert callback to constructor: "+e.message);
}
};
function _c4(){
_c0=setTimeout(function(){
_d3(OpenAjax.hub.SecurityAlert.LoadTimeout);
_b9._handleIncomingRPC=function(){
};
},_bf);
};
this._init();
};
OpenAjax.hub.IframeHubClient=function(_df){
if(!_df||!_df.HubClient||!_df.HubClient.onSecurityAlert){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var _e0=this;
var _e1=_df.HubClient.scope||window;
var _e2=false;
var _e3={};
var _e4=0;
var _e5;
if(_df.HubClient.log){
var log=function(msg){
try{
_df.HubClient.log.call(_e1,"IframeHubClient::"+_e5+": "+msg);
}
catch(e){
OpenAjax.hub._debugger();
}
};
}else{
log=function(){
};
}
this._init=function(){
var _e6=OpenAjax.gadgets.util.getUrlParameters();
if(!_e6.parent){
var _e7=_e6.oahParent+"/robots.txt";
OpenAjax.gadgets.rpc.setupReceiver("..",_e7);
}
if(_df.IframeHubClient&&_df.IframeHubClient.requireParentVerifiable&&OpenAjax.gadgets.rpc.getReceiverOrigin("..")===null){
OpenAjax.gadgets.rpc.removeReceiver("..");
throw new Error(OpenAjax.hub.Error.IncompatBrowser);
}
OpenAjax.hub.IframeContainer._rpcRouter.add("..",this);
_e5=OpenAjax.gadgets.rpc.RPC_ID;
if(_e6.oahId){
_e5=_e5.substring(0,_e5.lastIndexOf("_"));
}
};
this.connect=function(_e8,_e9){
if(_e2){
throw new Error(OpenAjax.hub.Error.Duplicate);
}
function _ea(_eb){
if(_eb){
_e2=true;
if(_e8){
try{
_e8.call(_e9||window,_e0,true);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onComplete callback to connect(): "+e.message);
}
}
}
};
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",_ea,"con");
};
this.disconnect=function(_ec,_ed){
if(!_e2){
throw new Error(OpenAjax.hub.Error.Disconnected);
}
_e2=false;
var _ee=null;
if(_ec){
_ee=function(_ef){
try{
_ec.call(_ed||window,_e0,true);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onComplete callback to disconnect(): "+e.message);
}
};
}
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",_ee,"dis");
};
this.getPartnerOrigin=function(){
if(_e2){
var _f0=OpenAjax.gadgets.rpc.getReceiverOrigin("..");
if(_f0){
return (/^([a-zA-Z]+:\/\/[^:]+).*/.exec(_f0)[1]);
}
}
return null;
};
this.getClientID=function(){
return _e5;
};
this.subscribe=function(_f1,_f2,_f3,_f4,_f5){
_f6();
_f7(_f1);
if(!_f2){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
_f3=_f3||window;
var _f8=""+_e4++;
_e3[_f8]={cb:_f2,sc:_f3,d:_f5};
function _f9(_fa){
if(_fa!==""){
delete _e3[_f8];
}
if(_f4){
try{
_f4.call(_f3,_f8,_fa==="",_fa);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onComplete callback to subscribe(): "+e.message);
}
}
};
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",_f9,"sub",_f1,_f8);
return _f8;
};
this.publish=function(_fb,_fc){
_f6();
_fd(_fb);
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",null,"pub",_fb,_fc);
};
this.unsubscribe=function(_fe,_ff,_100){
_f6();
if(!_fe){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
if(!_e3[_fe]||_e3[_fe].uns){
throw new Error(OpenAjax.hub.Error.NoSubscription);
}
_e3[_fe].uns=true;
function _101(_102){
delete _e3[_fe];
if(_ff){
try{
_ff.call(_100||window,_fe,true);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onComplete callback to unsubscribe(): "+e.message);
}
}
};
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",_101,"uns",null,_fe);
};
this.isConnected=function(){
return _e2;
};
this.getScope=function(){
return _e1;
};
this.getSubscriberData=function(_103){
_f6();
if(_e3[_103]){
return _e3[_103].d;
}
throw new Error(OpenAjax.hub.Error.NoSubscription);
};
this.getSubscriberScope=function(_104){
_f6();
if(_e3[_104]){
return _e3[_104].sc;
}
throw new Error(OpenAjax.hub.Error.NoSubscription);
};
this.getParameters=function(){
return _df;
};
this._handleIncomingRPC=function(_105,_106,data,_107){
if(_105==="pub"){
if(_e3[_107]&&!_e3[_107].uns){
try{
_e3[_107].cb.call(_e3[_107].sc,_106,data,_e3[_107].d);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onData callback to subscribe(): "+e.message);
}
}
}
if(_106==="con"){
return true;
}
return false;
};
function _f6(){
if(!_e2){
throw new Error(OpenAjax.hub.Error.Disconnected);
}
};
function _f7(_108){
if(!_108){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var path=_108.split(".");
var len=path.length;
for(var i=0;i<len;i++){
var p=path[i];
if((p==="")||((p.indexOf("*")!=-1)&&(p!="*")&&(p!="**"))){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
if((p=="**")&&(i<len-1)){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
}
};
function _fd(_109){
if(!_109||_109===""||(_109.indexOf("*")!=-1)||(_109.indexOf("..")!=-1)||(_109.charAt(0)==".")||(_109.charAt(_109.length-1)==".")){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
};
this._init();
};
OpenAjax.hub.IframeContainer._rpcRouter=function(){
var _10a={};
function _10b(){
var r=_10a[this.f];
if(r){
return r._handleIncomingRPC.apply(r,arguments);
}
};
function _10c(_10d,_10e){
var r=_10a[_10d];
if(r){
r._onSecurityAlert.call(r,_10e);
}
};
return {add:function(id,_10f){
function _110(id,_111){
if(id===".."){
if(!_10a[".."]){
_10a[".."]=_111;
}
return;
}
var _112=id;
while(document.getElementById(_112)){
_112=id+"_"+((32767*Math.random())|0).toString(16);
}
_10a[_112]=_111;
return _112;
};
OpenAjax.gadgets.rpc.register("openajax.pubsub",_10b);
OpenAjax.gadgets.rpc.config({securityCallback:_10c});
_113[OpenAjax.gadgets.rpc.SEC_ERROR_LOAD_TIMEOUT]=OpenAjax.hub.SecurityAlert.LoadTimeout;
_113[OpenAjax.gadgets.rpc.SEC_ERROR_FRAME_PHISH]=OpenAjax.hub.SecurityAlert.FramePhish;
_113[OpenAjax.gadgets.rpc.SEC_ERROR_FORGED_MSG]=OpenAjax.hub.SecurityAlert.ForgedMsg;
this.add=_110;
return _110(id,_10f);
},remove:function(id){
delete _10a[id];
}};
}();
var _113={};
function _114(_115,_116,log){
if(!OpenAjax.hub.IframeContainer._prng){
var seed=new Date().getTime()+Math.random()+document.cookie;
OpenAjax.hub.IframeContainer._prng=OpenAjax._smash.crypto.newPRNG(seed);
}
var p=_115.IframeContainer||_115.IframeHubClient;
if(p&&p.seed){
try{
var _117=p.seed.call(_116);
OpenAjax.hub.IframeContainer._prng.addSeed(_117);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from 'seed' callback: "+e.message);
}
}
var _118=(p&&p.tokenLength)||6;
return OpenAjax.hub.IframeContainer._prng.nextRandomB64Str(_118);
};
})();
}
if(typeof OpenAjax._smash=="undefined"){
OpenAjax._smash={};
}
OpenAjax._smash.crypto={"strToWA":function(str,_119){
var bin=Array();
var mask=(1<<_119)-1;
for(var i=0;i<str.length*_119;i+=_119){
bin[i>>5]|=(str.charCodeAt(i/_119)&mask)<<(32-_119-i%32);
}
return bin;
},"hmac_sha1":function(_11a,_11b,_11c){
var ipad=Array(16),opad=Array(16);
for(var i=0;i<16;i++){
ipad[i]=_11a[i]^909522486;
opad[i]=_11a[i]^1549556828;
}
var hash=this.sha1(ipad.concat(this.strToWA(_11b,_11c)),512+_11b.length*_11c);
return this.sha1(opad.concat(hash),512+160);
},"newPRNG":function(_11d){
var that=this;
if((typeof _11d!="string")||(_11d.length<12)){
alert("WARNING: Seed length too short ...");
}
var _11e=[43417,15926,18182,33130,9585,30800,49772,40144,47678,55453,4659,38181,65340,6787,54417,65301];
var _11f=[];
var _120=0;
function _121(_122){
return that.hmac_sha1(_11e,_122,8);
};
function _123(_124){
var _125=_121(_124);
for(var i=0;i<5;i++){
_11f[i]^=_125[i];
}
};
_123(_11d);
return {"addSeed":function(seed){
_123(seed);
},"nextRandomOctets":function(len){
var _126=[];
while(len>0){
_120+=1;
var _127=that.hmac_sha1(_11f,(_120).toString(16),8);
for(i=0;(i<20)&(len>0);i++,len--){
_126.push((_127[i>>2]>>(i%4))%256);
}
}
return _126;
},"nextRandomB64Str":function(len){
var _128="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
var _129=this.nextRandomOctets(len);
var _12a="";
for(var i=0;i<len;i++){
_12a+=_128.charAt(_129[i]&63);
}
return _12a;
}};
},"sha1":function(){
var _12b=function(x,y){
var lsw=(x&65535)+(y&65535);
var msw=(x>>16)+(y>>16)+(lsw>>16);
return (msw<<16)|(lsw&65535);
};
var rol=function(num,cnt){
return (num<<cnt)|(num>>>(32-cnt));
};
function _12c(t,b,c,d){
if(t<20){
return (b&c)|((~b)&d);
}
if(t<40){
return b^c^d;
}
if(t<60){
return (b&c)|(b&d)|(c&d);
}
return b^c^d;
};
function _12d(t){
return (t<20)?1518500249:(t<40)?1859775393:(t<60)?-1894007588:-899497514;
};
return function(_12e,_12f){
_12e[_12f>>5]|=128<<(24-_12f%32);
_12e[((_12f+64>>9)<<4)+15]=_12f;
var W=Array(80);
var H0=1732584193;
var H1=-271733879;
var H2=-1732584194;
var H3=271733878;
var H4=-1009589776;
for(var i=0;i<_12e.length;i+=16){
var a=H0;
var b=H1;
var c=H2;
var d=H3;
var e=H4;
for(var j=0;j<80;j++){
W[j]=((j<16)?_12e[i+j]:rol(W[j-3]^W[j-8]^W[j-14]^W[j-16],1));
var T=_12b(_12b(rol(a,5),_12c(j,b,c,d)),_12b(_12b(e,W[j]),_12d(j)));
e=d;
d=c;
c=rol(b,30);
b=a;
a=T;
}
H0=_12b(a,H0);
H1=_12b(b,H1);
H2=_12b(c,H2);
H3=_12b(d,H3);
H4=_12b(e,H4);
}
return Array(H0,H1,H2,H3,H4);
};
}()};
if(!this.JSON){
JSON={};
}
(function(){
function f(n){
return n<10?"0"+n:n;
};
if(typeof Date.prototype.toJSON!=="function"){
Date.prototype.toJSON=function(key){
return this.getUTCFullYear()+"-"+f(this.getUTCMonth()+1)+"-"+f(this.getUTCDate())+"T"+f(this.getUTCHours())+":"+f(this.getUTCMinutes())+":"+f(this.getUTCSeconds())+"Z";
};
String.prototype.toJSON=Number.prototype.toJSON=Boolean.prototype.toJSON=function(key){
return this.valueOf();
};
}
var cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,_130=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,gap,_131,meta={"\b":"\\b","\t":"\\t","\n":"\\n","\f":"\\f","\r":"\\r","\"":"\\\"","\\":"\\\\"},rep;
function _132(_133){
_130.lastIndex=0;
return _130.test(_133)?"\""+_133.replace(_130,function(a){
var c=meta[a];
return typeof c==="string"?c:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4);
})+"\"":"\""+_133+"\"";
};
function str(key,_134){
var i,k,v,_135,mind=gap,_136,_137=_134[key];
if(_137&&typeof _137==="object"&&typeof _137.toJSON==="function"){
_137=_137.toJSON(key);
}
if(typeof rep==="function"){
_137=rep.call(_134,key,_137);
}
switch(typeof _137){
case "string":
return _132(_137);
case "number":
return isFinite(_137)?String(_137):"null";
case "boolean":
case "null":
return String(_137);
case "object":
if(!_137){
return "null";
}
gap+=_131;
_136=[];
if(Object.prototype.toString.apply(_137)==="[object Array]"){
_135=_137.length;
for(i=0;i<_135;i+=1){
_136[i]=str(i,_137)||"null";
}
v=_136.length===0?"[]":gap?"[\n"+gap+_136.join(",\n"+gap)+"\n"+mind+"]":"["+_136.join(",")+"]";
gap=mind;
return v;
}
if(rep&&typeof rep==="object"){
_135=rep.length;
for(i=0;i<_135;i+=1){
k=rep[i];
if(typeof k==="string"){
v=str(k,_137);
if(v){
_136.push(_132(k)+(gap?": ":":")+v);
}
}
}
}else{
for(k in _137){
if(Object.hasOwnProperty.call(_137,k)){
v=str(k,_137);
if(v){
_136.push(_132(k)+(gap?": ":":")+v);
}
}
}
}
v=_136.length===0?"{}":gap?"{\n"+gap+_136.join(",\n"+gap)+"\n"+mind+"}":"{"+_136.join(",")+"}";
gap=mind;
return v;
}
};
if(typeof JSON.stringify!=="function"){
JSON.stringify=function(_138,_139,_13a){
var i;
gap="";
_131="";
if(typeof _13a==="number"){
for(i=0;i<_13a;i+=1){
_131+=" ";
}
}else{
if(typeof _13a==="string"){
_131=_13a;
}
}
rep=_139;
if(_139&&typeof _139!=="function"&&(typeof _139!=="object"||typeof _139.length!=="number")){
throw new Error("JSON.stringify");
}
return str("",{"":_138});
};
}
if(typeof JSON.parse!=="function"){
JSON.parse=function(text,_13b){
var j;
function walk(_13c,key){
var k,v,_13d=_13c[key];
if(_13d&&typeof _13d==="object"){
for(k in _13d){
if(Object.hasOwnProperty.call(_13d,k)){
v=walk(_13d,k);
if(v!==undefined){
_13d[k]=v;
}else{
delete _13d[k];
}
}
}
}
return _13b.call(_13c,key,_13d);
};
cx.lastIndex=0;
if(cx.test(text)){
text=text.replace(cx,function(a){
return "\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4);
});
}
if(/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]").replace(/(?:^|:|,)(?:\s*\[)+/g,""))){
j=eval("("+text+")");
return typeof _13b==="function"?walk({"":j},""):j;
}
throw new SyntaxError("JSON.parse");
};
}
})();


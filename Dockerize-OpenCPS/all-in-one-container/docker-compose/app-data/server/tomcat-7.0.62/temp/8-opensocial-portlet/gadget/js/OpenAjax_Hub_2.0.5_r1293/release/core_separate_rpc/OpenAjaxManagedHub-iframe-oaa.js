var OpenAjax=OpenAjax||{};
OpenAjax.hub=OpenAjax.hub||{};
OpenAjax.gadgets=typeof OpenAjax.gadgets==="object"?OpenAjax.gadgets:typeof gadgets==="object"?gadgets:{};
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
(function(){
if(typeof gadgets==="undefined"){
if(typeof oaaConfig==="undefined"){
var _1=document.getElementsByTagName("script");
var _2=/openajax(?:managedhub-(?:all|core).*|-mashup)\.js$/i;
for(var i=_1.length-1;i>=0;i--){
var _3=_1[i].getAttribute("src");
if(!_3){
continue;
}
var m=_3.match(_2);
if(m){
var _4=_1[i].getAttribute("oaaConfig");
if(_4){
try{
oaaConfig=eval("({ "+_4+" })");
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
OpenAjax.hub.IframeContainer=function(_5,_6,_7){
_8(arguments);
var _9=this;
var _a=_7.Container.scope||window;
var _b=false;
var _c={};
var _d;
var _e;
var _f=_7.IframeContainer.timeout||15000;
var _10;
if(_7.Container.log){
var log=function(msg){
try{
_7.Container.log.call(_a,"IframeContainer::"+_6+": "+msg);
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
_5.addContainer(this);
_e=OpenAjax.hub.IframeContainer._rpcRouter.add(_6,this);
_d=_66(_7,_a,log);
var _11=null;
var _12=OpenAjax.gadgets.rpc.getRelayChannel();
if(_7.IframeContainer.tunnelURI){
if(_12!=="wpm"&&_12!=="nix"){
throw new Error(OpenAjax.hub.Error.IncompatBrowser);
}
}else{
log("WARNING: Parameter 'IframeContaienr.tunnelURI' not specified. Connection will not be fully secure.");
if(_12==="rmr"){
_11=OpenAjax.gadgets.rpc.getOrigin(_7.IframeContainer.uri)+"/robots.txt";
}
}
_13();
OpenAjax.gadgets.rpc.setupReceiver(_e,_11);
_14();
};
this.sendToClient=function(_15,_16,_17){
OpenAjax.gadgets.rpc.call(_e,"openajax.pubsub",null,"pub",_15,_16,_17);
};
this.remove=function(){
_18();
clearTimeout(_10);
OpenAjax.gadgets.rpc.removeReceiver(_e);
var _19=document.getElementById(_e);
_19.parentNode.removeChild(_19);
OpenAjax.hub.IframeContainer._rpcRouter.remove(_e);
};
this.isConnected=function(){
return _b;
};
this.getClientID=function(){
return _6;
};
this.getPartnerOrigin=function(){
if(_b){
var _1a=OpenAjax.gadgets.rpc.getReceiverOrigin(_e);
if(_1a){
return (/^([a-zA-Z]+:\/\/[^:]+).*/.exec(_1a)[1]);
}
}
return null;
};
this.getParameters=function(){
return _7;
};
this.getHub=function(){
return _5;
};
this.getIframe=function(){
return document.getElementById(_e);
};
function _8(_1b){
var hub=_1b[0],_6=_1b[1],_7=_1b[2];
if(!hub||!_6||!_7||!_7.Container||!_7.Container.onSecurityAlert||!_7.IframeContainer||!_7.IframeContainer.parent||!_7.IframeContainer.uri){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
};
this._handleIncomingRPC=function(_1c,_1d,_1e){
switch(_1c){
case "pub":
_5.publishForClient(_9,_1d,_1e);
break;
case "sub":
var _1f="";
try{
_c[_1e]=_5.subscribeForClient(_9,_1d,_1e);
}
catch(e){
_1f=e.message;
}
return _1f;
case "uns":
var _20=_c[_1e];
_5.unsubscribeForClient(_9,_20);
delete _c[_1e];
return _1e;
case "con":
_21();
return true;
case "dis":
_14();
_18();
if(_7.Container.onDisconnect){
try{
_7.Container.onDisconnect.call(_a,_9);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onDisconnect callback to constructor: "+e.message);
}
}
return true;
}
};
this._onSecurityAlert=function(_22){
_23(_65[_22]);
};
function _13(){
var _24=document.createElement("span");
_7.IframeContainer.parent.appendChild(_24);
var _25="<iframe id=\""+_e+"\" name=\""+_e+"\" src=\"javascript:'<html></html>'\"";
var _26="";
var _27=_7.IframeContainer.iframeAttrs;
if(_27){
for(var _28 in _27){
switch(_28){
case "style":
for(var _29 in _27.style){
_26+=_29+":"+_27.style[_29]+";";
}
break;
case "className":
_25+=" class=\""+_27[_28]+"\"";
break;
default:
_25+=" "+_28+"=\""+_27[_28]+"\"";
}
}
}
_26+="visibility:hidden;";
_25+=" style=\""+_26+"\"></iframe>";
_24.innerHTML=_25;
var _2a;
if(_7.IframeContainer.tunnelURI){
_2a="&parent="+encodeURIComponent(_7.IframeContainer.tunnelURI)+"&forcesecure=true";
}else{
_2a="&oahParent="+encodeURIComponent(OpenAjax.gadgets.rpc.getOrigin(window.location.href));
}
var _2b="";
if(_e!==_6){
_2b="&oahId="+_e.substring(_e.lastIndexOf("_")+1);
}
document.getElementById(_e).src=_7.IframeContainer.uri+"#rpctoken="+_d+_2a+_2b;
};
function _21(){
function _2c(_2d){
if(_2d){
_b=true;
clearTimeout(_10);
document.getElementById(_e).style.visibility="visible";
if(_7.Container.onConnect){
try{
_7.Container.onConnect.call(_a,_9);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onConnect callback to constructor: "+e.message);
}
}
}
};
OpenAjax.gadgets.rpc.call(_e,"openajax.pubsub",_2c,"cmd","con");
};
function _18(){
if(_b){
_b=false;
document.getElementById(_e).style.visibility="hidden";
for(var s in _c){
_5.unsubscribeForClient(_9,_c[s]);
}
_c={};
}
};
function _23(_2e){
try{
_7.Container.onSecurityAlert.call(_a,_9,_2e);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onSecurityAlert callback to constructor: "+e.message);
}
};
function _14(){
_10=setTimeout(function(){
_23(OpenAjax.hub.SecurityAlert.LoadTimeout);
_9._handleIncomingRPC=function(){
};
},_f);
};
this._init();
};
OpenAjax.hub.IframeHubClient=function(_2f){
if(!_2f||!_2f.HubClient||!_2f.HubClient.onSecurityAlert){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var _30=this;
var _31=_2f.HubClient.scope||window;
var _32=false;
var _33={};
var _34=0;
var _35;
if(_2f.HubClient.log){
var log=function(msg){
try{
_2f.HubClient.log.call(_31,"IframeHubClient::"+_35+": "+msg);
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
var _36=OpenAjax.gadgets.util.getUrlParameters();
if(!_36.parent){
var _37=_36.oahParent+"/robots.txt";
OpenAjax.gadgets.rpc.setupReceiver("..",_37);
}
if(_2f.IframeHubClient&&_2f.IframeHubClient.requireParentVerifiable&&OpenAjax.gadgets.rpc.getReceiverOrigin("..")===null){
OpenAjax.gadgets.rpc.removeReceiver("..");
throw new Error(OpenAjax.hub.Error.IncompatBrowser);
}
OpenAjax.hub.IframeContainer._rpcRouter.add("..",this);
_35=OpenAjax.gadgets.rpc.RPC_ID;
if(_36.oahId){
_35=_35.substring(0,_35.lastIndexOf("_"));
}
};
this.connect=function(_38,_39){
if(_32){
throw new Error(OpenAjax.hub.Error.Duplicate);
}
function _3a(_3b){
if(_3b){
_32=true;
if(_38){
try{
_38.call(_39||window,_30,true);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onComplete callback to connect(): "+e.message);
}
}
}
};
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",_3a,"con");
};
this.disconnect=function(_3c,_3d){
if(!_32){
throw new Error(OpenAjax.hub.Error.Disconnected);
}
_32=false;
var _3e=null;
if(_3c){
_3e=function(_3f){
try{
_3c.call(_3d||window,_30,true);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onComplete callback to disconnect(): "+e.message);
}
};
}
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",_3e,"dis");
};
this.getPartnerOrigin=function(){
if(_32){
var _40=OpenAjax.gadgets.rpc.getReceiverOrigin("..");
if(_40){
return (/^([a-zA-Z]+:\/\/[^:]+).*/.exec(_40)[1]);
}
}
return null;
};
this.getClientID=function(){
return _35;
};
this.subscribe=function(_41,_42,_43,_44,_45){
_46();
_47(_41);
if(!_42){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
_43=_43||window;
var _48=""+_34++;
_33[_48]={cb:_42,sc:_43,d:_45};
function _49(_4a){
if(_4a!==""){
delete _33[_48];
}
if(_44){
try{
_44.call(_43,_48,_4a==="",_4a);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onComplete callback to subscribe(): "+e.message);
}
}
};
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",_49,"sub",_41,_48);
return _48;
};
this.publish=function(_4b,_4c){
_46();
_4d(_4b);
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",null,"pub",_4b,_4c);
};
this.unsubscribe=function(_4e,_4f,_50){
_46();
if(!_4e){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
if(!_33[_4e]||_33[_4e].uns){
throw new Error(OpenAjax.hub.Error.NoSubscription);
}
_33[_4e].uns=true;
function _51(_52){
delete _33[_4e];
if(_4f){
try{
_4f.call(_50||window,_4e,true);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onComplete callback to unsubscribe(): "+e.message);
}
}
};
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",_51,"uns",null,_4e);
};
this.isConnected=function(){
return _32;
};
this.getScope=function(){
return _31;
};
this.getSubscriberData=function(_53){
_46();
if(_33[_53]){
return _33[_53].d;
}
throw new Error(OpenAjax.hub.Error.NoSubscription);
};
this.getSubscriberScope=function(_54){
_46();
if(_33[_54]){
return _33[_54].sc;
}
throw new Error(OpenAjax.hub.Error.NoSubscription);
};
this.getParameters=function(){
return _2f;
};
this._handleIncomingRPC=function(_55,_56,_57,_58){
if(_55==="pub"){
if(_33[_58]&&!_33[_58].uns){
try{
_33[_58].cb.call(_33[_58].sc,_56,_57,_33[_58].d);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from onData callback to subscribe(): "+e.message);
}
}
}
if(_56==="con"){
return true;
}
return false;
};
function _46(){
if(!_32){
throw new Error(OpenAjax.hub.Error.Disconnected);
}
};
function _47(_59){
if(!_59){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
var _5a=_59.split(".");
var len=_5a.length;
for(var i=0;i<len;i++){
var p=_5a[i];
if((p==="")||((p.indexOf("*")!=-1)&&(p!="*")&&(p!="**"))){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
if((p=="**")&&(i<len-1)){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
}
};
function _4d(_5b){
if(!_5b||_5b===""||(_5b.indexOf("*")!=-1)||(_5b.indexOf("..")!=-1)||(_5b.charAt(0)==".")||(_5b.charAt(_5b.length-1)==".")){
throw new Error(OpenAjax.hub.Error.BadParameters);
}
};
this._init();
};
OpenAjax.hub.IframeContainer._rpcRouter=function(){
var _5c={};
function _5d(){
var r=_5c[this.f];
if(r){
return r._handleIncomingRPC.apply(r,arguments);
}
};
function _5e(_5f,_60){
var r=_5c[_5f];
if(r){
r._onSecurityAlert.call(r,_60);
}
};
return {add:function(id,_61){
function _62(id,_63){
if(id===".."){
if(!_5c[".."]){
_5c[".."]=_63;
}
return;
}
var _64=id;
while(document.getElementById(_64)){
_64=id+"_"+((32767*Math.random())|0).toString(16);
}
_5c[_64]=_63;
return _64;
};
OpenAjax.gadgets.rpc.register("openajax.pubsub",_5d);
OpenAjax.gadgets.rpc.config({securityCallback:_5e});
_65[OpenAjax.gadgets.rpc.SEC_ERROR_LOAD_TIMEOUT]=OpenAjax.hub.SecurityAlert.LoadTimeout;
_65[OpenAjax.gadgets.rpc.SEC_ERROR_FRAME_PHISH]=OpenAjax.hub.SecurityAlert.FramePhish;
_65[OpenAjax.gadgets.rpc.SEC_ERROR_FORGED_MSG]=OpenAjax.hub.SecurityAlert.ForgedMsg;
this.add=_62;
return _62(id,_61);
},remove:function(id){
delete _5c[id];
}};
}();
var _65={};
function _66(_67,_68,log){
if(!OpenAjax.hub.IframeContainer._prng){
var _69=new Date().getTime()+Math.random()+document.cookie;
OpenAjax.hub.IframeContainer._prng=OpenAjax._smash.crypto.newPRNG(_69);
}
var p=_67.IframeContainer||_67.IframeHubClient;
if(p&&p.seed){
try{
var _6a=p.seed.call(_68);
OpenAjax.hub.IframeContainer._prng.addSeed(_6a);
}
catch(e){
OpenAjax.hub._debugger();
log("caught error from 'seed' callback: "+e.message);
}
}
var _6b=(p&&p.tokenLength)||6;
return OpenAjax.hub.IframeContainer._prng.nextRandomB64Str(_6b);
};
})();
}
if(typeof OpenAjax._smash=="undefined"){
OpenAjax._smash={};
}
OpenAjax._smash.crypto={"strToWA":function(str,_6c){
var bin=Array();
var _6d=(1<<_6c)-1;
for(var i=0;i<str.length*_6c;i+=_6c){
bin[i>>5]|=(str.charCodeAt(i/_6c)&_6d)<<(32-_6c-i%32);
}
return bin;
},"hmac_sha1":function(_6e,_6f,_70){
var _71=Array(16),_72=Array(16);
for(var i=0;i<16;i++){
_71[i]=_6e[i]^909522486;
_72[i]=_6e[i]^1549556828;
}
var _73=this.sha1(_71.concat(this.strToWA(_6f,_70)),512+_6f.length*_70);
return this.sha1(_72.concat(_73),512+160);
},"newPRNG":function(_74){
var _75=this;
if((typeof _74!="string")||(_74.length<12)){
alert("WARNING: Seed length too short ...");
}
var _76=[43417,15926,18182,33130,9585,30800,49772,40144,47678,55453,4659,38181,65340,6787,54417,65301];
var _77=[];
var _78=0;
function _79(_7a){
return _75.hmac_sha1(_76,_7a,8);
};
function _7b(_7c){
var _7d=_79(_7c);
for(var i=0;i<5;i++){
_77[i]^=_7d[i];
}
};
_7b(_74);
return {"addSeed":function(_7e){
_7b(_7e);
},"nextRandomOctets":function(len){
var _7f=[];
while(len>0){
_78+=1;
var _80=_75.hmac_sha1(_77,(_78).toString(16),8);
for(i=0;(i<20)&(len>0);i++,len--){
_7f.push((_80[i>>2]>>(i%4))%256);
}
}
return _7f;
},"nextRandomB64Str":function(len){
var _81="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
var _82=this.nextRandomOctets(len);
var _83="";
for(var i=0;i<len;i++){
_83+=_81.charAt(_82[i]&63);
}
return _83;
}};
},"sha1":function(){
var _84=function(x,y){
var lsw=(x&65535)+(y&65535);
var msw=(x>>16)+(y>>16)+(lsw>>16);
return (msw<<16)|(lsw&65535);
};
var rol=function(num,cnt){
return (num<<cnt)|(num>>>(32-cnt));
};
function _85(t,b,c,d){
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
function _86(t){
return (t<20)?1518500249:(t<40)?1859775393:(t<60)?-1894007588:-899497514;
};
return function(_87,_88){
_87[_88>>5]|=128<<(24-_88%32);
_87[((_88+64>>9)<<4)+15]=_88;
var W=Array(80);
var H0=1732584193;
var H1=-271733879;
var H2=-1732584194;
var H3=271733878;
var H4=-1009589776;
for(var i=0;i<_87.length;i+=16){
var a=H0;
var b=H1;
var c=H2;
var d=H3;
var e=H4;
for(var j=0;j<80;j++){
W[j]=((j<16)?_87[i+j]:rol(W[j-3]^W[j-8]^W[j-14]^W[j-16],1));
var T=_84(_84(rol(a,5),_85(j,b,c,d)),_84(_84(e,W[j]),_86(j)));
e=d;
d=c;
c=rol(b,30);
b=a;
a=T;
}
H0=_84(a,H0);
H1=_84(b,H1);
H2=_84(c,H2);
H3=_84(d,H3);
H4=_84(e,H4);
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
var cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,_89=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,gap,_8a,_8b={"\b":"\\b","\t":"\\t","\n":"\\n","\f":"\\f","\r":"\\r","\"":"\\\"","\\":"\\\\"},rep;
function _8c(_8d){
_89.lastIndex=0;
return _89.test(_8d)?"\""+_8d.replace(_89,function(a){
var c=_8b[a];
return typeof c==="string"?c:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4);
})+"\"":"\""+_8d+"\"";
};
function str(key,_8e){
var i,k,v,_8f,_90=gap,_91,_92=_8e[key];
if(_92&&typeof _92==="object"&&typeof _92.toJSON==="function"){
_92=_92.toJSON(key);
}
if(typeof rep==="function"){
_92=rep.call(_8e,key,_92);
}
switch(typeof _92){
case "string":
return _8c(_92);
case "number":
return isFinite(_92)?String(_92):"null";
case "boolean":
case "null":
return String(_92);
case "object":
if(!_92){
return "null";
}
gap+=_8a;
_91=[];
if(Object.prototype.toString.apply(_92)==="[object Array]"){
_8f=_92.length;
for(i=0;i<_8f;i+=1){
_91[i]=str(i,_92)||"null";
}
v=_91.length===0?"[]":gap?"[\n"+gap+_91.join(",\n"+gap)+"\n"+_90+"]":"["+_91.join(",")+"]";
gap=_90;
return v;
}
if(rep&&typeof rep==="object"){
_8f=rep.length;
for(i=0;i<_8f;i+=1){
k=rep[i];
if(typeof k==="string"){
v=str(k,_92);
if(v){
_91.push(_8c(k)+(gap?": ":":")+v);
}
}
}
}else{
for(k in _92){
if(Object.hasOwnProperty.call(_92,k)){
v=str(k,_92);
if(v){
_91.push(_8c(k)+(gap?": ":":")+v);
}
}
}
}
v=_91.length===0?"{}":gap?"{\n"+gap+_91.join(",\n"+gap)+"\n"+_90+"}":"{"+_91.join(",")+"}";
gap=_90;
return v;
}
};
if(typeof JSON.stringify!=="function"){
JSON.stringify=function(_93,_94,_95){
var i;
gap="";
_8a="";
if(typeof _95==="number"){
for(i=0;i<_95;i+=1){
_8a+=" ";
}
}else{
if(typeof _95==="string"){
_8a=_95;
}
}
rep=_94;
if(_94&&typeof _94!=="function"&&(typeof _94!=="object"||typeof _94.length!=="number")){
throw new Error("JSON.stringify");
}
return str("",{"":_93});
};
}
if(typeof JSON.parse!=="function"){
JSON.parse=function(_96,_97){
var j;
function _98(_99,key){
var k,v,_9a=_99[key];
if(_9a&&typeof _9a==="object"){
for(k in _9a){
if(Object.hasOwnProperty.call(_9a,k)){
v=_98(_9a,k);
if(v!==undefined){
_9a[k]=v;
}else{
delete _9a[k];
}
}
}
}
return _97.call(_99,key,_9a);
};
cx.lastIndex=0;
if(cx.test(_96)){
_96=_96.replace(cx,function(a){
return "\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4);
});
}
if(/^[\],:{}\s]*$/.test(_96.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]").replace(/(?:^|:|,)(?:\s*\[)+/g,""))){
j=eval("("+_96+")");
return typeof _97==="function"?_98({"":j},""):j;
}
throw new SyntaxError("JSON.parse");
};
}
})();


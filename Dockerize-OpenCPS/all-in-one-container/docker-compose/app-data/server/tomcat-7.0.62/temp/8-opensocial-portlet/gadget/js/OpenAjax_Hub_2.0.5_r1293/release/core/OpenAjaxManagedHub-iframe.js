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
OpenAjax.gadgets.util=function(){
function _9b(url){
var _9c;
var _9d=url.indexOf("?");
var _9e=url.indexOf("#");
if(_9e===-1){
_9c=url.substr(_9d+1);
}else{
_9c=[url.substr(_9d+1,_9e-_9d-1),"&",url.substr(_9e+1)].join("");
}
return _9c.split("&");
};
var _9f=null;
var _a0=[];
return {getUrlParameters:function(_a1){
if(_9f!==null&&typeof _a1==="undefined"){
return _9f;
}
var _a2={};
var _a3=_9b(_a1||document.location.href);
var _a4=window.decodeURIComponent?decodeURIComponent:unescape;
for(var i=0,j=_a3.length;i<j;++i){
var pos=_a3[i].indexOf("=");
if(pos===-1){
continue;
}
var _a5=_a3[i].substring(0,pos);
var _a6=_a3[i].substring(pos+1);
_a6=_a6.replace(/\+/g," ");
_a2[_a5]=_a4(_a6);
}
if(typeof _a1==="undefined"){
_9f=_a2;
}
return _a2;
},registerOnLoadHandler:function(_a7){
_a0.push(_a7);
},runOnLoadHandlers:function(){
for(var i=0,j=_a0.length;i<j;++i){
_a0[i]();
}
},"attachBrowserEvent":function(_a8,_a9,_aa,_ab){
if(_a8.addEventListener){
_a8.addEventListener(_a9,_aa,_ab);
}else{
if(_a8.attachEvent){
_a8.attachEvent("on"+_a9,_aa);
}
}
},"removeBrowserEvent":function(_ac,_ad,_ae,_af){
if(_ac.removeEventListener){
_ac.removeEventListener(_ad,_ae,_af);
}else{
if(_ac.detachEvent){
_ac.detachEvent("on"+_ad,_ae);
}
}
}};
}();
OpenAjax.gadgets.util.getUrlParameters();
OpenAjax.gadgets.json=OpenAjax.gadgets.json||{};
if(!OpenAjax.gadgets.json.stringify){
OpenAjax.gadgets.json={parse:function(str){
try{
return window.JSON.parse(str);
}
catch(e){
return false;
}
},stringify:function(obj){
try{
return window.JSON.stringify(obj);
}
catch(e){
return null;
}
}};
}
OpenAjax.gadgets.log=function(_b0){
OpenAjax.gadgets.log.logAtLevel(OpenAjax.gadgets.log.INFO,_b0);
};
OpenAjax.gadgets.warn=function(_b1){
OpenAjax.gadgets.log.logAtLevel(OpenAjax.gadgets.log.WARNING,_b1);
};
OpenAjax.gadgets.error=function(_b2){
OpenAjax.gadgets.log.logAtLevel(OpenAjax.gadgets.log.ERROR,_b2);
};
OpenAjax.gadgets.setLogLevel=function(_b3){
OpenAjax.gadgets.log.logLevelThreshold_=_b3;
};
OpenAjax.gadgets.log.logAtLevel=function(_b4,_b5){
if(_b4<OpenAjax.gadgets.log.logLevelThreshold_||!OpenAjax.gadgets.log._console){
return;
}
var _b6;
var _b7=OpenAjax.gadgets.log._console;
if(_b4==OpenAjax.gadgets.log.WARNING&&_b7.warn){
_b7.warn(_b5);
}else{
if(_b4==OpenAjax.gadgets.log.ERROR&&_b7.error){
_b7.error(_b5);
}else{
if(_b7.log){
_b7.log(_b5);
}
}
}
};
OpenAjax.gadgets.log.INFO=1;
OpenAjax.gadgets.log.WARNING=2;
OpenAjax.gadgets.log.ERROR=3;
OpenAjax.gadgets.log.NONE=4;
OpenAjax.gadgets.log.logLevelThreshold_=OpenAjax.gadgets.log.INFO;
OpenAjax.gadgets.log._console=window.console?window.console:window.opera?window.opera.postError:undefined;
(function(){
if(!window.__isgadget){
var _b8=false;
function _b9(){
if(!_b8){
_b8=true;
OpenAjax.gadgets.util.runOnLoadHandlers();
OpenAjax.gadgets.util.registerOnLoadHandler=function(_ba){
setTimeout(_ba,0);
};
if(window.detachEvent){
window.detachEvent("onload",_b9);
}
}
};
if(window.addEventListener){
document.addEventListener("DOMContentLoaded",_b9,false);
window.addEventListener("load",_b9,false);
}else{
if(window.attachEvent){
window.attachEvent("onload",_b9);
}
}
}
})();
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.frameElement){
OpenAjax.gadgets.rpctx.frameElement=function(){
var _bb="__g2c_rpc";
var _bc="__c2g_rpc";
var _bd;
var _be;
function _bf(_c0,_c1,rpc){
try{
if(_c1!==".."){
var fe=window.frameElement;
if(typeof fe[_bb]==="function"){
if(typeof fe[_bb][_bc]!=="function"){
fe[_bb][_bc]=function(_c2){
_bd(OpenAjax.gadgets.json.parse(_c2));
};
}
fe[_bb](OpenAjax.gadgets.json.stringify(rpc));
return;
}
}else{
var _c3=document.getElementById(_c0);
if(typeof _c3[_bb]==="function"&&typeof _c3[_bb][_bc]==="function"){
_c3[_bb][_bc](OpenAjax.gadgets.json.stringify(rpc));
return;
}
}
}
catch(e){
}
return true;
};
return {getCode:function(){
return "fe";
},isParentVerifiable:function(){
return false;
},init:function(_c4,_c5){
_bd=_c4;
_be=_c5;
return true;
},setup:function(_c6,_c7){
if(_c6!==".."){
try{
var _c8=document.getElementById(_c6);
_c8[_bb]=function(_c9){
_bd(OpenAjax.gadgets.json.parse(_c9));
};
}
catch(e){
return false;
}
}
if(_c6===".."){
_be("..",true);
var _ca=function(){
window.setTimeout(function(){
OpenAjax.gadgets.rpc.call(_c6,OpenAjax.gadgets.rpc.ACK);
},500);
};
OpenAjax.gadgets.util.registerOnLoadHandler(_ca);
}
return true;
},call:function(_cb,_cc,rpc){
_bf(_cb,_cc,rpc);
}};
}();
}
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.ifpc){
OpenAjax.gadgets.rpctx.ifpc=function(){
var _cd=[];
var _ce=0;
var _cf;
function _d0(_d1){
var _d2=[];
for(var i=0,j=_d1.length;i<j;++i){
_d2.push(encodeURIComponent(OpenAjax.gadgets.json.stringify(_d1[i])));
}
return _d2.join("&");
};
function _d3(src){
var _d4;
for(var i=_cd.length-1;i>=0;--i){
var ifr=_cd[i];
try{
if(ifr&&(ifr.recyclable||ifr.readyState==="complete")){
ifr.parentNode.removeChild(ifr);
if(window.ActiveXObject){
_cd[i]=ifr=null;
_cd.splice(i,1);
}else{
ifr.recyclable=false;
_d4=ifr;
break;
}
}
}
catch(e){
}
}
if(!_d4){
_d4=document.createElement("iframe");
_d4.style.border=_d4.style.width=_d4.style.height="0px";
_d4.style.visibility="hidden";
_d4.style.position="absolute";
_d4.onload=function(){
this.recyclable=true;
};
_cd.push(_d4);
}
_d4.src=src;
window.setTimeout(function(){
document.body.appendChild(_d4);
},0);
};
return {getCode:function(){
return "ifpc";
},isParentVerifiable:function(){
return true;
},init:function(_d5,_d6){
_cf=_d6;
_cf("..",true);
return true;
},setup:function(_d7,_d8){
_cf(_d7,true);
return true;
},call:function(_d9,_da,rpc){
var _db=OpenAjax.gadgets.rpc.getRelayUrl(_d9);
++_ce;
if(!_db){
OpenAjax.gadgets.warn("No relay file assigned for IFPC");
return;
}
var src=null;
if(rpc.l){
var _dc=rpc.a;
src=[_db,"#",_d0([_da,_ce,1,0,_d0([_da,rpc.s,"","",_da].concat(_dc))])].join("");
}else{
src=[_db,"#",_d9,"&",_da,"@",_ce,"&1&0&",encodeURIComponent(OpenAjax.gadgets.json.stringify(rpc))].join("");
}
_d3(src);
return true;
}};
}();
}
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.nix){
OpenAjax.gadgets.rpctx.nix=function(){
var _dd="GRPC____NIXVBS_wrapper";
var _de="GRPC____NIXVBS_get_wrapper";
var _df="GRPC____NIXVBS_handle_message";
var _e0="GRPC____NIXVBS_create_channel";
var _e1=10;
var _e2=500;
var _e3={};
var _e4={};
var _e5;
var _e6=0;
function _e7(){
var _e8=_e3[".."];
if(_e8){
return;
}
if(++_e6>_e1){
OpenAjax.gadgets.warn("Nix transport setup failed, falling back...");
_e5("..",false);
return;
}
if(!_e8&&window.opener&&"GetAuthToken" in window.opener){
_e8=window.opener;
if(_e8.GetAuthToken()==OpenAjax.gadgets.rpc.getAuthToken("..")){
var _e9=OpenAjax.gadgets.rpc.getAuthToken("..");
_e8.CreateChannel(window[_de]("..",_e9),_e9);
_e3[".."]=_e8;
window.opener=null;
_e5("..",true);
return;
}
}
window.setTimeout(function(){
_e7();
},_e2);
};
function _ea(){
var loc=window.location.href;
var idx=loc.indexOf("#");
if(idx==-1){
return loc;
}
return loc.substring(0,idx);
};
function _eb(_ec){
var _ed=(2147483647*Math.random())|0;
var _ee=[_ea(),_ed];
OpenAjax.gadgets.rpc._createRelayIframe(_ec,_ee);
var _ef=window.location.href.split("#")[1]||"";
function _f0(){
var _f1=window.location.href.split("#")[1]||"";
if(_f1!==_ef){
clearInterval(_f2);
var _f3=OpenAjax.gadgets.util.getUrlParameters(window.location.href);
if(_f3.childtoken==_ed){
_e7();
return;
}
_e5("..",false);
}
};
var _f2=setInterval(_f0,100);
};
return {getCode:function(){
return "nix";
},isParentVerifiable:function(_f4){
if(_f4){
return _e4[_f4];
}
return false;
},init:function(_f5,_f6){
_e5=_f6;
if(typeof window[_de]!=="unknown"){
window[_df]=function(_f7){
window.setTimeout(function(){
_f5(OpenAjax.gadgets.json.parse(_f7));
},0);
};
window[_e0]=function(_f8,_f9,_fa){
if(OpenAjax.gadgets.rpc.getAuthToken(_f8)===_fa){
_e3[_f8]=_f9;
_e5(_f8,true);
}
};
var _fb="Class "+_dd+"\n "+"Private m_Intended\n"+"Private m_Auth\n"+"Public Sub SetIntendedName(name)\n "+"If isEmpty(m_Intended) Then\n"+"m_Intended = name\n"+"End If\n"+"End Sub\n"+"Public Sub SetAuth(auth)\n "+"If isEmpty(m_Auth) Then\n"+"m_Auth = auth\n"+"End If\n"+"End Sub\n"+"Public Sub SendMessage(data)\n "+_df+"(data)\n"+"End Sub\n"+"Public Function GetAuthToken()\n "+"GetAuthToken = m_Auth\n"+"End Function\n"+"Public Sub CreateChannel(channel, auth)\n "+"Call "+_e0+"(m_Intended, channel, auth)\n"+"End Sub\n"+"End Class\n"+"Function "+_de+"(name, auth)\n"+"Dim wrap\n"+"Set wrap = New "+_dd+"\n"+"wrap.SetIntendedName name\n"+"wrap.SetAuth auth\n"+"Set "+_de+" = wrap\n"+"End Function";
try{
window.execScript(_fb,"vbscript");
}
catch(e){
return false;
}
}
return true;
},setup:function(_fc,_fd,_fe){
_e4[_fc]=!!_fe;
if(_fc===".."){
if(_fe){
_eb(_fd);
}else{
_e7();
}
return true;
}
try{
var _ff=document.getElementById(_fc);
var _100=window[_de](_fc,_fd);
_ff.contentWindow.opener=_100;
}
catch(e){
return false;
}
return true;
},call:function(_101,from,rpc){
try{
if(_e3[_101]){
_e3[_101].SendMessage(OpenAjax.gadgets.json.stringify(rpc));
}
}
catch(e){
return false;
}
return true;
},relayOnload:function(_102,data){
var src=data[0]+"#childtoken="+data[1];
var _103=document.getElementById(_102);
_103.src=src;
}};
}();
}
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.rmr){
OpenAjax.gadgets.rpctx.rmr=function(){
var _104=500;
var _105=10;
var _106={};
var _107;
var _108;
function _109(_10a,_10b,data,_10c){
var _10d=function(){
document.body.appendChild(_10a);
_10a.src="about:blank";
if(_10c){
_10a.onload=function(){
_122(_10c);
};
}
_10a.src=_10b+"#"+data;
};
if(document.body){
_10d();
}else{
OpenAjax.gadgets.util.registerOnLoadHandler(function(){
_10d();
});
}
};
function _10e(_10f){
if(typeof _106[_10f]==="object"){
return;
}
var _110=document.createElement("iframe");
var _111=_110.style;
_111.position="absolute";
_111.top="0px";
_111.border="0";
_111.opacity="0";
_111.width="10px";
_111.height="1px";
_110.id="rmrtransport-"+_10f;
_110.name=_110.id;
var _112=OpenAjax.gadgets.rpc.getRelayUrl(_10f);
if(!_112){
_112=OpenAjax.gadgets.rpc.getOrigin(OpenAjax.gadgets.util.getUrlParameters()["parent"])+"/robots.txt";
}
_106[_10f]={frame:_110,receiveWindow:null,relayUri:_112,searchCounter:0,width:10,waiting:true,queue:[],sendId:0,recvId:0};
if(_10f!==".."){
_109(_110,_112,_113(_10f));
}
_114(_10f);
};
function _114(_115){
var _116=null;
_106[_115].searchCounter++;
try{
var _117=OpenAjax.gadgets.rpc._getTargetWin(_115);
if(_115===".."){
_116=_117.frames["rmrtransport-"+OpenAjax.gadgets.rpc.RPC_ID];
}else{
_116=_117.frames["rmrtransport-.."];
}
}
catch(e){
}
var _118=false;
if(_116){
_118=_119(_115,_116);
}
if(!_118){
if(_106[_115].searchCounter>_105){
return;
}
window.setTimeout(function(){
_114(_115);
},_104);
}
};
function _11a(_11b,_11c,from,rpc){
var _11d=null;
if(from!==".."){
_11d=_106[".."];
}else{
_11d=_106[_11b];
}
if(_11d){
if(_11c!==OpenAjax.gadgets.rpc.ACK){
_11d.queue.push(rpc);
}
if(_11d.waiting||(_11d.queue.length===0&&!(_11c===OpenAjax.gadgets.rpc.ACK&&rpc&&rpc.ackAlone===true))){
return true;
}
if(_11d.queue.length>0){
_11d.waiting=true;
}
var url=_11d.relayUri+"#"+_113(_11b);
try{
_11d.frame.contentWindow.location=url;
var _11e=_11d.width==10?20:10;
_11d.frame.style.width=_11e+"px";
_11d.width=_11e;
}
catch(e){
return false;
}
}
return true;
};
function _113(_11f){
var _120=_106[_11f];
var _121={id:_120.sendId};
if(_120){
_121.d=Array.prototype.slice.call(_120.queue,0);
_121.d.push({s:OpenAjax.gadgets.rpc.ACK,id:_120.recvId});
}
return OpenAjax.gadgets.json.stringify(_121);
};
function _122(_123){
var _124=_106[_123];
var data=_124.receiveWindow.location.hash.substring(1);
var _125=OpenAjax.gadgets.json.parse(decodeURIComponent(data))||{};
var _126=_125.d||[];
var _127=false;
var _128=false;
var _129=0;
var _12a=(_124.recvId-_125.id);
for(var i=0;i<_126.length;++i){
var rpc=_126[i];
if(rpc.s===OpenAjax.gadgets.rpc.ACK){
_108(_123,true);
if(_124.waiting){
_128=true;
}
_124.waiting=false;
var _12b=Math.max(0,rpc.id-_124.sendId);
_124.queue.splice(0,_12b);
_124.sendId=Math.max(_124.sendId,rpc.id||0);
continue;
}
_127=true;
if(++_129<=_12a){
continue;
}
++_124.recvId;
_107(rpc);
}
if(_127||(_128&&_124.queue.length>0)){
var from=(_123==="..")?OpenAjax.gadgets.rpc.RPC_ID:"..";
_11a(_123,OpenAjax.gadgets.rpc.ACK,from,{ackAlone:_127});
}
};
function _119(_12c,_12d){
var _12e=_106[_12c];
try{
var _12f=false;
_12f="document" in _12d;
if(!_12f){
return false;
}
_12f=typeof _12d["document"]=="object";
if(!_12f){
return false;
}
var loc=_12d.location.href;
if(loc==="about:blank"){
return false;
}
}
catch(ex){
return false;
}
_12e.receiveWindow=_12d;
function _130(){
_122(_12c);
};
if(typeof _12d.attachEvent==="undefined"){
_12d.onresize=_130;
}else{
_12d.attachEvent("onresize",_130);
}
if(_12c===".."){
_109(_12e.frame,_12e.relayUri,_113(_12c),_12c);
}else{
_122(_12c);
}
return true;
};
return {getCode:function(){
return "rmr";
},isParentVerifiable:function(){
return true;
},init:function(_131,_132){
_107=_131;
_108=_132;
return true;
},setup:function(_133,_134){
try{
_10e(_133);
}
catch(e){
OpenAjax.gadgets.warn("Caught exception setting up RMR: "+e);
return false;
}
return true;
},call:function(_135,from,rpc){
return _11a(_135,rpc.s,from,rpc);
}};
}();
}
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.wpm){
OpenAjax.gadgets.rpctx.wpm=function(){
var _136,_137;
var _138;
var _139=false;
var _13a=false;
function _13b(){
var hit=false;
function _13c(_13d){
if(_13d.data=="postmessage.test"){
hit=true;
if(typeof _13d.origin==="undefined"){
_13a=true;
}
}
};
OpenAjax.gadgets.util.attachBrowserEvent(window,"message",_13c,false);
window.postMessage("postmessage.test","*");
if(hit){
_139=true;
}
OpenAjax.gadgets.util.removeBrowserEvent(window,"message",_13c,false);
};
function _13e(_13f){
var rpc=OpenAjax.gadgets.json.parse(_13f.data);
if(!rpc||!rpc.f){
return;
}
var _140=OpenAjax.gadgets.rpc.getRelayUrl(rpc.f)||OpenAjax.gadgets.util.getUrlParameters()["parent"];
var _141=OpenAjax.gadgets.rpc.getOrigin(_140);
if(!_13a?_13f.origin!==_141:_13f.domain!==/^.+:\/\/([^:]+).*/.exec(_141)[1]){
return;
}
_136(rpc);
};
return {getCode:function(){
return "wpm";
},isParentVerifiable:function(){
return true;
},init:function(_142,_143){
_136=_142;
_137=_143;
_13b();
if(!_139){
_138=function(win,msg,_144){
win.postMessage(msg,_144);
};
}else{
_138=function(win,msg,_145){
window.setTimeout(function(){
win.postMessage(msg,_145);
},0);
};
}
OpenAjax.gadgets.util.attachBrowserEvent(window,"message",_13e,false);
_137("..",true);
return true;
},setup:function(_146,_147,_148){
if(_146===".."){
if(_148){
OpenAjax.gadgets.rpc._createRelayIframe(_147);
}else{
OpenAjax.gadgets.rpc.call(_146,OpenAjax.gadgets.rpc.ACK);
}
}
return true;
},call:function(_149,from,rpc){
var _14a=OpenAjax.gadgets.rpc._getTargetWin(_149);
var _14b=OpenAjax.gadgets.rpc.getRelayUrl(_149)||OpenAjax.gadgets.util.getUrlParameters()["parent"];
var _14c=OpenAjax.gadgets.rpc.getOrigin(_14b);
if(_14c){
_138(_14a,OpenAjax.gadgets.json.stringify(rpc),_14c);
}else{
OpenAjax.gadgets.error("No relay set (used as window.postMessage targetOrigin)"+", cannot send cross-domain message");
}
return true;
},relayOnload:function(_14d,data){
_137(_14d,true);
}};
}();
}
if(!OpenAjax.gadgets.rpc){
OpenAjax.gadgets.rpc=function(){
var _14e="__cb";
var _14f="";
var ACK="__ack";
var _150=500;
var _151=10;
var _152={};
var _153={};
var _154={};
var _155={};
var _156=0;
var _157={};
var _158={};
var _159={};
var _15a={};
var _15b={};
var _15c={};
var _15d=(window.top!==window.self);
var _15e=window.name;
var _15f=function(){
};
var _160=0;
var _161=1;
var _162=2;
var _163=(function(){
function _164(name){
return function(){
OpenAjax.gadgets.log("gadgets.rpc."+name+"("+OpenAjax.gadgets.json.stringify(Array.prototype.slice.call(arguments))+"): call ignored. [caller: "+document.location+", isChild: "+_15d+"]");
};
};
return {getCode:function(){
return "noop";
},isParentVerifiable:function(){
return true;
},init:_164("init"),setup:_164("setup"),call:_164("call")};
})();
if(OpenAjax.gadgets.util){
_15a=OpenAjax.gadgets.util.getUrlParameters();
}
function _165(){
return typeof window.postMessage==="function"?OpenAjax.gadgets.rpctx.wpm:typeof window.postMessage==="object"?OpenAjax.gadgets.rpctx.wpm:window.ActiveXObject?OpenAjax.gadgets.rpctx.nix:navigator.userAgent.indexOf("WebKit")>0?OpenAjax.gadgets.rpctx.rmr:navigator.product==="Gecko"?OpenAjax.gadgets.rpctx.frameElement:OpenAjax.gadgets.rpctx.ifpc;
};
function _166(_167,_168){
var tx=_169;
if(!_168){
tx=_163;
}
_15b[_167]=tx;
var _16a=_15c[_167]||[];
for(var i=0;i<_16a.length;++i){
var rpc=_16a[i];
rpc.t=_16b(_167);
tx.call(_167,rpc.f,rpc);
}
_15c[_167]=[];
};
var _16c=false,_16d=false;
function _16e(){
if(_16d){
return;
}
function _16f(){
_16c=true;
};
OpenAjax.gadgets.util.attachBrowserEvent(window,"unload",_16f,false);
_16d=true;
};
function _170(_171,_172,_173,data,_174){
if(!_155[_172]||_155[_172]!==_173){
OpenAjax.gadgets.error("Invalid auth token. "+_155[_172]+" vs "+_173);
_15f(_172,_162);
}
_174.onunload=function(){
if(_158[_172]&&!_16c){
_15f(_172,_161);
OpenAjax.gadgets.rpc.removeReceiver(_172);
}
};
_16e();
data=OpenAjax.gadgets.json.parse(decodeURIComponent(data));
_169.relayOnload(_172,data);
};
function _175(rpc){
if(rpc&&typeof rpc.s==="string"&&typeof rpc.f==="string"&&rpc.a instanceof Array){
if(_155[rpc.f]){
if(_155[rpc.f]!==rpc.t){
OpenAjax.gadgets.error("Invalid auth token. "+_155[rpc.f]+" vs "+rpc.t);
_15f(rpc.f,_162);
}
}
if(rpc.s===ACK){
window.setTimeout(function(){
_166(rpc.f,true);
},0);
return;
}
if(rpc.c){
rpc.callback=function(_176){
OpenAjax.gadgets.rpc.call(rpc.f,_14e,null,rpc.c,_176);
};
}
var _177=(_152[rpc.s]||_152[_14f]).apply(rpc,rpc.a);
if(rpc.c&&typeof _177!=="undefined"){
OpenAjax.gadgets.rpc.call(rpc.f,_14e,null,rpc.c,_177);
}
}
};
function _178(url){
if(!url){
return "";
}
url=url.toLowerCase();
if(url.indexOf("//")==0){
url=window.location.protocol+url;
}
if(url.indexOf("://")==-1){
url=window.location.protocol+"//"+url;
}
var host=url.substring(url.indexOf("://")+3);
var _179=host.indexOf("/");
if(_179!=-1){
host=host.substring(0,_179);
}
var _17a=url.substring(0,url.indexOf("://"));
var _17b="";
var _17c=host.indexOf(":");
if(_17c!=-1){
var port=host.substring(_17c+1);
host=host.substring(0,_17c);
if((_17a==="http"&&port!=="80")||(_17a==="https"&&port!=="443")){
_17b=":"+port;
}
}
return _17a+"://"+host+_17b;
};
function _17d(id){
if(typeof id==="undefined"||id===".."){
return window.parent;
}
id=String(id);
var _17e=window.frames[id];
if(_17e){
return _17e;
}
_17e=document.getElementById(id);
if(_17e&&_17e.contentWindow){
return _17e.contentWindow;
}
return null;
};
var _169=_165();
_152[_14f]=function(){
OpenAjax.gadgets.warn("Unknown RPC service: "+this.s);
};
_152[_14e]=function(_17f,_180){
var _181=_157[_17f];
if(_181){
delete _157[_17f];
_181(_180);
}
};
function _182(_183,_184,_185){
if(_158[_183]===true){
return;
}
if(typeof _158[_183]==="undefined"){
_158[_183]=0;
}
var _186=document.getElementById(_183);
if(_183===".."||_186!=null){
if(_169.setup(_183,_184,_185)===true){
_158[_183]=true;
return;
}
}
if(_158[_183]!==true&&_158[_183]++<_151){
window.setTimeout(function(){
_182(_183,_184,_185);
},_150);
}else{
_15b[_183]=_163;
_158[_183]=true;
}
};
function _187(_188,rpc){
if(typeof _159[_188]==="undefined"){
_159[_188]=false;
var _189=OpenAjax.gadgets.rpc.getRelayUrl(_188);
if(_178(_189)!==_178(window.location.href)){
return false;
}
var _18a=_17d(_188);
try{
_159[_188]=_18a.OpenAjax.gadgets.rpc.receiveSameDomain;
}
catch(e){
OpenAjax.gadgets.error("Same domain call failed: parent= incorrectly set.");
}
}
if(typeof _159[_188]==="function"){
_159[_188](rpc);
return true;
}
return false;
};
function _18b(_18c,url,_18d){
if(!/http(s)?:\/\/.+/.test(url)){
if(url.indexOf("//")==0){
url=window.location.protocol+url;
}else{
if(url.charAt(0)=="/"){
url=window.location.protocol+"//"+window.location.host+url;
}else{
if(url.indexOf("://")==-1){
url=window.location.protocol+"//"+url;
}
}
}
}
_153[_18c]=url;
_154[_18c]=!!_18d;
};
function _16b(_18e){
return _155[_18e];
};
function _18f(_190,_191,_192){
_191=_191||"";
_155[_190]=String(_191);
_182(_190,_191,_192);
};
function _193(_194,_195){
function init(_196){
var _197=_196?_196.rpc:{};
var _198=_197.parentRelayUrl;
if(_198.substring(0,7)!=="http://"&&_198.substring(0,8)!=="https://"&&_198.substring(0,2)!=="//"){
if(typeof _15a.parent==="string"&&_15a.parent!==""){
if(_198.substring(0,1)!=="/"){
var _199=_15a.parent.lastIndexOf("/");
_198=_15a.parent.substring(0,_199+1)+_198;
}else{
_198=_178(_15a.parent)+_198;
}
}
}
var _19a=!!_197.useLegacyProtocol;
_18b("..",_198,_19a);
if(_19a){
_169=OpenAjax.gadgets.rpctx.ifpc;
_169.init(_175,_166);
}
var _19b=_195||_15a.forcesecure||false;
_18f("..",_194,_19b);
};
var _19c={parentRelayUrl:OpenAjax.gadgets.config.NonEmptyStringValidator};
OpenAjax.gadgets.config.register("rpc",_19c,init);
};
function _19d(_19e,_19f,_1a0){
var _1a1=_1a0||_15a.forcesecure||false;
var _1a2=_19f||_15a.parent;
if(_1a2){
_18b("..",_1a2);
_18f("..",_19e,_1a1);
}
};
function _1a3(_1a4,_1a5,_1a6,_1a7){
if(!OpenAjax.gadgets.util){
return;
}
var _1a8=document.getElementById(_1a4);
if(!_1a8){
throw new Error("Cannot set up gadgets.rpc receiver with ID: "+_1a4+", element not found.");
}
var _1a9=_1a5||_1a8.src;
_18b(_1a4,_1a9);
var _1aa=OpenAjax.gadgets.util.getUrlParameters(_1a8.src);
var _1ab=_1a6||_1aa.rpctoken;
var _1ac=_1a7||_1aa.forcesecure;
_18f(_1a4,_1ab,_1ac);
};
function _1ad(_1ae,_1af,_1b0,_1b1){
if(_1ae===".."){
var _1b2=_1b0||_15a.rpctoken||_15a.ifpctok||"";
if(window["__isgadget"]===true){
_193(_1b2,_1b1);
}else{
_19d(_1b2,_1af,_1b1);
}
}else{
_1a3(_1ae,_1af,_1b0,_1b1);
}
};
return {config:function(_1b3){
if(typeof _1b3.securityCallback==="function"){
_15f=_1b3.securityCallback;
}
},register:function(_1b4,_1b5){
if(_1b4===_14e||_1b4===ACK){
throw new Error("Cannot overwrite callback/ack service");
}
if(_1b4===_14f){
throw new Error("Cannot overwrite default service:"+" use registerDefault");
}
_152[_1b4]=_1b5;
},unregister:function(_1b6){
if(_1b6===_14e||_1b6===ACK){
throw new Error("Cannot delete callback/ack service");
}
if(_1b6===_14f){
throw new Error("Cannot delete default service:"+" use unregisterDefault");
}
delete _152[_1b6];
},registerDefault:function(_1b7){
_152[_14f]=_1b7;
},unregisterDefault:function(){
delete _152[_14f];
},forceParentVerifiable:function(){
if(!_169.isParentVerifiable()){
_169=OpenAjax.gadgets.rpctx.ifpc;
}
},call:function(_1b8,_1b9,_1ba,_1bb){
_1b8=_1b8||"..";
var from="..";
if(_1b8===".."){
from=_15e;
}
++_156;
if(_1ba){
_157[_156]=_1ba;
}
var rpc={s:_1b9,f:from,c:_1ba?_156:0,a:Array.prototype.slice.call(arguments,3),t:_155[_1b8],l:_154[_1b8]};
if(_1b8!==".."&&!document.getElementById(_1b8)){
OpenAjax.gadgets.log("WARNING: attempted send to nonexistent frame: "+_1b8);
return;
}
if(_187(_1b8,rpc)){
return;
}
var _1bc=_15b[_1b8];
if(!_1bc){
if(!_15c[_1b8]){
_15c[_1b8]=[rpc];
}else{
_15c[_1b8].push(rpc);
}
return;
}
if(_154[_1b8]){
_1bc=OpenAjax.gadgets.rpctx.ifpc;
}
if(_1bc.call(_1b8,from,rpc)===false){
_15b[_1b8]=_163;
_169.call(_1b8,from,rpc);
}
},getRelayUrl:function(_1bd){
var url=_153[_1bd];
if(url&&url.substring(0,1)==="/"){
if(url.substring(1,2)==="/"){
url=document.location.protocol+url;
}else{
url=document.location.protocol+"//"+document.location.host+url;
}
}
return url;
},setRelayUrl:_18b,setAuthToken:_18f,setupReceiver:_1ad,getAuthToken:_16b,removeReceiver:function(_1be){
delete _153[_1be];
delete _154[_1be];
delete _155[_1be];
delete _158[_1be];
delete _159[_1be];
delete _15b[_1be];
},getRelayChannel:function(){
return _169.getCode();
},receive:function(_1bf,_1c0){
if(_1bf.length>4){
_175(OpenAjax.gadgets.json.parse(decodeURIComponent(_1bf[_1bf.length-1])));
}else{
_170.apply(null,_1bf.concat(_1c0));
}
},receiveSameDomain:function(rpc){
rpc.a=Array.prototype.slice.call(rpc.a);
window.setTimeout(function(){
_175(rpc);
},0);
},getOrigin:_178,getReceiverOrigin:function(_1c1){
var _1c2=_15b[_1c1];
if(!_1c2){
return null;
}
if(!_1c2.isParentVerifiable(_1c1)){
return null;
}
var _1c3=OpenAjax.gadgets.rpc.getRelayUrl(_1c1)||OpenAjax.gadgets.util.getUrlParameters().parent;
return OpenAjax.gadgets.rpc.getOrigin(_1c3);
},init:function(){
if(_169.init(_175,_166)===false){
_169=_163;
}
if(_15d){
_1ad("..");
}
},_getTargetWin:_17d,_createRelayIframe:function(_1c4,data){
var _1c5=OpenAjax.gadgets.rpc.getRelayUrl("..");
if(!_1c5){
return;
}
var src=_1c5+"#..&"+_15e+"&"+_1c4+"&"+encodeURIComponent(OpenAjax.gadgets.json.stringify(data));
var _1c6=document.createElement("iframe");
_1c6.style.border=_1c6.style.width=_1c6.style.height="0px";
_1c6.style.visibility="hidden";
_1c6.style.position="absolute";
function _1c7(){
document.body.appendChild(_1c6);
_1c6.src="javascript:\"<html></html>\"";
_1c6.src=src;
};
if(document.body){
_1c7();
}else{
OpenAjax.gadgets.util.registerOnLoadHandler(function(){
_1c7();
});
}
return _1c6;
},ACK:ACK,RPC_ID:_15e,SEC_ERROR_LOAD_TIMEOUT:_160,SEC_ERROR_FRAME_PHISH:_161,SEC_ERROR_FORGED_MSG:_162};
}();
OpenAjax.gadgets.rpc.init();
}


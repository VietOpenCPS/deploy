OpenAjax.gadgets.util=function(){
function _1(_2){
var _3;
var _4=_2.indexOf("?");
var _5=_2.indexOf("#");
if(_5===-1){
_3=_2.substr(_4+1);
}else{
_3=[_2.substr(_4+1,_5-_4-1),"&",_2.substr(_5+1)].join("");
}
return _3.split("&");
};
var _6=null;
var _7=[];
return {getUrlParameters:function(_8){
if(_6!==null&&typeof _8==="undefined"){
return _6;
}
var _9={};
var _a=_1(_8||document.location.href);
var _b=window.decodeURIComponent?decodeURIComponent:unescape;
for(var i=0,j=_a.length;i<j;++i){
var _c=_a[i].indexOf("=");
if(_c===-1){
continue;
}
var _d=_a[i].substring(0,_c);
var _e=_a[i].substring(_c+1);
_e=_e.replace(/\+/g," ");
_9[_d]=_b(_e);
}
if(typeof _8==="undefined"){
_6=_9;
}
return _9;
},registerOnLoadHandler:function(_f){
_7.push(_f);
},runOnLoadHandlers:function(){
for(var i=0,j=_7.length;i<j;++i){
_7[i]();
}
},"attachBrowserEvent":function(_10,_11,_12,_13){
if(_10.addEventListener){
_10.addEventListener(_11,_12,_13);
}else{
if(_10.attachEvent){
_10.attachEvent("on"+_11,_12);
}
}
},"removeBrowserEvent":function(_14,_15,_16,_17){
if(_14.removeEventListener){
_14.removeEventListener(_15,_16,_17);
}else{
if(_14.detachEvent){
_14.detachEvent("on"+_15,_16);
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
OpenAjax.gadgets.log=function(_18){
OpenAjax.gadgets.log.logAtLevel(OpenAjax.gadgets.log.INFO,_18);
};
OpenAjax.gadgets.warn=function(_19){
OpenAjax.gadgets.log.logAtLevel(OpenAjax.gadgets.log.WARNING,_19);
};
OpenAjax.gadgets.error=function(_1a){
OpenAjax.gadgets.log.logAtLevel(OpenAjax.gadgets.log.ERROR,_1a);
};
OpenAjax.gadgets.setLogLevel=function(_1b){
OpenAjax.gadgets.log.logLevelThreshold_=_1b;
};
OpenAjax.gadgets.log.logAtLevel=function(_1c,_1d){
if(_1c<OpenAjax.gadgets.log.logLevelThreshold_||!OpenAjax.gadgets.log._console){
return;
}
var _1e;
var _1f=OpenAjax.gadgets.log._console;
if(_1c==OpenAjax.gadgets.log.WARNING&&_1f.warn){
_1f.warn(_1d);
}else{
if(_1c==OpenAjax.gadgets.log.ERROR&&_1f.error){
_1f.error(_1d);
}else{
if(_1f.log){
_1f.log(_1d);
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
var _20=false;
function _21(){
if(!_20){
_20=true;
OpenAjax.gadgets.util.runOnLoadHandlers();
OpenAjax.gadgets.util.registerOnLoadHandler=function(_22){
setTimeout(_22,0);
};
if(window.detachEvent){
window.detachEvent("onload",_21);
}
}
};
if(window.addEventListener){
document.addEventListener("DOMContentLoaded",_21,false);
window.addEventListener("load",_21,false);
}else{
if(window.attachEvent){
window.attachEvent("onload",_21);
}
}
}
})();
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.frameElement){
OpenAjax.gadgets.rpctx.frameElement=function(){
var _23="__g2c_rpc";
var _24="__c2g_rpc";
var _25;
var _26;
function _27(_28,_29,rpc){
try{
if(_29!==".."){
var fe=window.frameElement;
if(typeof fe[_23]==="function"){
if(typeof fe[_23][_24]!=="function"){
fe[_23][_24]=function(_2a){
_25(OpenAjax.gadgets.json.parse(_2a));
};
}
fe[_23](OpenAjax.gadgets.json.stringify(rpc));
return;
}
}else{
var _2b=document.getElementById(_28);
if(typeof _2b[_23]==="function"&&typeof _2b[_23][_24]==="function"){
_2b[_23][_24](OpenAjax.gadgets.json.stringify(rpc));
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
},init:function(_2c,_2d){
_25=_2c;
_26=_2d;
return true;
},setup:function(_2e,_2f){
if(_2e!==".."){
try{
var _30=document.getElementById(_2e);
_30[_23]=function(_31){
_25(OpenAjax.gadgets.json.parse(_31));
};
}
catch(e){
return false;
}
}
if(_2e===".."){
_26("..",true);
var _32=function(){
window.setTimeout(function(){
OpenAjax.gadgets.rpc.call(_2e,OpenAjax.gadgets.rpc.ACK);
},500);
};
OpenAjax.gadgets.util.registerOnLoadHandler(_32);
}
return true;
},call:function(_33,_34,rpc){
_27(_33,_34,rpc);
}};
}();
}
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.ifpc){
OpenAjax.gadgets.rpctx.ifpc=function(){
var _35=[];
var _36=0;
var _37;
function _38(_39){
var _3a=[];
for(var i=0,j=_39.length;i<j;++i){
_3a.push(encodeURIComponent(OpenAjax.gadgets.json.stringify(_39[i])));
}
return _3a.join("&");
};
function _3b(src){
var _3c;
for(var i=_35.length-1;i>=0;--i){
var ifr=_35[i];
try{
if(ifr&&(ifr.recyclable||ifr.readyState==="complete")){
ifr.parentNode.removeChild(ifr);
if(window.ActiveXObject){
_35[i]=ifr=null;
_35.splice(i,1);
}else{
ifr.recyclable=false;
_3c=ifr;
break;
}
}
}
catch(e){
}
}
if(!_3c){
_3c=document.createElement("iframe");
_3c.style.border=_3c.style.width=_3c.style.height="0px";
_3c.style.visibility="hidden";
_3c.style.position="absolute";
_3c.onload=function(){
this.recyclable=true;
};
_35.push(_3c);
}
_3c.src=src;
window.setTimeout(function(){
document.body.appendChild(_3c);
},0);
};
return {getCode:function(){
return "ifpc";
},isParentVerifiable:function(){
return true;
},init:function(_3d,_3e){
_37=_3e;
_37("..",true);
return true;
},setup:function(_3f,_40){
_37(_3f,true);
return true;
},call:function(_41,_42,rpc){
var _43=OpenAjax.gadgets.rpc.getRelayUrl(_41);
++_36;
if(!_43){
OpenAjax.gadgets.warn("No relay file assigned for IFPC");
return;
}
var src=null;
if(rpc.l){
var _44=rpc.a;
src=[_43,"#",_38([_42,_36,1,0,_38([_42,rpc.s,"","",_42].concat(_44))])].join("");
}else{
src=[_43,"#",_41,"&",_42,"@",_36,"&1&0&",encodeURIComponent(OpenAjax.gadgets.json.stringify(rpc))].join("");
}
_3b(src);
return true;
}};
}();
}
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.nix){
OpenAjax.gadgets.rpctx.nix=function(){
var _45="GRPC____NIXVBS_wrapper";
var _46="GRPC____NIXVBS_get_wrapper";
var _47="GRPC____NIXVBS_handle_message";
var _48="GRPC____NIXVBS_create_channel";
var _49=10;
var _4a=500;
var _4b={};
var _4c={};
var _4d;
var _4e=0;
function _4f(){
var _50=_4b[".."];
if(_50){
return;
}
if(++_4e>_49){
OpenAjax.gadgets.warn("Nix transport setup failed, falling back...");
_4d("..",false);
return;
}
if(!_50&&window.opener&&"GetAuthToken" in window.opener){
_50=window.opener;
if(_50.GetAuthToken()==OpenAjax.gadgets.rpc.getAuthToken("..")){
var _51=OpenAjax.gadgets.rpc.getAuthToken("..");
_50.CreateChannel(window[_46]("..",_51),_51);
_4b[".."]=_50;
window.opener=null;
_4d("..",true);
return;
}
}
window.setTimeout(function(){
_4f();
},_4a);
};
function _52(){
var loc=window.location.href;
var idx=loc.indexOf("#");
if(idx==-1){
return loc;
}
return loc.substring(0,idx);
};
function _53(_54){
var _55=(2147483647*Math.random())|0;
var _56=[_52(),_55];
OpenAjax.gadgets.rpc._createRelayIframe(_54,_56);
var _57=window.location.href.split("#")[1]||"";
function _58(){
var _59=window.location.href.split("#")[1]||"";
if(_59!==_57){
clearInterval(_5a);
var _5b=OpenAjax.gadgets.util.getUrlParameters(window.location.href);
if(_5b.childtoken==_55){
_4f();
return;
}
_4d("..",false);
}
};
var _5a=setInterval(_58,100);
};
return {getCode:function(){
return "nix";
},isParentVerifiable:function(_5c){
if(_5c){
return _4c[_5c];
}
return false;
},init:function(_5d,_5e){
_4d=_5e;
if(typeof window[_46]!=="unknown"){
window[_47]=function(_5f){
window.setTimeout(function(){
_5d(OpenAjax.gadgets.json.parse(_5f));
},0);
};
window[_48]=function(_60,_61,_62){
if(OpenAjax.gadgets.rpc.getAuthToken(_60)===_62){
_4b[_60]=_61;
_4d(_60,true);
}
};
var _63="Class "+_45+"\n "+"Private m_Intended\n"+"Private m_Auth\n"+"Public Sub SetIntendedName(name)\n "+"If isEmpty(m_Intended) Then\n"+"m_Intended = name\n"+"End If\n"+"End Sub\n"+"Public Sub SetAuth(auth)\n "+"If isEmpty(m_Auth) Then\n"+"m_Auth = auth\n"+"End If\n"+"End Sub\n"+"Public Sub SendMessage(data)\n "+_47+"(data)\n"+"End Sub\n"+"Public Function GetAuthToken()\n "+"GetAuthToken = m_Auth\n"+"End Function\n"+"Public Sub CreateChannel(channel, auth)\n "+"Call "+_48+"(m_Intended, channel, auth)\n"+"End Sub\n"+"End Class\n"+"Function "+_46+"(name, auth)\n"+"Dim wrap\n"+"Set wrap = New "+_45+"\n"+"wrap.SetIntendedName name\n"+"wrap.SetAuth auth\n"+"Set "+_46+" = wrap\n"+"End Function";
try{
window.execScript(_63,"vbscript");
}
catch(e){
return false;
}
}
return true;
},setup:function(_64,_65,_66){
_4c[_64]=!!_66;
if(_64===".."){
if(_66){
_53(_65);
}else{
_4f();
}
return true;
}
try{
var _67=document.getElementById(_64);
var _68=window[_46](_64,_65);
_67.contentWindow.opener=_68;
}
catch(e){
return false;
}
return true;
},call:function(_69,_6a,rpc){
try{
if(_4b[_69]){
_4b[_69].SendMessage(OpenAjax.gadgets.json.stringify(rpc));
}
}
catch(e){
return false;
}
return true;
},relayOnload:function(_6b,_6c){
var src=_6c[0]+"#childtoken="+_6c[1];
var _6d=document.getElementById(_6b);
_6d.src=src;
}};
}();
}
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.rmr){
OpenAjax.gadgets.rpctx.rmr=function(){
var _6e=500;
var _6f=10;
var _70={};
var _71;
var _72;
function _73(_74,_75,_76,_77){
var _78=function(){
document.body.appendChild(_74);
_74.src="about:blank";
if(_77){
_74.onload=function(){
_8e(_77);
};
}
_74.src=_75+"#"+_76;
};
if(document.body){
_78();
}else{
OpenAjax.gadgets.util.registerOnLoadHandler(function(){
_78();
});
}
};
function _79(_7a){
if(typeof _70[_7a]==="object"){
return;
}
var _7b=document.createElement("iframe");
var _7c=_7b.style;
_7c.position="absolute";
_7c.top="0px";
_7c.border="0";
_7c.opacity="0";
_7c.width="10px";
_7c.height="1px";
_7b.id="rmrtransport-"+_7a;
_7b.name=_7b.id;
var _7d=OpenAjax.gadgets.rpc.getRelayUrl(_7a);
if(!_7d){
_7d=OpenAjax.gadgets.rpc.getOrigin(OpenAjax.gadgets.util.getUrlParameters()["parent"])+"/robots.txt";
}
_70[_7a]={frame:_7b,receiveWindow:null,relayUri:_7d,searchCounter:0,width:10,waiting:true,queue:[],sendId:0,recvId:0};
if(_7a!==".."){
_73(_7b,_7d,_7e(_7a));
}
_7f(_7a);
};
function _7f(_80){
var _81=null;
_70[_80].searchCounter++;
try{
var _82=OpenAjax.gadgets.rpc._getTargetWin(_80);
if(_80===".."){
_81=_82.frames["rmrtransport-"+OpenAjax.gadgets.rpc.RPC_ID];
}else{
_81=_82.frames["rmrtransport-.."];
}
}
catch(e){
}
var _83=false;
if(_81){
_83=_84(_80,_81);
}
if(!_83){
if(_70[_80].searchCounter>_6f){
return;
}
window.setTimeout(function(){
_7f(_80);
},_6e);
}
};
function _85(_86,_87,_88,rpc){
var _89=null;
if(_88!==".."){
_89=_70[".."];
}else{
_89=_70[_86];
}
if(_89){
if(_87!==OpenAjax.gadgets.rpc.ACK){
_89.queue.push(rpc);
}
if(_89.waiting||(_89.queue.length===0&&!(_87===OpenAjax.gadgets.rpc.ACK&&rpc&&rpc.ackAlone===true))){
return true;
}
if(_89.queue.length>0){
_89.waiting=true;
}
var url=_89.relayUri+"#"+_7e(_86);
try{
_89.frame.contentWindow.location=url;
var _8a=_89.width==10?20:10;
_89.frame.style.width=_8a+"px";
_89.width=_8a;
}
catch(e){
return false;
}
}
return true;
};
function _7e(_8b){
var _8c=_70[_8b];
var _8d={id:_8c.sendId};
if(_8c){
_8d.d=Array.prototype.slice.call(_8c.queue,0);
_8d.d.push({s:OpenAjax.gadgets.rpc.ACK,id:_8c.recvId});
}
return OpenAjax.gadgets.json.stringify(_8d);
};
function _8e(_8f){
var _90=_70[_8f];
var _91=_90.receiveWindow.location.hash.substring(1);
var _92=OpenAjax.gadgets.json.parse(decodeURIComponent(_91))||{};
var _93=_92.d||[];
var _94=false;
var _95=false;
var _96=0;
var _97=(_90.recvId-_92.id);
for(var i=0;i<_93.length;++i){
var rpc=_93[i];
if(rpc.s===OpenAjax.gadgets.rpc.ACK){
_72(_8f,true);
if(_90.waiting){
_95=true;
}
_90.waiting=false;
var _98=Math.max(0,rpc.id-_90.sendId);
_90.queue.splice(0,_98);
_90.sendId=Math.max(_90.sendId,rpc.id||0);
continue;
}
_94=true;
if(++_96<=_97){
continue;
}
++_90.recvId;
_71(rpc);
}
if(_94||(_95&&_90.queue.length>0)){
var _99=(_8f==="..")?OpenAjax.gadgets.rpc.RPC_ID:"..";
_85(_8f,OpenAjax.gadgets.rpc.ACK,_99,{ackAlone:_94});
}
};
function _84(_9a,_9b){
var _9c=_70[_9a];
try{
var _9d=false;
_9d="document" in _9b;
if(!_9d){
return false;
}
_9d=typeof _9b["document"]=="object";
if(!_9d){
return false;
}
var loc=_9b.location.href;
if(loc==="about:blank"){
return false;
}
}
catch(ex){
return false;
}
_9c.receiveWindow=_9b;
function _9e(){
_8e(_9a);
};
if(typeof _9b.attachEvent==="undefined"){
_9b.onresize=_9e;
}else{
_9b.attachEvent("onresize",_9e);
}
if(_9a===".."){
_73(_9c.frame,_9c.relayUri,_7e(_9a),_9a);
}else{
_8e(_9a);
}
return true;
};
return {getCode:function(){
return "rmr";
},isParentVerifiable:function(){
return true;
},init:function(_9f,_a0){
_71=_9f;
_72=_a0;
return true;
},setup:function(_a1,_a2){
try{
_79(_a1);
}
catch(e){
OpenAjax.gadgets.warn("Caught exception setting up RMR: "+e);
return false;
}
return true;
},call:function(_a3,_a4,rpc){
return _85(_a3,rpc.s,_a4,rpc);
}};
}();
}
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
if(!OpenAjax.gadgets.rpctx.wpm){
OpenAjax.gadgets.rpctx.wpm=function(){
var _a5,_a6;
var _a7;
var _a8=false;
var _a9=false;
function _aa(){
var hit=false;
function _ab(_ac){
if(_ac.data=="postmessage.test"){
hit=true;
if(typeof _ac.origin==="undefined"){
_a9=true;
}
}
};
OpenAjax.gadgets.util.attachBrowserEvent(window,"message",_ab,false);
window.postMessage("postmessage.test","*");
if(hit){
_a8=true;
}
OpenAjax.gadgets.util.removeBrowserEvent(window,"message",_ab,false);
};
function _ad(_ae){
var rpc=OpenAjax.gadgets.json.parse(_ae.data);
if(!rpc||!rpc.f){
return;
}
var _af=OpenAjax.gadgets.rpc.getRelayUrl(rpc.f)||OpenAjax.gadgets.util.getUrlParameters()["parent"];
var _b0=OpenAjax.gadgets.rpc.getOrigin(_af);
if(!_a9?_ae.origin!==_b0:_ae.domain!==/^.+:\/\/([^:]+).*/.exec(_b0)[1]){
return;
}
_a5(rpc);
};
return {getCode:function(){
return "wpm";
},isParentVerifiable:function(){
return true;
},init:function(_b1,_b2){
_a5=_b1;
_a6=_b2;
_aa();
if(!_a8){
_a7=function(win,msg,_b3){
win.postMessage(msg,_b3);
};
}else{
_a7=function(win,msg,_b4){
window.setTimeout(function(){
win.postMessage(msg,_b4);
},0);
};
}
OpenAjax.gadgets.util.attachBrowserEvent(window,"message",_ad,false);
_a6("..",true);
return true;
},setup:function(_b5,_b6,_b7){
if(_b5===".."){
if(_b7){
OpenAjax.gadgets.rpc._createRelayIframe(_b6);
}else{
OpenAjax.gadgets.rpc.call(_b5,OpenAjax.gadgets.rpc.ACK);
}
}
return true;
},call:function(_b8,_b9,rpc){
var _ba=OpenAjax.gadgets.rpc._getTargetWin(_b8);
var _bb=OpenAjax.gadgets.rpc.getRelayUrl(_b8)||OpenAjax.gadgets.util.getUrlParameters()["parent"];
var _bc=OpenAjax.gadgets.rpc.getOrigin(_bb);
if(_bc){
_a7(_ba,OpenAjax.gadgets.json.stringify(rpc),_bc);
}else{
OpenAjax.gadgets.error("No relay set (used as window.postMessage targetOrigin)"+", cannot send cross-domain message");
}
return true;
},relayOnload:function(_bd,_be){
_a6(_bd,true);
}};
}();
}
if(!OpenAjax.gadgets.rpc){
OpenAjax.gadgets.rpc=function(){
var _bf="__cb";
var _c0="";
var ACK="__ack";
var _c1=500;
var _c2=10;
var _c3={};
var _c4={};
var _c5={};
var _c6={};
var _c7=0;
var _c8={};
var _c9={};
var _ca={};
var _cb={};
var _cc={};
var _cd={};
var _ce=(window.top!==window.self);
var _cf=window.name;
var _d0=function(){
};
var _d1=0;
var _d2=1;
var _d3=2;
var _d4=(function(){
function _d5(_d6){
return function(){
OpenAjax.gadgets.log("gadgets.rpc."+_d6+"("+OpenAjax.gadgets.json.stringify(Array.prototype.slice.call(arguments))+"): call ignored. [caller: "+document.location+", isChild: "+_ce+"]");
};
};
return {getCode:function(){
return "noop";
},isParentVerifiable:function(){
return true;
},init:_d5("init"),setup:_d5("setup"),call:_d5("call")};
})();
if(OpenAjax.gadgets.util){
_cb=OpenAjax.gadgets.util.getUrlParameters();
}
function _d7(){
return typeof window.postMessage==="function"?OpenAjax.gadgets.rpctx.wpm:typeof window.postMessage==="object"?OpenAjax.gadgets.rpctx.wpm:window.ActiveXObject?OpenAjax.gadgets.rpctx.nix:navigator.userAgent.indexOf("WebKit")>0?OpenAjax.gadgets.rpctx.rmr:navigator.product==="Gecko"?OpenAjax.gadgets.rpctx.frameElement:OpenAjax.gadgets.rpctx.ifpc;
};
function _d8(_d9,_da){
var tx=_db;
if(!_da){
tx=_d4;
}
_cc[_d9]=tx;
var _dc=_cd[_d9]||[];
for(var i=0;i<_dc.length;++i){
var rpc=_dc[i];
rpc.t=_dd(_d9);
tx.call(_d9,rpc.f,rpc);
}
_cd[_d9]=[];
};
var _de=false,_df=false;
function _e0(){
if(_df){
return;
}
function _e1(){
_de=true;
};
OpenAjax.gadgets.util.attachBrowserEvent(window,"unload",_e1,false);
_df=true;
};
function _e2(_e3,_e4,_e5,_e6,_e7){
if(!_c6[_e4]||_c6[_e4]!==_e5){
OpenAjax.gadgets.error("Invalid auth token. "+_c6[_e4]+" vs "+_e5);
_d0(_e4,_d3);
}
_e7.onunload=function(){
if(_c9[_e4]&&!_de){
_d0(_e4,_d2);
OpenAjax.gadgets.rpc.removeReceiver(_e4);
}
};
_e0();
_e6=OpenAjax.gadgets.json.parse(decodeURIComponent(_e6));
_db.relayOnload(_e4,_e6);
};
function _e8(rpc){
if(rpc&&typeof rpc.s==="string"&&typeof rpc.f==="string"&&rpc.a instanceof Array){
if(_c6[rpc.f]){
if(_c6[rpc.f]!==rpc.t){
OpenAjax.gadgets.error("Invalid auth token. "+_c6[rpc.f]+" vs "+rpc.t);
_d0(rpc.f,_d3);
}
}
if(rpc.s===ACK){
window.setTimeout(function(){
_d8(rpc.f,true);
},0);
return;
}
if(rpc.c){
rpc.callback=function(_e9){
OpenAjax.gadgets.rpc.call(rpc.f,_bf,null,rpc.c,_e9);
};
}
var _ea=(_c3[rpc.s]||_c3[_c0]).apply(rpc,rpc.a);
if(rpc.c&&typeof _ea!=="undefined"){
OpenAjax.gadgets.rpc.call(rpc.f,_bf,null,rpc.c,_ea);
}
}
};
function _eb(url){
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
var _ec=url.substring(url.indexOf("://")+3);
var _ed=_ec.indexOf("/");
if(_ed!=-1){
_ec=_ec.substring(0,_ed);
}
var _ee=url.substring(0,url.indexOf("://"));
var _ef="";
var _f0=_ec.indexOf(":");
if(_f0!=-1){
var _f1=_ec.substring(_f0+1);
_ec=_ec.substring(0,_f0);
if((_ee==="http"&&_f1!=="80")||(_ee==="https"&&_f1!=="443")){
_ef=":"+_f1;
}
}
return _ee+"://"+_ec+_ef;
};
function _f2(id){
if(typeof id==="undefined"||id===".."){
return window.parent;
}
id=String(id);
var _f3=window.frames[id];
if(_f3){
return _f3;
}
_f3=document.getElementById(id);
if(_f3&&_f3.contentWindow){
return _f3.contentWindow;
}
return null;
};
var _db=_d7();
_c3[_c0]=function(){
OpenAjax.gadgets.warn("Unknown RPC service: "+this.s);
};
_c3[_bf]=function(_f4,_f5){
var _f6=_c8[_f4];
if(_f6){
delete _c8[_f4];
_f6(_f5);
}
};
function _f7(_f8,_f9,_fa){
if(_c9[_f8]===true){
return;
}
if(typeof _c9[_f8]==="undefined"){
_c9[_f8]=0;
}
var _fb=document.getElementById(_f8);
if(_f8===".."||_fb!=null){
if(_db.setup(_f8,_f9,_fa)===true){
_c9[_f8]=true;
return;
}
}
if(_c9[_f8]!==true&&_c9[_f8]++<_c2){
window.setTimeout(function(){
_f7(_f8,_f9,_fa);
},_c1);
}else{
_cc[_f8]=_d4;
_c9[_f8]=true;
}
};
function _fc(_fd,rpc){
if(typeof _ca[_fd]==="undefined"){
_ca[_fd]=false;
var _fe=OpenAjax.gadgets.rpc.getRelayUrl(_fd);
if(_eb(_fe)!==_eb(window.location.href)){
return false;
}
var _ff=_f2(_fd);
try{
_ca[_fd]=_ff.OpenAjax.gadgets.rpc.receiveSameDomain;
}
catch(e){
OpenAjax.gadgets.error("Same domain call failed: parent= incorrectly set.");
}
}
if(typeof _ca[_fd]==="function"){
_ca[_fd](rpc);
return true;
}
return false;
};
function _100(_101,url,_102){
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
_c4[_101]=url;
_c5[_101]=!!_102;
};
function _dd(_103){
return _c6[_103];
};
function _104(_105,_106,_107){
_106=_106||"";
_c6[_105]=String(_106);
_f7(_105,_106,_107);
};
function _108(_109,_10a){
function init(_10b){
var _10c=_10b?_10b.rpc:{};
var _10d=_10c.parentRelayUrl;
if(_10d.substring(0,7)!=="http://"&&_10d.substring(0,8)!=="https://"&&_10d.substring(0,2)!=="//"){
if(typeof _cb.parent==="string"&&_cb.parent!==""){
if(_10d.substring(0,1)!=="/"){
var _10e=_cb.parent.lastIndexOf("/");
_10d=_cb.parent.substring(0,_10e+1)+_10d;
}else{
_10d=_eb(_cb.parent)+_10d;
}
}
}
var _10f=!!_10c.useLegacyProtocol;
_100("..",_10d,_10f);
if(_10f){
_db=OpenAjax.gadgets.rpctx.ifpc;
_db.init(_e8,_d8);
}
var _110=_10a||_cb.forcesecure||false;
_104("..",_109,_110);
};
var _111={parentRelayUrl:OpenAjax.gadgets.config.NonEmptyStringValidator};
OpenAjax.gadgets.config.register("rpc",_111,init);
};
function _112(_113,_114,_115){
var _116=_115||_cb.forcesecure||false;
var _117=_114||_cb.parent;
if(_117){
_100("..",_117);
_104("..",_113,_116);
}
};
function _118(_119,_11a,_11b,_11c){
if(!OpenAjax.gadgets.util){
return;
}
var _11d=document.getElementById(_119);
if(!_11d){
throw new Error("Cannot set up gadgets.rpc receiver with ID: "+_119+", element not found.");
}
var _11e=_11a||_11d.src;
_100(_119,_11e);
var _11f=OpenAjax.gadgets.util.getUrlParameters(_11d.src);
var _120=_11b||_11f.rpctoken;
var _121=_11c||_11f.forcesecure;
_104(_119,_120,_121);
};
function _122(_123,_124,_125,_126){
if(_123===".."){
var _127=_125||_cb.rpctoken||_cb.ifpctok||"";
if(window["__isgadget"]===true){
_108(_127,_126);
}else{
_112(_127,_124,_126);
}
}else{
_118(_123,_124,_125,_126);
}
};
return {config:function(_128){
if(typeof _128.securityCallback==="function"){
_d0=_128.securityCallback;
}
},register:function(_129,_12a){
if(_129===_bf||_129===ACK){
throw new Error("Cannot overwrite callback/ack service");
}
if(_129===_c0){
throw new Error("Cannot overwrite default service:"+" use registerDefault");
}
_c3[_129]=_12a;
},unregister:function(_12b){
if(_12b===_bf||_12b===ACK){
throw new Error("Cannot delete callback/ack service");
}
if(_12b===_c0){
throw new Error("Cannot delete default service:"+" use unregisterDefault");
}
delete _c3[_12b];
},registerDefault:function(_12c){
_c3[_c0]=_12c;
},unregisterDefault:function(){
delete _c3[_c0];
},forceParentVerifiable:function(){
if(!_db.isParentVerifiable()){
_db=OpenAjax.gadgets.rpctx.ifpc;
}
},call:function(_12d,_12e,_12f,_130){
_12d=_12d||"..";
var from="..";
if(_12d===".."){
from=_cf;
}
++_c7;
if(_12f){
_c8[_c7]=_12f;
}
var rpc={s:_12e,f:from,c:_12f?_c7:0,a:Array.prototype.slice.call(arguments,3),t:_c6[_12d],l:_c5[_12d]};
if(_12d!==".."&&!document.getElementById(_12d)){
OpenAjax.gadgets.log("WARNING: attempted send to nonexistent frame: "+_12d);
return;
}
if(_fc(_12d,rpc)){
return;
}
var _131=_cc[_12d];
if(!_131){
if(!_cd[_12d]){
_cd[_12d]=[rpc];
}else{
_cd[_12d].push(rpc);
}
return;
}
if(_c5[_12d]){
_131=OpenAjax.gadgets.rpctx.ifpc;
}
if(_131.call(_12d,from,rpc)===false){
_cc[_12d]=_d4;
_db.call(_12d,from,rpc);
}
},getRelayUrl:function(_132){
var url=_c4[_132];
if(url&&url.substring(0,1)==="/"){
if(url.substring(1,2)==="/"){
url=document.location.protocol+url;
}else{
url=document.location.protocol+"//"+document.location.host+url;
}
}
return url;
},setRelayUrl:_100,setAuthToken:_104,setupReceiver:_122,getAuthToken:_dd,removeReceiver:function(_133){
delete _c4[_133];
delete _c5[_133];
delete _c6[_133];
delete _c9[_133];
delete _ca[_133];
delete _cc[_133];
},getRelayChannel:function(){
return _db.getCode();
},receive:function(_134,_135){
if(_134.length>4){
_e8(OpenAjax.gadgets.json.parse(decodeURIComponent(_134[_134.length-1])));
}else{
_e2.apply(null,_134.concat(_135));
}
},receiveSameDomain:function(rpc){
rpc.a=Array.prototype.slice.call(rpc.a);
window.setTimeout(function(){
_e8(rpc);
},0);
},getOrigin:_eb,getReceiverOrigin:function(_136){
var _137=_cc[_136];
if(!_137){
return null;
}
if(!_137.isParentVerifiable(_136)){
return null;
}
var _138=OpenAjax.gadgets.rpc.getRelayUrl(_136)||OpenAjax.gadgets.util.getUrlParameters().parent;
return OpenAjax.gadgets.rpc.getOrigin(_138);
},init:function(){
if(_db.init(_e8,_d8)===false){
_db=_d4;
}
if(_ce){
_122("..");
}
},_getTargetWin:_f2,_createRelayIframe:function(_139,data){
var _13a=OpenAjax.gadgets.rpc.getRelayUrl("..");
if(!_13a){
return;
}
var src=_13a+"#..&"+_cf+"&"+_139+"&"+encodeURIComponent(OpenAjax.gadgets.json.stringify(data));
var _13b=document.createElement("iframe");
_13b.style.border=_13b.style.width=_13b.style.height="0px";
_13b.style.visibility="hidden";
_13b.style.position="absolute";
function _13c(){
document.body.appendChild(_13b);
_13b.src="javascript:\"<html></html>\"";
_13b.src=src;
};
if(document.body){
_13c();
}else{
OpenAjax.gadgets.util.registerOnLoadHandler(function(){
_13c();
});
}
return _13b;
},ACK:ACK,RPC_ID:_cf,SEC_ERROR_LOAD_TIMEOUT:_d1,SEC_ERROR_FRAME_PHISH:_d2,SEC_ERROR_FORGED_MSG:_d3};
}();
OpenAjax.gadgets.rpc.init();
}


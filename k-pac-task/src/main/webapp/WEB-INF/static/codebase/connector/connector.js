if(window.dhtmlXGridObject){dhtmlXGridObject.prototype._init_point_connector=dhtmlXGridObject.prototype._init_point;dhtmlXGridObject.prototype._init_point=function(){this._con_f_used=[].concat(this._con_f_used);dhtmlXGridObject.prototype._con_f_used=[];var A=function(E){E=E.replace(/(\?|\&)connector[^\f]*/g,"");return E+(E.indexOf("?")!=-1?"&":"?")+"connector=true"+(this.hdr.rows.length>0?"&dhx_no_header=1":"")};var D=function(E){return A.call(this,E)+(this._connector_sorting||"")+(this._connector_filter||"")};var C=function(F,G,E){this._connector_sorting="&dhx_sort["+G+"]="+E;return D.call(this,F)};var B=function(F,E,H){for(var G=0;G<E.length;G++){E[G]="dhx_filter["+E[G]+"]="+encodeURIComponent(H[G])}this._connector_filter="&"+E.join("&");return D.call(this,F)};this.attachEvent("onCollectValues",function(E){if(this._con_f_used[E]){if(typeof (this._con_f_used[E])=="object"){return this._con_f_used[E]}else{return false}}return true});this.attachEvent("onDynXLS",function(){this.xmlFileUrl=D.call(this,this.xmlFileUrl);return true});this.attachEvent("onBeforeSorting",function(H,G,F){if(G=="connector"){var E=this;this.clearAndLoad(C.call(this,this.xmlFileUrl,H,F),function(){E.setSortImgState(true,H,F)});return false}return true});this.attachEvent("onFilterStart",function(F,E){if(this._con_f_used.length){this.clearAndLoad(B.call(this,this.xmlFileUrl,F,E));return false}return true});this.attachEvent("onXLE",function(F,E,H,G){if(!G){return }});if(this._init_point_connector){this._init_point_connector()}};dhtmlXGridObject.prototype._con_f_used=[];dhtmlXGridObject.prototype._in_header_connector_text_filter=function(B,A){if(!this._con_f_used[A]){this._con_f_used[A]=1}return this._in_header_text_filter(B,A)};dhtmlXGridObject.prototype._in_header_connector_select_filter=function(B,A){if(!this._con_f_used[A]){this._con_f_used[A]=2}return this._in_header_select_filter(B,A)};dhtmlXGridObject.prototype.load_connector=dhtmlXGridObject.prototype.load;dhtmlXGridObject.prototype.load=function(B,E,D){if(!this._colls_loaded&&this.cellType){var A=[];for(var C=0;C<this.cellType.length;C++){if(this.cellType[C].indexOf("co")==0||this._con_f_used[C]==2){A.push(C)}}if(A.length){arguments[0]+=(arguments[0].indexOf("?")!=-1?"&":"?")+"connector=true&dhx_colls="+A.join(",")}}return this.load_connector.apply(this,arguments)};dhtmlXGridObject.prototype._parseHead_connector=dhtmlXGridObject.prototype._parseHead;dhtmlXGridObject.prototype._parseHead=function(B,M,J){this._parseHead_connector.apply(this,arguments);if(!this._colls_loaded){var K=this.xmlLoader.doXPath("./coll_options",arguments[0]);for(var G=0;G<K.length;G++){var I=K[G].getAttribute("for");var L=[];var D=null;if(this.cellType[I]=="combo"){D=this.getColumnCombo(I)}else{if(this.cellType[I].indexOf("co")==0){D=this.getCombo(I)}}var F=this.xmlLoader.doXPath("./item",K[G]);var A=[];for(var E=0;E<F.length;E++){var C=F[E].getAttribute("value");if(D){var H=F[E].getAttribute("label")||C;if(D.addOption){A.push([C,H])}else{D.put(C,H)}L[L.length]=H}else{L[L.length]=C}}if(A.length){D.addOption(A)}if(this._con_f_used[I*1]){this._con_f_used[I*1]=L}}this._colls_loaded=true}}}if(window.dataProcessor){dataProcessor.prototype.init_original=dataProcessor.prototype.init;dataProcessor.prototype.init=function(A){this.init_original(A);A._dataprocessor=this;this.setTransactionMode("POST",true);this.serverProcessor+=(this.serverProcessor.indexOf("?")!=-1?"&":"?")+"editing=true"}}dhtmlxError.catchError("LoadXML",function(B,A,C){alert(C[0].responseText)});
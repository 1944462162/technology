(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6b5205ae"],{5530:function(t,e,a){"use strict";a.d(e,"a",(function(){return o}));a("a4d3"),a("4de4"),a("4160"),a("e439"),a("dbb4"),a("b64b"),a("159b");function i(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}function n(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(t);e&&(i=i.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,i)}return a}function o(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?n(Object(a),!0).forEach((function(e){i(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):n(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}},"68e3":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticClass:"stock"},[a("el-row",[a("el-col",{attrs:{span:4}},[a("el-button",{attrs:{type:"primary"},on:{click:t.handleCreate}},[t._v("新增原料")])],1),a("el-col",{attrs:{span:6}},[a("el-input",{attrs:{placeholder:"请输入要搜索的原料名称"},model:{value:t.searchStockName,callback:function(e){t.searchStockName=e},expression:"searchStockName"}},[a("el-button",{attrs:{slot:"append",icon:"el-icon-search"},slot:"append"})],1)],1)],1),a("el-table",{attrs:{data:t.filteredData}},[a("el-table-column",{attrs:{prop:"stockName",label:"原料名称"}}),a("el-table-column",{attrs:{prop:"unit",label:"单位"}}),a("el-table-column",{attrs:{prop:"weight",label:"数量"}}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return t.handleEdit(e.row)}}},[t._v("编辑")]),a("el-popover",{ref:"popover"+e.$index},[a("p",[t._v("确定删除 "+t._s(e.row.stockName)+" 吗？")]),a("div",{staticStyle:{"text-align":"right",margin:"0"}},[a("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(a){return t.closeDeletePopover(e.$index)}}},[t._v("取消")]),a("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(a){return t.handleDelete(e.row,e.$index)}}},[t._v("确定")])],1),a("el-button",{staticStyle:{"margin-left":"1rem"},attrs:{slot:"reference",size:"mini",type:"danger"},slot:"reference"},[t._v("删除")])],1)]}}])})],1),a("el-dialog",{attrs:{title:t.editDialogTitle,width:"30%","before-close":t.handleEditDialogClose,visible:t.editDialogVisible,center:""}},[a("el-form",{attrs:{model:t.editDialogData}},[a("el-form-item",{attrs:{label:"原料名称"}},[a("el-input",{model:{value:t.editDialogData.stockName,callback:function(e){t.$set(t.editDialogData,"stockName",e)},expression:"editDialogData.stockName"}})],1),a("el-form-item",{attrs:{label:"单位"}},[a("el-input",{model:{value:t.editDialogData.unit,callback:function(e){t.$set(t.editDialogData,"unit",e)},expression:"editDialogData.unit"}})],1),a("el-form-item",{attrs:{label:"数量"}},[a("el-input",{attrs:{disabled:""},model:{value:t.editDialogData.weight,callback:function(e){t.$set(t.editDialogData,"weight",e)},expression:"editDialogData.weight"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.editDialogVisible=!1}}},[t._v("取消")]),a("el-button",{attrs:{type:"primary"},on:{click:t.submitDialogData}},[t._v("确定")])],1)],1)],1)},n=[],o=(a("4de4"),a("c975"),a("96cf"),a("1da1")),r=a("5530"),l=a("2f62"),c={data:function(){return{searchStockName:"",loading:!0,editDialogVisible:!1,editDialogTitle:"",editDialogData:{id:void 0,stockName:"",unit:"",weight:0}}},computed:Object(r["a"])({filteredData:function(){var t=this;return this.searchStockName?this.stockData.filter((function(e){return-1!==e.stockName.indexOf(t.searchStockName)})):this.stockData}},Object(l["b"])(["stockData"])),created:function(){this.fetch()},methods:{handleEditDialogClose:function(t){var e=this;this.$confirm("确认关闭？").then((function(){t(),e.editDialogVisible=!1})).catch((function(){}))},closeDeletePopover:function(t){this.$refs["popover"+t].doClose()},fetch:function(){var t=this;return Object(o["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.loading=!0,e.next=3,t.$store.dispatch("fetchStockData");case 3:t.loading=!1;case 4:case"end":return e.stop()}}),e)})))()},handleEdit:function(t){this.editDialogVisible=!0,this.editDialogTitle="编辑 "+t.stockName,this.editDialogData=Object.assign(this.editDialogData,t)},handleCreate:function(){this.editDialogVisible=!0,this.editDialogTitle="新增原料",this.editDialogData.weight=0,this.editDialogData.id=void 0,this.editDialogData.stockName="",this.editDialogData.unit=""},submitDialogData:function(){var t=this;return Object(o["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.loading=!0,t.editDialogVisible=!1,e.next=4,t.$store.dispatch({type:"updateStockData",data:t.editDialogData});case 4:t.loading=!1;case 5:case"end":return e.stop()}}),e)})))()},handleDelete:function(t,e){var a=this;return Object(o["a"])(regeneratorRuntime.mark((function i(){return regeneratorRuntime.wrap((function(i){while(1)switch(i.prev=i.next){case 0:return a.closeDeletePopover(e),a.loading=!0,i.next=4,a.$store.dispatch({type:"deleteStockDataById",data:t.id});case 4:a.loading=!1;case 5:case"end":return i.stop()}}),i)})))()}}},s=c,u=a("2877"),d=Object(u["a"])(s,i,n,!1,null,null,null);e["default"]=d.exports},b64b:function(t,e,a){var i=a("23e7"),n=a("7b0b"),o=a("df75"),r=a("d039"),l=r((function(){o(1)}));i({target:"Object",stat:!0,forced:l},{keys:function(t){return o(n(t))}})},c975:function(t,e,a){"use strict";var i=a("23e7"),n=a("4d64").indexOf,o=a("a640"),r=a("ae40"),l=[].indexOf,c=!!l&&1/[1].indexOf(1,-0)<0,s=o("indexOf"),u=r("indexOf",{ACCESSORS:!0,1:0});i({target:"Array",proto:!0,forced:c||!s||!u},{indexOf:function(t){return c?l.apply(this,arguments)||0:n(this,t,arguments.length>1?arguments[1]:void 0)}})},dbb4:function(t,e,a){var i=a("23e7"),n=a("83ab"),o=a("56ef"),r=a("fc6a"),l=a("06cf"),c=a("8418");i({target:"Object",stat:!0,sham:!n},{getOwnPropertyDescriptors:function(t){var e,a,i=r(t),n=l.f,s=o(i),u={},d=0;while(s.length>d)a=n(i,e=s[d++]),void 0!==a&&c(u,e,a);return u}})},e439:function(t,e,a){var i=a("23e7"),n=a("d039"),o=a("fc6a"),r=a("06cf").f,l=a("83ab"),c=n((function(){r(1)})),s=!l||c;i({target:"Object",stat:!0,forced:s,sham:!l},{getOwnPropertyDescriptor:function(t,e){return r(o(t),e)}})}}]);
//# sourceMappingURL=chunk-6b5205ae.009c053a.js.map
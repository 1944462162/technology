(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-25a001fd"],{"68e3":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticClass:"stock"},[i("el-row",[i("el-col",{attrs:{span:4}},[i("el-button",{attrs:{type:"primary"},on:{click:t.handleCreate}},[t._v("新增原料")])],1),i("el-col",{attrs:{span:6}},[i("el-input",{attrs:{placeholder:"请输入要搜索的原料名称"},model:{value:t.searchStockName,callback:function(e){t.searchStockName=e},expression:"searchStockName"}},[i("el-button",{attrs:{slot:"append",icon:"el-icon-search"},slot:"append"})],1)],1)],1),i("el-table",{attrs:{data:t.filteredData}},[i("el-table-column",{attrs:{prop:"stockName",label:"原料名称"}}),i("el-table-column",{attrs:{prop:"unit",label:"单位"}}),i("el-table-column",{attrs:{prop:"weight",label:"数量"}}),i("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-button",{attrs:{size:"mini"},on:{click:function(i){return t.handleEdit(e.row)}}},[t._v("编辑")]),i("el-popover",{ref:"popover"+e.$index},[i("p",[t._v("确定删除 "+t._s(e.row.stockName)+" 吗？")]),i("div",{staticStyle:{"text-align":"right",margin:"0"}},[i("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(i){return t.closeDeletePopover(e.$index)}}},[t._v("取消")]),i("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(i){return t.handleDelete(e.row,e.$index)}}},[t._v("确定")])],1),i("el-button",{staticStyle:{"margin-left":"1rem"},attrs:{slot:"reference",size:"mini",type:"danger"},slot:"reference"},[t._v("删除")])],1)]}}])})],1),i("el-dialog",{attrs:{title:t.editDialogTitle,width:"30%","before-close":t.handleEditDialogClose,visible:t.editDialogVisible,center:""}},[i("el-form",{attrs:{model:t.editDialogData}},[i("el-form-item",{attrs:{label:"原料名称"}},[i("el-input",{model:{value:t.editDialogData.stockName,callback:function(e){t.$set(t.editDialogData,"stockName",e)},expression:"editDialogData.stockName"}})],1),i("el-form-item",{attrs:{label:"单位"}},[i("el-input",{model:{value:t.editDialogData.unit,callback:function(e){t.$set(t.editDialogData,"unit",e)},expression:"editDialogData.unit"}})],1),i("el-form-item",{attrs:{label:"数量"}},[i("el-input",{attrs:{disabled:""},model:{value:t.editDialogData.weight,callback:function(e){t.$set(t.editDialogData,"weight",e)},expression:"editDialogData.weight"}})],1)],1),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.editDialogVisible=!1}}},[t._v("取消")]),i("el-button",{attrs:{type:"primary"},on:{click:t.submitDialogData}},[t._v("确定")])],1)],1)],1)},n=[],r=(i("a4d3"),i("4de4"),i("c975"),i("e439"),i("dbb4"),i("b64b"),i("159b"),i("96cf"),i("1da1")),o=i("ade3"),l=i("2f62");function c(t,e){var i=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),i.push.apply(i,a)}return i}function s(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{};e%2?c(Object(i),!0).forEach((function(e){Object(o["a"])(t,e,i[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(i)):c(Object(i)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(i,e))}))}return t}var u={data:function(){return{searchStockName:"",loading:!0,editDialogVisible:!1,editDialogTitle:"",editDialogData:{id:void 0,stockName:"",unit:"",weight:0}}},computed:s({filteredData:function(){var t=this;return this.searchStockName?this.stockData.filter((function(e){return-1!==e.stockName.indexOf(t.searchStockName)})):this.stockData}},Object(l["b"])(["stockData"])),created:function(){this.fetch()},methods:{handleEditDialogClose:function(t){var e=this;this.$confirm("确认关闭？").then((function(){t(),e.editDialogVisible=!1})).catch((function(){}))},closeDeletePopover:function(t){this.$refs["popover"+t].doClose()},fetch:function(){var t=Object(r["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return this.loading=!0,t.next=3,this.$store.dispatch("fetchStockData");case 3:this.loading=!1;case 4:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),handleEdit:function(t){this.editDialogVisible=!0,this.editDialogTitle="编辑 "+t.stockName,this.editDialogData=Object.assign(this.editDialogData,t)},handleCreate:function(){this.editDialogVisible=!0,this.editDialogTitle="新增原料",this.editDialogData.weight=0,this.editDialogData.id=void 0,this.editDialogData.stockName="",this.editDialogData.unit=""},submitDialogData:function(){var t=Object(r["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return this.loading=!0,this.editDialogVisible=!1,t.next=4,this.$store.dispatch({type:"updateStockData",data:this.editDialogData});case 4:this.loading=!1;case 5:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),handleDelete:function(){var t=Object(r["a"])(regeneratorRuntime.mark((function t(e,i){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return this.closeDeletePopover(i),this.loading=!0,t.next=4,this.$store.dispatch({type:"deleteStockDataById",data:e.id});case 4:this.loading=!1;case 5:case"end":return t.stop()}}),t,this)})));function e(e,i){return t.apply(this,arguments)}return e}()}},d=u,f=i("2877"),p=Object(f["a"])(d,a,n,!1,null,null,null);e["default"]=p.exports},ade3:function(t,e,i){"use strict";function a(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}i.d(e,"a",(function(){return a}))},b64b:function(t,e,i){var a=i("23e7"),n=i("7b0b"),r=i("df75"),o=i("d039"),l=o((function(){r(1)}));a({target:"Object",stat:!0,forced:l},{keys:function(t){return r(n(t))}})},c975:function(t,e,i){"use strict";var a=i("23e7"),n=i("4d64").indexOf,r=i("b301"),o=[].indexOf,l=!!o&&1/[1].indexOf(1,-0)<0,c=r("indexOf");a({target:"Array",proto:!0,forced:l||c},{indexOf:function(t){return l?o.apply(this,arguments)||0:n(this,t,arguments.length>1?arguments[1]:void 0)}})},dbb4:function(t,e,i){var a=i("23e7"),n=i("83ab"),r=i("56ef"),o=i("fc6a"),l=i("06cf"),c=i("8418");a({target:"Object",stat:!0,sham:!n},{getOwnPropertyDescriptors:function(t){var e,i,a=o(t),n=l.f,s=r(a),u={},d=0;while(s.length>d)i=n(a,e=s[d++]),void 0!==i&&c(u,e,i);return u}})},e439:function(t,e,i){var a=i("23e7"),n=i("d039"),r=i("fc6a"),o=i("06cf").f,l=i("83ab"),c=n((function(){o(1)})),s=!l||c;a({target:"Object",stat:!0,forced:s,sham:!l},{getOwnPropertyDescriptor:function(t,e){return o(r(t),e)}})}}]);
//# sourceMappingURL=chunk-25a001fd.f15f6c14.js.map
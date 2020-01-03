(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-34bf988c"],{"022b":function(e,t,a){},"19db":function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"stock"},[a("el-row",[a("el-col",{attrs:{span:4}},[a("el-button",{attrs:{type:"primary"},on:{click:e.handleCreate}},[e._v("新增烧结记录")])],1),a("el-col",{attrs:{span:6}},[a("el-input",{attrs:{placeholder:"请输入要搜索的编号"},model:{value:e.searchSerial,callback:function(t){e.searchSerial=t},expression:"searchSerial"}},[a("el-button",{attrs:{slot:"append",icon:"el-icon-search"},slot:"append"})],1)],1)],1),a("el-table",{attrs:{data:e.filteredData}},[a("el-table-column",{attrs:{type:"expand"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-form",{attrs:{"label-width":"110px"}},[a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"编号"}},[e._v(" "+e._s(t.row.serial)+" ")])],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"日期"}},[e._v(" "+e._s(t.row.createTime)+" ")])],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"装炉块数"}},[e._v(" "+e._s(t.row.furnaceNumber)+" ")])],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"装炉重量"}},[e._v(" "+e._s(t.row.furnaceWeight)+" ")])],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"单件重量"}},[e._v(" "+e._s(t.row.singleWeight)+" ")])],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"单盒容量"}},[e._v(" "+e._s(t.row.boxCapacity)+" ")])],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"开始电量"}},[e._v(" "+e._s(t.row.startPower)+" ")])],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"结束电量"}},[e._v(" "+e._s(t.row.endPower)+" ")])],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"合计用电"}},[e._v(" "+e._s(t.row.totalPower)+" ")])],1)],1),a("el-form-item",{attrs:{label:"烧结工艺"}},[e._v(" "+e._s(t.row.sinterRecord.name)+" ")]),a("el-table",{attrs:{data:t.row.sinterRecord.data,border:""}},[a("el-table-column",{attrs:{label:"时间"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.col1))]}}],null,!0)}),a("el-table-column",{attrs:{prop:"col2",label:"累计时间"}}),a("el-table-column",{attrs:{prop:"col3",label:"烧结过程"}}),a("el-table-column",{attrs:{prop:"col4",label:"炉温"}}),a("el-table-column",{attrs:{prop:"col5",label:"真空度"}})],1),a("el-form-item",{attrs:{label:"备注"}},[e._v(" "+e._s(t.row.note)+" ")]),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"操作人白班"}},[e._v(" "+e._s(t.row.operatorInfo.row1)+" ")]),a("el-form-item",{attrs:{label:"操作人夜班班"}},[e._v(" "+e._s(t.row.operatorInfo.row2)+" ")])],1)],1)],1)]}}])}),a("el-table-column",{attrs:{label:"编号",prop:"serial"}}),a("el-table-column",{attrs:{label:"日期",prop:"createTime"}}),a("el-table-column",{attrs:{label:"装炉块数",prop:"furnaceNumber"}}),a("el-table-column",{attrs:{label:"日期",prop:"createTime"}}),a("el-table-column",{attrs:{label:"备注",prop:"note"}}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return e.handleEdit(t.row,t.$index)}}},[e._v("编辑")]),a("el-popover",{ref:"popover"+t.$index},[a("p",[e._v("确定删除 "+e._s(t.row.serial)+" 吗？")]),a("div",{staticStyle:{"text-align":"right",margin:"0"}},[a("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(a){return e.closeDeletePopover(t.$index)}}},[e._v("取消")]),a("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(a){return e.handleDelete(t.row,t.$index)}}},[e._v("确定")])],1),a("el-button",{staticStyle:{"margin-left":"1rem"},attrs:{slot:"reference",size:"mini",type:"danger"},slot:"reference"},[e._v("删除")])],1)]}}])})],1),a("el-dialog",{attrs:{title:e.editDialogTitle,width:"50%","before-close":e.handleEditDialogClose,visible:e.editDialogVisible,center:""}},[a("el-form",{attrs:{"label-width":"110px"}},[a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"编号"}},[a("el-input",{model:{value:e.editDialogData.serial,callback:function(t){e.$set(e.editDialogData,"serial",t)},expression:"editDialogData.serial"}})],1)],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"日期"}},[a("el-date-picker",{model:{value:e.editDialogData.createTime,callback:function(t){e.$set(e.editDialogData,"createTime",t)},expression:"editDialogData.createTime"}})],1)],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"装炉块数"}},[a("el-input",{model:{value:e.editDialogData.furnaceNumber,callback:function(t){e.$set(e.editDialogData,"furnaceNumber",t)},expression:"editDialogData.furnaceNumber"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"装炉重量"}},[a("el-input",{model:{value:e.editDialogData.furnaceWeight,callback:function(t){e.$set(e.editDialogData,"furnaceWeight",t)},expression:"editDialogData.furnaceWeight"}})],1)],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"单件重量"}},[a("el-input",{model:{value:e.editDialogData.singleWeight,callback:function(t){e.$set(e.editDialogData,"singleWeight",t)},expression:"editDialogData.singleWeight"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"单盒容量"}},[a("el-input",{model:{value:e.editDialogData.boxCapacity,callback:function(t){e.$set(e.editDialogData,"boxCapacity",t)},expression:"editDialogData.boxCapacity"}})],1)],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"开始电量"}},[a("el-input",{model:{value:e.editDialogData.startPower,callback:function(t){e.$set(e.editDialogData,"startPower",t)},expression:"editDialogData.startPower"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"结束电量"}},[a("el-input",{model:{value:e.editDialogData.endPower,callback:function(t){e.$set(e.editDialogData,"endPower",t)},expression:"editDialogData.endPower"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"合计用电"}},[e._v(" "+e._s(e.editDialogData.endPower-e.editDialogData.startPower)+" ")])],1)],1),a("el-form-item",{attrs:{label:"烧结工艺名称"}},[a("el-input",{model:{value:e.editDialogData.sinterRecord.name,callback:function(t){e.$set(e.editDialogData.sinterRecord,"name",t)},expression:"editDialogData.sinterRecord.name"}})],1),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.editDialogData.sinterRecord.data.push({})}}},[e._v("增加记录")]),e._l(e.editDialogData.sinterRecord.data,(function(t,l){return a("el-card",{key:l},[a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"时间"}},[a("el-input",{model:{value:t.col1,callback:function(a){e.$set(t,"col1",a)},expression:"data.col1"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"累计时间"}},[a("el-input",{model:{value:t.col2,callback:function(a){e.$set(t,"col2",a)},expression:"data.col2"}})],1)],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"烧结过程"}},[a("el-input",{model:{value:t.col3,callback:function(a){e.$set(t,"col3",a)},expression:"data.col3"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"炉温"}},[a("el-input",{model:{value:t.col4,callback:function(a){e.$set(t,"col4",a)},expression:"data.col4"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"真空度"}},[a("el-input",{model:{value:t.col5,callback:function(a){e.$set(t,"col5",a)},expression:"data.col5"}})],1)],1)],1)],1)})),a("el-form-item",{attrs:{label:"备注"}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.editDialogData.note,callback:function(t){e.$set(e.editDialogData,"note",t)},expression:"editDialogData.note"}})],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"操作人白班"}},[a("el-input",{model:{value:e.editDialogData.operatorInfo.row1,callback:function(t){e.$set(e.editDialogData.operatorInfo,"row1",t)},expression:"editDialogData.operatorInfo.row1"}})],1),a("el-form-item",{attrs:{label:"操作人夜班班"}},[a("el-input",{model:{value:e.editDialogData.operatorInfo.row2,callback:function(t){e.$set(e.editDialogData.operatorInfo,"row2",t)},expression:"editDialogData.operatorInfo.row2"}})],1)],1)],1)],2),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.editDialogVisible=!1}}},[e._v("取消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.submitDialogData}},[e._v("确定")])],1)],1)],1)},r=[],o=(a("a4d3"),a("4de4"),a("c975"),a("fb6a"),a("a9e3"),a("e439"),a("dbb4"),a("b64b"),a("159b"),a("96cf"),a("1da1")),i=a("4f96"),n=a("ade3"),s=a("2f62"),c=a("c1df"),d=a.n(c);function u(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var l=Object.getOwnPropertySymbols(e);t&&(l=l.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,l)}return a}function f(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?u(Object(a),!0).forEach((function(t){Object(n["a"])(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):u(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}var p={data:function(){return{searchSerial:"",loading:!0,editDialogVisible:!1,disableEditSerial:!0,editDialogTitle:"",editDialogData:{sinterRecord:{name:"",data:[]},operatorInfo:{row1:"",row2:""}}}},created:function(){this.fetch()},computed:f({filteredData:function(){var e=this,t=Object(i["a"])(this.sinterData),a=t.slice(0);return this.searchSerial&&(a=a.filter((function(t){return-1!==t.serial.indexOf(e.searchSerial)}))),a.forEach((function(e){e.sinterRecord=JSON.parse(e.sinterRecord),e.operatorInfo=JSON.parse(e.operatorInfo)})),a}},Object(s["b"])(["sinterData"])),methods:{handleEditDialogClose:function(e){var t=this;this.$confirm("确认关闭？").then((function(){e(),t.editDialogVisible=!1})).catch((function(){}))},closeDeletePopover:function(e){this.$refs["popover"+e].doClose()},fetch:function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return this.loading=!0,e.next=3,this.$store.dispatch("fetchSinterData");case 3:this.loading=!1;case 4:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}(),handleEdit:function(e){this.editDialogVisible=!0,this.editDialogTitle="编辑 "+e.serial,this.disableEditSerial=!0,this.editDialogData=JSON.parse(JSON.stringify(e)),this.editDialogData.createTime=d()(this.editDialogData.createTime,"YYYY-M-D").toDate(),console.log("edit dialog data"),console.log(this.editDialogData)},handleCreate:function(){this.editDialogVisible=!0,this.editDialogTitle="新增烧结记录",this.disableEditSerial=!1,this.editDialogData={createTime:new Date,sinterRecord:{name:"",data:[]},operatorInfo:{row1:"",row2:""}}},submitDialogData:function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return this.loading=!0,this.editDialogVisible=!1,t=JSON.parse(JSON.stringify(this.editDialogData)),t.createTime=d()(this.editDialogData.createTime).format("YYYY-M-D"),t.sinterRecord=JSON.stringify(t.sinterRecord),t.operatorInfo=JSON.stringify(t.operatorInfo),t.totalPower=Number(t.endPower)-Number(t.startPower),console.log(t),e.next=10,this.$store.dispatch({type:"updateSinterData",data:t});case 10:this.loading=!1;case 11:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}(),handleDelete:function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(t,a){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return this.closeDeletePopover(a),this.loading=!0,e.next=4,this.$store.dispatch({type:"deleteSinterDataById",data:t.id});case 4:this.loading=!1;case 5:case"end":return e.stop()}}),e,this)})));function t(t,a){return e.apply(this,arguments)}return t}()}},b=p,m=(a("32a2"),a("2877")),D=Object(m["a"])(b,l,r,!1,null,null,null);t["default"]=D.exports},"32a2":function(e,t,a){"use strict";var l=a("022b"),r=a.n(l);r.a},ade3:function(e,t,a){"use strict";function l(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}a.d(t,"a",(function(){return l}))},b64b:function(e,t,a){var l=a("23e7"),r=a("7b0b"),o=a("df75"),i=a("d039"),n=i((function(){o(1)}));l({target:"Object",stat:!0,forced:n},{keys:function(e){return o(r(e))}})},c975:function(e,t,a){"use strict";var l=a("23e7"),r=a("4d64").indexOf,o=a("b301"),i=[].indexOf,n=!!i&&1/[1].indexOf(1,-0)<0,s=o("indexOf");l({target:"Array",proto:!0,forced:n||s},{indexOf:function(e){return n?i.apply(this,arguments)||0:r(this,e,arguments.length>1?arguments[1]:void 0)}})},dbb4:function(e,t,a){var l=a("23e7"),r=a("83ab"),o=a("56ef"),i=a("fc6a"),n=a("06cf"),s=a("8418");l({target:"Object",stat:!0,sham:!r},{getOwnPropertyDescriptors:function(e){var t,a,l=i(e),r=n.f,c=o(l),d={},u=0;while(c.length>u)a=r(l,t=c[u++]),void 0!==a&&s(d,t,a);return d}})},e439:function(e,t,a){var l=a("23e7"),r=a("d039"),o=a("fc6a"),i=a("06cf").f,n=a("83ab"),s=r((function(){i(1)})),c=!n||s;l({target:"Object",stat:!0,forced:c,sham:!n},{getOwnPropertyDescriptor:function(e,t){return i(o(e),t)}})}}]);
//# sourceMappingURL=chunk-34bf988c.b4f2340c.js.map
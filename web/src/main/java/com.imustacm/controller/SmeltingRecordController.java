package com.imustacm.controller;

import com.imustacm.domain.SmeltingRecord;
import com.imustacm.domain.Vo.DefaultResponseVo;
import com.imustacm.service.SmeltingRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/application")
@Api(tags = "冶炼操作记录相关请求")
public class SmeltingRecordController {

    @Autowired
    SmeltingRecordService service=null;

    @ApiOperation(value = "获取所有的备料库存")
    @GetMapping("/getAllSmeltingRecord")
    public DefaultResponseVo getAllSmeltingRecord(){

        List<SmeltingRecord> SmeltingRecords = null;
        try {
            SmeltingRecords = service.getAllSmeltingRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(SmeltingRecords != null && SmeltingRecords.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("库存为空");
        }
        return defaultResponseVo;
    }
    @ApiOperation(value = "冶金操作记录添加")
    @GetMapping("/insertSmeltingRecord")
    public DefaultResponseVo insertSmeltingRecord(@RequestBody SmeltingRecord smeltingRecord) {
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.insertSmeltingRecord(smeltingRecord);

            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"无法增加备料库存");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  defaultResponseVo;
    }

    @ApiOperation(value = "删除冶金操作记录", notes = "根据id")
    @GetMapping("/deleteSmeltingRecord/{index}")
    public DefaultResponseVo deleteSmeltingRecord(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.deleteSmeltingRecordById(index);
            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"删除备料库存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }


    @ApiOperation(value = "更改原料库存", notes = "根据id更改")
    @GetMapping("/updateSmeltingRecord")
    public DefaultResponseVo updateSmeltingRecord(@RequestBody SmeltingRecord smeltingRecord){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.updateSmeltingRecord(smeltingRecord);
            if(code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"更新冶金操作记录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取冶金操作记录",notes = "根据id查找")
    @GetMapping("/getSmeltingRecordsById/{index}")
    public DefaultResponseVo getSmeltingRecordsById(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            SmeltingRecord smeltingRecord = service.getOneSmeltingRecord(index);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("SmeltingRecord",smeltingRecord);
            defaultResponseVo.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }



}

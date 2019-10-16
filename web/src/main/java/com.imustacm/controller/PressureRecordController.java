package com.imustacm.controller;


import com.imustacm.domain.Po.PressureRecord;
import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.service.PressureRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/application")
@Api(tags = "压型操作记录相关请求")
public class PressureRecordController {


    @Autowired
    private PressureRecordService service;


    @ApiOperation(value = "获取所有的炼料库存")
    @GetMapping("/getAllPressureRecord")
    public DefaultResponseVo getAllPressureRecord(){

        List<PressureRecord> pressureRecords = null;
        try {
            pressureRecords = service.getAllPressureRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(pressureRecords != null && pressureRecords.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("压型操作记录为空为空");
        }
        return defaultResponseVo;
    }
    @ApiOperation(value = "增加压型库存")
    @GetMapping("/insertPressureRecord")
    public DefaultResponseVo insertPressureRecord(@RequestBody PressureRecord pressureRecord) {
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.insertPressureRecord(pressureRecord);

            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"无法增加压型记录");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  defaultResponseVo;
    }
    @ApiOperation(value = "删除原料库存", notes = "根据id")
    @GetMapping("/deletePressureRecord/{index}")
    public DefaultResponseVo deletePressureRecord(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.deletePressureRecordById(index);
            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"删除压型记录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "更改压型库存", notes = "根据id更改")
    @GetMapping("/updatePressureRecord")
    public DefaultResponseVo updatePressureRecord(@RequestBody PressureRecord pressureRecord){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.updatePressureRecord(pressureRecord);
            if(code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"更新压型记录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }
    @ApiOperation(value = "获取单备料",notes = "根据id查找")
    @GetMapping("/PressureRecord/{index}")
    public DefaultResponseVo getPressureRecordId(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            PressureRecord pressureRecord = service.getOnePressureRecord(index);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("pressureRecord",pressureRecord);
            defaultResponseVo.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

}

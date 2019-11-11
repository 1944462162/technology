package com.imustacm.controller;


import com.imustacm.domain.Po.PressureRecord;
import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.PressureRecordVo;
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
    public DefaultResponseVo getAllPressureRecord() throws Exception {

        List<PressureRecordVo> pressureRecordsVo= service.getAllPressureRecord();

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(pressureRecordsVo != null && pressureRecordsVo.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("pressureRecords",pressureRecordsVo);
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
    @PostMapping("/insertPressureRecord")
    public DefaultResponseVo insertPressureRecord(@RequestBody PressureRecordVo pressureRecordVo) {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        try {
            Integer code = service.insertPressureRecord(pressureRecordVo);

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
    @DeleteMapping("/deletePressureRecord/{index}")
    public DefaultResponseVo deletePressureRecord(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = service.deletePressureRecordById(index);
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
    @PutMapping("/updatePressureRecord")
    public DefaultResponseVo updatePressureRecord(@RequestBody PressureRecordVo pressureRecordVo){
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = service.updatePressureRecord(pressureRecordVo);
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
    public DefaultResponseVo getPressureRecordId(@PathVariable("index") int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        PressureRecordVo pressureRecordVo = service.getOnePressureRecord(index);
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("pressureRecord",pressureRecordVo);
        defaultResponseVo.setData(map);
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取备料信息", notes = "根据编码查找")
    @GetMapping("/getPressureRecordByCode/{index}")
    public DefaultResponseVo getPressureRecordByCode(@PathVariable("index") String index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        List<PressureRecordVo> pressureRecordVo = service.getPressureRecordByCode(index);
        if(pressureRecordVo != null && pressureRecordVo.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("pressureRecordsCode",pressureRecordVo);
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("压型操作编码记录为空");
        }
        return defaultResponseVo;
    }
}

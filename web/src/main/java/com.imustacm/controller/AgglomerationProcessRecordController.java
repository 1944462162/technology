package com.imustacm.controller;


import com.imustacm.domain.AgglomerationProcessRecord;
import com.imustacm.domain.Vo.DefaultResponseVo;
import com.imustacm.service.AgglomerationProcessRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/application")
@Api(tags = "压坯记录相关请求")
public class AgglomerationProcessRecordController {
    @Autowired
    private AgglomerationProcessRecordService service;


    @ApiOperation(value = "获取所有的压坯库存")
    @GetMapping("/getAllAgglomerationProcessRecord")
    public DefaultResponseVo getAllAgglomerationProcessRecord(){

        List<AgglomerationProcessRecord> agglomerationProcessRecord = null;
        try {
            agglomerationProcessRecord = service.getAllAgglomerationProcessRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(agglomerationProcessRecord != null && agglomerationProcessRecord.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("操作记录为空");
        }
        return defaultResponseVo;
    }
    @ApiOperation(value = "增加压坯库存")
    @GetMapping("/insertAgglomerationProcessRecord")
    public DefaultResponseVo insertAgglomerationProcessRecord(@RequestBody AgglomerationProcessRecord agglomerationProcessRecord) {
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.insertAgglomerationProcessRecord(agglomerationProcessRecord);

            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"无法增加压坯记录");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  defaultResponseVo;
    }

    @ApiOperation(value = "删除压坯库存", notes = "根据id")
    @GetMapping("/deleteAgglomerationProcessRecord/{index}")
    public DefaultResponseVo deleteAgglomerationProcessRecord(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.deleteAgglomerationProcessRecordById(index);
            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"删除压坯记录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "更改压坯记录", notes = "根据id更改")
    @GetMapping("/updateAgglomerationProcessRecord")
    public DefaultResponseVo updateAgglomerationProcessRecord(@RequestBody AgglomerationProcessRecord agglomerationProcessRecord){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.updateAgglomerationProcessRecord(agglomerationProcessRecord);
            if(code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"更新压坯记录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }


    @ApiOperation(value = "获取单压坯",notes = "根据id查找")
    @GetMapping("/getAgglomerationProcessRecordById/{index}")
    public DefaultResponseVo getAgglomerationProcessRecordById(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            AgglomerationProcessRecord agglomerationProcessRecord = service.getOneAgglomerationProcessRecord(index);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("agglomerationProcessRecord",agglomerationProcessRecord);
            defaultResponseVo.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }
}

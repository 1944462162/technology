package com.imust.controller;

import com.imust.domain.RelationVo.DefaultResponseVo;
import com.imust.domain.Vo.AgglomerationProcessRecordVo;
import com.imust.service.AgglomerationProcessRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "烧结工艺记录")
public class AgglomerationProcessRecordController {
    @Autowired
    private AgglomerationProcessRecordService service;


    @ApiOperation(value = "获取所有的烧结工艺记录")
    @GetMapping("/getSinter")
    public DefaultResponseVo getAllAgglomerationProcessRecord(){

        List<AgglomerationProcessRecordVo> agglomerationProcessRecordVos = service.getAllAgglomerationProcessRecord();
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(agglomerationProcessRecordVos != null && agglomerationProcessRecordVos.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("AgglomerationProcessRecordVo",agglomerationProcessRecordVos);
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
    @ApiOperation(value = "增加烧结工艺记录")
    @PostMapping("/insertSinter")
    public DefaultResponseVo insertAgglomerationProcessRecord(@RequestBody AgglomerationProcessRecordVo agglomerationProcessRecordVo) {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();

        int code = service.insertAgglomerationProcessRecord(agglomerationProcessRecordVo);
        Integer number = service.getNewInsertagglomerationProcessRecords();
        if (code == 1){
            HashMap<String,Object> map = new HashMap<>();
            map.put("insertAgglomerationProcessRecord",number);
            defaultResponseVo = new DefaultResponseVo(200,"ok");
            defaultResponseVo.setData(map);
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"无法增加压坯记录");
        }

        return  defaultResponseVo;
    }

    @ApiOperation(value = "删除烧结工艺记录", notes = "根据id")
    @DeleteMapping("/deleteSinter/{index}")
    public DefaultResponseVo deleteAgglomerationProcessRecord(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
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

    @ApiOperation(value = "更改烧结工艺记录", notes = "根据id更改")
    @PutMapping("/updateSinter")
    public DefaultResponseVo updateAgglomerationProcessRecord(@RequestBody AgglomerationProcessRecordVo agglomerationProcessRecordVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();

        int code = service.updateAgglomerationProcessRecord(agglomerationProcessRecordVo);
        if(code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"更新压坯记录失败");
        }

        return defaultResponseVo;
    }


    @ApiOperation(value = "获取单个烧结工艺记录",notes = "根据id查找")
    @GetMapping("/getSinterBySerial/{index}")
    public DefaultResponseVo getAgglomerationProcessRecordById(@PathVariable("index") int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        AgglomerationProcessRecordVo agglomerationProcessRecordVo = service.getOneAgglomerationProcessRecord(index);
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("AgglomerationProcessRecordVo",agglomerationProcessRecordVo);
        defaultResponseVo.setData(map);
        return defaultResponseVo;
    }
}

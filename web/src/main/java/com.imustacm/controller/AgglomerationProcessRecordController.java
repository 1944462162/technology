package com.imustacm.controller;

import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.AgglomerationProcessRecordVo;
import com.imustacm.service.AgglomerationProcessRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/application")
@Api(tags = "烧结工艺记录")
public class AgglomerationProcessRecordController {
    @Autowired
    private AgglomerationProcessRecordService service;


    @ApiOperation(value = "获取所有的烧结工艺记录")
    @GetMapping("/getAllAgglomerationProcessRecord")
    public DefaultResponseVo getAllAgglomerationProcessRecord(){

        List<AgglomerationProcessRecordVo> agglomerationProcessRecordVos = new ArrayList<>();
        try {
            agglomerationProcessRecordVos = service.getAllAgglomerationProcessRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(agglomerationProcessRecordVos != null && agglomerationProcessRecordVos.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("AgglomerationProcessRecord",agglomerationProcessRecordVos);
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
    @PostMapping("/insertAgglomerationProcessRecord")
    public DefaultResponseVo insertAgglomerationProcessRecord(@RequestBody AgglomerationProcessRecordVo agglomerationProcessRecordVo) {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        try {
            Integer code = service.insertAgglomerationProcessRecord(agglomerationProcessRecordVo);

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

    @ApiOperation(value = "删除烧结工艺记录", notes = "根据id")
    @DeleteMapping("/deleteAgglomerationProcessRecord/{index}")
    public DefaultResponseVo deleteAgglomerationProcessRecord(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        try {
            Integer code = service.deleteAgglomerationProcessRecordById(index);
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
    @PutMapping("/updateAgglomerationProcessRecord")
    public DefaultResponseVo updateAgglomerationProcessRecord(@RequestBody AgglomerationProcessRecordVo agglomerationProcessRecordVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        try {
            Integer code = service.updateAgglomerationProcessRecord(agglomerationProcessRecordVo);
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


    @ApiOperation(value = "获取单个烧结工艺记录",notes = "根据id查找")
    @GetMapping("/getAgglomerationProcessRecordById/{index}")
    public DefaultResponseVo getAgglomerationProcessRecordById(@PathVariable("index") int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        AgglomerationProcessRecordVo agglomerationProcessRecordVo = service.getOneAgglomerationProcessRecord(index);
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("AgglomerationProcessRecord",agglomerationProcessRecordVo);
        defaultResponseVo.setData(map);
        return defaultResponseVo;
    }
}

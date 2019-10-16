package com.imustacm.controller;

import com.imustacm.domain.Po.AgglomerationProcess;
import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.service.AgglomerationProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/application")
@Api(tags = "压坯记录相关请求")
public class AgglomerationProcessController {
    @Autowired
    private AgglomerationProcessService service;

    @ApiOperation(value = "获取所有的压坯库存")
    @GetMapping("/getAllAgglomerationProcess")
    public DefaultResponseVo getAllAgglomerationProcess(){

        List<AgglomerationProcess> agglomerationProcess = null;
        try {
            agglomerationProcess = service.getAllAgglomerationProcess();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(agglomerationProcess != null && agglomerationProcess.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("记录为空");
        }
        return defaultResponseVo;
    }
    @ApiOperation(value = "增加压坯库存")
    @GetMapping("/insertAgglomerationProcess")
    public DefaultResponseVo insertAgglomerationProcess(@RequestBody AgglomerationProcess agglomerationProcess) {
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.insertAgglomerationProcess(agglomerationProcess);

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
    @GetMapping("/deleteAgglomerationProcess/{index}")
    public DefaultResponseVo deleteAgglomerationProcess(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.deleteAgglomerationProcessById(index);
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
    @GetMapping("/updateAgglomerationProcess")
    public DefaultResponseVo updateAgglomerationProcessRecord(@RequestBody AgglomerationProcess agglomerationProcess){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.updateAgglomerationProcess(agglomerationProcess);
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
    @GetMapping("/getAgglomerationProcessById/{index}")
    public DefaultResponseVo getAgglomerationProcessById(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            AgglomerationProcess agglomerationProcess = service.getOneAgglomerationProcess(index);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("agglomerationProcess",agglomerationProcess);
            defaultResponseVo.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

}

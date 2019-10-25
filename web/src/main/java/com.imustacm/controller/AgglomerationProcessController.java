package com.imustacm.controller;

import com.imustacm.domain.Po.AgglomerationProcess;
import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.RelationVo.RelationOneToManyRequestVo;
import com.imustacm.domain.RelationVo.RelationOneToOneRequestVo;
import com.imustacm.domain.Vo.AgglomerationProcessRecordVo;
import com.imustacm.domain.Vo.AgglomerationProcessVo;
import com.imustacm.service.AgglomerationProcessService;
import com.imustacm.shiro.CustomRealm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/10/21 15:15
 * Content:
 */
@RestController
@RequestMapping("/application")
@Api(tags = "烧结工艺")
public class AgglomerationProcessController {

    @Autowired
    AgglomerationProcessService agglomerationProcessService;

    @ApiOperation(value = "获取所有的结烧工艺")
    @GetMapping("/getAllAgglomerationProcess")
    public DefaultResponseVo getAllAgglomerationProcess() throws Exception {

        List<AgglomerationProcessVo> agglomerationProcessVos = new ArrayList<>();
        agglomerationProcessVos = agglomerationProcessService.getAllAgglomerationProcess();
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if (agglomerationProcessVos != null && agglomerationProcessVos.size() != 0) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("agglomerationProcess", agglomerationProcessVos);
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        } else {
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取所有结烧工艺失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "增加所有的结烧工艺")
    @PostMapping("/insertAgglomerationProcess")
    public DefaultResponseVo insertAgglomerationProcess(@RequestBody AgglomerationProcessVo agglomerationProcessVo) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = agglomerationProcessService.insertAgglomerationProcess(agglomerationProcessVo);
        if (code == 1) {
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        } else {
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("增加所有信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "删除结烧工艺")
    @DeleteMapping("/deleteAgglomerationProcess/{index}")
    public DefaultResponseVo deleteAgglomerationProcess(@PathVariable("index") int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = agglomerationProcessService.deleteAgglomerationProcessById(index);
        if(code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除结烧工艺信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取单个烧结工艺记录",notes = "根据id查找")
    @GetMapping("/getAgglomerationProcessById/{index}")
    public DefaultResponseVo getAgglomerationProcessById(@PathVariable("index") int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        AgglomerationProcessVo agglomerationProcessVo = agglomerationProcessService.getOneAgglomerationProcess(index);
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("AgglomerationProcess",agglomerationProcessVo);
        defaultResponseVo.setData(map);
        return defaultResponseVo;
    }

    @ApiOperation(value = "更改烧结工艺", notes = "根据id更改")
    @PutMapping("/updateAgglomerationProcess")
    public DefaultResponseVo updateAgglomerationProcess(@RequestBody AgglomerationProcessVo agglomerationProcessVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        try {
            int code = agglomerationProcessService.updateAgglomerationProcess(agglomerationProcessVo);
            if(code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"更新结烧工艺失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "增加结烧工艺与结烧工艺记录之间的关系")
    @PostMapping("/insertRelationShipRecordAndProcess")
    public DefaultResponseVo insertRelationShipRecordAndProcess(@RequestBody RelationOneToManyRequestVo relationOneToManyRequestVo) throws Exception {
        int code = agglomerationProcessService.insertRelationOfAgglomerationAndProcess(relationOneToManyRequestVo.getOneId(),relationOneToManyRequestVo.getManyId());
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("增加结烧工艺与结烧工艺记录之间的关系失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "删除结烧工艺与结烧工艺记录之间的关系")
    @DeleteMapping("/deleteRelationShipRecordAndProcess")
    public DefaultResponseVo deleteRelationShipRecordAndProcess(@RequestBody RelationOneToOneRequestVo relationOneToOneRequestVo) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = agglomerationProcessService.deleteOneRelation(relationOneToOneRequestVo.getId1(),relationOneToOneRequestVo.getId2());
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除结烧工艺与结烧工艺记录之间的关系失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "更新结烧工艺与结烧工艺记录之间的关系")
    @DeleteMapping("/updateRelationShipRecordAndProcess")
    public DefaultResponseVo updateRelationShipRecordAndProcess(@RequestBody RelationOneToManyRequestVo relationOneToManyRequestVo) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = agglomerationProcessService.updateRelationOfAgglomerationAndProcess(relationOneToManyRequestVo.getOneId(),relationOneToManyRequestVo.getManyId());
        if(code == 1)
        {
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("更新关系信息成功");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新结烧工艺与结烧工艺记录之间的关系失败");
        }

        return defaultResponseVo;
    }
}
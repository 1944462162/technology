package com.imustacm.controller;

import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.RelationVo.RelationOneToManyRequestVo;
import com.imustacm.domain.RelationVo.RelationOneToOneRequestVo;
import com.imustacm.domain.Vo.BlankSizeVo;
import com.imustacm.domain.Vo.RelationshipDieAndBlankVo;
import com.imustacm.service.Impl.BlankSizeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping("/application")
@Api(tags = "设计压坯尺寸")
public class BlankSizeController {

    @Autowired
    private BlankSizeServiceImpl blankSizeService;

    @ApiOperation("获取所有的压坯尺寸")
    @GetMapping("/getAllBlankSize")
    public DefaultResponseVo getAllBlankSize() throws Exception {

        List<BlankSizeVo> blankSizeVos = blankSizeService.getAllBlankSize();
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(blankSizeVos != null && blankSizeVos.size() != 0){
            HashMap<String,Object> map = new HashMap<>();
            map.put("blankSize",blankSizeVos);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            defaultResponseVo.setData(map);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取所有压坯信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("增加压坯信息")
    @PostMapping("/insertBlankSize")
    public DefaultResponseVo insertBlankSize(@RequestBody BlankSizeVo blankSizeVo) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        Integer code = blankSizeService.insertBlankSize(blankSizeVo);
        Integer number = blankSizeService.getNewInsertBlankSize();
        if(code == 1)
        {
            HashMap map = new HashMap();
            map.put("NewInsertBlankSize",number);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            defaultResponseVo.setData(map);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("增加压坯信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("根据id删除压坯信息")
    @DeleteMapping("/deleteBlankSize/{index}")
    public DefaultResponseVo deleteBlankSize(@PathVariable int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        Integer code = blankSizeService.deleteBlankSizeById(index);
        if(code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除压坯信息失败");
        }
        return  defaultResponseVo;
    }

    @ApiOperation("更新压坯信息")
    @PutMapping("/updateBlankSize")
    public DefaultResponseVo updateBlankSize(@RequestBody BlankSizeVo blankSizeVo) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        Integer code = blankSizeService.updateBlankSize(blankSizeVo);
        if(code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新压坯信息失败");
        }
        return  defaultResponseVo;
    }

    @ApiOperation("获取单个压坯信息")
    @GetMapping("/getBlankSizeById/{index}")
    public DefaultResponseVo getBlankSizeById(@PathVariable int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        BlankSizeVo blankSizeVo = blankSizeService.getOneBlankSize(index);
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("blankSize",blankSizeVo);
        defaultResponseVo.setData(map);
        return  defaultResponseVo;
    }

    @ApiOperation("增加压型记录和设计压坯尺寸对照表")
    @PostMapping("/insertRelationPressureAndBlank")
    public DefaultResponseVo insertRelationPressureAndBlank(@RequestBody RelationOneToManyRequestVo relationOneToManyRequestVo) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        Integer code = blankSizeService.insertRelationPressureAndBlank(relationOneToManyRequestVo.getOneId(),relationOneToManyRequestVo.getManyId());
        if(code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("增加压型记录和设计压坯尺寸关系失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("删除压型记录和设计压坯尺寸对照表")
    @DeleteMapping("/deleteRelationPressureAndBlank/{index1}/{index2}")
    public DefaultResponseVo deleteRelationPressureAndBlank(@PathVariable("index1") int index1,@PathVariable("index2") int index2) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        RelationOneToOneRequestVo relationOneToOneRequestVo = new RelationOneToOneRequestVo();
        relationOneToOneRequestVo.setId1(index1);
        relationOneToOneRequestVo.setId2(index2);
        Integer code  = blankSizeService.deleteOneRelation(relationOneToOneRequestVo.getId1(),relationOneToOneRequestVo.getId2());
        if(code == 1)
        {
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除压型记录和设计压坯尺寸对照表信息失败");
        }
        return defaultResponseVo;
    }
    @ApiOperation("更新压型记录和设计压坯尺寸对照表")
    @DeleteMapping("/updateRelationPressureAndBlank")
    public DefaultResponseVo updateRelationPressureAndBlank(@RequestBody RelationOneToManyRequestVo relationOneToManyRequestVo) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        Integer code = blankSizeService.updateRelationPressureAndBlank(relationOneToManyRequestVo.getOneId(),relationOneToManyRequestVo.getManyId());
        if(code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新压型记录和设计压坯尺寸对照表失败");
        }
        return defaultResponseVo;
    }


    @ApiOperation("获取所有的压型记录和设计压坯尺寸对照表信息")
    @GetMapping("/getAllRelationDieAndBlank")
    public DefaultResponseVo getAllRelationDieAndBlank() throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        List<RelationshipDieAndBlankVo> relationshipDieAndBlankVos = blankSizeService.getAllRelation();
        if (relationshipDieAndBlankVos != null && relationshipDieAndBlankVos.size() != 0){
            HashMap map = new HashMap();
            map.put("relationshipDieAndBlank",relationshipDieAndBlankVos);
            defaultResponseVo.setData(map);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取关系对照表失败");
        }
        return defaultResponseVo;
    }

}

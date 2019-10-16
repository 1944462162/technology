package com.imustacm.controller;

import com.imustacm.domain.Po.SpareParts;
import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.service.SparePartsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/9/30 19:18
 * Content:
 */
@RestController
@RequestMapping("/application")
@Api(tags = "备料库存相关请求")
public class SparePartsController {

    @Autowired
    SparePartsService sparePartsService;

    //获取所有的原料库存
    @ApiOperation(value = "获取所有的备料库存")
    @GetMapping("/getAllSpareParts")
    public DefaultResponseVo getAllSpareParts(){

        List<SpareParts> spareParts = null;
        try {
            spareParts = sparePartsService.getAllSpareParts();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(spareParts != null && spareParts.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("备料库存为空");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "增加备料库存")
    @GetMapping("/insertSpareParts")
    public DefaultResponseVo insertSpareParts(@RequestBody SpareParts spareParts) {
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = sparePartsService.insertSpareParts(spareParts);

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

    @ApiOperation(value = "删除原料库存", notes = "根据id")
    @GetMapping("/deleteSpareParts/{index}")
    public DefaultResponseVo deleteSpareParts(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = sparePartsService.deleteSparePartsById(index);
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
    @GetMapping("/updateSpareParts")
    public DefaultResponseVo updateSpareParts(@RequestBody SpareParts spareParts){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = sparePartsService.updateSpareParts(spareParts);
            if(code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"跟新备料库存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取单备料",notes = "根据id查找")
    @GetMapping("/getSparePartsById/{index}")
    public DefaultResponseVo getSparePartsById(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            SpareParts spareParts = sparePartsService.getOneSpareParts(index);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("spareParts",spareParts);
            defaultResponseVo.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }
}

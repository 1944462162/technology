package com.imustacm.controller;

import com.imustacm.domain.Po.SpareParts;
import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.SparePartsVo;
import com.imustacm.service.SparePartsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


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

        List<SparePartsVo> sparePartsVos = null;
        try {
            sparePartsVos = sparePartsService.getAllSpareParts();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(sparePartsVos != null && sparePartsVos.size() != 0){
            HashMap<String, Object> data = new HashMap<>();
            data.put("spareParts",sparePartsVos);
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
    @PostMapping("/insertSpareParts")
    public DefaultResponseVo insertSpareParts(@RequestBody SparePartsVo sparePartsVo) {
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = sparePartsService.insertSpareParts(sparePartsVo);

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
    @DeleteMapping("/deleteSpareParts/{index}")
    public DefaultResponseVo deleteSpareParts(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = sparePartsService.deleteSparePartsById(index);
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
    @PutMapping("/updateSpareParts")
    public DefaultResponseVo updateSpareParts(@RequestBody SparePartsVo sparePartsVo){
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = sparePartsService.updateSpareParts(sparePartsVo);
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
    public DefaultResponseVo getSparePartsById(@PathVariable("index") int index) throws Exception {
       SparePartsVo sparePartsVo = sparePartsService.getOneSpareParts(index);
       DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
       defaultResponseVo.setCode(200);
       defaultResponseVo.setMsg("ok");
       HashMap<String,Object> map = new HashMap<>();
       map.put("spareParts",sparePartsVo);
       defaultResponseVo.setData(map);
        return defaultResponseVo;
    }


    @ApiOperation(value = "根据牌号获取单备料",notes = "根据Code查找")
    @GetMapping("/getSparePartsByCode/{code}")
    public DefaultResponseVo getSparePartsByCode(@PathVariable("code") int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        List<SparePartsVo> sparePartsVos = sparePartsService.getSparePartsByCode(index);
        if(sparePartsVos != null && sparePartsVos.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("getSparePartsByCode",sparePartsVos);
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("此牌号信息为空");
        }
        return defaultResponseVo;
    }
}

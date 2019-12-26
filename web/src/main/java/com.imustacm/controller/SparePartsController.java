package com.imustacm.controller;

import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.SparePartsVo;
import com.imustacm.service.SparePartsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/12/25 15:01
 * Content: 备料信息
 */
@RestController
@RequestMapping("/api")
@Api(tags = "备料")
public class SparePartsController {

    @Autowired
    private SparePartsService sparePartsService;

    @ApiOperation("获取所有备料信息")
    @GetMapping("/getAllSpareParts")
    public DefaultResponseVo getAllSpareParts(){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        List<SparePartsVo> sparePartsVo = sparePartsService.getAllSpareParts();
        if (sparePartsVo != null && sparePartsVo.size() != 0){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("SpareParts",sparePartsVo);
            defaultResponseVo.setData(hashMap);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取所有备料信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("增加备料信息")
    @PostMapping("/insertSpareParts")
    public DefaultResponseVo insertSpareParts(@RequestBody SparePartsVo sparePartsVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code  = sparePartsService.insertSpareParts(sparePartsVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("增加备料信息失败");
        }

        return  defaultResponseVo;
    }

    @ApiOperation("删除备料信息")
    @DeleteMapping("/deleteSpareParts/{index}")
    public DefaultResponseVo deleteSpareParts(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = sparePartsService.deleteSparePartsById(index);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除备料信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("更新备料信息")
    @PutMapping("/updateSpareparts")
    public DefaultResponseVo updateSpareparts(@RequestBody SparePartsVo sparePartsVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = sparePartsService.updateSpareParts(sparePartsVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新备料信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取备料信息",notes = "根据牌号")
    @GetMapping("/getSparepartsBySerial/{index}")
    public DefaultResponseVo getSparepartsBySerial(@PathVariable("index") String index){
        SparePartsVo sparePartsVo = sparePartsService.getSparePartsByCode(index);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        defaultResponseVo.setMsg("ok");
        defaultResponseVo.setCode(200);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("Spareparts",sparePartsVo);
        defaultResponseVo.setData(hashMap);
        return defaultResponseVo;
    }
}

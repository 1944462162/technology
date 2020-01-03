package com.imust.controller;

import com.imust.domain.Po.Powder;
import com.imust.domain.RelationVo.DefaultResponseVo;
import com.imust.domain.Vo.PowderVo;
import com.imust.service.LoginService;
import com.imust.service.PowderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Date: 2020/1/3 20:27
 * Content:
 */

@RestController
@RequestMapping("/api")
@Api(tags = "粉入库")
public class PowderController {


    @Autowired
    private PowderService powderService;

    @GetMapping("/getAllPowder")
    public DefaultResponseVo getAllPowder(){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        List<PowderVo> powderVos = powderService.getAllPowder();
        if (powderVos != null && powderVos.size() != 0){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("Powder",powderVos);
            defaultResponseVo.setData(hashMap);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取所有入粉库信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "增加入粉信息")
    @PostMapping("/insertPower")
    public DefaultResponseVo insertPowder(@RequestBody PowderVo powderVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = powderService.insertPowder(powderVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("增加入粉信息失败");
        }
        return defaultResponseVo;
    }

    @DeleteMapping("/deletePowder/{index}")
    public DefaultResponseVo deletePowder(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = powderService.DeletePowderByCode(index);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除信息失败");
        }
        return defaultResponseVo;
    }

    @PutMapping("/UpdatePowderByCode")
    public DefaultResponseVo UpdatePowderByCode(@RequestBody PowderVo powderVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = powderService.UpdatePowderByCode(powderVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新粉库信息失败");
        }
        return defaultResponseVo;
    }


    @GetMapping("/getPowerBySerial/{index}")
    public DefaultResponseVo getPowerBySerial(@PathVariable("index") String index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        PowderVo powderVo = powderService.getPowerBySerial(index);
        if (powderVo != null){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("Powder",powderVo);
            defaultResponseVo.setData(hashMap);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取入粉信息失败");
        }
        return defaultResponseVo;
    }
}

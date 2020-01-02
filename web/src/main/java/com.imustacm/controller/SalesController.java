package com.imustacm.controller;

import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.SalesVo;
import com.imustacm.service.SalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Date: 2019/12/25 20:21
 * Content:
 */

@RestController
@RequestMapping("/api")
@Api(tags = "销售库")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @ApiOperation("获取所有的销售库")
    @GetMapping("/getAllSales")
    public DefaultResponseVo getAllSales(){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        List<SalesVo> salesVos = salesService.getAllSales();
        if (salesVos != null && salesVos.size() != 0){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("sales",salesVos);
            defaultResponseVo.setData(hashMap);
        }
        else {
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取所有销售库信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("增加销售库信息")
    @PostMapping("/insertSales")
    public DefaultResponseVo insertSales(@RequestBody SalesVo salesVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = salesService.insertSales(salesVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("增加销售库信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("删除销售库信息")
    @DeleteMapping("/deleteSale/{index}")
    public DefaultResponseVo deleteSales(@PathVariable("index")int index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = salesService.deleteSales(index);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除销售信息失败");
        }
        return  defaultResponseVo;
    }

    @ApiOperation("更新销售信息")
    @PutMapping("/updateSale")
    public DefaultResponseVo updateSale(@RequestBody SalesVo salesVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = salesService.updateSales(salesVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新销售信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("获取销售信息根据销售编号")
    @GetMapping("/getSalesBySerial/{index}")
    public DefaultResponseVo getSalesBySerial(@PathVariable("index") String index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        SalesVo salesVo = salesService.getSalesBySerial(index);
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("sales",salesVo);
        defaultResponseVo.setData(hashMap);
        return defaultResponseVo;
    }
}

package com.imust.controller;

import com.imust.domain.RelationVo.DefaultResponseVo;
import com.imust.domain.Vo.StockVo;
import com.imust.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Date: 2019/12/25 14:12
 * Content:
 */

@RestController
@RequestMapping("/api")
@Api(tags = "原料库存表")
public class StockController {

    @Autowired
    private StockService stockService;

    @ApiOperation(value = "获取所有的原料库存信息")
    @GetMapping("/getAllStocks")
    public DefaultResponseVo getAllStock(){

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        List<StockVo> stockVos = stockService.getAllStock();
        if (stockVos != null && stockVos.size() != 0){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("stock",stockVos);
            defaultResponseVo.setData(hashMap);
            defaultResponseVo.setMsg("ok");
            defaultResponseVo.setCode(200);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("原料库存表为空");
        }
        return  defaultResponseVo;
    }

    @ApiOperation(value = "增加原料库存信息")
    @PostMapping("/insertStock")
    public DefaultResponseVo insertStock(@RequestBody StockVo stockVo){
        DefaultResponseVo defaultResponseVo = null;

        int code = stockService.insertStock(stockVo);
        if (code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"增加原料库存失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "删除原料库存", notes = "根据id")
    @DeleteMapping("/deleteStock/{index}")
    public DefaultResponseVo deleteStock(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;

        int code = stockService.deleteStockById(index);
        if (code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"删除原料库存失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "更改原料库存", notes = "根据id更改")
    @PutMapping("/updateStock")
    public DefaultResponseVo updateStock(@RequestBody StockVo stockVo){
        DefaultResponseVo defaultResponseVo = null;
        int code = stockService.updateStock(stockVo);
        if(code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"更新原料库存失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取单个原料信息",notes = "根据Id进行查找")
    @GetMapping("/getStockById/{index}")
    public DefaultResponseVo getStockById(@PathVariable("index") int index){
        StockVo stockVo = stockService.getOneStock(index);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("stock",stockVo);
        defaultResponseVo.setData(hashMap);
        return defaultResponseVo;
    }
}

package com.imustacm.controller;

import com.imustacm.domain.Po.Stock;
import com.imustacm.domain.RelationVo.DefaultResponseVo;

import com.imustacm.service.StockService;
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
@Api(tags = "原料库存相关请求")
public class StockController {

    @Autowired
    StockService stockService;
    //获取所有的原料库存
    @ApiOperation(value = "获取所有的原料库存")
    @GetMapping("/getAllStock")
    public DefaultResponseVo getAllStock(){
        System.out.println("hello world");
        List<Stock> allStock = null;
        try {
            allStock = stockService.getAllStoch();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(allStock != null && allStock.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("allStock",allStock);

            defaultResponseVo.setData(data);

            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("原料库存为空");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "增加原料库存")
    @GetMapping("/insertStock")
    public DefaultResponseVo insertStock(@RequestBody Stock stock) {
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = stockService.insertStoch(stock);

            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"无法增加原料库存");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  defaultResponseVo;
    }

    @ApiOperation(value = "删除原料库存", notes = "根据id")
    @GetMapping("/deleteStock/{index}")
    public DefaultResponseVo deleteStock(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = stockService.deleteStochById(index);
            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"删除原料库存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "更改原料库存", notes = "根据id更改")
    @GetMapping("/updateStock")
    public DefaultResponseVo updateStock(@RequestBody Stock stock){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = stockService.updateStock(stock);
            if(code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"跟新原料库存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取单个原料",notes = "根据id查找")
    @GetMapping("/getStockById/{index}")
    public DefaultResponseVo getStockById(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            Stock stock = stockService.getOneStock(index);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("Stock",stock);
            defaultResponseVo.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }
}

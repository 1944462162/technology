package com.imustacm.controller;

import com.imustacm.domain.Po.Stock;
import com.imustacm.domain.RelationVo.DefaultResponseVo;

import com.imustacm.domain.Vo.StockVo;
import com.imustacm.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


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

        List<StockVo> allStock = null;
        try {
            allStock = stockService.getAllStock();
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
    @PostMapping("/insertStock")
    public DefaultResponseVo insertStock(@RequestBody StockVo stockVo) {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        try {
            Integer code = stockService.insertStock(stockVo);

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
    @DeleteMapping("/deleteStock/{index}")
    public DefaultResponseVo deleteStock(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = stockService.deleteStockById(index);
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
    @PutMapping("/updateStock")
    public DefaultResponseVo updateStock(@RequestBody StockVo stockVo){
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = stockService.updateStock(stockVo);
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
    public DefaultResponseVo getStockById(@PathVariable("index") int index) throws Exception {
        StockVo stockVo = stockService.getOneStock(index);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("stock",stockVo);
        defaultResponseVo.setData(map);
        return defaultResponseVo;
    }
}

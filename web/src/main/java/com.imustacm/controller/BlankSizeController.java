package com.imustacm.controller;

import com.imustacm.domain.BlankSize;
import com.imustacm.domain.Vo.DefaultResponseVo;
import com.imustacm.service.BlankSizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/application")
@Api(tags = "压坯记录相关请求")
public class BlankSizeController {


    @Autowired
    private BlankSizeService service;
    @ApiOperation(value = "获取所有的压坯库存")
    @GetMapping("/getAllBlankSize")
    public DefaultResponseVo getAllBlankSize(){

        List<BlankSize> blankSizes = null;
        try {
            blankSizes = service.getAllBlankSize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(blankSizes != null && blankSizes.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("压坯记录为空");
        }
        return defaultResponseVo;
    }
    @ApiOperation(value = "增加压坯库存")
    @GetMapping("/insertBlankSize")
    public DefaultResponseVo insertBlankSize(@RequestBody BlankSize blankSize) {
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.insertBlankSize(blankSize);

            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"无法增加压坯记录");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  defaultResponseVo;
    }
    @ApiOperation(value = "删除压坯库存", notes = "根据id")
    @GetMapping("/deleteBlankSize/{index}")
    public DefaultResponseVo deleteBlankSize(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.deleteBlankSizeById(index);
            if (code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"删除压坯记录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "更改压坯记录", notes = "根据id更改")
    @GetMapping("/updateBlankSize")
    public DefaultResponseVo updateBlankSize(@RequestBody BlankSize blankSize){
        DefaultResponseVo defaultResponseVo = null;
        try {
            int code = service.updateBlankSize(blankSize);
            if(code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"更新压坯记录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取单压坯",notes = "根据id查找")
    @GetMapping("/getBlankSizeById/{index}")
    public DefaultResponseVo getBlankSizeById(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            BlankSize blankSize = service.getOneBlankSize(index);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("blankSize",blankSize);
            defaultResponseVo.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }
}

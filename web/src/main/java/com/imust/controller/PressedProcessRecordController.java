package com.imust.controller;

import com.imust.domain.RelationVo.DefaultResponseVo;
import com.imust.domain.Vo.PressedProcessRecordVo;
import com.imust.service.PressedProcessRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Date: 2020/1/2 10:47
 * Content:
 */
@RestController
@RequestMapping("/api")
@Api(tags = "压型工艺记录相关记录")
public class PressedProcessRecordController {

    @Autowired
    private PressedProcessRecordService pressedProcessRecordService;


    @ApiOperation(value = "获取所有的压型工艺")
    @GetMapping("/getAllPressedProcessRecord")
    public DefaultResponseVo getAllPressedProcessRecord(){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        List<PressedProcessRecordVo> pressedProcessRecordVos = pressedProcessRecordService.getAllPressedProcessRecord();
        if (pressedProcessRecordVos != null && pressedProcessRecordVos.size() != 0){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("pressedProcessRecord",pressedProcessRecordVos);
            defaultResponseVo.setData(hashMap);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取所有压型工艺信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "增加压型工艺信息")
    @PostMapping("/insertPressedProcessRecord")
    public DefaultResponseVo insertPressedProcessRecord(@RequestBody PressedProcessRecordVo pressedProcessRecordVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = pressedProcessRecordService.insertPressedProcessRecord(pressedProcessRecordVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("增加压型工艺信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "更新压型工艺信息")
    @PutMapping("/updatePressedProcessRecord")
    public DefaultResponseVo updatePressedProcessRecord(@RequestBody PressedProcessRecordVo pressedProcessRecordVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = pressedProcessRecordService.updatePressedProcessRecord(pressedProcessRecordVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新压型工艺记录失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取压型工艺信息根据编号")
    @GetMapping("/getPressedProcessRecordBySerial/{index}")
    public DefaultResponseVo getPressedProcessRecordBySerial(@PathVariable("index") String index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        PressedProcessRecordVo pressedProcessRecordVo = pressedProcessRecordService.getOnePressedProcessRecordBySerial(index);
        if (pressedProcessRecordVo != null){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("PressedProcessRecordBySerial",pressedProcessRecordVo);
            defaultResponseVo.setData(hashMap);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取压型工艺信息根据编号信息失败");
        }
        return defaultResponseVo;
    }


    @ApiOperation("删除压型工艺记录")
    @DeleteMapping("/deletePressedProcessRecordById/{index}")
    public DefaultResponseVo deletePressedProcessRecordById(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = pressedProcessRecordService.deletePressedProcessRecordById(index);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除压型工艺记录信息失败");
        }
        return defaultResponseVo;
    }
}

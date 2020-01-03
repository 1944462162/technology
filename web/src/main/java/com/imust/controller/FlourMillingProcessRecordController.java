package com.imust.controller;

import com.imust.domain.RelationVo.DefaultResponseVo;
import com.imust.domain.Vo.FlourMillingProcessRecordVo;
import com.imust.service.FlourMillingProcessRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "制粉操作记录相关请求")
public class FlourMillingProcessRecordController {

    @Autowired
    private FlourMillingProcessRecordService flourMillingProcessRecordService;

    @ApiOperation(value = "获取所有的制粉库存")
    @GetMapping("/getAllFlourMillingProcessRecord")
    public DefaultResponseVo getAllFlourMillingProcessRecord()  {

        List<FlourMillingProcessRecordVo> flourMillingProcessRecordsVo = flourMillingProcessRecordService.getAllFlourMillingProcessRecord();

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(flourMillingProcessRecordsVo != null && flourMillingProcessRecordsVo.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("FlourMillingProcessRecordVo",flourMillingProcessRecordsVo);
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("制粉操作记录为空为空");
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "增加制粉库存")
    @PostMapping("/insertFlourMillingProcessRecords")
    public DefaultResponseVo insertFlourMillingProcessRecords(@RequestBody FlourMillingProcessRecordVo flourMillingProcessRecordsVo) {
        DefaultResponseVo defaultResponseVo = null;

        int code = flourMillingProcessRecordService.insertFlourMillingProcessRecord(flourMillingProcessRecordsVo);

        if (code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"无法增加制粉记录");
        }

        return  defaultResponseVo;
    }
    @ApiOperation(value = "删除原料库存", notes = "根据id")
    @DeleteMapping("/deleteFlourMillingProcessRecords/{index}")
    public DefaultResponseVo deleteFlourMillingProcessRecords(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;

        int code = flourMillingProcessRecordService.deleteFlourMillingProcessRecordById(index);
        if (code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"删除压型记录失败");
        }

        return defaultResponseVo;
    }

    @ApiOperation(value = "更改制粉记录", notes = "根据id更改")
    @PutMapping("/updateFlourMillingProcessRecord")
    public DefaultResponseVo updateFlourMillingProcessRecord(@RequestBody FlourMillingProcessRecordVo pressureRecordVo){
        DefaultResponseVo defaultResponseVo = null;

        int code = flourMillingProcessRecordService.updateFlourMillingProcessRecord(pressureRecordVo);
        if(code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"更新制粉记录失败");
            }

        return defaultResponseVo;
    }
    @ApiOperation(value = "获取单备料",notes = "根据id查找")
    @GetMapping("/getFlourMillingProcessRecordById/{index}")
    public DefaultResponseVo getFlourMillingProcessRecordById(@PathVariable("index") int index) throws Exception {
        FlourMillingProcessRecordVo flourMillingProcessRecordVo = flourMillingProcessRecordService.getOneFlourMillingProcessRecord(index);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("flourMillingProcessRecord",flourMillingProcessRecordVo);
        defaultResponseVo.setData(map);
        return defaultResponseVo;
    }
}

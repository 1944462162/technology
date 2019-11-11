package com.imustacm.controller;

import com.imustacm.domain.Po.SmeltingRecord;
import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.SmeltingRecordVo;
import com.imustacm.service.SmeltingRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/application")
@Api(tags = "冶炼操作记录相关请求")
public class SmeltingRecordController {

    @Autowired
    SmeltingRecordService smeltingRecordService=null;

    @ApiOperation(value = "获取所有的备料库存")
    @GetMapping("/getAllSmeltingRecord")
    public DefaultResponseVo getAllSmeltingRecord(){

        List<SmeltingRecordVo> SmeltingRecordsVo = null;
        try {
            SmeltingRecordsVo = smeltingRecordService.getAllSmeltingRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if(SmeltingRecordsVo != null && SmeltingRecordsVo.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("SmeltingRecords",SmeltingRecordsVo);
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("库存为空");
        }
        return defaultResponseVo;
    }
    @ApiOperation(value = "冶金操作记录添加")
    @PostMapping("/insertSmeltingRecord")
    public DefaultResponseVo insertSmeltingRecord(@RequestBody SmeltingRecordVo smeltingRecordVo) {
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = smeltingRecordService.insertSmeltingRecord(smeltingRecordVo);

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

    @ApiOperation(value = "删除冶金操作记录", notes = "根据id")
    @DeleteMapping("/deleteSmeltingRecord/{index}")
    public DefaultResponseVo deleteSmeltingRecord(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = smeltingRecordService.deleteSmeltingRecordById(index);
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
    @PutMapping("/updateSmeltingRecord")
    public DefaultResponseVo updateSmeltingRecord(@RequestBody SmeltingRecordVo smeltingRecordVo){
        DefaultResponseVo defaultResponseVo = null;
        try {
            Integer code = smeltingRecordService.updateSmeltingRecord(smeltingRecordVo);
            if(code == 1){
                defaultResponseVo = new DefaultResponseVo(200,"ok");
            }
            else{
                defaultResponseVo = new DefaultResponseVo(500,"更新冶金操作记录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取冶金操作记录",notes = "根据id查找")
    @GetMapping("/getSmeltingRecordsById/{index}")
    public DefaultResponseVo getSmeltingRecordsById(@PathVariable("index") int index) throws Exception {
        SmeltingRecordVo smeltingRecordVo = smeltingRecordService.getOneSmeltingRecord(index);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("smeltingRecord",smeltingRecordVo);
        defaultResponseVo.setData(map);
        return defaultResponseVo;
    }

    @ApiOperation(value = "获取冶炼操作记录", notes = "根据编号进行查找")
    @GetMapping("/getSmeltingRecordsByCode/{index}")
    public DefaultResponseVo getSmeltingRecordsByCode(@PathVariable("index") String index) throws Exception {
        List<SmeltingRecordVo> smeltingRecordVo = smeltingRecordService.getSmeltingRecordByCode(index);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();

        if(smeltingRecordVo != null && smeltingRecordVo.size() != 0){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("smeltingRecordByCode",smeltingRecordVo);
            defaultResponseVo.setData(data);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("此编号记录为空");
        }
        return defaultResponseVo;
    }

}

package com.imustacm.controller;

import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.SmeltVo;
import com.imustacm.service.SmeltService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/10/16 22:27
 * Content:
 */
@RestController
@RequestMapping("/application")
@Api(tags = "冶炼相关信息")
public class SmeltController {

    @Autowired
    private SmeltService smeltService;

    @ApiOperation(value = "获取所有的冶炼信息")
    @GetMapping("/getAllSmelt")
    public DefaultResponseVo getAllSmelt() throws Exception {
        List<SmeltVo> smeltVos = smeltService.getAllSmelt();
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if (smeltVos != null && smeltVos.size() != 0){
            HashMap<String,Object> map = new HashMap<>();
            map.put("smelt",smeltVos);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            defaultResponseVo.setData(map);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取所有信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("增加冶炼信息")
    @PostMapping("/insertSmelt")
    public DefaultResponseVo insertSmelt(@RequestBody SmeltVo smeltVo) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        Integer code = smeltService.insertSmelt(smeltVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else {
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("无法增加冶炼信息");
        }
        return defaultResponseVo;
    }

    @ApiOperation("删除冶炼信息根据id")
    @DeleteMapping("/deleteSmeltById/{index}")
    public DefaultResponseVo deleteSmeltById(@PathVariable("index") int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        Integer code = smeltService.deleteSmeltById(index);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除冶炼信息失败");
        }
        return defaultResponseVo;
    }
    @ApiOperation("更新冶炼信息")
    @PutMapping("/updateSmelt")
    public DefaultResponseVo updateSmelt(@RequestBody SmeltVo smeltVo) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        Integer code = smeltService.updateSmelt(smeltVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新冶炼信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("根据id获取冶炼信息")
    @GetMapping("/getOneSmeltById/{index}")
    public DefaultResponseVo getOneSmeltById(@PathVariable int index) throws Exception {
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        SmeltVo smeltVo = smeltService.getOneSmelt(index);
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("smelt",smeltVo);
        defaultResponseVo.setData(map);
        return defaultResponseVo;
    }
}

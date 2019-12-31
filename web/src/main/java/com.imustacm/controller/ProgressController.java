package com.imustacm.controller;

import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.service.ProgressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Author: wangJianBo
 * Date: 2019/12/30 10:26
 * Content:
 */
@RestController
@RequestMapping("/api")
@Api(tags = "进度条")
public class ProgressController {

    @Autowired
    private ProgressService progressService;


    @ApiOperation(value = "获取进度条")
    @GetMapping("/getProgress/{index}")
    public DefaultResponseVo progressbar(@PathVariable("index") String index){
        int code = progressService.progressbar(index);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if (code == -1){
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取进度条失败");
        }
        else{
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> map = new HashMap<>();
            map.put("Progress",code);
            defaultResponseVo.setData(map);
        }
        return defaultResponseVo;
    }

}

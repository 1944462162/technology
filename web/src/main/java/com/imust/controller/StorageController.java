package com.imust.controller;

import com.imust.domain.RelationVo.DefaultResponseVo;
import com.imust.domain.Vo.StorageVo;
import com.imust.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Date: 2019/12/23 21:44
 * Content: 入库表
 */


@RestController
@RequestMapping("/api")
@Api(tags = "入库信息相关请求")
public class StorageController {

    @Autowired
    StorageService storageService;

    @ApiOperation(value = "获取所有的入库信息")
    @GetMapping("/getAllStorage")
    public DefaultResponseVo getAllStorage(){
        List<StorageVo> storages = storageService.getAllStorage();
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if (storages != null && storages.size() != 0){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("storages",storages);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            defaultResponseVo.setData(hashMap);
        }
        else {
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("入库信息为空");
        }
        return defaultResponseVo;
    }

    @ApiOperation("插入入库信息")
    @PostMapping("/insertStorage")
    public DefaultResponseVo insertStorage(@RequestBody StorageVo storageVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();

        Integer code = storageService.insertStorage(storageVo);

        if (code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"无法增加入库信息");
        }

        return  defaultResponseVo;
    }

    @ApiOperation(value = "删除入库信息", notes = "根据id")
    @DeleteMapping("/deleteStorage/{index}")
    public DefaultResponseVo deleteStorage(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = null;

        Integer code = storageService.deleteStorage(index);
        if (code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"删除原料入库信息失败");
        }
        return defaultResponseVo;
    }


    @ApiOperation(value = "更改入库信息", notes = "根据id更改")
    @PutMapping("/updateStorage")
    public DefaultResponseVo updateStorage(@RequestBody StorageVo storageVo){
        DefaultResponseVo defaultResponseVo = null;

        Integer code = storageService.updateStorage(storageVo);
        if(code == 1){
            defaultResponseVo = new DefaultResponseVo(200,"ok");
        }
        else{
            defaultResponseVo = new DefaultResponseVo(500,"更新入库信息失败");
        }

        return defaultResponseVo;
    }
    @ApiOperation(value = "获取单个原料",notes = "根据id查找")
    @GetMapping("/getStorageById/{index}")
    public DefaultResponseVo getStorageById(@PathVariable("index") int index) {
        StorageVo storageVo = storageService.getStorageById(index);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        HashMap<String,Object> map = new HashMap<>();
        map.put("stock",storageVo);
        defaultResponseVo.setData(map);
        return defaultResponseVo;
    }

}

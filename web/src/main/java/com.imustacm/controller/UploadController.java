package com.imustacm.controller;

import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.ImageVo;
import com.imustacm.service.FileuploadService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * Author: wangJianBo
 * Date: 2019/12/31 12:04
 * Content:
 */
@RestController
@RequestMapping("/api")
@Api(tags = "文件上传")
public class UploadController {

    @Autowired
    private FileuploadService fileuploadService;

    @PostMapping("/fileupload")
    // 和文件表单名字必须一致upload
    public DefaultResponseVo fileupload(HttpServletRequest request, @RequestParam MultipartFile upload) throws IOException {

        int code = fileuploadService.fileFileupload(request,upload);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if (code != 0){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("文件上传失败");
        }
        return defaultResponseVo;
    }

    @GetMapping("/getFile/{index}")
    public DefaultResponseVo getFile(@PathVariable("index") String index){

        ImageVo imageVo = fileuploadService.getFile(index);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if (imageVo != null){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("Image",imageVo);
            defaultResponseVo.setData(hashMap);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("没有相对应的图片");
        }
        return defaultResponseVo;
    }
}

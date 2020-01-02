package com.imustacm.controller;

import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.service.FileuploadService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;


/**
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

        String code = fileuploadService.fileFileupload(request,upload);
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if (code != null){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("ImageName",code);
            defaultResponseVo.setData(hashMap);
            return defaultResponseVo;
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("文件上传失败");
        }
        return defaultResponseVo;
    }

}

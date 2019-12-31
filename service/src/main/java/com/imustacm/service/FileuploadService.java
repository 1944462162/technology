package com.imustacm.service;

import com.imustacm.domain.Po.Image;
import com.imustacm.domain.Vo.ImageVo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: wangJianBo
 * Date: 2019/12/31 12:51
 * Content:
 */
public interface FileuploadService {
    int fileFileupload(HttpServletRequest request, @RequestParam MultipartFile upload);

    ImageVo getFile(String fileName);
}

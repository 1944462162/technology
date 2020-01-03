package com.imust.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Date: 2019/12/31 12:51
 * Content:
 */
public interface FileuploadService {

    String fileFileupload(HttpServletRequest request, @RequestParam MultipartFile upload) throws IOException;
}

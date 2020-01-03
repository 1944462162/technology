package com.imust.service.Impl;

import com.imust.dao.ImageDao;
import com.imust.service.FileuploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * Date: 2019/12/31 12:52
 * Content:
 */
@Service("fileuploadService")
public class FileuploadServiceImpl implements FileuploadService {

    @Autowired
    private ImageDao imageDao;

    @Override
    public String fileFileupload(HttpServletRequest request, MultipartFile upload) throws IOException {

        //上传文件的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads");

        //判断路径是否存在
        File file = new File(path);

        if (!file.exists()){
            //创建文件夹
            file.mkdirs();
        }

        String filename = upload.getOriginalFilename();

        // 将文件设置成为唯一值
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;

        try {
            upload.transferTo(new File(path,filename));
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败");
        }

//        Image image = new Image();
//        image.setImagename(filename);
//        image.setPath(path);
        try {
            return filename;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}

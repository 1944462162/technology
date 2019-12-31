package com.imustacm.service.Impl;

import com.imustacm.dao.ImageDao;
import com.imustacm.domain.Po.Image;
import com.imustacm.domain.Vo.ImageVo;
import com.imustacm.service.FileuploadService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Author: wangJianBo
 * Date: 2019/12/31 12:52
 * Content:
 */
@Service("fileuploadService")
public class FileuploadServiceImpl implements FileuploadService {

    @Autowired
    private ImageDao imageDao;

    @Override
    public int fileFileupload(HttpServletRequest request, MultipartFile upload) {
        System.out.println("Spring 文件上传");
        //上传文件的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads");

        //判断路径是否存在
        File file = new File(path);

        if (!file.exists()){
            //创建文件夹
            file.mkdirs();
        }

        String filename = upload.getOriginalFilename();

//        // 将文件设置成为唯一值
//        String uuid = UUID.randomUUID().toString().replace("-","");
//        filename = uuid + "_" + filename;

        try {
            upload.transferTo(new File(path,filename));
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败");
        }

        Image image = new Image();
        image.setImagename(filename);
        image.setPath(path);
        try {
            return imageDao.insertEntry(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ImageVo getFile(String fileName) {

        Image image = new Image();
        image.setImagename(fileName);
        ImageVo imageVo = new ImageVo();
        try {
          List<Image> images = imageDao.selectEntryList(image);

          if (images != null && images.size() != 0){
              image = images.get(0);

              BeanUtils.copyProperties(image,imageVo);
          }
          else{
              return null;
          }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageVo;
    }
}

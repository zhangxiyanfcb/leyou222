package com.leyou.upload.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxiyan
 * @create 2019-05-08 19:23
 */
@Service
@Transactional
@Slf4j
public class UploadService {
    private static  final List<String> IMAGE_TYPES= Arrays.asList("image/jpeg","image/png","image/bmp");

    public String uploadImage(MultipartFile file) {
        String contentType = file.getContentType();
        try {
        //图片类型校验
        if(!IMAGE_TYPES.contains(contentType)){
            throw new LyException(ExceptionEnum.ILLEGAL_IMAGE_TYPE);
        }
        //图片内容校验
        BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                throw new LyException(ExceptionEnum.ILLEGAL_IMAGE_TYPE);
            }

         //准备目标路径
         File fileDir=new File("C:/Users/Administrator/Desktop/资料/uploadImage",file.getOriginalFilename());
         file.transferTo(fileDir);

         //返回路径
            return "http://image.leyou.com/"+file.getOriginalFilename();
        } catch (IOException e) {
            //上传失败
            log.error("图片上传失败",e);
            throw  new LyException(ExceptionEnum.IMAGE_UPLOAD_ERROR);
        }

    }


}

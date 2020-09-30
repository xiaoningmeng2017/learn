package com.leyou.upload.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@PropertySource("classpath:upload.properties")
@Slf4j
public class UploadService {

    @Value("#{'${upload.image.content_type}'.split(',')}")
    private List<String> contentTypes ;
    public String upload(MultipartFile file) {
        //获取原始文件名
        String originalFileName = file.getOriginalFilename();
        //校验文件类型
        if(!contentTypes.contains(file.getContentType())){
            log.info("文件类型不合法：{}", originalFileName);
            throw new LyException(ExceptionEnum.INVALID_IMAGE_UPLOAD);
        }
        //校验文件内容
        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null){
                log.info("文件内容不合法：{}", originalFileName);
                throw new LyException(ExceptionEnum.INVALID_IMAGE_UPLOAD);
            }
        //保存到文件的服务器
            file.transferTo(new File("D:\\study\\leyouimage\\"+originalFileName));
        //返回url
            return "http://image.leyou.com/"+originalFileName;
        } catch (IOException e) {
            log.info("服务器内部错误"+originalFileName);
            e.printStackTrace();
        }


        return null;
    }
}

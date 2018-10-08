package com.wx.control.upload;

import com.alibaba.fastjson.JSON;
import com.wx.VO.AjaxMsg;
import com.wx.model.file.TSysFile;
import com.wx.service.file.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * 文件上传
 * Created by wx
 * 2018/10/8
 */
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {

    @Autowired
    private FileService fileService;

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @PostMapping("/upload/singleFile")
    public Object singleFileUpload(MultipartFile file) {
//        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
         if (Objects.isNull(file) || file.isEmpty()) {
            return "文件为空，请重新上传";
        }

        try {
            byte[] bytes = file.getBytes();

            //上传时的文件名字
            String oldfileName = file.getOriginalFilename();

            String uuid =  UUID.randomUUID().toString();
            //服务器存放的文件名
            String newfileName = uuid + oldfileName.substring(oldfileName.lastIndexOf("."), oldfileName.length());

            //服务器存放地址
            String newSavePath =  new SimpleDateFormat("yyyy").format(new Date()) + "/"
                    + new SimpleDateFormat("MM").format(new Date()) + "/"
                    + new SimpleDateFormat("dd").format(new Date());


            Path path = Paths.get(UPLOAD_FOLDER + newSavePath);
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(path);
            }

            Path filePath = Paths.get(UPLOAD_FOLDER + newSavePath + "/" + newfileName);
            //文件写入指定路径
            Files.write(filePath, bytes);

            //保存进数据库
            TSysFile sysFile = new TSysFile();
            sysFile.setCreatedate(new Date());
            sysFile.setUuid(uuid);
            sysFile.setName(oldfileName);
            sysFile.setPath(filePath.toString());
            sysFile.setUrl("image/"+newSavePath+"/"+newfileName);
            fileService.addFile(sysFile);

            return new AjaxMsg(true,"文件上传成功",uuid);
        } catch (IOException e) {
            e.printStackTrace();
            return new AjaxMsg(false,"后端异常...");
        }
    }
}

package com.wx.control.file;

import com.wx.VO.AjaxMsg;
import com.wx.model.file.TSysFile;
import com.wx.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件管理
 * Created by wx
 * 2018/10/9
 */
@RestController
@RequestMapping("/file")
public class FileControl {

    @Autowired
    private FileService fileService;

    @GetMapping("/getFile")
    public AjaxMsg getFile(String uuid) {
        TSysFile sysFile = fileService.getFile(uuid);
        if(sysFile == null){
            return new AjaxMsg(false,"找不到该文件");
        }else{
            return new AjaxMsg(true,"",sysFile);
        }


    }
}

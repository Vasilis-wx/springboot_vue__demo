package com.wx.service.file;

import com.wx.model.file.TSysFile;

/**
 * Created by wx
 * 2018/10/8
 */
public interface FileService {
    void addFile(TSysFile sysFile);

    TSysFile getFile(String uuid);
}

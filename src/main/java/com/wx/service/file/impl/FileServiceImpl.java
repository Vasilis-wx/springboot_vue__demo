package com.wx.service.file.impl;

import com.wx.dao.file.FileDao;
import com.wx.model.file.TSysFile;
import com.wx.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wx
 * 2018/10/8
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public void addFile(TSysFile sysFile) {
        fileDao.save(sysFile);
    }
}

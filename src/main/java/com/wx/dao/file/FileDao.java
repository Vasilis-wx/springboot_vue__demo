package com.wx.dao.file;

import com.wx.model.file.TSysFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wx
 * 2018/10/8
 */
public interface FileDao extends JpaRepository<TSysFile,String> {

    TSysFile save(TSysFile sysFile);

    TSysFile getTSysFileByUuid(String uuid);

}

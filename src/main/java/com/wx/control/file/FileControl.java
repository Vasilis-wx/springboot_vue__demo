package com.wx.control.file;

import com.wx.VO.AjaxMsg;
import com.wx.model.file.TSysFile;
import com.wx.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 根据uuid获取TFile
     * @param uuids
     * @return
     */
    @GetMapping("/getFile")
    public AjaxMsg getFile(String uuids) {
        if(StringUtils.isEmpty(uuids)){
            return new AjaxMsg(false,"没有文件");
        }
        String[] uuidAray = uuids.split(",");

        List<TSysFile> sysFileList = new ArrayList<>();
        for(String uuid : uuidAray){
            TSysFile sysFile = fileService.getFile(uuid);
            sysFileList.add(sysFile);
        }

        if(sysFileList.size()==0){
            return new AjaxMsg(false,"找不到文件");
        }else{
            return new AjaxMsg(true,"",sysFileList);
        }
    }

    /**
     * 下载文件
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/download")
    public String downloadFile(HttpServletRequest request,
                               HttpServletResponse response,String uuid) throws UnsupportedEncodingException {

        TSysFile sysFile = fileService.getFile(uuid);

        String fileName = sysFile.getName(); //下载的文件名

        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            String realPath = sysFile.getPath();
//            File file = new File(realPath, fileName);

            File file = new File(realPath);
            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download the song successfully!");
                }
                catch (Exception e) {
                    System.out.println("Download the song failed!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}

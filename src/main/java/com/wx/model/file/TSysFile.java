package com.wx.model.file;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "sysFile")
@Data
public class TSysFile {

	@Id
	@Column(columnDefinition = "varchar(100)")
	private String uuid;
	/** 文件名称 **/
	private String name;
	/** 文件路径 **/
	private String path;
	/** 访问地址 **/
	private String url;
	/** 创建时间 **/
	private Date createdate = new Date();
	/** 标志是否在用 **/
	private boolean flag = false;
    /**
     * 文件拓展名<br>
     * 1.此字段有值，则url、path字段中无拓展名
     * 
     * */
    private String extName;


	@Override
	public String toString() {
		return "TFile [uuid=" + uuid + ", name=" + name + ", path=" + path + ", url=" + url + ", createdate="
				+ createdate + ", flag=" + flag + ", extName=" + extName + "]";
	}
	
	
}

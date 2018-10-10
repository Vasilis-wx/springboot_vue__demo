package com.wx.fmode.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户信息表
 * Created by wx
 * 2018/9/21
 */
@Data
public class FUser {

    private int id;

    private String name;// 用户名

    private String username;// 登录账号

    private String password;// 密码

    private Integer sex;// 1男 2女

    private String userface;// 头像

    private String userfaceUUid;// 头像图片uuid

    private String userfaceUrl;// 头像图片url

    private String birthday;// 出生日期

    private String address;// 地址

    private String email;

    private String phone;

    private String attachments;
}

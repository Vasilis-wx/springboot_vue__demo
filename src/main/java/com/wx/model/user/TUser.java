package com.wx.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户信息表
 * Created by wx
 * 2018/9/21
 */
@Data
@Entity(name = "user")
public class TUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;// 用户名

    private String username;// 登录账号

    private String password;// 密码

    private Integer sex;// 1男 2女

    private String userface;// 头像

    private String userfaceUUid;// 头像图片uuid

    private Date birthday;// 出生日期

    private String address;// 地址

    private String email;

    private String phone;

}

package com.wx.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by wx
 * 2018/9/26
 */
@Data
public class AjaxMsg {

    private String status;

    private String msg;

    public AjaxMsg() {

    }

    public AjaxMsg(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}

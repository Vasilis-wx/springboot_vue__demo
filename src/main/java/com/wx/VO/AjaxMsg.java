package com.wx.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by wx
 * 2018/9/26
 */
@Data
public class AjaxMsg {

    private boolean status;

    private String msg;

    private String result;

    public AjaxMsg() {

    }

    public AjaxMsg(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public AjaxMsg(boolean status, String msg, String result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }
}

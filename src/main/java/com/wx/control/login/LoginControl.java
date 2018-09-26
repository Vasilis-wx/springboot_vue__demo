package com.wx.control.login;

import com.wx.VO.ResultVO;
import com.wx.model.user.TUser;
import com.wx.service.user.UserService;
import com.wx.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wx
 * 2018/9/19
 */
@RestController
@RequestMapping("/login")
public class LoginControl {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResultVO<Map<String,String>> login(String username, String password){
        System.out.printf(username+"---"+password);
        TUser user = userService.findUserByUsernameAndPassword(username,password);
        if(user!=null){
            return ResultVOUtil.succsee(user);
        }else{
            return ResultVOUtil.error(1,"用户名密码不正确");
        }

    }

    @RequestMapping("/logout")
    public ResultVO<Map<String,String>> logout(){
        return ResultVOUtil.succsee("注销成功！");
    }
}

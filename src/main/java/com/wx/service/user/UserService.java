package com.wx.service.user;

import com.wx.fmode.user.FUser;
import com.wx.fmode.user.UserI;
import com.wx.model.user.TUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by wx
 * 2018/9/21
 */
public interface UserService {

    /** 根据用户名密码获取用户信息 **/
    TUser findUserByUsernameAndPassword(String username,String password);

    /** 查询人员列表 */
    Page<FUser> findList(Pageable pageable);

    void delUserByIds(String ids);

    void addUser(TUser user);
}

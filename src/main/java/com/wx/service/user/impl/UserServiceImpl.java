package com.wx.service.user.impl;

import com.wx.dao.user.UserDao;
import com.wx.model.user.TUser;
import com.wx.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wx
 * 2018/9/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public TUser findUserByUsernameAndPassword(String username, String password) {
        List<TUser> list = userDao.findByUsernameAndPassword(username,password);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Page<TUser> findList(Pageable pageable) {
        //获取所有人员
        Page<TUser> userPage = userDao.findAll(pageable);
        return userPage;
    }

    @Override
    public void delUserByIds(String ids) {
        for(String id : ids.split(",")){
            userDao.deleteById(Integer.valueOf(id));
        }

    }

    @Override
    public void addUser(TUser user) {
        userDao.save(user);
    }
}

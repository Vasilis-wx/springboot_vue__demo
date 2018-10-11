package com.wx.control.user;

import com.wx.dao.user.UserDao;
import com.wx.fmode.user.FUser;
import com.wx.model.user.TUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wx
 * 2018/9/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findByUsernameAndPassword(){
        List<TUser> LIST = userDao.findByUsernameAndPassword("wx","666");
        System.out.printf(LIST.size()+"");
    }

    @Test
    public void finall(){
//        List<FUser> LIST = userDao.findAllUser2();
//        System.out.printf(LIST.size()+"");
    }


    @Test
    public void addUserTest(){
        for(int i = 5800 ; i < 100000 ;i++ ){
            TUser user = new TUser();
            user.setId(i);
            user.setName("测试");
            user.setPhone("1212121212212");
            user.setSex(1);
            user.setUserface("4545454545");
            user.setPassword("666");
            user.setBirthday(new Date());

            userDao.save(user);
        }
    }
}
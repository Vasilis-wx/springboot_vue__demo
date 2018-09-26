package com.wx.dao.user;

import com.wx.model.user.TUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wx
 * 2018/9/21
 */
public interface UserDao extends JpaRepository<TUser,Integer> {

    List<TUser> findByUsernameAndPassword(String username, String password);

    void deleteById(Integer id);

    TUser save(TUser user);
}

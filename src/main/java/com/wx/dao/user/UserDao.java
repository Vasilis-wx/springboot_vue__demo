package com.wx.dao.user;

import com.wx.fmode.user.FUser;
import com.wx.model.user.TUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by wx
 * 2018/9/21
 */
public interface UserDao extends JpaRepository<TUser,Integer> {

    List<TUser> findByUsernameAndPassword(String username, String password);

    void deleteById(Integer id);

    TUser save(TUser user);

    @Query(value="select user ,sysFile.url as userfaceUrl from user, sysFile where sysFile.uuid =  user.userfaceUUid ")
    Page<FUser> findAllUser(Pageable pageable);

    @Query(value="select user  from TUser user where user.id = :id")
    List<Map<String,Object>> findAllUser2(@Param("id") int id);
}

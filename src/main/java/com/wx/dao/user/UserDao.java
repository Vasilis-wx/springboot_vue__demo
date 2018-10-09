package com.wx.dao.user;

import com.wx.fmode.user.FUser;
import com.wx.fmode.user.UserI;
import com.wx.model.user.TUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wx
 * 2018/9/21
 */
public interface UserDao extends JpaRepository<TUser,Integer> {

    List<TUser> findByUsernameAndPassword(String username, String password);

    void deleteById(Integer id);

    TUser save(TUser user);

    @Query(value="select user.* ,sysFile.url as userfaceUrl from user left join sys_file sysFile  on sysFile.uuid =  user.userfaceUUid ", nativeQuery=true)
    Page<FUser> findAllUser(Pageable pageable);
}

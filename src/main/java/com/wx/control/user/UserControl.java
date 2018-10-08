package com.wx.control.user;

import com.wx.VO.AjaxMsg;
import com.wx.VO.ResultVO;
import com.wx.fmode.user.FUser;
import com.wx.model.user.TUser;
import com.wx.service.user.UserService;
import com.wx.util.DateUtils;
import com.wx.util.PageInfo;
import com.wx.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理
 * Created by wx
 * 2018/9/25
 */
@RestController
@RequestMapping("/user")
public class UserControl {
    @Autowired
    private UserService userService;

    /**
     * 用户list
     * @param pageInfo
     * @return
     */
    @RequestMapping("/list")
    public ResultVO<Map<String,String>> list(PageInfo pageInfo){

        Page<TUser> userList = userService.findList(pageInfo.getPageRequestWithSort());

        Map<String,Object> map = new HashMap<>();
        map.put("emps",userList.getContent());
        map.put("totalCount",userList.getTotalElements());

        return ResultVOUtil.successMap(map);
    }

    /**
     * 删除用户
     * @param ids
     * @return
     */
    @RequestMapping("/delUser/{ids}")
    public AjaxMsg delUser(@PathVariable  String ids) {

        Map<String,Object> map = new HashMap<>();
        try {
            userService.delUserByIds(ids);
            return new AjaxMsg("success","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMsg("error","删除出现问题");
        }
    }

    /**
     * 添加用户
     * @param fUser
     * @return
     */
    @RequestMapping("/addUser")
    public AjaxMsg addUser(FUser fUser){
        try {
            TUser user = new TUser();
            BeanUtils.copyProperties(fUser,user);
            user.setBirthday(DateUtils.strToDate(fUser.getBirthday()));
            user.setPassword("666");
            userService.addUser(user);
            return new AjaxMsg("success","添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMsg("error","添加用户出现问题");
        }
    }

}

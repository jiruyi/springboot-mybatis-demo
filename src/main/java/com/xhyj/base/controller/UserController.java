package com.xhyj.base.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhyj.base.dao.User;
import com.xhyj.base.dao.UserExample;
import com.xhyj.base.dao.UserExtend;
import com.xhyj.base.mapper.UserMapper;
import com.xhyj.base.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author jiruyi
 * @create 2019-08-23 14:07
 */

@RestController
public class UserController {


    @Autowired
    private UserManagerService userManagerService;


    @PostMapping ("/user/add")
    public boolean addUser(User user){

       return  this.userManagerService.addUser(user);
    }

    @PostMapping("/user/query")
    public PageInfo<User> getUserList(User user){
      return this.userManagerService.getUserList(user);
    }

    @PostMapping("/user/update")
    public boolean updateUser(User user){

        return this.userManagerService.updateUser(user);
    }

    @PostMapping("/user/userAndDept")

    public  PageInfo<UserExtend> getUserDepartmentList(User user){
        return this.userManagerService.getUserDepartmentList(user);
    }


}

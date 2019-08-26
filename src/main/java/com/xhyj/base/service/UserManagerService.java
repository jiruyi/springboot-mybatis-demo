package com.xhyj.base.service;

import com.github.pagehelper.PageInfo;
import com.xhyj.base.dao.User;
import com.xhyj.base.dao.UserExtend;

import java.util.Map;

/**
 * @author jiruyi
 * @create 2019-08-26 8:49
 */
public interface UserManagerService {

    public boolean addUser(User user);

    public PageInfo<User> getUserList(User user);

    public boolean updateUser(User user);

    public PageInfo<UserExtend> getUserDepartmentList(User user);


}

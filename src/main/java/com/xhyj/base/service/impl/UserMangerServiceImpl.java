package com.xhyj.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhyj.base.dao.*;
import com.xhyj.base.mapper.DepartmentMapper;
import com.xhyj.base.mapper.UserMapper;
import com.xhyj.base.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author jiruyi
 * @create 2019-08-26 8:53
 */

@Service
public class UserMangerServiceImpl implements UserManagerService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DepartmentMapper departmentMapper;


    /**
     * 添加用户 同时对应部门人数加一
     * @param user
     * @return
     */
    @Transactional
    @Override
    public boolean addUser(User user) {
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        user.setCreateTime(new Date());
        user.setLastUpdateTime(new Date());
        user.setStatus("1");
        int n_0  = this.userMapper.insertSelective(user);

        //条件
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria =  departmentExample.createCriteria();
        criteria.andDepartmentIdEqualTo(user.getDepartmentId());
        //javabean
        Department  department_return = this.departmentMapper.selectByPrimaryKey(user.getDepartmentId());
        if("市场部".equals(department_return.getDepartmentName())){
            throw new RuntimeException("部门人已满!");
        }
        Department department = new Department();
        department.setDepartmentCount(department_return.getDepartmentCount()+1);
        int n_1 =  this.departmentMapper.updateByExampleSelective(department,departmentExample);

        if(n_0 > 0 && n_1 >0){
            return true;
        }
        return false;
    }


    /**
     * 查询用户列表 单表
     * @param user
     * @return
     */
    @Override
    public PageInfo<User> getUserList(User user) {
        UserExample userExample = new UserExample();
        //拼装条件
        UserExample.Criteria criteria =  userExample.createCriteria();
        criteria.andUserNameLike("%"+user.getUserName());
        UserExample.Criteria criteria_or =  userExample.createCriteria();
        criteria_or.andSexEqualTo(user.getSex());
        userExample.or(criteria_or);


        PageHelper.startPage(0,5);

        List<User> userList =  this.userMapper.selectByExample(userExample);
        PageInfo<User>  pageInfo = new PageInfo(userList);

        return pageInfo;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria =  userExample.createCriteria();
        criteria.andUserNameLike("%"+user.getUserName());
        int n  = this.userMapper.updateByExampleSelective(user,userExample);
        return n > 0 ? true : false;
    }


    /**
     * 查询用户以及部门 多表
     * @param user
     * @return
     */
    @Override
    public PageInfo<UserExtend> getUserDepartmentList(User user) {
        UserExample userExample = new UserExample();
        //拼装条件
        UserExample.Criteria criteria =  userExample.createCriteria();
        criteria.andUserNameLike("%"+user.getUserName());

        PageHelper.startPage(0,10);

        List<UserExtend> userList =  this.userMapper.getUserDepartmentList(userExample);
        PageInfo<UserExtend>  pageInfo = new PageInfo(userList);

        return pageInfo;
    }
}

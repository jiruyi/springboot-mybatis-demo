package com.xhyj.base.mapper;

import com.github.pagehelper.PageInfo;
import com.xhyj.base.dao.User;
import com.xhyj.base.dao.UserExample;
import com.xhyj.base.dao.UserExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User>  selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<UserExtend> getUserDepartmentList(UserExample example);
}
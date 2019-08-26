package com.xhyj.base.dao;

import org.apache.ibatis.type.Alias;

/**
 * @author jiruyi
 * @create 2019-08-26 10:16
 */
public class UserExtend extends User {

    /** 关联部门*/
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

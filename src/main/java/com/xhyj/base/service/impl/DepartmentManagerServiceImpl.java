package com.xhyj.base.service.impl;

import com.xhyj.base.dao.Department;
import com.xhyj.base.mapper.DepartmentMapper;
import com.xhyj.base.service.DepartmentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author jiruyi
 * @create 2019-08-26 9:01
 */
@Service
public class DepartmentManagerServiceImpl implements DepartmentManagerService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public boolean addDepartment(Department department) {

        department.setDepartmentId(UUID.randomUUID().toString().replace("-",""));
        department.setCreateTime(new Date());
        department.setLastUpdateTime(new Date());
        department.setStatus("1");
        department.setDepartmentCount(0);
        int n = departmentMapper.insertSelective(department);

        return n > 0 ? true : false;
    }
}

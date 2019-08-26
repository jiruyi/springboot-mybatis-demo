package com.xhyj.base.controller;

import com.xhyj.base.dao.Department;
import com.xhyj.base.mapper.DepartmentMapper;
import com.xhyj.base.service.DepartmentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @author jiruyi
 * @create 2019-08-23 15:28
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentManagerService departmentManagerService;

    @PostMapping("/dept/add")
    public boolean addDepartment(Department department){

        return this.departmentManagerService.addDepartment(department);
    }

}



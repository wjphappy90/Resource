package com.itheima.service;

import com.itheima.dao.EmployeeDao;
import com.itheima.entity.Employee;

import java.util.List;

/**
 * 业务层
 */
public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    /**
     * 查询所有的员工
     * @return
     */
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }
}

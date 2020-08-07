package com.itheima.service;

import com.itheima.dao.EmployeeDao;
import com.itheima.entity.Employee;
import flexjson.JSONSerializer;

import java.util.List;

/**
 * 员工的业务层
 */
public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    /**
     * 调用dao得到所有的员工对象
     * @return
     */
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    /**
     * 将数据转成json对象
     */
    public String toJson(List<Employee> employees) {
        //创建json转换器对象
        JSONSerializer serializer = new JSONSerializer();
        //排除class属性
        serializer.exclude("class");
        return serializer.serialize(employees);
    }

}

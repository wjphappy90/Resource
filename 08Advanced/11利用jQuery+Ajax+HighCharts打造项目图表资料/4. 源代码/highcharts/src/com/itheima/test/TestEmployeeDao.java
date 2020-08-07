package com.itheima.test;

import com.itheima.dao.EmployeeDao;
import com.itheima.entity.Employee;
import flexjson.JSONSerializer;
import org.junit.Test;

import java.util.List;

public class TestEmployeeDao {

    private EmployeeDao employeeDao = new EmployeeDao();

    @Test
    public void testFindAll() {
        List<Employee> employees = employeeDao.findAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testToJSON() {
        List<Employee> employees = employeeDao.findAllEmployees();
        //创建JSON转换器
        JSONSerializer serializer = new JSONSerializer();
        //去除class属性
        serializer.exclude("class");
        String serialize = serializer.serialize(employees);
        System.out.println(serialize);
    }
}

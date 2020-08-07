package com.itheima.test;

import com.itheima.dao.EmployeeDao;
import com.itheima.entity.Employee;
import com.itheima.service.EmployeeService;
import com.itheima.utils.DataSourceUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.List;

public class TestEmployeeDao {

    EmployeeDao employeeDao = new EmployeeDao();
    EmployeeService employeeService = new EmployeeService();

    @Test
    public void testGetDataSource() {
        DataSource ds = DataSourceUtils.getDataSource();
        System.out.println(ds);
    }

    @Test
    public void testFindAllEmployees() {
        List<Employee> employees = employeeDao.findAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testToJson() {
        List<Employee> employees = employeeService.findAllEmployees();
        String toJson = employeeService.toJson(employees);
        System.out.println(toJson);
    }
}

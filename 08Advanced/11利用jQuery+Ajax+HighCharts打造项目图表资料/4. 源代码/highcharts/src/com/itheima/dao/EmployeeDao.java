package com.itheima.dao;

import com.itheima.entity.Employee;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDao {

    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    public List<Employee> findAllEmployees() {
        try {
            return runner.query("select * from employee", new BeanListHandler<>(Employee.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

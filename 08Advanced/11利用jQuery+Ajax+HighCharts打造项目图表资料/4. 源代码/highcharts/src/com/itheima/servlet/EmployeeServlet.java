package com.itheima.servlet;

import com.itheima.entity.Employee;
import com.itheima.service.EmployeeService;
import flexjson.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //指定响应类型为JSON
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //调用业务层访问数据
        List<Employee> employees = employeeService.findAllEmployees();
        //创建JSON转换对象
        JSONSerializer serializer = new JSONSerializer();
        serializer.exclude("class");  //排除class属性
        String serialize = serializer.serialize(employees);
        //输出到客户端
        out.print(serialize);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

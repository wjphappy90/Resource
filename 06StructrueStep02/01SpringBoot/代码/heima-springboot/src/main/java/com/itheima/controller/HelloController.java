package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloController {

    @Autowired
    private DataSource dataSource;

    @Value("${itcast.url}")
    private String itcastUrl;

    @Value("${itheima.url}")
    private String itheimaUrl;

    @Autowired
    private UserService userService;

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/user/{id}")
    public User queryById(@PathVariable Long id){
        return userService.queryById(id);
    }

    @GetMapping("hello")
    public String hello(){
        System.out.println(" itcastUrl = " + itcastUrl);
        System.out.println(" itheimaUrl = " + itheimaUrl);
        System.out.println(" DataSource = " + dataSource);
        return "Hello, Spring Boot!";
    }


}

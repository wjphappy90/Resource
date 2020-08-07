package com.itheima.web.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * RequestParam注解的使用讲解
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
public class RequestParamController {

    /**
     * 基本类型和String类型的封装
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/useParam1")
    public String param1(String name,Integer age){
        System.out.println("name is "+name+", age is "+age);
        return "success";
    }


    /**
     * 实体类类型的封装
     * @param user
     * @return
     */
    @RequestMapping(value = "/useParam2")
    public String param2(User user){
        System.out.println("user is "+user);
        int i=1/0;
        return "success";
    }

    /**
     * RequestParam注解的使用
     * @param page
     * @return
     */
    @RequestMapping("/useRequestParam")
    public String useRequestParam(@RequestParam(value = "page",defaultValue = "10") int page){
        System.out.println("当前页是："+page);
        return "success";
    }

}

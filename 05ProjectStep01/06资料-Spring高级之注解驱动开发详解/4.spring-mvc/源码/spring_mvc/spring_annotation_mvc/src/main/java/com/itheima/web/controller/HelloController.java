package com.itheima.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入门案例的控制
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("控制器方法执行了");
        return "success";
    }

}

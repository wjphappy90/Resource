package com.itheima.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ModelAttribute注解的讲解
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
public class ModelAttributeController {

    @ModelAttribute("username")
    public String showModel(String name){
        System.out.println("showModel method name is "+name);
        name = name + "aaa";
        return name;
    }

    @RequestMapping("/useModelAttribute")
    public String useModelAttribute(@ModelAttribute("username") String name){
        System.out.println("controller method name is "+name);
        return "success";
    }
}

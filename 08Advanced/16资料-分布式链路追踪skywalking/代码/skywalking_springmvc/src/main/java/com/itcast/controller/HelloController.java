package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
//hello/sayHello.do
public class HelloController {
    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(String name){
        return "hello world";
    }
}

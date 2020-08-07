package com.itcast.skywalking_springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    //正常访问接口
    @RequestMapping("/sayBoot")
    public String sayBoot(){
        return "Hello Boot!";
    }

    //异常访问接口
    @RequestMapping("/exception")
    public String exception(){
        int i = 1/0;
        return "Hello Boot!";
    }
}

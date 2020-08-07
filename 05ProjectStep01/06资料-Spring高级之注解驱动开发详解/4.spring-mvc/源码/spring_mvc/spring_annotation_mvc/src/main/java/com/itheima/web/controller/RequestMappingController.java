package com.itheima.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestMapping注解讲解的控制器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
@RequestMapping("springmvc")
public class RequestMappingController {

    /**
     * 用于处理请求的方法
     * @return
     */
//    @RequestMapping(value = "/useRequestMapping",name = "使用RequestMapping注解的请求映射",
//                    method = RequestMethod.GET,params = {"name"},headers = {"Accept-Encoding"})
    @PostMapping(value = "useRequestMapping",name = "使用RequestMapping注解的请求映射",
                 params = {"name"},headers = {"Accept-Encoding"})
    public String useRequestMapping(){
        System.out.println("使用RequestMapping注解");
        return "success";
    }
}

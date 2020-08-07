package com.itheima.web.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * RequestBody注解的讲解
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
@ResponseBody
public class RequestBodyResponseBodyController {

    @RequestMapping("/useRequestBody")
    public String useRequestBody(@RequestBody(required = false) User user){
        System.out.println("不支持跨域 user is "+user);
        return "success";
    }


    @RequestMapping("/useResponseBody")
    public String useResponseBody(){
        return "use response body";
    }
}

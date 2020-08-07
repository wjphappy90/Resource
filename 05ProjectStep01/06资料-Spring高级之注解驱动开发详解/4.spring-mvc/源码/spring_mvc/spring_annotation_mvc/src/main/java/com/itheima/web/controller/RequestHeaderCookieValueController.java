package com.itheima.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求消息头和cookie值获取的注解讲解
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
public class RequestHeaderCookieValueController {

    @RequestMapping("/useRequestHeader")
    public String useRequestHeader(@RequestHeader(value = "Tccept-Language",required = false,defaultValue = "test") String header){
        System.out.println("Accept-Language:"+header);
        return "success";
    }

    @RequestMapping("/useCookieValue")
    public String useCookieValue(@CookieValue("JSESSIONID") String jsessionid){
        System.out.println(jsessionid);
        return "success";
    }
}

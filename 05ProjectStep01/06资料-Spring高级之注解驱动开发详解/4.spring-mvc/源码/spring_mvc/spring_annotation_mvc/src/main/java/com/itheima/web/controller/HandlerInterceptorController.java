package com.itheima.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 用于演示拦截器的控制器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
public class HandlerInterceptorController {

    /**
     * 打招呼
     * @return
     */
    @RequestMapping("/sayHello")
    public String sayHello(ModelMap model){
        System.out.println("sayHello方法执行了");
        model.addAttribute("message","Hello itheima");
        return "success";
    }

    /**
     * 模拟登录方法
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        request.getSession().setAttribute("loginName","test");
        return "forward:/index.jsp";
    }
}

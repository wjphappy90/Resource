package com.itheima.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * SessionAttribute和SessionAttributes注解的使用
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
@SessionAttributes(value = {"message"})
public class SessionAttributesController {

    /**
     * 往session域中存入数据
     * 在没有SessionAttributes注解时，当控制器方法的参数有Model,ModelMap时是默认往请求域中存入数据
     * @return
     */
    @RequestMapping("/useSessionAttributes")
    public String useSessionAttributes(Model model){
        model.addAttribute("message","存入请求域的数据");
        return "success";
    }


    @RequestMapping("/useSessionAttribute")
    public String useSessionAttribute(HttpServletRequest request,@SessionAttribute(value = "message",required = false) String message){
        System.out.println(message);
        System.out.println("request attribute "+request.getAttribute("message"));
        return "success";
    }
}

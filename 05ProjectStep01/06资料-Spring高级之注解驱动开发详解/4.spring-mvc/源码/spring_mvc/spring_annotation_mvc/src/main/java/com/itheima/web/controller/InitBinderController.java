package com.itheima.web.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * InitBinder注解的使用
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
public class InitBinderController {

    @RequestMapping("/useInitBinder")
    public String useInitBinder(User user){
        System.out.println("user is "+user);
        return "success";
    }

    /**
     * 初始化数据绑定器
     * @param dataBinder

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }*/
}

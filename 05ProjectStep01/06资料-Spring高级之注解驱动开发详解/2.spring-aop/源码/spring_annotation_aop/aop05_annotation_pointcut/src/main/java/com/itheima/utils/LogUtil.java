package com.itheima.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
@Aspect("perthis(com.itheima.pointcuts.MyPointcut.pointcut1())")//表明当前类是一个切面类
@Scope("prototype")
public class LogUtil {



    /**
     * 用于配置当前方法是一个前置通知
     */
    @Before(value = "com.itheima.pointcuts.MyPointcut.pointcut1()")
    public void printLog(){
        System.out.println("执行打印日志的功能");
    }

}

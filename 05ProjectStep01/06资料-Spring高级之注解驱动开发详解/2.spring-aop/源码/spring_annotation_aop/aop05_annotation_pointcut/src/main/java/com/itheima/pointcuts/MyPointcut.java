package com.itheima.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class MyPointcut {

    /**
     * 用于定义通用的切入点表达式
     */
    @Pointcut(value = "execution(* com.itheima.service.impl.*.*(..))")
    public void pointcut1(){}
}

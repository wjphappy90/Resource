package com.itheima.utils;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 用于统计方法执行效率
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
//@Aspect
//@Order(value = 2)
public class EfficiencyUtils {

    private Long time;

    /**
     * 前置通知，记录开始时间
     */
    @Before("execution(* com.itheima.service.impl.*.*(..))")
    public void before(){
        time = System.currentTimeMillis();
        System.out.println("方法执行开始时间："+time);
    }

    /**
     * 最终通知，统计执行了多久
     */
    @After("execution(* com.itheima.service.impl.*.*(..))")
    public void after(){
        System.out.println("方法执行时间为:"+((System.currentTimeMillis()-time)/1000));
    }
}

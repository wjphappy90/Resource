package com.itheima.utils;

import com.itheima.domain.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
@Aspect//表明当前类是一个切面类
public class LogUtil {

    @Before(value="execution(* com.itheima.service.impl.*.*(..)) && args(user,id)")
    public void beforePrintLogC(String id,User user){
        System.out.println("前置通知增强了beforePrintLoga"+id+","+user);
    }

    @Before(value="execution(* com.itheima.service.impl.*.*(..)) && args(user,id)")
    public void beforePrintLogC(User user,String id){
        System.out.println("前置通知增强了beforePrintLogC"+user+","+id);
    }















    /**
     * 前置通知
     * 它是在切入点方法执行之前执行（注解驱动开发）
     * 可以获取切入点方法的参数，并且对其进行增强

    @Before(value="execution(* com.itheima.service.impl.*.*(..)) && args(user,id)")
    public void beforePrintLog(User user,String id){
        id = UUID.randomUUID().toString()+"_"+id;
        System.out.println("前置通知增强了"+user+","+id);
    }*/

    /**
     * 最终通知
     * 它是在切入点方法执行之后执行（注解驱动开发）

    @After(value="execution(* com.itheima.service.impl.*.*(..)) && args(user,id)")
    public void afterPrintLog(User user,String id){
        System.out.println("最终通知增强了"+user+","+id);
    }*/

    /**
     * 后置通知
     * 它是在切入点方法正常执行并返回之前执行（此时已经执行完最终通知了）

    @AfterReturning(pointcut="execution(* com.itheima.service.impl.*.*(..))",returning = "obj")
    public void afterReturningPrintLog(Object obj){
        System.out.println("后置通知增强了"+obj);
    }*/

    /**
     * 例外通知（异常通知）
     * 它是在切入点方法执行产生异常之后执行（此时已经执行完最终通知了）

    @AfterThrowing(pointcut="execution(* com.itheima.service.impl.*.*(..))",throwing = "e")
    public void afterThrowingPrintLog(Throwable e){
        System.out.println("异常通知增强了"+e);
    }*/

}

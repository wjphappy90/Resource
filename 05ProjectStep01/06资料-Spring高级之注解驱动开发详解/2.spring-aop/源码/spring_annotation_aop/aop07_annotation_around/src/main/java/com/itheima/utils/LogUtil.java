package com.itheima.utils;

import com.itheima.domain.SystemLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * 记录日志的工具类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
@Aspect//表明当前类是一个切面类
public class LogUtil {


    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        //定义返回值对象
        Object rtValue = null;
        try {
            //创建系统日志对象
            SystemLog log = new SystemLog();
            //设置主键
            String id = UUID.randomUUID().toString().replace("-","").toUpperCase();
            log.setId(id);
            //设置来访者ip，由于我们是java工程，没有请求信息
            log.setRemoteIP("127.0.0.1");
            //设置执行时间
            log.setTime(new Date());
            //设置当前执行的方法名称
            //1.使用ProceedingJoinPoint接口中的获取签名方法
            Signature signature = pjp.getSignature();
            //2.判断当前签名是否方法签名
            if(signature instanceof MethodSignature){
                //3.把签名转成方法签名
                MethodSignature methodSignature = (MethodSignature)signature;
                //4.获取当前执行的方法
                Method method = methodSignature.getMethod();
                //5.得到方法名称
                String methodName = method.getName();
                //6.给系统日志中方法名称属性赋值
                log.setMethod(methodName);

                //设置当前执行的方法说明
                //7.判断当前方法上是否有@Description注解
                boolean isAnnotated = method.isAnnotationPresent(Description.class);
                if(isAnnotated){
                    //8.得到当前方法上的Description注解
                    Description description = method.getAnnotation(Description.class);
                    //9.得到注解的value属性
                    String value = description.value();
                    //10.给系统日志的方法说明属性赋值
                    log.setAction(value);
                }
            }

            System.out.println("环绕通知执行了记录日志："+log);



            //获取切入点方法的参数
            Object[] args = pjp.getArgs();
            //切入点方法执行
            rtValue = pjp.proceed(args);
            return rtValue;
        }catch (Throwable e){
            throw new RuntimeException(e);
        }
    }



























    /**
     * 用于增强业务层方法，在其执行时记录系统日志
     * @return
    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        //定义返回值对象
        Object rtValue = null;
        try {
            try {
                System.out.println("前置通知执行了");
                //获取切入点方法的参数
                Object[] args = pjp.getArgs();
                //切入点方法执行
                rtValue = pjp.proceed(args);
            }finally {
                System.out.println("最终通知执行了");
            }
            System.out.println("后置通知执行了");
            return rtValue;
        }catch (Throwable e){
            System.out.println("异常通知执行了");
            throw new RuntimeException(e);
        }
    }*/
}

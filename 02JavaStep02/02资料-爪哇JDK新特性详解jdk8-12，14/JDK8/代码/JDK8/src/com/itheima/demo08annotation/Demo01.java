package com.itheima.demo08annotation;

import org.junit.Test;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
// 3.配置重复注解
@MyTest("ta")
@MyTest("tb")
@MyTest("tc")
public class Demo01 {
    @Test
    @MyTest("ma")
    @MyTest("mb")
    public void test()  {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // 4.解析重复注解
        // 获取类上的重复注解
        // getAnnotationsByType是新增的API用户获取重复的注解
        MyTest[] annotationsByType = Demo01.class.getAnnotationsByType(MyTest.class);
        for (MyTest myTest : annotationsByType) {
            System.out.println(myTest);
        }
        System.out.println("----------");
        // 获取方法上的重复注解
        MyTest[] tests = Demo01.class.getMethod("test").getAnnotationsByType(MyTest.class);
        for (MyTest test : tests) {
            System.out.println(test);
        }
    }
}

// 1.定义重复的注解容器注解
@Retention(RetentionPolicy.RUNTIME)
@interface MyTests { // 这是重复注解的容器
    MyTest[] value();
}

// 2.定义一个可以重复的注解
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyTests.class)
@interface MyTest {
    String value();
}


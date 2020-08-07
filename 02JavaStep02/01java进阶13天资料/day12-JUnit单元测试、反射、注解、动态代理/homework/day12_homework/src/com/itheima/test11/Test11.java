package com.itheima.test11;

import java.lang.reflect.Method;

/**
 1)  模拟JUnit测试的注释@Test，首先需要编写自定义注解@MyTest，并添加元注解，保证自定义注解只能修饰方法，且在运行时可以获得。
 2) 其次编写目标类（测试类），然后给目标方法（测试方法）使用@MyTest注解，编写三个方法，其中两个加上@MyTest注解。
 3) 最后编写调用类，使用main方法调用目标类，模拟JUnit的运行，只要有@MyTest注释的方法都会运行。
 */
public class Test11 {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("com.itheima.test11.Student");
        Object obj = aClass.getConstructor().newInstance();
        Method[] methodArr = aClass.getMethods();
        for (Method m : methodArr) {
            if (m.isAnnotationPresent(MyTest.class)) {
                m.invoke(obj);
            }
        }
    }
}

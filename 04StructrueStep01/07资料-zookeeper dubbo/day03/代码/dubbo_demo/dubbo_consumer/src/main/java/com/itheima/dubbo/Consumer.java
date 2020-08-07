package com.itheima.dubbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) {
        ApplicationContext context  = new ClassPathXmlApplicationContext("consumer.xml");

        DemoService service = context.getBean(DemoService.class);

        String resutl = service.sayHello("张三");

        System.out.println(resutl);
    }
}

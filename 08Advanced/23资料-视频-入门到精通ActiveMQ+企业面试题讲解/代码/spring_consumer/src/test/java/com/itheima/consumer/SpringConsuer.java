package com.itheima.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 用于启动消费方监听
 */
public class SpringConsuer {

    public static void main(String[] args) throws IOException {
        //1.加载spring配置
        ClassPathXmlApplicationContext
                cxt = new ClassPathXmlApplicationContext("classpath:applicationContext-consumer.xml");
        //2.启动
        cxt.start();

        //3.阻塞方法,让程序一直处于等待状态
        System.in.read();

    }

}

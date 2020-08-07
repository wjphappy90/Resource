package com.itheima.rpc.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {

        ApplicationContext context= new ClassPathXmlApplicationContext("provider.xml");
        ((ClassPathXmlApplicationContext) context).start();
        System.in.read();

    }
}

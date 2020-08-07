package com.ithiema.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class ConnectionTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        Connection connection = ac.getBean("connection",Connection.class);
        System.out.println(connection);
    }
}

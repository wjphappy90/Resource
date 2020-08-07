package com.itheima.demo02_concurrent_problem;

import java.util.ArrayList;
import java.util.List;

/*
    目标:演示原子性问题
        1.定义一个共享变量number
        2.对number进行1000的++操作
        3.使用5个线程来进行
 */
public class Test02Atomicity {
    // 1.定义一个共享变量number
    private static int number = 0;
    private static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        // 2.对number进行1000的++操作
        Runnable increment = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (obj) {
                    number++;
                }
            }
        };

        List<Thread> list = new ArrayList<>();
        // 3.使用5个线程来进行
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(increment);
            t.start();
            list.add(t);
        }

        for (Thread t : list) {
            t.join();
        }

        System.out.println("number = " + number);
    }
}
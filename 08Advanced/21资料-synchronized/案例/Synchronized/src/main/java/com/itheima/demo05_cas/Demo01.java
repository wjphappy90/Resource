package com.itheima.demo05_cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
    目标:演示原子性问题
        1.定义一个共享变量number
        2.对number进行1000的++操作
        3.使用5个线程来进行
 */
public class Demo01 {
    // 1.定义一个共享变量number
    private static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        // 2.对number进行1000的++操作
        Runnable increment = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.incrementAndGet(); // 变量赋值的原子性
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

        System.out.println("atomicInteger = " + atomicInteger.get());
    }
}
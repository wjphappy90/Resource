package com.itheima.demo05_cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo02 {
    private static int number = 0;
    private static Object obj = new Object();
    private static AtomicInteger atomicInteger = new AtomicInteger();

    private static final int numberOfLoop = 10000;
    private static final int numberOfThread = 300;

    public static void main(String[] args) throws InterruptedException {
        test01();
        test02();
    }

    private static void test02() throws InterruptedException {
        System.out.println("CAS开始");
        long start = System.currentTimeMillis();
        Runnable increment = () -> {
            for (int i = 0; i < numberOfLoop; i++) {
                atomicInteger.incrementAndGet();
            }
        };

        List<Thread> list = new ArrayList<>();
        // 3.使用5个线程来进行
        for (int i = 0; i < numberOfThread; i++) {
            Thread t = new Thread(increment);
            t.start();
            list.add(t);
        }

        for (Thread t : list) {
            t.join();
        }

        System.out.println("number = " + atomicInteger.get());
        long end = System.currentTimeMillis();
        System.out.println("cas消耗时间: " + (end - start));
    }

    private static void test01() throws InterruptedException {
        System.out.println("synchronized开始");
        long start = System.currentTimeMillis();
        Runnable increment = () -> {
            for (int i = 0; i < numberOfLoop; i++) {
                synchronized (obj) {
                    number++;
                }
            }
        };

        List<Thread> list = new ArrayList<>();
        // 3.使用5个线程来进行
        for (int i = 0; i < numberOfThread; i++) {
            Thread t = new Thread(increment);
            t.start();
            list.add(t);
        }

        for (Thread t : list) {
            t.join();
        }

        System.out.println("number = " + number);
        long end = System.currentTimeMillis();
        System.out.println("synchronized 消耗时间: " + (end - start));
    }
}

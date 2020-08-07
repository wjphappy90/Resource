package com.itheima.demo03_synchronized_nature;
/*
    目标:演示synchronized不可中断
        1.定义一个Runnable
        2.在Runnable定义同步代码块
        3.先开启一个线程来执行同步代码块,保证不退出同步代码块
        4.后开启一个线程来执行同步代码块(阻塞状态)
        5.停止第二个线程
 */
public class Demo02_Uninterruptible {
    private static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        // 1.定义一个Runnable
        Runnable run = () -> {
            // 2.在Runnable定义同步代码块
            synchronized (obj) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "进入同步代码块");
                // 保证不退出同步代码块
                try {
                    Thread.sleep(888888);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 3.先开启一个线程来执行同步代码块
        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        // 4.后开启一个线程来执行同步代码块(阻塞状态)
        Thread t2 = new Thread(run);
        t2.start();

        // 5.停止第二个线程
        System.out.println("停止线程前");
        t2.interrupt();
        System.out.println("停止线程后");

        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
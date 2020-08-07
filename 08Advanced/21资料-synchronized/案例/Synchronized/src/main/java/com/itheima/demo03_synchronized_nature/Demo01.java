package com.itheima.demo03_synchronized_nature;

/*
    目标:演示synchronized可重入
        1.自定义一个线程类
        2.在线程类的run方法中使用嵌套的同步代码块
        3.使用两个线程来执行
 */
public class Demo01 {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }

    public static void test01() {
        synchronized (MyThread.class) {
            String name = Thread.currentThread().getName();
            System.out.println(name + "进入了同步代码块2");
        }
    }
}

// 1.自定义一个线程类
class MyThread extends Thread {
    @Override
    public void run() {
        synchronized (MyThread.class) {
            System.out.println(getName() + "进入了同步代码块1");

            Demo01.test01();
        }
    }


}
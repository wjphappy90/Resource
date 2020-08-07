package com.itheima.demo08_lightweight_lock;

import org.openjdk.jol.info.ClassLayout;

public class Demo01 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
}

class MyThread extends Thread {
    static Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj) {
            // ...
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }
}
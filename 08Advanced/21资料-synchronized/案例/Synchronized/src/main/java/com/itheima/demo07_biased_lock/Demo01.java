package com.itheima.demo07_biased_lock;

import org.openjdk.jol.info.ClassLayout;

public class Demo01 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

        MyThread mt2 = new MyThread();
        mt2.start();
    }
}

class MyThread extends Thread {
    static Object obj = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (obj) {
                // ...
                System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            }
        }
    }
}
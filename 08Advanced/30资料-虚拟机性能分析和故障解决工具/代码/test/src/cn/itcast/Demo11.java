package cn.itcast;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    jvisualvm:线程分析
 */
public class Demo11 {
    public static void main(String[] args) throws Exception{
        System.in.read();
        System.out.println("死锁");
        deadLock();
    }

    private static void deadLock() {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        new Thread(() -> {
            try {
                lock1.lock();
                Thread.sleep(100);
                lock2.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "myThread1").start();
        new Thread(() -> {
            try {
                lock2.lock();
                Thread.sleep(100);
                lock1.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "myThread2").start();
    }
}
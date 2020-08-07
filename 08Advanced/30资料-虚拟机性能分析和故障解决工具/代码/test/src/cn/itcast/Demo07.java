package cn.itcast;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    jstack应用
 */
public class Demo07 {

    public static void main(String[] args) {
        System.out.println("start");
//        test1();
//        test2();
        test3();
        System.out.println("end");
    }

    //死循环
    public static void test1() {
        while (true) {
        }
    }

    //等待控制台输入
    public static void test2() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //死锁
    public static void test3() {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        new Thread(() -> {
            try {
                lock1.lock();
                Thread.sleep(100);
                lock2.lock();//需要加锁，加锁失败，锁被另外一个线程mythread2持有了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "myThread1").start();
        new Thread(() -> {
            try {
                lock2.lock();
                Thread.sleep(100);
                lock1.lock();//通过lock1加锁，失败，等待锁被释放
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "myThread2").start();
    }


}
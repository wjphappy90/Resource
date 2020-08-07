package com.itheima.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
    目标：使用原子性来实现变量修改的原子性操作。
 */
public class VolatileDemo05 {
    public static void main(String[] args) {
        // 1.创建一个线程任务对象
        Runnable target = new ThreadTarget02();
        // 2.开始100个线程对象执行这个任务。
        for(int i = 1 ; i <= 100 ; i++ ) {
            new Thread(target,"第"+i+"个线程").start();
        }
    }
}

// 线程任务类
class ThreadTarget02 implements Runnable{
    // 提供一个原子类。
    private AtomicInteger atomicInteger = new AtomicInteger();
    @Override
    public void run() {
        for(int i = 1 ; i <= 10000 ; i++ ) {
            System.out.println(Thread.currentThread().getName()+"count =========>>>> " + atomicInteger.incrementAndGet());
        }
    }
}

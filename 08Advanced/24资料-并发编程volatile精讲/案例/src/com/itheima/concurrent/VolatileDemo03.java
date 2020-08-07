package com.itheima.concurrent;

/**
    目标：研究Volatile的原子性操作。

    基本观点：Volatile不能保证原子性操作。

    案例演示：
        定义一个共享变量。
        开启100个线程，每个线程负责为变量累加10000次。
        在线程执行完毕之后看变量的结果。
 */
public class VolatileDemo03 {
    public static void main(String[] args) {
        // 1.创建一个线程任务对象
        Runnable target = new ThreadTarget();
        // 2.开始100个线程对象执行这个任务。
        for(int i = 1 ; i <= 100 ; i++ ) {
            new Thread(target,"第"+i+"个线程").start();
        }
    }
}

// 线程任务类
class ThreadTarget implements Runnable{
    // 定义一个共享变量
    private volatile int count = 0 ;
    @Override
    public void run() {
        for(int i = 1 ; i <= 10000 ; i++ ) {
            count++;
            System.out.println(Thread.currentThread().getName()+"count =========>>>> " + count);
        }
    }
}

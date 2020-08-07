package com.itheima.usevolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
    目标：volatile的使用场景介绍。
        1.适合做纯赋值操作，不适合做a++等操作。

 */
public class UserVolatile01 implements Runnable {
    // 定义一个volatile修饰的boolean变量
    public volatile boolean flag = false ;
    // 定义一个原子类记录总的赋值次数
    public AtomicInteger atomicInteger = new AtomicInteger();
    @Override
    public void run() {
        for(int i = 1 ; i <= 10000 ; i++ ){
            switchFlag();
            atomicInteger.incrementAndGet(); // +1
        }
    }

    private void switchFlag() {
        //flag = true;   // 纯赋值操作符合预期
         flag = !flag ; // 这样做不符合预期
    }
}

class Test{
    public static void main(String[] args) throws Exception {
        UserVolatile01 target = new UserVolatile01();
        // 创建两个线程线程执行赋值操作
        Thread t1 = new Thread(target);
        Thread t2 = new Thread(target);
        t1.start();
        t2.start();
        // 等两个线程执行完毕以后获取执行的结果。
        t1.join();
        t2.join();
        // 得到结果
        System.out.println(target.flag);
        System.out.println(target.atomicInteger.get());

    }
}
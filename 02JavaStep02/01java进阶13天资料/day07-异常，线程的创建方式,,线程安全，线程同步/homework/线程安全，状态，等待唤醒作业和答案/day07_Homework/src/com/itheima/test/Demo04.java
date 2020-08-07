package com.itheima.test;

/**
 写一个卖票的程序，

 1. 写一个类，该类继承Thread，定义一个变量记录总票数。

 1. 开启四个卖票窗口(开始四个线程),同时执行卖票的程序。
 要求每卖一张票在控制台输出：当前窗口为：窗口a卖了一张票，剩余票数为19。其中窗口a为线程的名字。

 */
public class Demo04 {
    public static void main(String[] args) {
        // 创建四个个线程对象
        Ticket t0 = new Ticket("窗口a");
        Ticket t1 = new Ticket("窗口b");
        Ticket t2 = new Ticket("窗口c");
        Ticket t3 = new Ticket("窗口d");

        // 开启线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
class Ticket extends Thread {
    // 票数
    private static int tickets = 100;
    // 构造方法
    public Ticket(String name) {
        super(name);
    }

    @Override
    public void run() {
        // 使用循环卖票，直到所有票都卖完了
        while(true) {
            synchronized (Ticket.class) {
                if(tickets > 0) {
                    // 休眠操作
                    try {
                        Thread.sleep(10);
                        // 如果还有票，则卖一张
                        System.out.println(Thread.currentThread().getName()
                                + " 卖了第 "+(tickets --)+"票");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                    }
                }
            }
        }
    }
}


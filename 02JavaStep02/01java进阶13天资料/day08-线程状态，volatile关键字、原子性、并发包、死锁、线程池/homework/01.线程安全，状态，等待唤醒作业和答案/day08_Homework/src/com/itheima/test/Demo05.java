package com.itheima.test;

/**
 开启三个线程，分别执行以下三个运算，并将运算结果输出到控制台。

 - 一个线程计算10!
 - 一个线程计算5!
 - 一个线程计算8!
 */
public class Demo05 {
    public static void main(String[] args) {
        // 创建三个线程分别计算指定数的阶乘
        new CountThread(10).start();
        new CountThread(5).start();
        new CountThread(8).start();
    }
}
class CountThread extends Thread{
    // 接收外面传递的数字
    private int num;

    public CountThread(int num) {
        this.num = num;
    }

    public CountThread() {
    }

    @Override
    public void run() {
        int sum = 1;
        // 计算num的阶乘
        for (int index = num; index >= 1; index--) {
            sum *= index;
        }
        // 获得当前线程
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " 计算 " + num + "的阶乘结果为：" + sum);
    }
}



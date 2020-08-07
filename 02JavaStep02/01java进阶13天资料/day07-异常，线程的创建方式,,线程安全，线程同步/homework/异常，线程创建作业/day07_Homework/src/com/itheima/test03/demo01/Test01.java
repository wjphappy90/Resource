package com.itheima.test03.demo01;

import java.util.Random;

/**
 训练描述
 开启一个线程执行任务：随机获得10个100到1000的整数并将10个整数相加求和，将求和结果输出。
 */
public class Test01 {
    public static void main(String[] args){
        // 创建线程对象
        MyThread thread = new MyThread();
        // 开启线程
        thread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        // 定义求和变量
        int sum = 0;
        // 创建随机对象
        Random r = new Random();
        // 循环产生10个随机整数
        for (int i = 0; i < 10 ; i++) {
            sum += r.nextInt(901) + 100;
        }
        System.out.println("sum = " + sum);
    }
}

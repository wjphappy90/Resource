package com.itheima.test04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 使用线程池：一个线程计算10! ，一个线程计算5!， 一个线程计算8!
 打印在那个线程执行的和执行结果.(使用Runnable)
 */
public class Demo01 {

    public static void main(String[] args) {
        // 创建线程池对象
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        // 提交线程任务
        threadPool.submit(new CountRunnable(10));
        threadPool.submit(new CountRunnable(5));
        threadPool.submit(new CountRunnable(8));

        threadPool.shutdown();
    }

}

class CountRunnable implements Runnable{
    // 接收外面传递的数字
    private int num;

    public CountRunnable(int num) {
        this.num = num;
    }

    public CountRunnable() {
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


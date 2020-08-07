package com.itheima.test;

/**
 1. 有100个限量版的水杯，但是只能通过实体店和官网才能进行购买，并且分别统计卖了多少。
 请用线程进行模拟并设置线程名称用来代表售出途径，再将信息打印出来。

 比如（实体店卖出第1个，总共剩余n个..）

 */
public class Demo02 {
    public static void main(String[] args) {
        // 创建一个卖水杯的Runnable接口实现类
        Seller seller = new Seller();
        // 创建实体店的线程
        Thread t1 = new Thread(seller, "实体店");
        // 创建官网的线程
        Thread t2 = new Thread(seller,"官网");
        // 实体店开始卖水杯
        t1.start();
        // 官网开始卖水杯
        t2.start();
    }
}
class Seller implements Runnable {
    // 有100个限量版的水杯
    private int count = 100;
    public void run() {
        // 获取当前线程的名字
        String name = Thread.currentThread().getName();
        // 定义变量统计卖出去的个数
        int sellCount = 0;
        // 开启循环卖票
        while(true) {
            synchronized(this) {
                if(count > 0) {
                    // 每卖出一个count-1
                    count--;
                    // 线程每卖出一个把卖出的数量+1
                    sellCount ++;
                    // 卖出第1个，总共剩余n个.
                    System.out.println(name +"卖出第"+sellCount+"个,总共剩余"+count+"个");
                }else{
                    break;
                }
            }

            // 为了更好看到竞争资源,睡一小下
			/*try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
        }
    }
}


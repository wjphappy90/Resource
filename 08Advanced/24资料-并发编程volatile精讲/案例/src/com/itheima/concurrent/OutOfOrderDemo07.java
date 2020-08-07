package com.itheima.concurrent;

/**
    目标：使用volatile修改变量从而防止指令重排序带来的并发修改问题！！
 */
public class OutOfOrderDemo07 {
    // 新建几个静态变量
    public  static int a = 0 , b = 0;
    public volatile static int i = 0 , j = 0;

    public static void main(String[] args) throws Exception {
        int count = 0;
        while(true){
            count++;
            a = 0 ;
            b = 0 ;
            i = 0 ;
            j = 0 ;
            // 定义两个线程。
            // 线程A
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    i = b;
                }
            });

            // 线程B
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    j = a;
                }
            });

            t1.start();
            t2.start();
            t1.join(); // 让t1线程优先执行完毕
            t2.join(); // 让t2线程优先执行完毕

            // 得到线程执行完毕以后 变量的结果。
            System.out.println("第"+count+"次输出结果：i = " +i +" , j = "+j);
            if(i == 0 && j == 0){
                break;
            }
        }
    }
}

package com.itheima.test;

/**
 请按要求编写多线程应用程序，模拟多个人通过一个山洞：

 - 这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒。
 - 随机生成10个人，同时准备过此山洞，显示每次通过山洞人的姓名。
 */
public class Demo01 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Tunnel t = new Tunnel("张三" + i);
            t.start();
        }
    }
}


/*
 * 1.定义一个隧道类继承Thread
 */
class Tunnel extends Thread {

    // 1.1 定义一个变量，用来记录通过隧道的人数
    private static int crossNum = 0;

    public Tunnel(String name){
        super(name);
    }
    /*
     * 1.2 重写Runnable的run方法
     */
    @Override
    public void run() {
        /*
         * 1.3 使用同步代码块，模拟每个人通过隧道需要5秒钟
         */
        synchronized(Tunnel.class){
            // 1.3.1 子线程睡眠5秒钟，模拟每个人通过隧道需要5秒钟
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 1.3.2 改变通过的人次
            crossNum++;
            // 1.3.3 打印线程名称及其通过隧道的顺序，模拟人通过隧道及其顺序
            System.out.println(Thread.currentThread().getName()+"已经通过隧道，TA是第"+crossNum+"通过的！");
        }
    }

}
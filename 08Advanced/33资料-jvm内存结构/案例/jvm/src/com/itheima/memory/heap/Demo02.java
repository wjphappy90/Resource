package com.itheima.memory.heap;
/*
    jps：查看当前系统中有哪些Java进程

    jmap 工具：查看堆内存占用情况(某一个时刻)
    jmap -heap 进程id

    jconsole 工具：图形界面的，内置 Java 性能分析器，多功能的监测工具，可以连续监测
 */
public class Demo02 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1......");
        Thread.sleep(30000);
        byte[] bys = new byte[1024 * 1024 * 10]; //10Mb
        System.out.println("2......");
        Thread.sleep(10000);
        bys = null;
        System.gc();
        System.out.println("3......");
        Thread.sleep(1000000);
    }
}

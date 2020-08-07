package com.itheima.test05;

/**
 1. 给出以下代码，请问该程序的运行结果是什么? 如有问题，请说明原因。

 public class Test07 implements Runnable {
     public static void main(String[] args) {
         Thread t = new Thread(new Test07());
         t.start();
     }
     public void run(int num) {
         for (int i = 0; i < num; i++) {
         System.out.println(i);
         }
     }
 }

 答
 在编译时期就会报错
 Test类没有重写Runnable接口中的run()方法
 public void run(int num)不是Runnable接口中的run()方法。
 注意：Runnable接口中的run()方法，参数列表为空，不带参数。
 */
public class Demo01 {
}

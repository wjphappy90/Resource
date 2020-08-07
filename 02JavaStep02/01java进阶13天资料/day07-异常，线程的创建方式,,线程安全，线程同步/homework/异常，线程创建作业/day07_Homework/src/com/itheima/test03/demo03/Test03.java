package com.itheima.test03.demo03;

/**
 编写程序，创建两个线程对象，一根线程输出“播放背景音乐”，
 另一根线程输出“显示画面”，
 要求线程实现Runnable接口，且使用匿名内部类实现。
 */
public class Test03 {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("播放背景音乐");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("显示画面");
            }
        }).start();
    }
}



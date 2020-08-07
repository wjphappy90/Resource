package com.itheima.threadlocal;

import java.util.HashMap;

/*
    同一线程中: 存的变量和取的变量要一致
 */
public class Demo01 {
    ThreadLocal<String> tl = new ThreadLocal<>();

    private String content;

    public String getContent() {
//        return content;
        //取的时候: 获取当前线程绑定的局部变量
        return tl.get();
    }

    public void setContent(String content) {
//        this.content = content;
        //存的时候 : content变量就跟当前线程绑定了
        tl.set(content);
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();

        //开启5个线程
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    /*
                    * 预期: 例如存的时候线程0 : 线程0的数据
                    *   取出的时候, 线程0 对应的 线程0的数据
                    * */
                    demo01.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("-----------------------------------------");
                    String content = demo01.getContent();
                    System.out.println(Thread.currentThread().getName() + ":" + content);
//                    HashMap
                }
            };
            t.setName("线程" + i);// 线程0~4
            t.start();
        }
    }
}

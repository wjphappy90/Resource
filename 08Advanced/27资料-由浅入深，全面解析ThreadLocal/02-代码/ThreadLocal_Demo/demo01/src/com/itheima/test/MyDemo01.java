package com.itheima.test;

/*
*  需求： 线程隔离
*       在多线程并发的场景下, 每个线程中的变量都是相互独立
*       线程A ：  设置（变量1 ）   获取（变量1）
*       线程B ：  设置（变量2 ）   获取（变量2）
*
*       ThreadLocal :
*           1. set() :  将变量绑定到当前线程中
*           2. get() :  获取当前线程绑定的变量
* */
public class MyDemo01 {

    ThreadLocal<String> tl = new ThreadLocal<>();

    //变量
    private String content;

    private String getContent() {
//        return content;
        String s = tl.get();
        return s;
    }

    private void setContent(String content) {
//        this.content = content;
        //变量content绑定到当前线程
        tl.set(content);
    }

    public static void main(String[] args) {
        MyDemo01 demo = new MyDemo01();

        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    /*
                        每个线程: 存一个变量 , 过一会 取出这个变量
                     */
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("-----------------------");
                    System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
                }
            });

            thread.setName("线程" + i); //线程0~4
            thread.start();
        }
    }

}

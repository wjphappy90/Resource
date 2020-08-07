package com.itheima.threadlocal;

/*
    同一线程中: 存的变量和取的变量要一致
 */
public class Demo02 {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();

        //开启5个线程
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    /*
                    * 预期: 例如存的时候线程0 : 线程0的数据
                    *   取出的时候, 线程0 对应的 线程0的数据
                    * */
                    synchronized (Demo02.class){
                        demo02.setContent(Thread.currentThread().getName() + "的数据");
                        System.out.println("-----------------------------------------");
                        String content = demo02.getContent();
                        System.out.println(Thread.currentThread().getName() + ":" + content);
                    }

                }
            };
            t.setName("线程" + i);// 线程0~4
            t.start();
        }
    }
}

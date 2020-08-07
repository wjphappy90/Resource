package com.itheima.concurrent;

/**
    目标：研究一下多线程下变量访问的不可见性现象。

    准备内容：
        1.准备2个线程。
        2.定义一个成员变量。
        3.开启两个线程，其中一个线程负责修改，另外一个负责读取。
 */
public class VisibilityDemo01 {
    // main方法，作为一个主线程。
    public static void main(String[] args) {
        // a.开启一个子线程
        MyThread t = new MyThread();
        t.start();

        // b.主线程执行
        while(true){
            if(t.isFlag()){
                System.out.println("主线程进入循环执行~~~~~");
            }
        }
    }
}

class MyThread extends Thread{
    // 成员变量
    private boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 触发修改共享成员变量
        flag = true;
        System.out.println("flag="+flag);
    }
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

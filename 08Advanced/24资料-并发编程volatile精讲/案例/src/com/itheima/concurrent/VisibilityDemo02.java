package com.itheima.concurrent;

/**
    目标：解决多线程下并发修改变量的不可见性问题。

    解决思路：
        1.加锁。
        2.对共享的变量使用volatile关键字修饰即可。
 */
public class VisibilityDemo02 {
    // main方法，作为一个主线程。
    public static void main(String[] args) {
        // a.开启一个子线程
        MyThread02 t = new MyThread02();
        t.start();

        // b.主线程执行
        while(true){
            synchronized (t){
                if(t.isFlag()){
                    System.out.println("主线程进入循环执行~~~~~");
                }
            }
        }
    }
}

class MyThread02 extends Thread{
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

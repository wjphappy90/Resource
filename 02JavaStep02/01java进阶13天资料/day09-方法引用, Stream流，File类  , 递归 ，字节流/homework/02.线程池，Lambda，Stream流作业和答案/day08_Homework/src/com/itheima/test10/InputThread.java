package com.itheima.test10;


public class InputThread implements Runnable {
    private Person p;

    public InputThread(Person p) {
        this.p = p;
    }

    @Override
    public void run() {
        int index = 0;
        while(true) {
            synchronized (p) {
                // 给对象属性赋值
                if(index % 2 == 0 ) {
                    p.name = "张三";
                    p.sex = "男";
                } else {
                    p.name = "lisi";
                    p.sex = "nv";
                }
                // 设置标记为true
                p.flag = true;
                // 唤醒输出线程
                p.notify();
                try {
                    // 等待输出线程输出
                    p.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            index ++;
        }
    }
}

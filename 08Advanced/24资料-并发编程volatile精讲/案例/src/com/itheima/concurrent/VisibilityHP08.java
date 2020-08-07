package com.itheima.concurrent;

/**
    目标：volatile写读建立的happens-before规则。

    规则：
     如果线程1写入了volatile变量v（临界资源），接着线程2读取了v，那么，
     线程1写入v及之前的写操作都对线程2可见（线程1和线程2可以是同一个线程）*
 */
public class VisibilityHP08 {
    int a = 1;
    int aaa;
    volatile int b = 2;

    // 线程1
    private void write(){
        aaa = 1000;
        a = 3 ;
        b = a ; // volatile修饰b
    }

    // 线程2
    public void read(){
        System.out.println("b = "+b+" , a = " + a +" , aaa="+aaa);
    }

    public static void main(String[] args) {
        while(true){
            VisibilityHP08  t = new VisibilityHP08();
            // 开启两个线程，一个线程负责写数据，一个线程负责读取数据。
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t.write();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    t.read();
                }
            }).start();
        }
    }

}

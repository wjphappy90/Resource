package com.itheima.usevolatile;

/**
    目标：volatile的使用场景二：可以作为刷新之前操作的触发器。
 */
public class UserVolatile02 {
    int a = 1;
    int b = 2;
    int c = 3;
    volatile boolean flag = false;

    public void write(){
        a = 100 ;
        b = 200 ;
        c = 300 ;
        flag = true ; // 修饰volatile修饰的变量。
    }

    public void read(){
        while(flag){
            System.out.println("a="+a+", b="+b+" ,c="+c);
        }
    }

    public static void main(String[] args) {
        UserVolatile02 target = new UserVolatile02();
        new Thread(new Runnable() {
            @Override
            public void run() {
                target.write();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                target.read();
            }
        }).start();
    }
}

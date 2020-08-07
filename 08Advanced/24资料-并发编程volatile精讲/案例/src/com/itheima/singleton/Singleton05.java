package com.itheima.singleton;

/**
    目标：懒汉式（线程不安全）

    步骤：
        1.构造器私有。
        2.定义一个静态变量存储一个单例对象。
        3.提供一个方法返回一个单例对象。


 */
public class Singleton05 {
    // 2.定义一个静态变量存储一个单例对象。
    private static Singleton05 INSTANCE ;
    // 1.构造器私有
    private Singleton05(){

    }
    // 3.返回一个单例对象
    public static Singleton05 getInstance(){
        // 判断单例对象的变量是否为null
        if(INSTANCE == null){
            // 很多个线程执行到这里来：A , B
            synchronized (Singleton05.class){
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }
}

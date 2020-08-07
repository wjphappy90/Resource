package com.itheima.singleton;

/**
    目标：懒汉式（线程安全的写法）。
    步骤：
        1.构造器私有。
        2.定义一个静态的变量存储一个单例对象（定义的时候不初始化该对象）
        3.定义一个获取单例的方法，每次返回单例对象的时候先询问是否有对象，有直接返回。
            没有就创建一个新的单例对象。
        4.为获取单例的方法加锁：用synchronized
 */
public class Singleton04 {
    // 2.定义一个静态的变量存储一个单例对象（定义的时候不初始化该对象）
    private static Singleton04 INSTANCE;
    // 1.构造器私有。
    private Singleton04(){

    }
    // 3.定义一个获取单例的方法，每次返回单例对象的时候先询问是否有对象，有直接返回。
    //   没有就创建一个新的单例对象。
    // 懒汉式线程安全的写法：线程A ， 线程B.
    public synchronized static Singleton04 getInstance(){
        if(INSTANCE == null){
            // 说明这是第一次来拿单例对象，需要真正的创建出来！
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }
}

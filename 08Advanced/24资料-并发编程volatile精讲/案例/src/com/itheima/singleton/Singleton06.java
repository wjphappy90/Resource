package com.itheima.singleton;

/**
    目标：双重检查机制，以及使用volatile修饰（最好，最安全的方式，推荐写法）

    步骤：
        1.构造器私有。
        2.提供了一个静态变量用于存储一个单例对象。
        3.提供一个方法进行双重检查机制返回单例对象。
        4.必须使用volatile修饰静态的变量。？

     双重检查的优点：线程安全，延迟加载，效率较高！!
 */
public class Singleton06 {
    //  2.提供了一个静态变量用于存储一个单例对象。
    private volatile static Singleton06 INSTANCE;

    // 1.构造器私有。
    private Singleton06(){

    }

    // 3.提供一个方法进行双重检查机制返回单例对象。
    public static Singleton06 getInstance(){
        // 第一次检查：判断单例对象的变量是否为null
        if(INSTANCE == null ){
            // A , B
            synchronized (Singleton06.class){
                // 第二次检查：判断单例对象的变量是否为null
                if(INSTANCE == null){
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }
}

package com.itheima.singleton;

/**
    目标：基于类的初始化实现延迟加载和线程安全的单例设计。

    步骤：
        1.构造器私有。
        2.提供一个静态内部类，里面提供一个常量存储一个单例对象。
        3.提供一个方法返回静态内部类中的单例对象。
 */
public class Singleton07 {
    //  1.构造器私有。
    private Singleton07(){

    }
    //  2.提供一个静态内部类，里面提供一个常量存储一个单例对象。
    private static class Inner{
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    // .提供一个方法返回静态内部类中的单例对象。
    // 线程A ， 线程B
    public static Singleton07 getInstance(){
        return Inner.INSTANCE;
    }
}

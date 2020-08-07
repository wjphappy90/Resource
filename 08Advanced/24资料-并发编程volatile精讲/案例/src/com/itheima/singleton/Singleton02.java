package com.itheima.singleton;

/**
    目标：饿汉式（静态代码块）

    步骤：
        1.构造器私有。
        2.定义一个静态常量保存一个唯一的实例对象（单例），可以通过静态代码块初始化单例对象。
        3.提供一个方法返回单例对象。
 */
public class Singleton02 {
    // 2.定义一个静态常量保存一个唯一的实例对象（单例）
    private static final Singleton02 INSTANCE ;

    static{
        INSTANCE = new Singleton02();
    }

    // 1.构造器私有。
    private Singleton02(){

    }
    // 3.提供一个方法返回单例对象。
    public static Singleton02 getInstance(){
        return INSTANCE;
    }
}

class Test02{
    public static void main(String[] args) {
        Singleton02 s1 = Singleton02.getInstance();
        Singleton02 s2 = Singleton02.getInstance();
        System.out.println(s1 == s2);
    }
}
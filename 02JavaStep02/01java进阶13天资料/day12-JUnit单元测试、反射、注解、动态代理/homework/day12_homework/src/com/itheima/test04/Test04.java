package com.itheima.test04;

import java.lang.reflect.Method;

public class Test04 {
    /*
     *  1. 定义一个类，在类中定义一个成员方法show，方法功能是：打印一个字符串。
        2. 使用反射机制创建该类的对象，并调用该对象的show方法。
     */
    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class clazz = Class.forName("com.itheima.test04.Demo");
        // 利用反射创建对象
        Demo demo = (Demo)clazz.newInstance();
        // 利用反射获取print方法
        Method printMethod = clazz.getMethod("show",String.class);

        printMethod.invoke(demo,"java");
    }
}

class Demo {
    public Demo() {
    }
    public void show(String str){
        System.out.println("Hello "+str);
    }
}
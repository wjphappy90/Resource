package com.itheima.demo02interfaceupgrade;

public class Demo03UseStaticFunction {
    public static void main(String[] args) {
        BBB bbb = new BBB();
        // bbb.test01();
        // 使用接口名.静态方法名();
        AAA.test01();
    }
}

interface AAA {
    public static void test01() {
        System.out.println("我是接口静态方法");
    }
}

class BBB implements AAA {
    // @Override
    // public static void test01() {
    //     System.out.println("我是接口静态方法");
    // }
}
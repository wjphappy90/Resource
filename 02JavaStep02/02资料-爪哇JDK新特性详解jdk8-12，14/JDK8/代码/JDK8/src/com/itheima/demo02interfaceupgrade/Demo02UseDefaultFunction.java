package com.itheima.demo02interfaceupgrade;

public class Demo02UseDefaultFunction {
    public static void main(String[] args) {
        BB bb = new BB();
        bb.test01();

        CC cc = new CC();
        cc.test01();
    }
}

interface AA {
    public default void test01() {
        System.out.println("我是接口AA默认方法");
    }
}
// 默认方法使用方式一: 实现类可以直接使用
class BB implements AA {
}

// 默认方法使用方式二: 实现类可以重写接口默认方法
class CC implements AA {
    @Override
    public void test01() {
        System.out.println("我是CC类重写的默认方法");
    }
}


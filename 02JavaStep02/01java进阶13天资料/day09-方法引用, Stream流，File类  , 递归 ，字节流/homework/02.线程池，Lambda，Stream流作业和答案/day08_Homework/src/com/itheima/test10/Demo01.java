package com.itheima.test10;

/**
 使用等待唤醒,实现一个线程给共享对象Person的属性(姓名,性别)赋值,
 一个线程打印共享对象的属性要求赋值->打印->赋值->打印 ... 不允许出现人妖.
 */
public class Demo01 {
    public static void main(String[] args) {
        // 创建共享资源对象
        Person p = new Person();
        // 创建输入线程
        Thread tin = new Thread(new InputThread(p),"输入线程");
        // 创建输出线程
        Thread tout = new Thread(new OutputThread(p),"输出线程");
        // 开启线程
        tin.start();
        tout.start();
    }
}

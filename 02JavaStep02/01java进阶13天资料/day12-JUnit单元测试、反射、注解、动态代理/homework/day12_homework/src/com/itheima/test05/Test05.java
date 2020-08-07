package com.itheima.test05;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 1. 编写一个类A，定义一个实例方法showString，用于打印一个字符串。
 2. 在编写一个类TestA，用键盘输入一个字符串，该字符串就是类A的类全名，
 使用反射机制创建该类的对象，并调用该对象中的方法showString
 */
public class Test05 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个类的全类名,用.隔开:");
        String className = sc.nextLine();

        Class clazz = Class.forName(className);
        // 利用反射创建对象
        A a = (A)clazz.newInstance();
        // 利用反射获取print方法
        Method printMethod = clazz.getMethod("showString");
        printMethod.invoke(a);
    }
}
class A {
    public void showString() {
        System.out.println("一定要学好Java");
    }
}
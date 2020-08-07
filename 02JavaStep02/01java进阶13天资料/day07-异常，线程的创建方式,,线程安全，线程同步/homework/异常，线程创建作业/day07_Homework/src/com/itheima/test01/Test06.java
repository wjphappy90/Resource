package com.itheima.test01;

/**
 训练描述

 请使用代码实现
 1. 每一个学生(Student)都有学号,姓名和分数,分数永远不能为为负数。
 2. 如果试图给学生赋值一个负数,抛出一个自定异常 。

 */
public class Test06 {
    public static void main(String[] args) {
        // i.使用满参构造方法创建Student对象,分数传入一个负数,运行程序
        // Student s = new Student("景甜", -10);
        // ii.由于一旦遇到异常,后面的代码的将不在执行,所以需要注释掉上面的代码

        // iii.使用空参构造创建Student对象
        Student s = new Student();
        // iv.调用setScore(int score)方法,传入一个正数,运行程序
        s.setScore(100);
        // v.调用setScore(int score)方法,传入一个负数,运行程序
        s.setScore(-5);
    }
}

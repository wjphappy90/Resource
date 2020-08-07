package com.heima.serDemo.domain;

import java.io.Serializable;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
public class Student implements Serializable{
    //姓名
    private String name;
    //年龄
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /*
        分析:
            创建StringBuilder对象
            先追加一个当前类的类名,以及大括号、成员变量的名字以及='
            再追加成员变量对应的值
            再追加', 成员变量的名字以及=
            最后再次追加成员变量的名字 和 大括号
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{name='");
        sb.append(this.name);
        sb.append("', age=");
        sb.append(this.age);
        sb.append("}");
        return sb.toString();
    }
}


/*
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
 */
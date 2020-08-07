package com.itheima.test08;

import java.util.Arrays;

/**
 * 1. 对Java基础班学生的考试成绩进行排序
 * - 定义一个学生类，有两个属性。姓名，考试成绩
 * - 在测试类中定义一个学生数组，存储学生信息。
 * - 使用Lambda省略格式写法对学生数组按照考试成绩由高到低进行排序。
 */
public class Demo01 {
    public static void main(String[] args) {
        // 本来成绩乱序的对象数组 
        Student[] array = new Student[3];
        array[0] = new Student("张三",90);
        array[1] = new Student("李四",99);
        array[2] = new Student("老王",87);
        //使用lambda省略格式排序 
        Arrays.sort(array,(s1,s2)-> s2.getScore() - s1.getScore());
        // 遍历输出
        for (Student stu:array
             ) {
            System.out.println(stu);
        }
    }
}

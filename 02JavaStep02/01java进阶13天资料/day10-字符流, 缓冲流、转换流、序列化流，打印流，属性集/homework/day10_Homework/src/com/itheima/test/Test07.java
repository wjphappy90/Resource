package com.itheima.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        // 创建学生对象
        Student s = new Student("jack",20,"男");
        // 创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stu.txt"));
        // 将学生对象保存文件中
        oos.writeObject(s);
        // 关闭流并释放资源
        oos.close();
    }
}

class Student implements Serializable {
    private static final long serialVersionUID = 4983659706961705248L;
    private String name;
    private int age;
    private String gender;

    public Student() {
    }
    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}

package com.heima.serDemo.demo;

import com.heima.serDemo.domain.Student;

import java.io.*;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
public class SerTest01 {
    public static void main(String[] args) throws Exception {
        //调用写数据的方法
        writeObject();
        //调用读数据的方法
        readObject();
    }

    //定义方法将对象数据写入到文件
    private static void writeObject() throws IOException {
        //创建对象操作流 --> 序列化 (将对象的数据写入到文件)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Test\\obj.txt"));
        //创建学生对象
        Student s1 = new Student("容颜老去蒋青青",32);
        //调用对象操作流写对象的方法,将对象的数据写入到文件
        oos.writeObject(s1);
        //关闭流
        oos.close();
    }

    //定义方法将文件的数据读取出来
    private static void readObject() throws IOException, ClassNotFoundException {
        //创建对象操作流 --> 反序列化 (将数据从文件中读取出来)
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Test\\obj.txt"));
        //调用方法读取一个对象
        Student stu = (Student) ois.readObject();
        //关闭流
        ois.close();
        //输出读取到对象的数据
        System.out.println(stu);
    }
}

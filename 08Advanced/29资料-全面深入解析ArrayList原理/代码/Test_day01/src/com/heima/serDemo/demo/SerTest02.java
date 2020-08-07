package com.heima.serDemo.demo;

import com.heima.serDemo.domain.Student;

import java.io.*;
import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 需求:
 *      已知4个学生对象,要求将4个学生对象序列化到当前模块根路径下的stu.txt中
 *      序列化成功后,请通过反序列化将文件中的数据读取出来,且打印到控制台
 *
 * 分析:
 *      创建ArrayList集合
 *      将要序列化的学生对象添加到集合
 *      序列化一次集合即可
 *      反序列化一次集合
 *      遍历集合
 */
public class SerTest02 {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("悔创阿里杰克马",51);
        Student s2 = new Student("会打一点长几颗",26);
        Student s3 = new Student("容颜老去蒋青青",32);
        Student s4 = new Student("将里最丑刘一飞",27);
        //创建ArrayList集合
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        //创建对象操作流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Test\\stu.txt"));
        //将集合写入到文件
        oos.writeObject(list);
        //关闭流
        oos.close();

        //反序列化
        //创建对象操作流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Test\\stu.txt"));
        //读数据
        ArrayList<Student> list1 = (ArrayList<Student>) ois.readObject();
        //遍历集合
        for (Student student : list1) {
            System.out.println(student);
        }
    }
}

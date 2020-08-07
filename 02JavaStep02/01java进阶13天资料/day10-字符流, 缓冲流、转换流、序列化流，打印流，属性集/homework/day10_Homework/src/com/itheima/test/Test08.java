package com.itheima.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test08 {
    public static void main(String[] args) throws Exception {
        // 创建字节输入流对象并关联文件
        FileInputStream fis = new FileInputStream("stu.txt");
        // 创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(fis);
        // 读取学生对象
        Student s = (Student) ois.readObject();
        System.out.println(s);
        // 关闭流
        ois.close();
    }

}

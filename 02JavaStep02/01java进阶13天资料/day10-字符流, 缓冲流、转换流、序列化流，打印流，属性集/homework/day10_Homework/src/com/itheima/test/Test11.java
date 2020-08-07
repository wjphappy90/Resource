package com.itheima.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test11 {
    public static void main(String[] args) throws Exception{
        // 创建集合对象，存放学生对象
        List<Student> stus = new ArrayList<Student>();
        // 添加学生对象
        stus.add(new Student("jack",20,"男"));
        stus.add(new Student("rose",18,"女"));
        stus.add(new Student("laowang",20,"男"));
        // 创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stus.txt"));
        // 将学生对象保存文件中
        oos.writeObject(stus);
        // 关闭流并释放资源
        oos.close();
    }

}

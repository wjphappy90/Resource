package com.itheima.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test06 {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流对象并关联文件
        FileInputStream fis = new FileInputStream("day10_Homework/a.txt");
        // 创建转换输入流对象
        InputStreamReader isr = new InputStreamReader(fis,"gbk");
        // 定义字符数组存放读取的内容
        char[] buffer = new char[1024];
        // 定义变量接收读取的字符个数
        int len = -1;
        while((len = isr.read(buffer)) != -1) {
            System.out.print(new String(buffer,0,len));
        }
        // 关闭流
        isr.close();
    }
}

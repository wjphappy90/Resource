package com.itheima.test;

import java.io.*;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流对象并关联文件路径
        FileInputStream fis = new FileInputStream("c:/b.png");
        // 利用字节输出流对象创建高效字节输出流对象
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 创建字节输出流对象并指定文件路径。
        FileOutputStream fos = new FileOutputStream("d:/b.png");
        // 利用字节输出流创建高效字节输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 定义变量接收读取的字节数
        int len = -1;
        // 循环读取图片数据
        while((len = bis.read()) != -1) {
            // 每读取一个字节的数据就写出到目标文件中
            bos.write(len);
        }
        // 关闭流
        bis.close();
        bos.close();
    }
}

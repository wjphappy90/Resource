package com.itheima.test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        // 创建字节输出流FileOutputStream对象并指定文件路径。
        FileOutputStream fos = new FileOutputStream("c:/e.txt");
        // 利用字节输出流创建高效字节输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 调用高效字节输出流对象的write(byte[] buff)方法写出一个字节数据
        bos.write("i love java".getBytes());
        // 关闭流
        bos.close();
    }
}

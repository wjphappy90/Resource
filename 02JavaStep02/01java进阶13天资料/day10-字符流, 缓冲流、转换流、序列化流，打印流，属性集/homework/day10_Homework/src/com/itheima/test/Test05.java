package com.itheima.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        // 要保存的字符串
        String content = "我爱Java";
        // 创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("day10_Homework/a.txt");
        // 创建转换输出流对象
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        // 调用方法写出数据
        osw.write(content);
        // 关闭流释放资源
        osw.close();
    }
}

package com.itheima.jdk11;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * JDK 11对于IO方法的改变。
 */
public class Demo06 {
    public static void main(String[] args) throws Exception {
        // Files类更方便的读写数据方法
        Files.writeString(Path.of("itheima.txt"),"Java的学习，JDK11新特性！");
        // Files类更方便的读数据方法
        String rs = Files.readString(Path.of("itheima.txt"), StandardCharsets.UTF_8);
        System.out.println(rs);

        // Reader新增方法：得到一个不执行任何操作的Reader
        Reader fr = Reader.nullReader();
        System.out.println(fr.read());

        // InputStream 还终于有了一个非常有用的方法：transferTo
        try(
                InputStream is = new FileInputStream("itheima.txt");
                OutputStream os = new FileOutputStream("newItheima.txt");
                ){
            // 开始把字节输入流中的全部字节数据转移到字节输出流中去。
            is.transferTo(os);
            System.out.println("复制完成！");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

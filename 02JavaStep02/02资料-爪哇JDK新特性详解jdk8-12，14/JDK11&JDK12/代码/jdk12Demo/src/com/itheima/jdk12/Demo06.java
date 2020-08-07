package com.itheima.jdk12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * JDK 12 : Files新增mismatch方法
 */
public class Demo06 {
    public static void main(String[] args) throws Exception {
        Writer fw = new FileWriter("a.txt");
        fw.write("add");
        fw.write("bbb");
        fw.write("ccc");
        fw.close();

        Writer fw1 = new FileWriter("b.txt");
        fw1.write("add3dd");
        fw1.write("bbb");
        fw1.write("ccc");
        fw1.close();
        // 两个文件的匹配：mismatch方法
        // 如果两个文件没有不匹配的，完全匹配返回-1.
        // 如果不匹配会返回第一个不匹配的字符索引值
        System.out.println(Files.mismatch(Path.of("a.txt") ,Path.of("b.txt") ));
    }
}

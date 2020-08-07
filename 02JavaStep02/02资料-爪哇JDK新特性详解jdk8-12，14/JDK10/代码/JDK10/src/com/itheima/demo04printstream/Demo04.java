package com.itheima.demo04printstream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class Demo04 {
    public static void main(String[] args) throws Exception {
        // test01();
        test02();
    }

    // 需求,使用GBK编码来打印内容
    public static void test02() throws IOException {
        PrintStream ps = new PrintStream("JDK10\\files\\ps2.txt", Charset.forName("gbk"));
        ps.print("你好中国");
        ps.close();
    }

    // 观察PrintStream默认使用什么编码?
    // IDEA默认使用的是UTF-8编码
    public static void test01() throws Exception {
        PrintStream ps = new PrintStream("JDK10\\files\\ps.txt");
        ps.println("你好中国");
        ps.close();
    }
}

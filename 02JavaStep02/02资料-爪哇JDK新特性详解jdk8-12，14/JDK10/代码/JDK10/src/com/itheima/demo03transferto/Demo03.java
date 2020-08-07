package com.itheima.demo03transferto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
    public long transferTo(Writer out) throws IOException {
        Objects.requireNonNull(out, "out");
        long transferred = 0;
        char[] buffer = new char[TRANSFER_BUFFER_SIZE];
        int nRead;
        while ((nRead = read(buffer, 0, TRANSFER_BUFFER_SIZE)) >= 0) {
            out.write(buffer, 0, nRead);
            transferred += nRead;
        }
        return transferred;
    }
 */
public class Demo03 {
    public static void main(String[] args) throws Exception {
        // test01();
        test02();
    }

    // 使用 transferTo方法复制文件
    public static void test02() throws IOException {
        FileReader fr = new FileReader("JDK10\\files\\a.txt");
        FileWriter fw = new FileWriter("JDK10\\files\\c.txt");

        // 将输入流中的数据转到输出流中
        fr.transferTo(fw);

        fw.close();
        fr.close();
    }

    // 以前IO流复制文件
    public static void test01() throws Exception {
        FileReader fr = new FileReader("JDK10\\files\\a.txt");
        FileWriter fw = new FileWriter("JDK10\\files\\b.txt");

        // 以前复制文件代码比较麻烦
        // 循环读写
        char[] chs = new char[1024];
        int len;
        while ((len = fr.read(chs)) != -1) {
            fw.write(chs, 0, len);
        }

        fw.close();
        fr.close();
    }
}

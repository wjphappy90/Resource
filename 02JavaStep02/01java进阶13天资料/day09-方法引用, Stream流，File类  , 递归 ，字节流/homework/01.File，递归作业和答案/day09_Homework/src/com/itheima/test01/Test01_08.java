package com.itheima.test01;

import java.io.File;
import java.io.IOException;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test01_08 {
    public static void main(String[] args) throws IOException {
        // 创建文件对象
        File f = new File("c:/aaa");
        // 获得文件夹下所有文件
        File[] files = f.listFiles();
        // 遍历文件数组
        for (File file : files) {
            // 将文件的名字打印到控制台
            System.out.println(file.getName());
        }
    }
}

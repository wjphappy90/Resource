package com.itheima.test02;

import java.io.File;
import java.io.FileFilter;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test02_04 {
    public static void main(String[] args) {
        // 创建文件夹对象
        File file = new File("c:/aaa");
        // 获得该文件夹下的所有java文件
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // 判断文件后缀名是否.java文件
                if(pathname.getName().endsWith(".java")) return true;
                return false;
            }
        });
        // 遍历文件数组,打印所有的Java文件路径
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}

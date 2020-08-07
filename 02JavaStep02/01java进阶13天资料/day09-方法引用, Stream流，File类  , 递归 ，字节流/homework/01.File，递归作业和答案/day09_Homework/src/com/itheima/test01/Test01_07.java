package com.itheima.test01;

import java.io.File;
import java.io.IOException;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test01_07 {
    public static void main(String[] args) throws IOException {
        // 创建文件对象
        File f1 = new File("c:/b.txt");
        // 判断是否是一个文件
        if(f1.isFile()) {
            System.out.println(f1.getName()+"是一个文件");
        }  else {
            System.out.println(f1.getName()+"不是一个文件");
        }
        // 创建文件对象
        File f2 = new File("c:/aaaa");
        // 判断是否是一个文件夹
        if(f1.isDirectory()) {
            System.out.println(f1.getName()+"是一个文件夹");
        }  else {
            System.out.println(f1.getName()+"不是一个文件夹");
        }
    }
}

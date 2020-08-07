package com.itheima.test02;

import java.io.File;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test02_03 {
    public static void main(String[] args) {
        // 创建文件夹对象
        File dir = new File("c:/aaa");
        // 调用递归方法
        printFiles(dir);
    }
    /*
     * 递归方法：遍历指定文件夹的所有文件
     */
    public static void printFiles(File dir){
        // 获得该文件夹下的所有文件
        File[] files = dir.listFiles();
        // 遍历文件数组
        for (File f : files) {
            if(f.isFile()) { // 是文件
                System.out.println(f.getAbsolutePath());
            } else { // 是文件夹，递归调用当前方法
                printFiles(f);
            }
        }
    }
}

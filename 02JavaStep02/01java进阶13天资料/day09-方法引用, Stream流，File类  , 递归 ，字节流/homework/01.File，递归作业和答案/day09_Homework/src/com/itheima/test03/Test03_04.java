package com.itheima.test03;

import java.io.File;
import java.util.Scanner;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test03_04 {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径：");
        // 接收用户输入的路径
        String filePath = sc.nextLine();
        // 根据路径字符串创建文件对象
        File dir = new File(filePath);
        // 打印目录结构
        printDir(dir,0);
    }

    /*
     * 打印目录结构
     * level:表示目录的层次
     */
    public static void printDir(File f, int level){
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(f.getName());
        if(f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                printDir(file,level + 1);
            }
        }
    }
}

package com.itheima.test02;

import java.io.File;
import java.util.Scanner;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test02_02 {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        // 提示用户输入一个文件路径
        System.out.println("请输入一个文件路径:");
        // 接收用户输入的文件路径
        String filePath = sc.nextLine();
        // 根据文件路径创建文件对象
        File file = new File(filePath);
        // 判断是否是文件
        if(file.isFile()) {
            // 输出文件大小
            System.out.println("文件大小为：" + file.length());
        } else {
            // 是文件夹
            // 定义变量统计文件大小之和
            int length = 0;
            // 获得该文件夹下的所有文件
            File[] files = file.listFiles();
            // 遍历文件数组
            for (File f : files) {
                if(f.isFile()) {
                    // 累加文件大小
                    length += f.length();
                }
            }
            // 输出文件夹文件的总大小
            System.out.println("文件总大小为：" + length);
        }
    }
}

package com.itheima.test02;

import java.io.File;
import java.util.Scanner;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test02_05 {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        // 提示用户输入一个文件路径
        System.out.println("请输入一个文件夹路径:");
        // 接收用户输入的文件夹路径
        String dirPath = sc.nextLine();
        // 根据文件夹路径创建文件对象
        File dir = new File(dirPath);
        // 获得该文件夹下的所有文件
        File[] files = dir.listFiles();
        // 遍历文件数组删除每一个文件
        for (File file : files) {
            // 删除文件
            file.delete();
        }
        // 删除文件夹
        System.out.println(dir.delete()?"删除成功":"删除失败");
    }
}

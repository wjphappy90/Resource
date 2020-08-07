package com.itheima.test02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test02_01 {
    public static void main(String[] args) {
        try {
            // 创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            // 提示用户输入一个文件路径
            System.out.println("请输入一个文件路径:");
            // 接收用户输入的文件路径
            String filePath = sc.nextLine();
            // 根据文件路径创建文件对象
            File file = new File(filePath);
            // 判断文件是否存在
            if(!file.exists()) {
                // 不存在，则创建文件
                file.createNewFile();
            } else {
                // 输出文件大小
                System.out.println("文件大小为：" + file.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

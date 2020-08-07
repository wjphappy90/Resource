package com.itheima.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test04 {
    public static void main(String[] args) throws Exception {
        //键盘录入3个字符串并写入项目根路径下的data.txt文件中
        writeString2File();
        //验证码验证
        verifyCode();
    }
    /**
     * 验证码验证
     * @throws Exception 
     */
    private static void verifyCode() throws Exception {
        //创建ArrayList集合，用于存储文件中的3个验证码
        ArrayList<String> list = new ArrayList<>();
        //创建高效字符缓冲输入流对象,并和data.txt文件关联
        BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")));
        String line = null;
        //循环读取每一行
        while(null!=(line = br.readLine())) {
            //将读到的每一行信息存入到list集合中
            list.add(line);
        }
        //关闭流对象
        br.close();
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //提示用户输入验证码
        System.out.println("请输入一个验证码");
        String code = sc.nextLine();
        if(list.contains(code)) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }
    }
    /**
     * 键盘录入3个字符串并写入项目根路径下的data.txt文件中
     * @throws Exception 
     */
    private static void writeString2File() throws Exception {
        //创建高效字符缓冲输出流对象并和data.txt文件关联
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data.txt")));
        String line = null;
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<3;i++) {
            System.out.println("请输入第"+(i+1)+"个字符串验证码");
            //读取用户键盘录入的一行验证码信息
            line = sc.nextLine();
            //将读取到的一行验证码写入到文件中
            bw.write(line);
            //写入换行符
            bw.newLine();
        }
        //关闭流对象
        bw.close();
    }
}

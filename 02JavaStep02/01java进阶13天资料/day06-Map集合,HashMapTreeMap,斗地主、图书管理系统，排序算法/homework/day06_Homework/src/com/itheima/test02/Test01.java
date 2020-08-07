package com.itheima.test02;

import java.util.HashMap;
import java.util.Scanner;


/*
 * 使用键盘录入5个学生信息,录入格式为:”姓名,年龄”.将这5个学生信息存入Map集合中,key是姓名,value是年龄
 */
public class Test01 {
    public static void main(String[] args) {
        // 1.创建HashMap
        HashMap<String, Integer> hm = new HashMap<>();

        // 2.创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 3.循环判断只要HashMap数量是否小于5
        while (hm.size() < 5) {
            // 4.HashMap数量小于5个就让用户接着输入
            System.out.println("请输入姓名和年龄,格式为:姓名,年龄");
            String line = sc.nextLine();

            // 5.使用,分割用户输入的字符串
            String[] strings = line.split(",");

            // 6.将分割后的索引为0的字符串作为key,索引为1的字符串作为value,放入HashMap中
            hm.put(strings[0], Integer.valueOf(strings[1]));
        }

        // 7.输出HashMap中的数据
        System.out.println(hm);
    }
}
package com.itheima.test02;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
	利用键盘录入，输入一个字符串,统计该字符串中各个字符的数量
	如用户输入字符串:"hello world java",程序输出结果：h(1)e(1)l(3)o(2) (2)w(1)r(1)d(1)j(1)a(2)v(1)
	注：输出结果不要求顺序一致
 */
public class Test04 {
    public static void main(String[] args) {
        // 1.创建键盘输入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一行字符串:");

        // 2.使用nextLine从键盘中读取一行内容
        String line = sc.nextLine();

        // 3.将字符串转换成字符数组
        char[] charArray = line.toCharArray();

        // 4.创建map集合，用来存放字符：key是字符 value是字符出现的个数
        Map<Character,Integer> map = new HashMap<>();

        // 5.遍历字符数组
        for (char c : charArray) {
            // 6.拿到每个字符,去map中查看是否有保存对应的次数
            Integer count = map.get(c);

            if (count == null) {
                // 7.如果这个字符没有保存次数,就设置为1次
                map.put(c, 1);
            } else {
                // 8.如果这个字符有保存次数,就设置为原来的次数+1次
                map.put(c, count + 1);
            }
        }

        // 9.创建字符串缓冲区对象
        StringBuilder sb = new StringBuilder();
        // 10.按题目要求拼接字符串
        for(Entry<Character,Integer> entry : map.entrySet()) {
            sb.append(entry.getKey() + "(" + entry.getValue() + ")");
        }
        // 11.输出结果
        System.out.println(sb);
    }

}
package com.itheima.test02;


import java.util.HashMap;
import java.util.Scanner;

/*
	键盘录入一个字符串,分别统计出其中英文字母、空格、数字和其它字符的数量,输出结果:”其他=1, 空格=2, 字母=12, 数字=6”
 */
public class Test05 {
    public static void main(String[] args) {
        // 6.创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 7.使用nextLine获取用户录入的字符串
        System.out.println("请录入一串字符串");
        String line = sc.nextLine();

        // 8.定义一个Map用于统计,字母,空格,数字和其他字符的数量,key是字符value是字符出现的次数
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // 9.将输入的字符串转成字符
        char[] charArray = line.toCharArray();

        // 10.遍历字符串数组中的每一个字符
        for (char ch : charArray) {
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                // 11.如果ch是一个字符,调用countingKey方法传入(map, "字母")作为参数
                countingKey(map, "字母");
            } else if (ch == ' ') {
                // 12.如果字符是一个空格,调用countingKey方法传入(map, "空格")作为参数
                countingKey(map, "空格");
            } else if (ch >= '0' && ch <= '9') {
                // 13.如果字符是一个数字,调用countingKey方法传入(map, "数字")作为参数
                countingKey(map, "数字");
            } else {
                // 14.如果字符是一个其他,调用countingKey方法传入(map, "其他")作为参数
                countingKey(map, "其他");
            }
        }
        // 15.打印统计结果
        System.out.println(map);
    }

    // 1.定义countingKey(HashMap<String, Integer> map, String key)方法.用于统计key出现的次数.调用一次,让key所对应的次数+1.
    private static void countingKey(HashMap<String, Integer> map, String key) {
        // 2.在countingKey方法中.使用get方法从map中取出key的值
        Integer num = map.get(key);
        // 3.如果为空,说明key第一次出现
        if (num == null) {
            // 4.放入key,把次数设置为1
            map.put(key, 1);
        } else {
            // 5.如果之前,已经有key了,就把key的次数+1
            map.put(key, num + 1);
        }
    }

}
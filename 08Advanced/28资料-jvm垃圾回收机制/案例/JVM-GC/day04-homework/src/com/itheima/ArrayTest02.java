package com.itheima;

import java.util.Scanner;

//请使用动态初始化的方式，定义一个整型数组，数组的长度由键盘录入（长度1-5即可）。
// 然后再使用键盘录入的方式，分别为数组中的元素赋值。遍历数组，查看每个元素。运行效果如
public class ArrayTest02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i+1) + "个数字");
            arr[i] = sc.nextInt();
        }
        //遍历数组
        System.out.println("数组遍历结果");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

package com.itheima;

import java.util.Scanner;

//请使用动态初始化的方式，定义一个长度为3的整型数组，
// 然后使用键盘录入的方式，分别为数组中的元素赋值。遍历数组，查看每个元素。运行结果如下：
public class ArrayTest01 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        Scanner sc = new Scanner(System.in);
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

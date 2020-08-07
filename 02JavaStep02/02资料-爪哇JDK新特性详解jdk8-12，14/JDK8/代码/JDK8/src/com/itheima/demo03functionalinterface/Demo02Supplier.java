package com.itheima.demo03functionalinterface;


import java.util.Arrays;
import java.util.function.Supplier;

public class Demo02Supplier {
    // 使用Lambda表达式返回数组元素最大值
    public static void main(String[] args) {
        System.out.println("开始了");
        printMax(() -> {
            int[] arr = {11, 99, 88, 77, 22};
            Arrays.sort(arr); // 升序排序
            return arr[arr.length - 1];
        });
    }

    public static void printMax(Supplier<Integer> supplier) {
        System.out.println("aa");
        int max = supplier.get();
        System.out.println("max = " + max);
    }
}

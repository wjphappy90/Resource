package com.itheima.demo03functionalinterface;

import java.util.function.Function;

public class Demo06FunctionAndThen {
    // 使用Lambda表达式将字符串转成数字, 第二个操作将这个数字乘以5
    public static void main(String[] args) {
        getNumber((String str) -> {
            return Integer.parseInt(str);
        }, (Integer i) -> {
            return i * 5;
        });
    }

    public static void getNumber(Function<String, Integer> f1, Function<Integer, Integer> f2) {
        System.out.println("aa");
        // Integer num = f1.apply("6");
        // Integer num2 = f2.apply(num);
        Integer num2 = f1.andThen(f2).apply("6");
        System.out.println("num2 = " + num2);
    }
}

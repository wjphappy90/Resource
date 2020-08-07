package com.itheima.demo03functionalinterface;

import java.util.function.Function;

public class Demo05Function {
    // 使用Lambda表达式将字符串转成数字
    public static void main(String[] args) {
        System.out.println("开始");
        getNumber((String str) -> {
            int i = Integer.parseInt(str);
            return i;
        });
    }

    public static void getNumber(Function<String, Integer> function) {
        System.out.println("aa");
        Integer num1 = function.apply("10");
        System.out.println("num1 = " + num1);
    }
}

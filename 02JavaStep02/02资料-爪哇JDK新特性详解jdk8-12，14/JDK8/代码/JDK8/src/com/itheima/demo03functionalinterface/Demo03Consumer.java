package com.itheima.demo03functionalinterface;

import java.util.function.Consumer;

public class Demo03Consumer {
    // 使用Lambda表达式将一个字符串转成大写的字符串
    public static void main(String[] args) {
        System.out.println("开始啦");
        printHello((String str) -> {
            System.out.println(str.toUpperCase());
        });
    }

    public static void printHello(Consumer<String> consumer) {
        System.out.println("aaa");
        consumer.accept("Hello World");
    }
}

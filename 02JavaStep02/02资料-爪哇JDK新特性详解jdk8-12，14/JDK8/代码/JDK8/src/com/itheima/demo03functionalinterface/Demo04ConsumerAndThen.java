package com.itheima.demo03functionalinterface;


import java.util.function.Consumer;

public class Demo04ConsumerAndThen {
    // 使用Lambda表达式先将一个字符串转成小写的字符串,再转成大写
    public static void main(String[] args) {
        System.out.println("开始啦");
        printHello((String str) -> {
            System.out.println(str.toLowerCase());
        }, (String str) -> {
            System.out.println(str.toUpperCase());
        });
    }

    public static void printHello(Consumer<String> c1, Consumer<String> c2) {
        System.out.println("aa");
        String str = "Hello World";
        // c1.accept(str);
        // c2.accept(str);

        c2.andThen(c1).accept(str);

    }
}

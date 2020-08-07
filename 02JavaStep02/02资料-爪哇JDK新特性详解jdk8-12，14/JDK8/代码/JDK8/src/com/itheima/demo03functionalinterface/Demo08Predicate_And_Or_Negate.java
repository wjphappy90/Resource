package com.itheima.demo03functionalinterface;


import java.util.function.Predicate;

public class Demo08Predicate_And_Or_Negate {
    // 使用Lambda表达式判断一个字符串中即包含W,也包含H
    // 使用Lambda表达式判断一个字符串中包含W或者包含H
    // 使用Lambda表达式判断一个字符串中不包含W
    public static void main(String[] args) {
        test((String str) -> {
            // 判断是否包含W
            return str.contains("W");
        }, (String str) -> {
            // 判断是否包含H
            return str.contains("H");
        });
    }

    public static void test(Predicate<String> p1, Predicate<String> p2) {
        // String str = "Hello orld";
        // boolean b1 = p1.test(str);
        // boolean b2 = p2.test(str);
        // if (b1 && b2) {
        //     System.out.println("即包含W,也包含H");
        // }
        // 使用Lambda表达式判断一个字符串中即包含W,也包含H
        String str = "Hello World";
        boolean b = p1.and(p2).test(str);
        if (b) {
            System.out.println("即包含W,也包含H");
        }

        // 使用Lambda表达式判断一个字符串中包含W或者包含H
        boolean b1 = p1.or(p2).test(str);
        if (b1) {
            System.out.println("包含W或者包含H");
        }
        // 使用Lambda表达式判断一个字符串中不包含W
        boolean b2 = p1.negate().test("Hello W");
        // negate相当于取反 !boolean
        if (b2) {
            System.out.println("不包含W");
        }
    }
}

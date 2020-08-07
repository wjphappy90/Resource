package com.itheima.jdk11;

/**
 * JDK 11对于String处理方法的增强
 */
public class Demo04 {
    public static void main(String[] args) {
        // 判断字符串是否为空白
        System.out.println("判断字符串是否为空白："+"    ".isBlank()); // true
        System.out.println("判断字符串是否为空："+"    ".isEmpty());  // false

        // 去除字符串的前后空白
        // JDK 11去除前后空白的方法strip是支持去除全角空格的
        System.out.println("去除字符串的前后空白:"+"　　　itheima　　　".strip());
        System.out.println("去除字符串的前后空格:"+"　　　itheima　　　".trim());

        // 去除字符串的首部空白
        System.out.println("　　　itheima　　　".stripLeading()+"aaa");

        // 去除字符串的尾部空白
        System.out.println("　　　itheima　　　".stripTrailing()+"aaa");

        // 统计字符串中的行数
        System.out.println("A\nB\nC\nD\n".lines().count());
    }
}

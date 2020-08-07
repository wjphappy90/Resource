package com.itheima.GC.region;

public class StringTest {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println("--------------------");
        //在运行过程中添加进常量池中
        System.out.println(str1.intern());
        System.out.println(str1.intern() == str2.intern());
    }
}

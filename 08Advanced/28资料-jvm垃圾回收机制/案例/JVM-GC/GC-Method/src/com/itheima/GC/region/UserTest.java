package com.itheima.GC.region;

public class UserTest {
    public static void main(String[] args) {
        //创建对象
        User user = new User("tom",30);
        //数组
        int[] arr = new int[3];
//        String str1 = "hello";
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1.intern());
        System.out.println(str2.intern());
        System.out.println(str1.intern() == str2.intern());
    }
}

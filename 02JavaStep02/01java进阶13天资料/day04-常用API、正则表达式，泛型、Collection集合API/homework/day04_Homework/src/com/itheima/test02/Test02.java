package com.itheima.test02;

/**
 需求说明

 测试以下两个操作执行所消耗的时间

 1. 创建String对象，使用for循环对字符串进行拼接，计算执行10000次for循环花费的时间。
 2. 创建StringBuilder对象，使用for循环对字符串进行拼接，计算执行10000次for循环花费的时间。

 */
public class Test02 {
    public static void main(String[] args) {
        // a) 使用System的currentTimeMillis()方法获取当前操作系统的毫秒值,作用程序执行的开始时间,使用start变量接收
        long start = System.currentTimeMillis();
        // b)需要测试执行性能的代码
        testString(); //消耗时间: 29295毫秒
        // testStringBuilder();// 消耗时间:6毫秒
        // c)使用System的currentTimeMillis()方法获取当前操作系统的毫秒值,作用程序执行的结束时间,使用end变量接收
        long end = System.currentTimeMillis();
        // d)计算代码执行花费的时间 end - start,输出代码执行消耗的时间
        System.out.println("所花费的时间为:" + (end - start));
    }

    // 3.写一个静态方法: testString(),在该方法中
    public static void testString() {
        // a)定义一个字符串 str,内容随意
        String str = "hello";
        // b)写一个循环100000次for循环,在循环中写上
        for (int i = 0; i < 100000; i++) {
            // i.str +=”随机内容” ; 这里不要写str += (str+”xxx”) 这样会导致堆内存溢出错误.
            str += "world";
        }
    }

    // 4. 写一个静态方法:testStringBuilder(),在方法中
    public static void testStringBuilder() {
        // a)创建一个StringBuilder对象sb,初始内容与testString()中的字符串相同
        StringBuilder sb = new StringBuilder("hello");
        // b)写一个循环100000次for循环,在循环中写上
        for (int i = 0; i < 100000; i++) {
            // i.调用sb.append()方法,传入的内容与testString()方法中+=后面的内容一样
            sb.append("world");
        }
        // c)循环结束调用sb.toString()方法转换为字符串
        String newStr = sb.toString();
    }
}

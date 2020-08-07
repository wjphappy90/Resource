package com.itheima.test01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 需求说明
    把你的生日字符串(格式：1992-10-20)转换为对应的日期对象.
 */
public class Test04 {
    public static void main(String[] args) throws ParseException {
        // a)创建SimpleDateFormat对象 df,并制定日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // b)调用df的parse(String str)方法,传入你的生日字符串;结束返回的日期对象
        Date date = df.parse("1999-09-09");
        // c)打印这个日期对象
        System.out.println(date);
    }
}

package com.itheima.test01;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 需求说明
 获取当前的日期,并把这个日期转换为指定格式的字符串。如：2088-08-08 08:08:08
 */
public class Test03 {
    public static void main(String[] args){
        // a)获取当前日期对象 now;
        Date now = new Date();
        // b)创建SimpleDateFormat对象 df,并制定日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // c)调用df的format(Date date) 方法,传入now; 接收返回的字符串
        String datestr = df.format(now);
        // d)打印这个字符串
        System.out.println(datestr);
    }
}


package com.itheima.test03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 需求说明

 使用SimpleDateFormat类把2016-12-18转换为2016年12月18日.

 提示: SimpleDateFormat对象的日期格式字符串可以通过applyPattern(String pattern)进行修改

 */
public class Test01 {
    public static void main(String[] args) throws ParseException {
        // a)创建SimpleDateFormat对象 df,指定日期模式为yyyy-MM-dd
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // b)调用df的parse(String str) 方法传入2016-12-18,得到对应日期类型
        Date date = df.parse("2016-12-18");
        // c)修改df的日期模式为yyyy年MM月dd日
        df.applyPattern("yyyy年MM月dd日");
        // d)调用df的format(Date date) 传入刚才转换为日期
        String newStr = df.format(date);
        // e)打印转换后的字符串
        System.out.println(newStr);
    }
}

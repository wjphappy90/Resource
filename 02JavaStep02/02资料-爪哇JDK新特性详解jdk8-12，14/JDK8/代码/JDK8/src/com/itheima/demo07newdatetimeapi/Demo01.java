package com.itheima.demo07newdatetimeapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) {
        // 旧版日期时间 API 存在的问题
        // 1.设计部合理
        Date now = new Date(1985, 9, 23);
        System.out.println(now);

        // 2.时间格式化和解析是线程不安全的
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    Date date = sdf.parse("2019-09-09");
                    System.out.println("date = " + date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

package com.itheima.demo07newdatetimeapi;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

public class Demo02 {
    @Test
    public void testLocalDate() {
        // LocalDate: 表示日期,有年月日
        LocalDate date = LocalDate.of(2018, 8, 8);
        System.out.println("date = " + date);

        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
    }

    @Test
    public void testLocalTime() {
        // LocalTime: 表示时间,有时分秒
        LocalTime time = LocalTime.of(13, 26, 39);
        System.out.println("time = " + time);

        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());
    }

    @Test
    public void testLocalDateTime() {
        // LocalDateTime: LocalDate + LocalTime 有年月日 时分秒
        LocalDateTime dateTime = LocalDateTime.of(2018, 7, 12, 13, 28, 59);
        System.out.println("dateTime = " + dateTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getHour());
        System.out.println(now.getSecond());
    }

    // 修改时间
    @Test
    public void testLocalDateTime2() {
        LocalDateTime now = LocalDateTime.now();
        // 修改时间,修改后返回新的时间对象
        LocalDateTime dateTime = now.withYear(9102);
        System.out.println("dateTime = " + dateTime);
        System.out.println("now == dateTime: " + (now == dateTime));

        // 增加或减去时间
        // plus: 增加指定的时间
        // minus: 减去指定的时间
        System.out.println(now.plusYears(2));
        System.out.println(now.minusYears(10));
    }

    // 比较时间
    @Test
    public void testEquals() {
        LocalDateTime dateTime = LocalDateTime.of(2018, 7, 12, 13, 28, 59);

        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.isAfter(dateTime)); // true
        System.out.println(now.isBefore(dateTime)); // false
        System.out.println(now.isEqual(dateTime)); //  false
    }


    // 日期格式化
    @Test
    public void test04() {
        // 创建一个日期时间
        LocalDateTime now = LocalDateTime.now();

        // 格式化
        // 指定时间的格式
        // JDK自带的时间格式
        // DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd HH时mm分ss秒");

        String format = now.format(dtf);
        System.out.println("format = " + format);

        // 解析
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                LocalDateTime parse = LocalDateTime.parse("2016年09月20 15时16分16秒", dtf);
                System.out.println("parse = " + parse);
            }).start();
        }
    }

    // 时间戳
    @Test
    public void test07() {
        // Instant内部保存了秒和纳秒,一般不是给用户使用的,而是方便我们程序做一些统计的.
        Instant now = Instant.now();
        System.out.println("now = " + now); // 2019-10-19T07:30:42.629520400Z

        Instant plus = now.plusSeconds(20);
        System.out.println("plus = " + plus);

        Instant minus = now.minusSeconds(20);
        System.out.println("minus = " + minus);

        // 得到秒纳秒
        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
    }

    // Duration/Period类: 计算日期时间差
    @Test
    public void test08() {
        // Duration计算时间的距离
        LocalTime now = LocalTime.now();
        LocalTime time = LocalTime.of(14, 15, 20);
        Duration duration = Duration.between(time, now);
        System.out.println("相差的天数:" + duration.toDays());
        System.out.println("相差的小时数:" + duration.toHours());
        System.out.println("相差的分钟数:" + duration.toMinutes());
        System.out.println("相差的秒数:" + duration.toSeconds());

        // Period计算日期的距离
        LocalDate nowDate = LocalDate.now();
        LocalDate date = LocalDate.of(1998, 8, 8);
        // 让后面的时间减去前面的时间
        Period period = Period.between(date, nowDate);
        System.out.println("相差的年:" + period.getYears());
        System.out.println("相差的月:" + period.getMonths());
        System.out.println("相差的天:" + period.getDays());
    }

    // TemporalAdjuster类:自定义调整时间
    @Test
    public void test09() {
        LocalDateTime now = LocalDateTime.now();

        // 将日期调整到“下一个月的第一天”操作。
        TemporalAdjuster firstDayOfNextMonth = temporal -> {
            // temporal要调整的时间
            LocalDateTime dateTime = (LocalDateTime)temporal;
            return dateTime.plusMonths(1).withDayOfMonth(1); // 下一个月的第一天
        };

        // JDK中自带了很多时间调整器
        // LocalDateTime newDateTime = now.with(firstDayOfNextMonth);
        LocalDateTime newDateTime = now.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("newDateTime = " + newDateTime);
    }


    // 设置日期时间的时区
    @Test
    public void test10() {
        // 1.获取所有的时区ID
        // ZoneId.getAvailableZoneIds().forEach(System.out::println);

        // 不带时间,获取计算机的当前时间
        LocalDateTime now = LocalDateTime.now(); // 中国使用的东八区的时区.比标准时间早8个小时
        System.out.println("now = " + now);

        // 2.操作带时区的类
        // now(Clock.systemUTC()): 创建世界标准时间
        ZonedDateTime bz = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("bz = " + bz);

        // now(): 使用计算机的默认的时区,创建日期时间
        ZonedDateTime now1 = ZonedDateTime.now();
        System.out.println("now1 = " + now1); // 2019-10-19T16:19:44.007153500+08:00[Asia/Shanghai]

        // 使用指定的时区创建日期时间
        ZonedDateTime now2 = ZonedDateTime.now(ZoneId.of("America/Vancouver"));
        System.out.println("now2 = " + now2); // 2019-10-19T01:53:41.225898600-07:00[America/Vancouver]

        // 修改时区
        // withZoneSameInstant: 即更改时区,也更改时间
        ZonedDateTime withZoneSameInstant = now2.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        System.out.println("withZoneSameInstant = " + withZoneSameInstant); // 2019-10-19T16:53:41.225898600+08:00[Asia/Shanghai]

        // withZoneSameLocal: 只更改时区,不更改时间
        ZonedDateTime withZoneSameLocal = now2.withZoneSameLocal(ZoneId.of("Asia/Shanghai"));
        System.out.println("withZoneSameLocal = " + withZoneSameLocal); // 2019-10-19T01:54:52.058871300+08:00[Asia/Shanghai]
    }
}

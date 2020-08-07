package com.itheima.jdk12;

import java.text.NumberFormat;
import java.util.Locale;

public class Demo07 {
    public static void main(String[] args) {
        //例如：
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        String result = fmt.format(1000);
        System.out.println(result);
        // 上面的例子导致“1K”。

        var cnf = NumberFormat.getCompactNumberInstance(Locale.CHINA,
                NumberFormat.Style.SHORT);
        System.out.println(cnf.format(3_0000));
        System.out.println(cnf.format(3_4200));
        System.out.println(cnf.format(3_000_000));
        System.out.println(cnf.format(3L << 30));
        System.out.println(cnf.format(3L << 50));
        System.out.println(cnf.format(3L << 60));
    }
}

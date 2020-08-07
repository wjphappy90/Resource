package com.itheima.jdk12;

import java.util.function.Function;

/**
 * JDK 12 String新增方法。
 */
public class Demo05 {
    public static void main(String[] args) {
        var rs = "itheima".transform(s -> s +"学习Java!").transform(s -> s.toUpperCase());
        System.out.println(rs);
        System.out.println("=======================");
        var rs1 = "A\nB\bC\n".indent(3);
        System.out.println(rs1);
    }
}

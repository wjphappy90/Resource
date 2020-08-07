package com.itheima.memory.stack;

public class Demo01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        method(a, b);
    }

    private static void method(int a, int b) {
        a += 10;
        b += 20;
        method2(a, b);
    }

    private static void method2(int a, int b) {
        int c = a + b;
        System.out.println(c);
    }
}

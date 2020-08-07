package com.itheima.memory.stack;

/*
java.lang.StackOverflowError
-Xss256k：次数减少
-Xss10m：次数变多
 */
public class Demo02 {
    private static int count;

    public static void method() {
        count++;
        method();
    }


    public static void main(String[] args) {
        try {
            method();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }
}


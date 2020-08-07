package com.itheima.GC.region;

public class StackTest {
    public static void main(String[] args) {
        //定义局部变量
        int num1 = 10;
        int num2 = 20;
        int max = getMax(num1, num2);
        System.out.println(max);
    }
    /**
     * 获取最大值
     */
    public static int getMax(int num1, int num2){
        return num1 > num2 ? num1 : num2;
    }
}

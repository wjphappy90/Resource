package com.itheima.GC.exception;

public class StackOOM {
    public static void main(String[] args) {
        //从第三个月开始，每个月的兔子数量等于前两个月之和
        int rabbitNum = getRabbitNum(20);
        System.out.println(rabbitNum);
    }
    public static int getRabbitNum(int month){
        return getRabbitNum(month - 1) + getRabbitNum(month - 2);
    }
}

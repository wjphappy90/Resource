package com.itheima.switchdemo;

/**
    目标：jdk 13中switch依然是可以简化的
 */
public class SwitchDemo02 {
    public static void main(String[] args) {
        // 声明变量score，并为其赋值为'C'
        var score = 'C';
        // 执行switch分支语句
        switch (score) {
            case 'A' -> System.out.println("优秀");
            case 'B' ->  System.out.println("良好");
            case 'C' -> System.out.println("中");
            case 'D' ->  System.out.println("及格");
            case 'E' -> System.out.println("不及格");
            default -> System.out.println("数据非法！");
        }
    }
}

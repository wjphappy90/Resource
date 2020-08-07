package com.itheima.switchdemo;

/**
    目标：jdk 13中switch作为表达式
 */
public class SwitchDemo04 {
    public static void main(String[] args) {
        // 声明变量score，并为其赋值为'C'
        var score = 'B';
        // 执行switch分支语句
        String result = switch (score) {
            case 'A' -> "优秀";
            case 'B','C' ->  "良好";
            case 'D' ->  "及格";
            case 'E' , 'F'-> "不及格";
            default -> "数据非法！";
        };
        System.out.println( "结果是："+ result);
    }
}

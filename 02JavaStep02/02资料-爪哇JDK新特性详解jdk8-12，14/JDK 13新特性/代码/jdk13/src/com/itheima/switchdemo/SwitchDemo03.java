package com.itheima.switchdemo;

/**
    目标：jdk 13中switch作为表达式
 */
public class SwitchDemo03 {
    public static void main(String[] args) {
        // 声明变量score，并为其赋值为'C'
        var score = 'C';
        // 执行switch分支语句
        String result = switch (score) {
            case 'A' -> "优秀";
            case 'B' ->  "良好";
            case 'C' -> "中";
            case 'D' ->  "及格";
            case 'E' -> "不及格";
            default -> "数据非法！";
        };
        System.out.println( "结果是："+ result);
    }
}

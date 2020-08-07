package com.itheima.jdk12;

/**
 * JDK 12开始switch可以作为一个表达式返回执行的结果了。
 */
public class Demo03 {
    public static void main(String[] args) {
        var score = 'B';
        String rs = switch (score){
            case 'A' -> "优秀";
            case 'B' -> "良好";
            case 'C' -> "中";
            case 'D' -> "及格";
            case 'E' -> "较差";
            default -> "成绩数据非法！";
        };
        System.out.println("执行的结果："+rs);
    }
}

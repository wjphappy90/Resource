package com.itheima.jdk12;

/**
 * JDK 12开始switch可以支持多值匹配
 */
public class Demo04 {
    public static void main(String[] args) {
        var score = 'D';
        String rs = switch (score){
            case 'A','B' -> "优秀";
            case 'C','D' -> "中等";
            case 'E' -> "一般";
            default -> "成绩数据非法！";
        };
        System.out.println("执行的结果："+rs);
    }
}

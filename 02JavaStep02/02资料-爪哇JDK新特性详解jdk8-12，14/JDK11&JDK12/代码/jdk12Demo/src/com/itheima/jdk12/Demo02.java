package com.itheima.jdk12;

/**
 * JDK 12开始switch的新写法：不需要写break了。
 */
public class Demo02 {
    public static void main(String[] args) {
        var score = 'B';
        switch (score){
            case 'A' -> System.out.println("优秀");
            case 'B' -> System.out.println("良好");
            case 'C' -> System.out.println("中");
            case 'D' -> System.out.println("及格");
            case 'E' -> System.out.println("较差");
            default -> System.out.println("成绩数据非法！");
        }
    }
}

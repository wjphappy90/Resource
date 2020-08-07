package com.itheima.switchdemo;

/**
    目标：jdk 13中switch作为表达式:yield关键字返回一个结果数据
 */
public class SwitchDemo05 {
    public static void main(String[] args) {
        // 声明变量score，并为其赋值为'C'
        var score = 'F';
        // 执行switch分支语句
        String result = switch (score) {
            case 'A' -> "优秀";
            case 'B','C' ->  "良好";
            case 'D' ->  "及格";
            case 'E' , 'F'-> {
                if(score == 'E'){
                    yield score +"是还可以的";
                }else{
                    yield score +"不及格，补考";
                }
            }
            default -> "数据非法！";
        };
        System.out.println( "结果是："+ result);
    }
}

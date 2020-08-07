package com.itheima.ds_project05.dp;

import javax.sound.midi.Soundbank;

/**
 * 动态规划的思想解决斐波拉契数列重复计算的问题：
 * 自底向上方式
 */
public class FbPlus {

    public  static  int  fb(int n){
        // 数据合法性的校验
        if (n<=0){
            return -1;
        }
        // 创建我们备忘录
        int [] memory = new int[n+1];

        memory[1] =1;  // f(1)  =1
        memory[2] =1;  // f(2)  =1

        for ( int i=3;i<=n;i++){
            memory[i] =memory[i-1]+memory[i-2];
        }
        return memory[n];
    }

    public static void main(String[] args) {
        int i = fb(7);
        System.out.println(i);
    }


}

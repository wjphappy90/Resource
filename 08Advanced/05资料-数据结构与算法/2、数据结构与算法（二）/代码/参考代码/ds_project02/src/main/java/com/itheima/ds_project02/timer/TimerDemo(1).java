package com.itheima.ds_project02.timer;

import org.junit.Test;

/**
 * 算法的时间复杂度
 */
public class TimerDemo {

   public int sum1(int n) {
        int sum = 0; //执行一遍
        for ( int i = 1; i <= n; ++i) {//执行n遍
            sum = sum + i;//执行n遍
        }
        return sum;
    }

    public  int sum2(int n) {
        int sum = 0;//执行一遍
        for (int i = 1; i <= n; ++i) { //执行n遍
            for (int j = 1; j <= n; ++j) { //执行n*n遍
                sum = sum + i * j;//执行n*n遍
            }
        }
        return sum;
    }

    @Test
    public void  timerTest01(){
       //  记录程序执行开始时间
        long start = System.currentTimeMillis();
        this.sum1(100000000);
        // 记录程序执行结束时间
        long end =System.currentTimeMillis();
        //  计算程序执行过程中消耗时间
        long time = end -start;
        System.out.println(time);
    }
}

package com.itheima.ds_project02.algorithm.recursion;

import org.junit.Test;

import java.math.BigInteger;

/**
 * 阶乘问题
 * 阶乘的递推公式：n! = n*(n-1)*(n-2)*......*1，其中n>0
 */
public class Factorial {

    /**
     * 求一个数n的阶乘
     * @param n
     * @return
     */
    /*public int factorial(int n){
        if(n==0){
            return 1;
        }else {
            return n * factorial(n-1);
        }
    }*/
    
    public BigInteger factorial(int n){
        if(n==0){
            return BigInteger.ONE;
        }else {
            return BigInteger.valueOf(n).multiply(factorial(n-1));
        }
    }
    @Test
   public void test1(){
        //输出10的阶乘
        System.out.println(factorial(100));
   }
}

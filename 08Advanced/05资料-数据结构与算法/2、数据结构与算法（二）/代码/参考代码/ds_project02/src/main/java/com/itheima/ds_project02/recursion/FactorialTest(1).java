package com.itheima.ds_project02.recursion;

import java.math.BigInteger;

/**
 * 计算n！（n的阶乘）
 */
public class FactorialTest {

      // 递推公式  ： 0！=1  , n！=n*(n-1)!

    public static  int factorial( int n)
    {
          if(n==0){
              return  1;
          }else {
              return  n*factorial(n-1);
          }
    }


    public  static  BigInteger factorial2( int n){
        if(n==0){
            return BigInteger.ONE;
        }else {
            return BigInteger.valueOf(n).multiply(factorial2(n-1));
        }
    }


    public static void main(String[] args) {
      //  int factorial = factorial(100);
        BigInteger factorial2 = factorial2(100);
        // 5!= 5*4*3*2*1  =120
        //System.out.println(factorial);
        System.out.println(factorial2);
    }

        // 阶乘  n!  当我们n足够大的时候

        //  数组处理我们的阶乘的问题。
}

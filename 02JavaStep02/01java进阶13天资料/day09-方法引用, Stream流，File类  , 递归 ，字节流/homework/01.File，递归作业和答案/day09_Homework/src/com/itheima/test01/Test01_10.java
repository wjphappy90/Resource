package com.itheima.test01;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test01_10 {
    public static void main(String[] args) {
        int result = jc(10);
        System.out.println(result);
    }
    // 递归求阶乘方法
    public static int jc(int num) {
        // 递归出口
        if(num == 1) return 1;
        return num * jc(num - 1);
    }
}

package com.itheima.test01;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test01_09 {
    public static void main(String[] args) {
        int result = sum(100);
        System.out.println(result);
    }
    // 递归求和方法
    public static int sum(int num) {
        // 递归出口
        if(num == 1) return 1;
        return num + sum(num - 1);
    }
}

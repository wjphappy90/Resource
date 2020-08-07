package com.itheima.stack;

/**
 * Created by tanshuai on 2019/6/22.
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        for (int i=0; i<15; i++) {
            boolean push = stack.push(i);
            System.out.println("第"+(i+1)+"次存储数据为:"+i+",存储结果是:"+push);
        }
        // stack.push(1);
        for (int i=0; i<11; i++) {
            Object pop = stack.pop();
            System.out.println(pop);
        }
    }
}

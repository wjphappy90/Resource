package com.itheima.stack;

/**
 * Created by tanshuai on 2019/6/23.
 */
public class LinkedListStackTest {

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        for(int i=0;i<5;i++){
            stack.push(i+"");    
        }

        for(int i=0;i<4;i++){
            Object pop = stack.pop();
            System.out.println("从栈中取出的数据为:"+pop);
        }
    }
}

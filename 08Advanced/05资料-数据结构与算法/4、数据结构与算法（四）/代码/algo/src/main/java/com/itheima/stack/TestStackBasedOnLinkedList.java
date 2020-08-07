package com.itheima.stack;

/**
 * 测试基于单链表的链式栈
 */
public class TestStackBasedOnLinkedList {
    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        for(int i=0;i<6;i++){
            stack.push(i+"");
            System.out.println("第"+(i+1)+"次入栈,入栈的值为:"+i);
        }
        
        for(int i=0;i<8;i++){
            Object pop = stack.pop();
            System.out.println("取出的结果:"+pop);
        }
    }
}

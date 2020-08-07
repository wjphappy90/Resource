package com.itcast.dynamic;


import com.itcast.dynamic.Linked.LinkedList2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestLinkedList {

    public static void main(String[] args) {

        LinkedList  linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        //nextIndex ： 0     next  第一号节点元素
        //lastReturned 记录返回值的对象
        // private int expectedModCount = modCount; 将记录链表长度发生变化次数的记录值赋值给 期望值 ->  程序在初始化的时候，那么他们一定是相等的
        //Iterator iterator = linkedList.iterator();
        ListIterator iterator = linkedList.listIterator();
        while (iterator.hasNext()){
            //hashNext  遍历链表长度的次数
            iterator.add(10);
            System.out.println(iterator.next());
        }
       // System.out.println(linkedList);
    }
}

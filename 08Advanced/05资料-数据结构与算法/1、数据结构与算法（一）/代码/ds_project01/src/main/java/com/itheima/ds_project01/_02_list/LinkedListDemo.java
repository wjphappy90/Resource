package com.itheima.ds_project01._02_list;

import java.util.LinkedList;
import java.util.List;

/**
 * 演示链表源码分析
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        //构建容器
        List<String> list = new LinkedList<String>();
        //向容器中添加数据
        list.add("itheima");
        list.add("itcast");
        list.add("buxuegu");
        list.add("kudingyu");
        String s = list.get(2);
        System.out.println(s);

    }
}

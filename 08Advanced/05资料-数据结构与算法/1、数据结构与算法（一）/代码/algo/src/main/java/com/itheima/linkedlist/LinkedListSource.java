package com.itheima.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tanshuai on 2019/6/20.
 */
public class LinkedListSource {
    public static void main(String[] args) {
        //构建容器
        List<String> list = new LinkedList<String>();
        //向容器中添加数据
        list.add("itheima");
        list.add("itcast");
        //获取元素
        String s = list.get(1);
        System.out.println(s);

    }
}

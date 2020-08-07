package com.heima.conDemo;

import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * ArrayList有参构造源码分析二
 */
@SuppressWarnings("all")
public class Test03 {
    public static void main(String[] args) {
        //ArrayList(Collection <? extends E> c) 构造一个包含指定集合的元素的列表，按照它们由集合的迭代器返回的顺序。
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        //这行代码做了什么?
        ArrayList<String> list1 = new ArrayList<>(list);

        for (String s : list1) {
            System.out.println(s);
        }
    }
}

package com.heima.iteratorDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 案例一: 已知集合：List<String> list = new ArrayList<String>();里面有三个元素："hello"、"Java"、"PHP"，
 * 使用迭代器遍历获取集合的每一个元素
 */
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("Java");
        list.add("PHP");
        //获取迭代器
        Iterator<String> it = list.iterator();
        //遍历集合
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }
}

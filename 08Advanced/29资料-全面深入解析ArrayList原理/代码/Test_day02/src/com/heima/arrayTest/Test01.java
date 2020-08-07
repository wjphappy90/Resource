package com.heima.arrayTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 面试题:
 *      ArrayList频繁扩容导致添加性能急剧下降，如何处理？
 */
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");

        long startTime = System.currentTimeMillis();
        //需求:还需要添加10W条数据
        for (int i = 0; i < 100000; i++) {
            list.add(i+"");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("添加10W条数据用时: "+ (endTime - startTime));


        System.out.println("-----------------------------");
        //ArrayList​(int initialCapacity) 构造具有指定初始容量的空列表。
        List<String> list1 = new ArrayList<>(10000);
        //添加之前记录时间
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list1.add(i+"");
        }
        //循环结束之后记录时间
        endTime = System.currentTimeMillis();
        System.out.println("添加10W条数据用时: "+ (endTime - startTime));
    }
}

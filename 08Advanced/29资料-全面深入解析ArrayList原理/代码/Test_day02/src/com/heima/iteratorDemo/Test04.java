package com.heima.iteratorDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 * Iterator 迭代器默认方法源码分析
 *      default void remove() 迭代器中的remove方法,删除集合中的元素
 */
public class Test04 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");
        //获取迭代器
        Iterator<String> it = list.iterator();
        //遍历集合
        while (it.hasNext()) {
            String s = it.next();
            if(s.equals("hello")) {
                it.remove();
            }
        }
        System.out.println(list);
    }
}

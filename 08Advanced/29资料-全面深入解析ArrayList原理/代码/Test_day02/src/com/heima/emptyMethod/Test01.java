package com.heima.emptyMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * ArrayList 判断集合是否为空
 *      public boolean isEmpty()
 */
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");

        boolean b = list.isEmpty();
        System.out.println(b);
        System.out.println(list);
    }
}

package com.heima.addMethod;

import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 * ArrayList添加方法
 *      public boolean addAll(int index, Collection<? extends E> c)
 *      将指定集合中的所有元素插入到此列表中，从指定的位置开始。
 */
public class Test04 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("黑马程序员");
        list.add("传智播客");
        list.add("传智大学");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("酷丁鱼");
        list1.add("博学谷");
        //在指定索引处添加一个集合
        list1.addAll(1,list);

        System.out.println(list);
        System.out.println(list1);
    }
}

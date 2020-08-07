package com.heima.addMethod;

import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 * ArrayList添加方法
 *      public boolean addAll(Collection<? extends E> c)将集合的所有元素一次性添加到集合
 */
public class Test03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("黑马程序员");
        list.add("传智播客");
        list.add("传智大学");
        ArrayList<String> list1 = new ArrayList<>();
        //将list集合的所有元素一次性添加到集合list1
        list1.addAll(list);

        System.out.println(list);
        System.out.println(list1);
    }
}

package com.heima.addMethod;

import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * ArrayList添加方法
 *      public void add(int index, E element)在指定索引处添加元素
 */
public class Test02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("黑马程序员");
        list.add("传智播客");
        list.add("传智大学");
        list.add(1, "长沙校区");
        System.out.println(list);
    }
}

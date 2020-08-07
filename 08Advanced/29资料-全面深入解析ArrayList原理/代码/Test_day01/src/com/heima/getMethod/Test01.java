package com.heima.getMethod;

import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * ArrayList修改方法
 *      public E get(int index) 根据索引获取元素
 */
public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("山东大李逵");
        list.add("天魁星宋江");
        list.add("天罡星卢俊义");
        list.add("西门大人");

        //根据索引获取集合元素
        String value = list.get(1);
        System.out.println("get方法返回值: "+value);
        System.out.println("集合的元素: "+list);
    }
}

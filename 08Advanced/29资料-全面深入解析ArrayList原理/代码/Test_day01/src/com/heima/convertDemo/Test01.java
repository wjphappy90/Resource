package com.heima.convertDemo;

import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * ArrayList转换方法
 *      public String toString() 把集合所有数据转换成字符串
 */
public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("山东大李逵");
        list.add("天魁星宋江");
        list.add("天罡星卢俊义");
        list.add("西门大人");

        //将集合的元素转换为字符串
        String str = list.toString();
        System.out.println(str);

        //System.out.println("集合的元素: "+list);
    }
}

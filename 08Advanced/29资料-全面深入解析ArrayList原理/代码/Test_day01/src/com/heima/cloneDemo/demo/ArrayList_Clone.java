package com.heima.cloneDemo.demo;

import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 克隆的基本使用:
 *         将ArrayList集合的数据clone到另外一个集合
 */
public class ArrayList_Clone {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("人生就是旅途");
        list.add("也许终点和起点会重合");
        list.add("但是一开始就站在起点等待终点");
        list.add("那么其中就没有美丽的沿途风景和令人难忘的过往");

        //调用方法进行克隆
        Object o = list.clone();
        System.out.println(o == list);
        System.out.println(o);
        System.out.println(list);
    }
}

package com.heima.clearDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * ArrayList集合清空方法
 *      public void clear() 清空集合所有数据
 */
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");
        System.out.println("清空前的集合: "+list);
        //清空集合所有元素
        list.clear();
        System.out.println("清空后的集合: "+list);
    }
}

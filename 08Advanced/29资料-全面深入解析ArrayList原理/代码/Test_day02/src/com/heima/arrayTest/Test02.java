package com.heima.arrayTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 面试题:
 *      ArrayList插入或删除元素一定慢么?
 */
public class Test02 {
    public static void main(String[] args) {
        //创建ArrayList集合对象
        ArrayList<String> arrayList = new ArrayList<String>();
        //添加500W个元素
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(i+"黑马");
        }
        //获取开始时间
        long startTime = System.currentTimeMillis();
        //根据索引删除ArrayList集合元素
        //删除索引5000对应的元素
        String value = arrayList.remove(50000);
        System.out.println(value);
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList集合删除元素的时间: "+(endTime-startTime));

        //创建LinkedList集合对象
        LinkedList<String> linkedList = new LinkedList<String>();
        //添加500W个元素
        for (int i = 0; i < 5000000; i++) {
            linkedList.add(i+"黑马");
        }
        //获取开始时间
        startTime = System.currentTimeMillis();
        //根据索引删除LinkedList集合元素
        //删除索引5000对应的元素
        value = arrayList.remove(50000);
        System.out.println(value);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList集合删除元素的时间: "+(endTime-startTime));
    }
}

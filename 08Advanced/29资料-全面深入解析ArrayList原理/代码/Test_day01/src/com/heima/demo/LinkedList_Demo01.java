package com.heima.demo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
public class LinkedList_Demo01 {
    public static void main(String[] args) {
        //创建LinkedList集合
        List<String> list = new LinkedList<String>();
        //添加10W条数据
        for (int i = 0; i < 100000; i++) {
            list.add(i+"a");
        }

        //测试随机访问时间
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            //取出集合的每一个元素
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("随机访问用时: "+(endTime-startTime));

        //测试顺序访问时间
        startTime = System.currentTimeMillis();
        //获取迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            //取出集合的每一个元素
            it.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("顺序访问用时: "+(endTime-startTime));
    }
}

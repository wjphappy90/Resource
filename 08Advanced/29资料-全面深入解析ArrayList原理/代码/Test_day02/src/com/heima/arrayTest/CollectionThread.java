package com.heima.arrayTest;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
//线程任务类
class CollectionThread implements Runnable{
    //private static ArrayList<String> list = new ArrayList<String>();
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
    static{
        list.add("Jack");
        list.add("Lucy");
        list.add("Jimmy");
    }

    @Override
    public void run() {
        for (String value : list) {
            System.out.println(value);
            //在读取数据的同时又向集合写入数据
            list.add("coco");
        }
    }
}
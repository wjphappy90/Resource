package com.heima.arrayListThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
//测试类
@SuppressWarnings("all")
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程安全的集合类Vector
        //List<String> list = new Vector<>();
        ArrayList<String> list1 = new ArrayList<String>();
        //通过Collections工具类把List变成一个线程安全的集合
        List<String> list = Collections.synchronizedList(list1);
        //创建线程任务
        CollectionTask ct = new CollectionTask(list);
        //开启50条线程
        for (int i = 0; i < 50; i++) {
            new Thread(ct).start();
        }

        //确保子线程执行完毕
        Thread.sleep(3000);
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("集合长度: "+list.size());
    }
}
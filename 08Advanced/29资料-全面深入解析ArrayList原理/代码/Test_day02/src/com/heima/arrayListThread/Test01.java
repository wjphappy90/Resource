package com.heima.arrayListThread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        //创建集合
        List<String> list = new ArrayList<String>();
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

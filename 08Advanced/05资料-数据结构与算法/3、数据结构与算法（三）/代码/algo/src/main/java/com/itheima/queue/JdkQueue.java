package com.itheima.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by tanshuai on 2019/6/24.
 */
public class JdkQueue {
    public static void main(String[] args) {
        Queue queue  = new ConcurrentLinkedQueue();
        //元素入队列
        queue.offer("itcast");
        queue.offer("itheima");
        //获取元素
        Object poll = queue.poll();
        System.out.println(poll);


        Queue blockqueue = new ArrayBlockingQueue(5);
        blockqueue.offer("itcast");
        blockqueue.offer("itheima");
    }
}

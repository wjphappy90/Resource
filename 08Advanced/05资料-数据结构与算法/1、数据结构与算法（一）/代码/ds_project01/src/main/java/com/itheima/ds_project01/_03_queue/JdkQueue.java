package com.itheima.ds_project01._03_queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
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

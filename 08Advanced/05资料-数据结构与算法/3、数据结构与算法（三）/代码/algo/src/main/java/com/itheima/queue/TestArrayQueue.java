package com.itheima.queue;

/**
 * Created by tanshuai on 2019/6/24.
 */
public class TestArrayQueue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        //入队列
        queue.enqueue("itcast1");
        queue.enqueue("itcast2");
        queue.enqueue("itcast3");
        queue.enqueue("itcast4");
        //此时入队列应该走扩容的逻辑
        queue.enqueue("itcast5");
        queue.enqueue("itcast6");
        //出队列
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        //此时入队列应该走数据搬移逻辑
        queue.enqueue("itcast7");
        //出队列
        System.out.println(queue.dequeue());
        //入队列
        queue.enqueue("itcast8");
        //出队列
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        //入队列
        queue.enqueue("itcat9");
        queue.enqueue("itcat10");
        queue.enqueue("itcat11");
        queue.enqueue("itcat12");
        //出队列
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

package com.itheima.queue;

/**
 * Created by tanshuai on 2019/6/24.
 */
public class TestLinkedListQueue {
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        System.out.println(queue.dequeue());
        queue.enqueue("itcast1");
        queue.enqueue("itcast2");
        queue.enqueue("itcast3");
        queue.enqueue("itcast4");
        queue.enqueue("itcast5");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("itcast6");
        queue.enqueue("itcast7");
        queue.enqueue("itcast8");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

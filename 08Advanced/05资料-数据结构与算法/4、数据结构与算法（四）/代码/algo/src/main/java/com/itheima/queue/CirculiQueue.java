package com.itheima.queue;

/**
 * Created by tanshuai on 2019/6/24.
 */
public class CirculiQueue {
    //存储队列数据的数组
    private Object[] elements;
    //默认数组容量
    private int DEFAULT_CAPACITY=10;
    //队列中元素个数
    private int size;
    // 队列头指针
    private int head;
    //队列尾指针
    private int tail;

    /**
     * 默认构造函数
     */
    public CirculiQueue(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 通过传入的容量参数构造队列
     * @param capacity
     */
    public CirculiQueue(int capacity){
        elements = new Object[capacity];
    }

    /**
     * 元素入队列
     * @param element
     * @return
     */
    public boolean enqueue(Object element){
        //判断队列是否已满
        if(head == (tail+1)%elements.length){
            //队列已满
            return false;
        }
        //将元素存入tail位置上
        elements[tail]=element;
        //尾指针后移
        /*tail++;
        if(tail==elements.length){
            tail = 0;
        }*/
        tail = (tail+1)%elements.length;
        size++;
        return true;
    }

    /**
     * 元素出队列
     * @return
     */
    public Object dequeue(){
        //判断队列是否为空
        if(head==tail){
            return null;
        }
        //获取head位置上的元素
        Object element = elements[head];
        //头指针后移
        /*head++;
        if(head==elements.length){
            head = 0;
        }*/
        head = (head+1)%elements.length;
        size--;
        return element;
    }

    /**
     * 获取队列大小
     * @return
     */
    public int getSize() {
        return size;
    }
}

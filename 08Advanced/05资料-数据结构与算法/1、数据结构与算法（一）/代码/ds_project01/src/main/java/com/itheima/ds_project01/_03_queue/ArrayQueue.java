package com.itheima.ds_project01._03_queue;

import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;

/**
 * 1\ 基于数组实现
 * 2、定义队列结构
 * 3、定义结构上操作
 *          3.1  入队列 【扩容机制，借鉴ArrayList】
 */
public class ArrayQueue {

    //  定义队列结构

    //使用数组来存储我们队列的元素
    private Object[]  elements;
    //定义队列的大小
    private int size;
    //   定义队列的初始容量
    private int DEFAULT_SIZE = 10;
    //   定义一个容量最大
    private int MAX_ARRAY_SIZE = Integer.MAX_VALUE-8;
    // 定义队列头指针
    private  int head;
    // 定义一个尾指针
    private int tail;

    /**
     * 定义一个默认初始化长度为10 队列
     */
    public ArrayQueue(){
        elements = new Object[DEFAULT_SIZE];
        // 初始化首尾指针
       /* this.head=0;
        this.tail=0;*/
       this.initPoint(0,0);

    }

    /**
     * 用户可以通过传入的容量来构建队列
     * @param capcity
     */
    public  ArrayQueue(int capcity){
        if (capcity<=0){
            throw  new RuntimeException("队列的初始容量有问题！");
        }
        elements = new Object[capcity];
        this.initPoint(0,0);
    }


    /**
     *
     * @param head
     * @param tail
     */

    private  void  initPoint(int head ,int tail){

        this.head = head;
        this.tail = tail;
    }

    // 定义结构上操作（算法）

    //  入队列【支持动态扩容】

    public boolean  enqueue(Object  element){
        // 校验我们的队列容量是否够用！
        ensureSizeHelper();
        elements[tail++] = element;
        size++;
        return  true;
    }

    // 出队列

    public Object dequeue(){
        if(head ==tail){
            return null;
        }
        Object object= elements[head++];
        size--;
        return object;
    }



    // 动态扩容机制

    // 1、判断队列容量是否够用
    private void ensureSizeHelper(){
        // 尾指针已经越过队列的尾部
        if(tail==elements.length){
            if(size<elements.length){
                if(head==0){
                     // 扩容操作

                }else {
                    for ( int i= head; i<tail ;i++){
                        elements[i-head] =elements[i];
                    }
                    initPoint(0,tail-head);
                }
            }
        }


    }



    //  2、扩容方法
    private  void  grow(int oldSize){
        int newSize = oldSize+(oldSize>>1);  // 扩容1.5倍
        if(newSize-oldSize<0){
            newSize = DEFAULT_SIZE;
        }
        if (newSize-MAX_ARRAY_SIZE>0){
              newSize =capcityFinal(newSize);
        }

    }

    private  int  capcityFinal(int newSize){
        return (newSize>MAX_ARRAY_SIZE)?Integer.MAX_VALUE-8:newSize;
    }


}

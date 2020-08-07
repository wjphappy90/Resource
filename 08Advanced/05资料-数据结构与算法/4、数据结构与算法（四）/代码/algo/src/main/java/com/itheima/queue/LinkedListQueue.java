package com.itheima.queue;

import com.itheima.stack.LinkedListStack;

/**
 * Created by tanshuai on 2019/6/24.
 */
public class LinkedListQueue {
    //队列元素个数
    private int size;
    //头节点
    private Node head;
    //尾节点
    private Node tail;
    
    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
    }

    /**
     * 入队列
     * @param data
     * @return
     */
    public boolean enqueue(Object data){
        Node newNode = new Node(data,null);
        if(tail == null){
            tail = newNode;
            head = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * 出队列
     * @return
     */
    public Object dequeue(){
        if(head==null){
            return null;
        }
        Object data = head.data;
        head = head.next;
        if(head==null){
            tail = null;
        }
        size--;
        return data;
    }
    
    
    private static class Node{
        //节点数据
        private Object data;
        //后继节点
        private Node next;
        
        public Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }
}

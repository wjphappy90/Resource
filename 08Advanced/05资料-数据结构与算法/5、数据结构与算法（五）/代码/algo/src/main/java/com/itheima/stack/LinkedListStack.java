package com.itheima.stack;

/**
 * 基于双向链表的链式栈实现
 */
public class LinkedListStack {
    // 栈大小
    private int size;
    //存储链表尾节点
    private Node tail;
    
    public LinkedListStack(){
        this.tail = null;
    }

    /**
     * 入栈
     * @param data
     * @return
     */
    public boolean push(Object data){
        Node newNode = new Node(tail,data,null);
        if(size>0){
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){
        if((size-1) < 0){
            //栈为空
            return  null;
        }
        Object data = tail.getData();
        tail = tail.prev;
        if(tail!=null){
            tail.next = null;
        }
        size--;
        return data;
    }
}

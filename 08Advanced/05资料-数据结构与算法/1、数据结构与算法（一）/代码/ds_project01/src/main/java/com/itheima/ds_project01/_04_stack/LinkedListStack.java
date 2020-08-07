package com.itheima.ds_project01._04_stack;

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

class Node {
    //前驱节点
    public Node prev;
    //节点数据
    private Object data;
    //后继节点
    public Node next;

    public Node(Node prev,Object data,Node next){
        this.prev = prev;
        this.data =data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }
}
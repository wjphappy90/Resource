package com.itheima.ds_project01._03_queue;


import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;


/**
 * 1、定义链表节点的结构（单链表）
 *
 * 2、定义队列结构
 *
 * 3、定义队列操作
 *          入队列（链表的尾部添加一个元素）
 *          出队列  （链表的头节点删除）
 *
 *
 *
 */


public class LinkedListQueue {

    // 队列中元素个数
    private int size;
    private  Node head;
    private  Node tail;

    public  LinkedListQueue(){
          this.head=null;
          this.tail =null;
    }

    //  入队列
    public  boolean  enqueue(Object element){
        Node node = new Node(element,null);
        if(tail==null){
            tail = node;
            head = node;
        }else {
            tail.next= node;
            tail =node;
        }
        size++;
        return  true;
    }

    // 出队列

    public  Object dequeue(){
        if (head==null){
            return null;
        }
        Object data = head.data;
        head =head.next;
        if(head==null){
            tail =null;
        }
        size--;
        return  data;
    }









    /**
     * 链表的节点定义完毕
     */
    static  class  Node{
        private  Object  data;
        private Node next;

        public  Node ( Object data ,Node next){
            this.data = data;
            this.next = next;
        }
    }

}

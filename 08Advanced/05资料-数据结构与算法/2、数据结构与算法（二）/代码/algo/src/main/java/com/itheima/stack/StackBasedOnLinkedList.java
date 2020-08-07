package com.itheima.stack;

/**
 * 基于单链表实现的栈
 */
public class StackBasedOnLinkedList {
    // 存储链表头节点
    private Node head;
    
    public StackBasedOnLinkedList(){
        this.head = null;
    }

    /**
     * 入栈
     * @param data
     * @return
     */
    public boolean push(Object data){
        Node newNode = new Node(data,head);
        head = newNode;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){
        if(head==null){
            return null;
        }
        Node topNode = head;
        head = topNode.next;
        topNode.next=null;
        return topNode.data;
    }
    

    /**
     * 节点对象
     */
    private static  class Node {
        //节点数据
        private Object data;
        // next指针
        private Node next;

        public Node(Object data,Node next){
            this.data =  data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }
}

package com.itheima.stack;

/**
 * Created by tanshuai on 2019/6/22.
 */
public class Node {
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

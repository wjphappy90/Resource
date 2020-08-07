package com.itheima.ds_project01._05_test;

public class ListNode {

    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString(){
        ListNode head =this;
         StringBuilder sb = new StringBuilder();
         while (head!=null){
             sb.append(head.value+"  ");
             head = head.next;
         }
         return sb.toString();
    }


}

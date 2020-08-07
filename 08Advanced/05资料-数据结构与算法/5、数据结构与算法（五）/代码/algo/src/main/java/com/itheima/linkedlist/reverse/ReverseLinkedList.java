package com.itheima.linkedlist.reverse;

/**
 * 未实现
 */
public class ReverseLinkedList {
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = head.next;
        while (head.next!=null){
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }
        return next;
    }
    
    
    
    private static class ListNode{
        private Object data;
        private ListNode next;
        
        public ListNode(Object data,ListNode next){
            this.data = data;
            this.next = next;
        }
    }
}

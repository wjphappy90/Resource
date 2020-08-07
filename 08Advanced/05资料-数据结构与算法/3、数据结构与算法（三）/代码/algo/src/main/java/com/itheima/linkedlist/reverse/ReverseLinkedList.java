package com.itheima.linkedlist.reverse;

/**
 * 未实现
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        
    }
    public ListNode reverseList(ListNode head) {
        ListNode curr = null;
        
        curr = head;
        
        while(curr.next!=null){
            ListNode node = new ListNode(head.val);
            node.next = curr;
        }
        return curr;
    }
}

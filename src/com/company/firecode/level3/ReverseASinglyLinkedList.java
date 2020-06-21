package com.company.firecode.level3;

public class ReverseASinglyLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while(current.next != null){
            ListNode newHead = current;
            current = current.next;

            newHead.next=prev;
            prev = newHead;
        }

        ListNode newHead = current;

        newHead.next=prev;
        prev = newHead;

        return prev;

    }

    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }
}

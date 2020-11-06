package com.company.leetcode;

import com.company.leetcode.bloomberg.ListNode;

public class Lc206ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next= new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);

        System.out.println(reverseList(list).val);
    }

    public static ListNode reverseList(ListNode head) {
        if(head== null)
            return head;

//        1-2-3-4
        ListNode reversed = new ListNode(head.val);
        ListNode current = head.next;


        while (current != null){
            ListNode temp = reversed;
            reversed = new ListNode(current.val);
            reversed.next=temp;
            current=current.next;
        }

        return reversed;
    }
}

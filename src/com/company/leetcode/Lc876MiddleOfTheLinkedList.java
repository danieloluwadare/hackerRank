package com.company.leetcode;

import com.company.leetcode.bloomberg.ListNode;

public class Lc876MiddleOfTheLinkedList {
    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.next= new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        System.out.println(middleNode(list).val);
        list.next.next.next.next.next = new ListNode(6);
        System.out.println(middleNode(list).val);

    }

    public static ListNode middleNode(ListNode head) {
        if(head==null)
            return head;

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
        }

        if(fastPointer.next != null)
            return slowPointer.next;

        return  slowPointer;
    }
}

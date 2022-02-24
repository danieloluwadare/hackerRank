package com.company.leetcode2.bloomberg.easy;

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
//        1-2-3-4
//        rev = 1
//        newNode = 2
//        newNode.next = rev
//        rev=newNode

        ListNode reverseNode = null;
        ListNode current = head;

        while (current != null){
            ListNode newNode = new ListNode(current.val);
            if (reverseNode != null) {
                newNode.next = reverseNode;
            }
            reverseNode = newNode;

            current= current.next;

        }

        return reverseNode;
    }
}

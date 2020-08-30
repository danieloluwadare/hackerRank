package com.company.leetcode.bloomberg;

public class ListNode {

    int data;
    ListNode next;
    ListNode(int data) { this.data = data; }

    public static void toString(ListNode head) {
        ListNode curr =head;
        while (curr != null){
            System.out.print(curr.data+",");
            curr=curr.next;
        }
    }
}

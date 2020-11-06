package com.company.leetcode.bloomberg;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int val) { this.val = val; }

    public static void toString(ListNode head) {
        ListNode curr =head;
        while (curr != null){
            System.out.print(curr.val +",");
            curr=curr.next;
        }
    }
}

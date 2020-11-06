package com.company.leetcode;

import com.company.leetcode.bloomberg.ListNode;

public class Lc83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next= new ListNode(2);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(3);

        deleteDuplicates(l1);

        ListNode l2 = new ListNode(1);
        l2.next= new ListNode(1);
        l2.next.next= new ListNode(2);
        deleteDuplicates(l2);

        l1.next.next=null;
        deleteDuplicates(l1);

        l1.next=null;
        deleteDuplicates(l1);

        l1=null;
        deleteDuplicates(l1);


    }

    public static ListNode deleteDuplicates(ListNode head) {
//        1-2-2-3-3

        if(head==null)
            return head;


        ListNode current = head.next;
        ListNode prev=head;

        while (current != null ){
            if(current.val !=  prev.val){
                prev=current;
                current=current.next;
                continue;
            }


            prev.next=current.next;
            current=current.next;

        }

        System.out.println("solution");
        System.out.println(head);
        return head;

    }
}

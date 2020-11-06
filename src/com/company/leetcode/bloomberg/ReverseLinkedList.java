package com.company.leetcode.bloomberg;

public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        reverseList(l1);
    }

    public static ListNode reverseList(ListNode head) {

//        1->2->3->4->5->NULL
//        1->NULL
//        1->2->NULL

//        head = 5
//        newNode= 5->4->3->2->1->NULL
//        newHead = 4->3->2->1->NULL

        if(head == null){
            return head;
        }

        ListNode current = head;
        ListNode newHead = null;

        while (current != null){
          ListNode newNode = new ListNode(current.val);
          newNode.next = newHead;
          newHead=newNode;
          current=current.next;
        }


        return newHead;

    }


}

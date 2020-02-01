package com.company.firecode;

public class FindTheMiddleOfAListInASinglePass {

    public ListNode findMiddleNode(ListNode head) {
        if(head==null || head.next == null || head.next.next==null)return head;

        ListNode current = head;
        ListNode itr= head.next;

        while(itr.next.next != null){
            current=current.next;
            itr=itr.next;
        }

        return current;
    }

    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }
}

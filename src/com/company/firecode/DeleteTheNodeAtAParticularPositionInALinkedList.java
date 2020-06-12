package com.company.firecode;

public class DeleteTheNodeAtAParticularPositionInALinkedList {

    public ListNode deleteAtMiddle(ListNode head, int position) {
        if(head==null){
            return null;
        }
        ListNode current = head;
        ListNode prev= null;
        int count = 1;

        while(current.next != null){
            if(count == position){
                break;
            }
            count++;
            prev=current;
            current=current.next;
        }

        if(count==position){
            if(prev==null){
                return head.next;
            }
            prev.next = current.next;
            current=null;
            return head;


        }else{
            return head;
        }


    }

    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }
}

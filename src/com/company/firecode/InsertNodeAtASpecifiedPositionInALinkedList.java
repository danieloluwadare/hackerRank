package com.company.firecode;

public class InsertNodeAtASpecifiedPositionInALinkedList {

    public ListNode insertAtPosition(ListNode head, int data, int pos) {
        ListNode newNode = new ListNode(data);
        if(head==null){
            return newNode;
        }

        if(pos==1){
            newNode.next=head;
            return newNode;
        }

        ListNode current = head;
        int count = 1;

        while(current.next != null){
            if(count+1==pos){
                break;
            }
            current=current.next;
            count++;
        }

        ListNode nodeAtRequestedPosition = current.next;
        newNode.next=nodeAtRequestedPosition;
        current.next=newNode;
        return head;

    }

    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }
}

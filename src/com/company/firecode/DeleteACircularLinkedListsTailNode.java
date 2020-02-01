package com.company.firecode;

public class DeleteACircularLinkedListsTailNode {

    public ListNode deleteAtTail(ListNode head) {
        // if(head.next == head){
        //     return null;
        // }

        ListNode currentNode = head.next;
        ListNode prevNode = head;

        while(currentNode.next != null){
            if(currentNode.data == head.data){
                break;
            }

            System.out.println(currentNode.data);

            prevNode = currentNode;
            currentNode= currentNode.next;
        }

        currentNode=head;
        while(currentNode.next != prevNode){
            currentNode=currentNode.next;
        }

        prevNode.next=null;
        prevNode=null;
        currentNode.next=head;

        return head;


    }

    public ListNode deleteAtTail2(ListNode head) {
        ListNode currentNode = head;
        ListNode prevNode = head;
        while(currentNode.next != head) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        prevNode.next = head;
        currentNode.next = null;
        return head;
    }


    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }
}

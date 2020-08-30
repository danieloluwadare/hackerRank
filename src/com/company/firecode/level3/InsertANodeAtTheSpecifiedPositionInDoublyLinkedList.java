package com.company.firecode.level3;

public class InsertANodeAtTheSpecifiedPositionInDoublyLinkedList {

    public DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        // if head is null and the position is not 1
        if(head == null && pos != 1){
            return null;
        }

        // if the position is 1 make it the first element
        if(pos==1){
            newNode.next = head;
            if (head != null){
                head.prev = newNode;
            }
            return newNode;
        }

        DoublyLinkedNode current = head;
        DoublyLinkedNode prevNode = null;
        int count = 1;
        boolean found = false;

        while(current.next != null){
            if(count==pos){
                found=true;
                break;
            }
            current = current.next;
            prevNode = current.prev;
            count++;
        }

        // if the position has been found
        if(found || count==pos){
            newNode.next = current;
            current.prev = newNode;

            prevNode.next = newNode;
            newNode.prev = prevNode;

        }

        // if the position to be inserted =4 and DoublyLinkedList= 1<=>2<=>3
        else if(count+1==pos){
            current.next= newNode;
            newNode.prev = current;

        }

        return head;

    }
}

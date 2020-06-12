package com.company.firecode;

public class EvenOrOddLinkList {

    public static void main(String[] args) {

    }

    public Boolean isListEven(ListNode head) {
        if(head == null){
            return true;
        }

        ListNode current = head;
        int size = 1;

        while(current.next != null){
            current=current.next;
            size++;
        }

        if(size % 2 == 0){
            return true;
        }else{
            return false;
        }


    }

    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }
}

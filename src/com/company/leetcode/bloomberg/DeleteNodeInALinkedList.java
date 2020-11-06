package com.company.leetcode.bloomberg;

public class DeleteNodeInALinkedList {
//    Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
//
//Given linked list -- head = [4,5,1,9], which looks like following:

//    Note:
//
//-The linked list will have at least two elements.
//-All of the nodes' values will be unique.
//-The given node will not be the tail and it will always be a valid node of the linked list.
//-Do not return anything from your function.

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
        deleteNode(l3);
        ListNode.toString(l1);

    }

    public static void deleteNode(ListNode node) {
//        1->2->3->4->5->NULL
//        node = 3
        ListNode nextNode = node.next;
        node.val =nextNode.val;
        node.next=nextNode.next;

        nextNode=null;

    }
}

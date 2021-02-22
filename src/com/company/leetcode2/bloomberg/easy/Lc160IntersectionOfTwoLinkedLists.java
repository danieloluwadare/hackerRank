package com.company.leetcode2.bloomberg.easy;

import com.company.leetcode.bloomberg.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Lc160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

        ListNode twoL = new ListNode(2);
        ListNode fourL = new ListNode(4);

        twoL.next=fourL;

        ListNode oneL = new ListNode(1);
        ListNode nineL = new ListNode(9);
        ListNode ooneL = new ListNode(1);

        oneL.next=nineL;
        nineL.next=ooneL;

        ListNode threeL = new ListNode(3);

        threeL.next=twoL;
        ooneL.next=twoL;


        ListNode.toString(threeL);
        System.out.println();
        ListNode.toString(oneL);
        System.out.println();
        ListNode.toString(getIntersectionNode(oneL,threeL));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode currentA = headA;
        while (currentA != null){
            set.add(currentA);
            currentA=currentA.next;
        }

        ListNode currentB = headB;
        while (currentB != null){
            if(set.contains(currentB))
                return currentB;
            currentB=currentB.next;
        }

        return null;
    }
}

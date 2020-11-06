package com.company.leetcode;

import com.company.leetcode.bloomberg.ListNode;

public class Lc445AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode list = new ListNode(7);
        list.next= new ListNode(2);
        list.next.next = new ListNode(4);
        list.next.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next= new ListNode(6);
        list2.next.next = new ListNode(4);

//        addTwoNumbers(list,list2);

        ListNode list3 = new ListNode(3);
        list3.next= new ListNode(7);
        list3.next.next = new ListNode(7);

        ListNode list4 = new ListNode(3);
        list4.next= new ListNode(3);

//        addTwoNumbers(list3,list4);

        ListNode list5 = new ListNode(9);
        list5.next= new ListNode(9);
        list5.next.next = new ListNode(9);

        ListNode list6 = new ListNode(1);

        addTwoNumbers(list5,list6);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Count = 1;
        ListNode current = l1;
        while (current.next != null){
            current=current.next;
            l1Count++;
        }

        int l2Count = 1;
        current = l2;
        while (current.next != null){
            current=current.next;
            l2Count++;
        }

        ListNode longestNumber , shorterNumber;
        int difference = Math.abs(l1Count-l2Count) ;
        longestNumber = (l1Count > l2Count) ? l1 : l2;
        shorterNumber = (l1Count < l2Count) ? l1 : l2;

        int i = 0;
        ListNode result = null;
        while (longestNumber != null){
            int val1 = longestNumber.val;
            int val2 = 0;
            if(i >= difference){
                val2=shorterNumber.val;
                shorterNumber=shorterNumber.next;
            }

            int sum = val1 + val2;
            ListNode newNode = new ListNode(sum);

            if(result==null){
                result=newNode;
            }
            else {
                newNode.next=result;
                result=newNode;
            }



            longestNumber=longestNumber.next;
            i++;
        }

        int carry=0;
        ListNode sum = null;
        while (result != null){
            int val = result.val + carry;
            carry = val / 10;
            int remainder = val % 10;

            ListNode node = new ListNode(remainder);
            if(sum==null){
                sum = node;
            }
            else {
                node.next=sum;
                sum = node;
            }

            result=result.next;
        }

        if(carry == 1){
            ListNode node = new ListNode(carry);
            node.next=sum;
            sum=node;

        }

        System.out.println(sum);
        return sum;
    }
}

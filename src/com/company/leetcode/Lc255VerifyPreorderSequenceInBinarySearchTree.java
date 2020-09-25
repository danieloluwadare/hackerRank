package com.company.leetcode;

import java.util.Stack;

public class Lc255VerifyPreorderSequenceInBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(verifyPreorder(new int[]{5,2,6,1,3}));
        System.out.println(verifyPreorder(new int[]{5,2,1,3,6}));

    }
    public static boolean verifyPreorder(int[] preorder) {
        int lastRemoved = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < preorder.length; i++){
            int currNum = preorder[i];
            if(lastRemoved > currNum){
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < currNum){
                lastRemoved=stack.pop();
            }

            stack.push(currNum);
        }

        return true;
    }
}

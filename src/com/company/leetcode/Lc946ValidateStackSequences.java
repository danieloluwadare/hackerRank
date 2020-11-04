package com.company.leetcode;

import java.util.Stack;

public class Lc946ValidateStackSequences {

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[] {1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(validateStackSequences(new int[] {1,2,3,4,5},new int[]{4,3,5,1,2}));
        System.out.println(validateStackSequences(new int[] {1,2,3,5},new int[]{4,3,5,1,2}));

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushedLength = 0;
        int poppedLength = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i < pushed.length; i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[poppedLength]){
                stack.pop();
                poppedLength++;
            }
            pushedLength++;
        }

        return (pushedLength-poppedLength)==0;
    }
}

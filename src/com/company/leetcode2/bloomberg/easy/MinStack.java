package com.company.leetcode2.bloomberg.easy;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
//        ["MinStack","push","push","push","getMin","pop","getMin"]
//[[],[0],[1],[0],[],[],[]]
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    /** initialize your data structure here. */
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;
    public MinStack() {
        stack=new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }
        else {
            int min = x < minStack.peek() ? x : minStack.peek();
            minStack.push(min);
        }
    }

    public void pop() {
        int popped = stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

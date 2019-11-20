package com.company;

import java.util.Stack;

public class StacKwithMaximum {
    private Stack<StackWithMax> stack= new Stack<StackWithMax>();

    public static void main(String[] args) {
        StacKwithMaximum stacKwithMaximum = new StacKwithMaximum();
        stacKwithMaximum.push(3);
        stacKwithMaximum.push(10);
        stacKwithMaximum.push(5);
        stacKwithMaximum.push(11);
        stacKwithMaximum.push(9);
        stacKwithMaximum.push(15);
        stacKwithMaximum.push(4);
        stacKwithMaximum.push(7);

        System.out.println("max== "+stacKwithMaximum.getStackMax());
        System.out.println("popped=="+stacKwithMaximum.pop());;
        System.out.println("popped=="+stacKwithMaximum.pop());;
        System.out.println("popped=="+stacKwithMaximum.pop());;

        System.out.println("popped=="+stacKwithMaximum.pop());;
        System.out.println("popped=="+stacKwithMaximum.pop());;

        System.out.println("max== "+stacKwithMaximum.getStackMax());



    }

    public void push(int value){
        stack.push(computeMaximum(value));

    }

    public int pop(){
        return stack.pop().getValue();
    }

    public int getStackMax(){
        return stack.peek().getMaxValue();
    }

    private StackWithMax computeMaximum(int value){
        if(stack.empty()){
            int minimumValue = Integer.MIN_VALUE;
            return new StackWithMax(value, minimumValue);

        }
        int currentMaximumValue = stack.peek().getMaxValue();
        if(value >= currentMaximumValue){
            return new StackWithMax(value, value);
        }
        return new StackWithMax(value, currentMaximumValue);
    }

    class StackWithMax{
        private int value;
        private int maxValue;

        public StackWithMax(int value, int maxValue) {
            this.value = value;
            this.maxValue = maxValue;
        }

        public int getValue() {
            return value;
        }

        public int getMaxValue() {
            return maxValue;
        }
    }
}


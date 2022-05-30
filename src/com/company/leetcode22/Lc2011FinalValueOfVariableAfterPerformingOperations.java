package com.company.leetcode22;

public class Lc2011FinalValueOfVariableAfterPerformingOperations {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X","X++","X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"++X","++X","X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"X++","++X","--X","X--"}));
    }
    public static int finalValueAfterOperations(String[] operations) {
        int i = 0;
        for(String operation : operations){
            if(operation.charAt(0) == '+' || operation.charAt(operation.length()-1) == '+' )
                i++;
            else
                i--;
        }

        return i;
    }
}

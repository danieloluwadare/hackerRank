package com.company.leetcode;

import java.util.Arrays;

public class CheckPermutationOneTwoCTC {
    public static void main(String[] args) {
        String testCase1= "cat";
        String testCase2="abt";
//        System.out.println(String.format("is %s a permutation of %s  ? = %b", testCase1,testCase2, isPermutationOfOtherStringv2(testCase1, testCase2)));
//        System.out.println(String.format("is %s unique ? %b", testCase2, isStringUnique(testCase2)));
    }

    public static boolean isPermutationOfOtherStringv1(String input, String secondaryInput){
        if(input.length() != secondaryInput.length()){
            return false;
        }

        char [] inputCharArray = input.toCharArray();
        char [] secondaryInputCharArray = secondaryInput.toCharArray();
        return isEqual(inputCharArray,secondaryInputCharArray);

    }

    public static boolean isEqual(char [] inputCharArray,  char [] secondaryInputCharArray){
        Arrays.sort(inputCharArray);
        Arrays.sort(secondaryInputCharArray);

        return (new String(inputCharArray).equals(new String(secondaryInputCharArray)));
    }

    public static boolean isPermutationOfOtherStringv2(String input, String secondaryInput){
        if(input.length() != secondaryInput.length()){
            return false;
        }



        int [] ascii = new int [128];

        for(int i=-0; i<input.length(); i++){
            int character = input.charAt(i);
            ascii[character]++;
        }

        for(int i=-0; i<secondaryInput.length(); i++){
            int character = secondaryInput.charAt(i);
            ascii[character]--;
            if(ascii[character] < 0){
                return false;
            }

        }

        return true;

    }
}

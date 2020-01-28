package com.company.firecode;

public class PalindromeTester {

    public static void main(String[] args) {
        System.out.println(isStringPalindrome("madam"));
        System.out.println(isStringPalindrome("not a palindrome"));

    }

    public static boolean isStringPalindrome(String str){
        if(str==null || str.length()==0) return true;
        int len = str.length();
        for(int i = 0; i<len/2; i++){
            char leftSide = str.charAt(i);
            char rightSide = str.charAt(len-1-i);
            if(leftSide != rightSide){
                return false;
            }
        }

        return true;

    }
}

package com.company.leetcode.bloomberg;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }


    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int input = x;
        int rev = 0;
        while(x != 0){
            rev = (rev * 10) + ( x % 10);
            x = x/10;
        }

        System.out.println(rev);

        if(input == rev){
            return true;
        }
        return false ;
    }
}

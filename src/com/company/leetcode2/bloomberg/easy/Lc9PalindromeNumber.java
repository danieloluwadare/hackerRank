package com.company.leetcode2.bloomberg.easy;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 *
 * Input: x = -101
 * Output: false
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class Lc9PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(-101));
//        System.out.println(isPalindrome(10));
//        System.out.println(isPalindrome(143));

    }

    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int reversed = 0;
        int initial = x;
        while (x != 0){
            reversed = (reversed * 10) + (x % 10);
            x = x / 10;
        }

        System.out.println(reversed);

        return reversed==initial;
    }
}

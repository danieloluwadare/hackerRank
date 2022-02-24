package com.company.leetcode2.bloomberg.medium;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being
 * repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original val does not contain any digits and that digits are only
 * for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */

public class Lc394DecodeString {

    public static void main(String[] args) {

//        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));

        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));

//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
//        System.out.println('2'-'0');

    }


    public static String decodeString(String s) {
        Stack<StringBuilder> stringBuilderStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder initialString = new StringBuilder();
        int count = 0;
//        System.out.println(decodeString("3[a]2[bc]"));
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                count = (count * 10) + currentChar - '0';
            }
            else if(Character.isLetter(currentChar)){
                initialString.append(currentChar);
            }
            else if(currentChar=='['){
                countStack.push(count);
                stringBuilderStack.push(initialString);
                count=0;
                initialString = new StringBuilder();
            }
            else {
                int poppedCount = countStack.pop();
                StringBuilder poppedSb = stringBuilderStack.pop();
//                String x= initialString.toString();
                for(int j =0 ; j < poppedCount; j++){
//                    initialString.append(x);
                    poppedSb.append(initialString);
                }
                initialString=poppedSb;
            }
        }

        return initialString.toString();
    }
}

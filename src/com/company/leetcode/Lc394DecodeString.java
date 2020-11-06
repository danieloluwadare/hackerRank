package com.company.leetcode;

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

        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));

        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));

//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
//        System.out.println('2'-'0');

    }

    public static String decodeString2(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ']'){
                sb = new StringBuilder();
                char stackCh = ' ';
                while(!stack.isEmpty() && stackCh != '['){
                    stackCh=stack.pop();
                    if(stackCh != '[')
                        sb.insert(0,stackCh);
                }

                StringBuilder sbInteger = new StringBuilder();
//                boolean integerNotAllFound = true;

                while (!stack.isEmpty()){
                    char intCount = stack.peek();
//                    if((intCount >= 'a' && intCount <='z') ||
//                            (intCount >= 'A' && intCount <='Z') || intCount == '['){
//                        break;
//                    }
                    if(Character.isLetter(intCount) || intCount == '['){
                        break;
                    }
                    sbInteger.insert(0,stack.pop());
                }

                int count = Integer.parseInt(String.valueOf(sbInteger.toString()));
                String poppedString = sb.toString();
                for(int j=1; j < count; j++ ){
                    sb.append(poppedString);
                }

                for(int j = 0; j < sb.length(); j++){
                    stack.push(sb.charAt(j));
                }

            }else {
                stack.push(ch);
            }
        }

        StringBuilder sbd = new StringBuilder();
        while (!stack.isEmpty()){
            sbd.insert(0, stack.pop());
        }
        return sbd.toString();
    }

    public static String decodeString(String s) {

        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int constant = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                constant = constant * 10 + ch - '0';
            }
            else if(Character.isLetter(ch)){
                currentString.append(ch);
            }
            else if(ch == '['){
                countStack.push(constant);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                constant = 0;
            }
            else if(ch == ']'){
                int currentConstant = countStack.pop();
                String decodedString = currentString.toString();
                for(int j = 1; j < currentConstant; j++){
                    currentString.append(decodedString);
                }
                currentString.insert(0,stringStack.pop());
            }

        }

        return currentString.toString();
    }
}

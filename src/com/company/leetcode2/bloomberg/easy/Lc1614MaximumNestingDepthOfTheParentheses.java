package com.company.leetcode2.bloomberg.easy;

import java.util.*;

/**
 * 1614. Maximum Nesting Depth of the Parentheses
 * Easy
 *
 * 243
 *
 * 55
 *
 * Add to List
 *
 * Share
 * A string is a valid parentheses string (denoted VPS) if it meets one of the following:
 *
 * It is an empty string "", or a single character not equal to "(" or ")",
 * It can be written as AB (A concatenated with B), where A and B are VPS's, or
 * It can be written as (A), where A is a VPS.
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 *
 * depth("") = 0
 * depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
 * depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 * For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 *
 * Given a VPS represented as string s, return the nesting depth of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Explanation: Digit 8 is inside of 3 nested parentheses in the string.
 * Example 2:
 *
 * Input: s = "(1)+((2))+(((3)))"
 * Output: 3
 * Example 3:
 *
 * Input: s = "1+(2*3)/(2-1)"
 * Output: 1
 * Example 4:
 *
 * Input: s = "1"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
 * It is guaranteed that parentheses expression s is a VPS.
 */
public class Lc1614MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("abc(def[ghi]jkl)mno"));
        System.out.println(maxDepth("abc(def)ghi[jkl]mno"));

    }
    public static int maxDepth(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<StringBuilder>> map = new HashMap<>();
        int count = 0;
        int maxCount =0;

        for(int i =0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(currentChar=='(' || currentChar=='{' || currentChar=='['){
               stack.push(sb);
               count++;
               maxCount = Math.max(count,maxCount);
               sb=new StringBuilder();
            }
            else if(currentChar==')' || currentChar=='}' || currentChar==']'){
                if(!map.containsKey(count)){
                    map.put(count,new ArrayList<>());
                }
                map.get(count).add(sb);
                count--;
                sb = stack.pop();
            }
            else {
               sb.append(currentChar);
            }
        }
        System.out.println(map.get(maxCount));
        return maxCount;
    }
}

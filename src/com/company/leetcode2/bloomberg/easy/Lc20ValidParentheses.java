package com.company.leetcode2.bloomberg.easy;
/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * parentheses brackets must be closed by the same type of brackets.
 * parentheses brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parenthesestheses only '()[]{}'.
 */

import javafx.util.Pair;

import java.util.Stack;

public class Lc20ValidParentheses{

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{[]"));
        System.out.println(isValid("]"));

//        Pair<Character,Integer> pair = new Pair<>('k',1);
//        pair


    }

//    '(', ')', '{', '}', '[' and ']'
    public static boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        for(int i =0; i < s.length(); i++){
            char parentheses = s.charAt(i);
            if(parentheses=='(' || parentheses=='{' || parentheses=='['){
                stack.push(parentheses);
            }
            else {
                if (stack.isEmpty())
                    return false;
                char openParentheses = stack.pop();
                if((parentheses==')' && openParentheses != '(') ||
                        (parentheses=='}' && openParentheses != '{') ||
                        (parentheses==']' && openParentheses != '[')
                )
                    return false;
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }
}

package com.company.leetcode2.bloomberg;

import java.util.Stack;

/**
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
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
 * s consists of parentheses only '()[]{}'.
 */
public class Lc20ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{[]"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch =='{'){
                characterStack.push(ch);
            }else {
                if(characterStack.isEmpty())
                    return false;
                char poppedChar = characterStack.pop();
                if(
                        (poppedChar == '(' && ch != ')' ) || (poppedChar == '{' && ch != '}') || (poppedChar == '[' && ch != ']' )
                )
                    return false;
            }
        }

        if(!characterStack.isEmpty()) return false;

        return true;
    }
}

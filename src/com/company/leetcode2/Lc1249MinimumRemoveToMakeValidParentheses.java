package com.company.leetcode2;

/**
 * Medium
 *
 * 2081
 *
 * 48
 *
 * Add to List
 *
 * Share
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
 * so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 *
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s[i] is one of  '(' , ')' and lowercase English letters.
 */
public class Lc1249MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid( "))(("));

    }

    public static String minRemoveToMakeValid(String s) {
        if(s==null || s.length() == 0)
            return "";
//        check from left to right any ) without any ( should be marked for removal
        StringBuilder sb = new StringBuilder();
        char [] sArray = s.toCharArray();
        int open = 0;
        for (int i =0; i < sArray.length; i++){
            if(s.charAt(i)=='(')open++;
            if(s.charAt(i)==')'){
                if (open==0) continue;
                open--;
            }
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
//          check from left to right any ( without any ) should be marked for removal
        StringBuilder result = new StringBuilder();
        for(int i = sb.length()-1; i >= 0; i--){
            if(sb.charAt(i) =='(' && open > 0){
                open--;
                continue;
            }
            result.insert(0,sb.charAt(i));
        }
//
        return result.toString();
    }
}

package com.company.leetcode2.bloomberg.medium;

import java.util.Stack;

/**
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing
 * the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 *
 * It is guaranteed that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 *
 * Example 2:
 *
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 *
 * Example 3:
 *
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 */
public class Lc1209RemoveAllAdjacentDuplicatesinStringII {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcd");
        sb.delete(4-2,4);
        System.out.println(sb.toString());

        System.out.println(removeDuplicates("deeedbbcccbdaa",3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais",2));

    }

    public static String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(stack.isEmpty() || ch != sb.charAt(sb.length()-1)){
                stack.push(1);
                sb.append(ch);
            }else {
                int count = stack.pop() + 1;
                if(count==k){
                    sb.delete(sb.length()-k+1,sb.length());
                }else{
                    stack.push(count);
                    sb.append(ch);
                }

            }
        }

        return sb.toString();
    }
}

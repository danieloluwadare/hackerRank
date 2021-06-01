package com.company.leetcode2;

import java.util.Map;

/**
 * Given a string s and an array of integers cost where cost[i] is the cost of deleting the ith character in s.
 *
 * Return the minimum cost of deletions such that there are no two identical letters next to each other.
 *
 * Notice that you will delete the chosen characters at the same time, in other words, after deleting a character,
 * the costs of deleting other characters will not change.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abaac", cost = [1,2,3,4,5]
 * Output: 3
 * Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
 *
 * Example 2:
 *
 * Input: s = "abc", cost = [1,2,3]
 * Output: 0
 * Explanation: You don't need to delete any character because there are no identical letters next to each other.
 *
 * Example 3:
 *
 * Input: s = "aabaa", cost = [1,2,3,4,1]
 * Output: 2
 * Explanation: Delete the first and the last character, getting the string ("aba").
 *
 *
 *
 * Constraints:
 *
 *     s.length == cost.length
 *     1 <= s.length, cost.length <= 10^5
 *     1 <= cost[i] <= 10^4
 *     s contains only lowercase English letters.
 */
public class Lc1578MinimumDeletionCostToAvoidRepeatingLetters {

    public static void main(String[] args) {
//        Input: s = "abaac", cost = [1,2,3,4,5]
        System.out.println(minCost("abaac", new int[]{1,2,3,4,5}));
//        Input: s = "abc", cost = [1,2,3]
        System.out.println(minCost("abc", new int[]{1,2,3}));
//        Input: s = "aabaa", cost = [1,2,3,4,1]
        System.out.println(minCost("aabaa", new int[]{1,2,3,4,1}));

//        "aaabbbabbbb"
//[3,5,10,7,5,3,5,5,4,8,1]

        System.out.println(minCost("aaabbbabbbb", new int[]{3,5,10,7,5,3,5,5,4,8,1}));

    }
    public static int minCost(String s, int[] cost) {
        int minCost = 0;
        for (int i = 1; i < s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                minCost += Math.min(cost[i], cost[i-1]);
                if(cost[i] < cost[i-1]){
                    cost[i] = cost[i-1];
                }
            }
        }
        return minCost;
    }

}

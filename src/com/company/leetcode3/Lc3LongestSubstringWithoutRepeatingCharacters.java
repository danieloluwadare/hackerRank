package com.company.leetcode3;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class Lc3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        int maxCount = 1;
        int i = 1;
        int j = 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (i < s.length()){
            char currentChar = s.charAt(i);
            if(!set.contains(currentChar)){
                set.add(currentChar);
                maxCount = Math.max(i - j + 1, maxCount);
                i++;
            }else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return maxCount;
    }
}

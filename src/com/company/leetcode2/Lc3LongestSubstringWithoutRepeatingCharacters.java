package com.company.leetcode2;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 *
 * 14129
 *
 * 730
 *
 * Add to List
 *
 * Share
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

import java.util.HashSet;
import java.util.Set;


public class Lc3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int maxCount = 1;
        int i =1, j=0;
        set.add(s.charAt(0));
        while(i<s.length()){
            char currentChar = s.charAt(i);
            if(!set.contains(currentChar)){
              maxCount=Math.max(maxCount,i-j+1) ;
              set.add(currentChar);
              i++;
            }else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return maxCount;
    }
}

package com.company.leetcode2.bloomberg.easy;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 *
 * Note: You may assume the string contains only lowercase English letters.
 */
public class Lc387FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("test"));
        System.out.println(firstUniqChar("aaaaabvvv"));
        System.out.println(firstUniqChar("leetcode"));
    }
    public static int firstUniqChar(String s) {

        if (s == null || s.length() == 0)
            return -1;

        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(hash[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}

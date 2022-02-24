package com.company.leetcode2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 * Medium
 *
 * 1050
 *
 * 98
 *
 * Add to List
 *
 * Share
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
public class Lc1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public static void main(String[] args) {
        System.out.println(maxLength(Arrays.asList(new String[]{"un","iq","ue"})));
        System.out.println(maxLength(Arrays.asList(new String[]{"cha","r","act","ers"})));
        System.out.println(maxLength(Arrays.asList(new String[]{"abcdefghijklmnopqrstuvwxyz"})));


    }

    public static int maxLength(List<String> arr) {
        int maximum = 0;
        Set<Character> set = new HashSet<>();
//        for(int i = 0; i < arr.size(); i++){
//            for (int j = i+1; j <a)
//        }
        return 0;

    }
}

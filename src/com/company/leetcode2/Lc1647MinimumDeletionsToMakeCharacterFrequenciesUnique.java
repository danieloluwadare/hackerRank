package com.company.leetcode2;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in the string.
 * For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * Example 2:
 *
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 * Example 3:
 *
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s contains only lowercase English letters.
 */

import java.util.*;

public class Lc1647MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("ceabaacb"));
        System.out.println(minDeletions("abcabc"));

    }

    public static int minDeletions(String s){
        Map<Character, Integer>  map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+ 1);
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(map.values());
        list.sort((x, y)->y-x);
        System.out.println(list);
        int count = 0;
        int max = list.get(0);
        for(int i : list){
            if(max > 0 && max >= i){
                max = i-1;
            }
            else if(max > 0 && max < i){
                count += i-max;
                max= max - 1;
            }else {
                count += i;
            }
        }
        return count;
    }

}

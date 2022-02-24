package com.company.leetcode22.microsoft.medium;

import java.util.*;

/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 * Medium
 *
 * 1112
 *
 * 27
 *
 * Add to List
 *
 * Share
 * A string s is called good if there are no two different characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
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
 * Input: s = "ceabaacb" ==>"aaabbcce"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 *
 * Input: s = "aaabbbccddd"
 * Output: 2
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s contains only lowercase English letters.
 */
public class Lc1647MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));
        System.out.println(minDeletions("abcabc"));

    }

    public static int minDeletions(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        System.out.println(map);
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((x,y)->y-x);
        int max = Integer.MAX_VALUE;
        int count =0;
        for (int i =0; i < list.size(); i++){
            int num = list.get(i);
            if(max <= num){
                if(max > 0){
                    int difference = num - max + 1;
                    count+= difference;
                    max = num - difference;
                }else {
                    count+=num;
                }
            }else{
                max=num;
            }
        }

        /**
         * 6 min =6 c=0
         * 3 min =3 c=0
         * 3 =2 min=2 c=1
         * 3 =1 min=1 c=2
         * 3 =0 min=0 c=3
         * 2 =0 min=0 c=2
         */

        /**
         * 6 min=6
         * 6 = 5 min=5 c= 1
         * 4 min=4
         * 3 min=3
         * 3 = 2 min=2 c=2
         * 2 = 1 min=1 c=3
         * 1 = 0 min = 0 c= 4
         */

        return count;
    }
}

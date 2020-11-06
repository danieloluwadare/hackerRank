package com.company.leetcode;

/**
 * Given a string s, return the last substring of s in lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: "bab"
 * Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "tcode"
 *
 *
 * Note:
 *
 * 1 <= s.length <= 4 * 10^5
 * s contains only lowercase English letters.
 * best solution==> https://leetcode.com/problems/last-substring-in-lexicographical-order/discuss/822722/Easy-to-understand-Java-Solution
 */
public class Lc1163LastSubstringInLexicographicalOrder {
    public static void main(String[] args) {
//        System.out.println("bz".compareTo("ba"));
//        System.out.println("zg".compareTo("z"));
//        System.out.println("z".compareTo("zzz"));
//        System.out.println("abcde".substring(1));
//
        System.out.println(lastSubstring("leetcode"));
    }

    public static String lastSubstring(String s) {

        StringBuilder sb = new StringBuilder(s);
        String max = "";
        char highestChar = sb.charAt(0);
        int i = 0;
        while (i < sb.length()){
            if(sb.charAt(i) >= highestChar ){
                highestChar= sb.charAt(i);
                max=maxString(max,sb.substring(i));
            }
            i++;

//            check if previous char is the same as present char
//            e.g  zzza
            while (i < sb.length() && sb.charAt(i-1)==sb.charAt(i)){
                i++;
            }

        }

        return max;
    }

    public static String maxString(String maxString, String newString){
        if(maxString.compareTo(newString) > 0)
            return maxString;
        if(maxString.compareTo(newString) < 0)
            return newString;
        return maxString;
    }
}
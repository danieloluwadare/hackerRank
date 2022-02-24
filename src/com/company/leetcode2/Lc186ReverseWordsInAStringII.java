package com.company.leetcode2;

import java.util.Arrays;

/**
 * 186. Reverse Words in a String II
 * Medium
 *
 * 663
 *
 * 122
 *
 * Add to List
 *
 * Share
 * Given a character array s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
 *
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Example 2:
 *
 * Input: s = ["a"]
 * Output: ["a"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
 * There is at least one word in s.
 * s does not contain leading or trailing spaces.
 * All the words in s are guaranteed to be separated by a single space.
 */
public class Lc186ReverseWordsInAStringII {
    public static void main(String[] args) {
        reverseWords(new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
    }

    public static void reverseWords(char[] s) {
        for (int i = 0; i < s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length - i - 1] ;
            s[s.length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(s));

        int i = 0;
        int j = 0;
        while (j <= s.length){
            if(j == s.length || s[j]==' '){
                int difference = j - i;
                for (int k = 0; k < difference / 2; k++){
                    char temp = s[i + k];
                    s[i + k] = s[j - k - 1];
                    s[j - k -1] = temp;
                }
                i=j+1;
            }
            j++;
        }

        System.out.println(Arrays.toString(s));
    }
}

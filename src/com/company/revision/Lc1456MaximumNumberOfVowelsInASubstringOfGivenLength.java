package com.company.revision;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Medium
 *
 * 514
 *
 * 27
 *
 * Add to List
 *
 * Share
 * Given a string s and an integer k.
 *
 * Return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are (a, e, i, o, u).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * Example 4:
 *
 * Input: s = "rhythms", k = 4
 * Output: 0
 * Explanation: We can see that s doesn't have any vowel letters.
 * Example 5:
 *
 * Input: s = "tryhard", k = 4
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
public class Lc1456MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("leetcode", 3));
        System.out.println(maxVowels("rhythms", 4));
        System.out.println(maxVowels("tryhard", 4));
    }

    public static int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i'); vowels.add('o'); vowels.add('u');
        int maxVowelCount = 0;
        int currentVowelCount = 0;
        for(int i = 0, j = 0;  i < s.length(); i++ ){
            char charAtIndexI = s.charAt(i);
            if(i < k){
                if(vowels.contains(charAtIndexI)){
                    maxVowelCount++;currentVowelCount++;
                }
            }else {
                char charAtIndexJ = s.charAt(j);
                if(vowels.contains(charAtIndexJ))
                    currentVowelCount--;
                if(vowels.contains(charAtIndexI))
                    currentVowelCount++;

                maxVowelCount = Math.max(currentVowelCount,maxVowelCount);
                j++;
            }
        }
        return maxVowelCount;
    }
}

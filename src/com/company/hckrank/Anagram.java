package com.company.hckrank;

/**
 * Two words are anagrams of one another if their letters can be rearranged to form the other word.
 *
 * Given a string, split it into two contiguous substrings of equal length. Determine the minimum number of characters to change to make the two substrings into anagrams of one another.
 *
 * Example
 *
 * Break  into two parts: 'abc' and 'cde'. Note that all letters have been used, the substrings are contiguous and their lengths are equal. Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams. Two changes were necessary.
 *
 * Function Description
 *
 * Complete the anagram function in the editor below.
 *
 * anagram has the following parameter(s):
 *
 * string s: a string
 * Returns
 *
 * int: the minimum number of characters to change or -1.
 * Input Format
 *
 * The first line will contain an integer, , the number of test cases.
 * Each test case will contain a string .
 *
 * -----------------------------
 * Constraints
 *
 *
 *  consists only of characters in the range ascii[a-z].
 * Sample Input
 *
 * 6
 * aaabbb
 * ab
 * abc
 * mnop
 * xyyx
 * xaxbbbxx
 * Sample Output
 *
 * 3
 * 1
 * -1
 * 2
 * 0
 * 1
 * Explanation
 *
 * Test Case #01: We split  into two strings ='aaa' and ='bbb'. We have to replace all three characters from the first string with 'b' to make the strings anagrams.
 *
 * Test Case #02: You have to replace 'a' with 'b', which will generate "bb".
 *
 * Test Case #03: It is not possible for two strings of unequal length to be anagrams of one another.
 *
 * Test Case #04: We have to replace both the characters of first string ("mn") to make it an anagram of the other one.
 *
 * Test Case #05:  and  are already anagrams of one another.
 *
 * Test Case #06: Here S1 = "xaxb" and S2 = "bbxx". You must replace 'a' from S1 with 'b' so that S1 = "xbxb".
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(anagram("aaabbb") == 3);
        System.out.println(anagram("ab") == 1);
        System.out.println(anagram("abc") == -1);
        System.out.println(anagram("mnop") == 2);
        System.out.println(anagram("xyyx") == 0);
        System.out.println(anagram("xaxbbbxx") == 1);


    }

    public static int anagram(String s) {
        // Write your code here
        if(s.length()%2 != 0)
            return -1;
        int [] hash = new int[26];
        for (int i = 0; i < s.length(); i++){
            int charIndex = s.charAt(i) - 'a';
            if(i < s.length() / 2)
                hash[charIndex]++;
            else
                hash[charIndex]--;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(hash[i] > 0)
                count += hash[i];
        }
        System.out.println(count);
        return count;
    }
}

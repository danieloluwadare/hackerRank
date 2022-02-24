package com.company.leetcode22.microsoft.easy;

/**
 * 557. Reverse Words in a String III
 * Easy
 *
 * 2442
 *
 * 150
 *
 * Add to List
 *
 * Share
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 */
public class Lc557ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("God Ding"));
    }

    public static String reverseWords(String s) {
        String [] splitStrings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : splitStrings){
            char[] charWords = word.toCharArray();
            for(int i =0;  i < charWords.length/2; i++){
                char temp = charWords[i];
                charWords[i] = charWords[charWords.length - i -1];
                charWords[charWords.length - i -1] = temp;
            }
            sb.append(charWords).append(" ");
        }
        return sb.toString().trim();
    }
}

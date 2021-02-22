package com.company.leetcode2.bloomberg.easy;

public class Lc242ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","tar"));
        System.out.println(isAnagram("rat","jar"));

    }
    public static boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        int [] hash = new int[26];
        for(int i = 0; i < s.length(); i++)
            hash[s.charAt(i)-'a']++;

        for(int i = 0; i < t.length(); i++){
            hash[t.charAt(i)-'a']--;
            if(hash[t.charAt(i)-'a'] < 0)
                return false;
        }

        return true;
    }
}

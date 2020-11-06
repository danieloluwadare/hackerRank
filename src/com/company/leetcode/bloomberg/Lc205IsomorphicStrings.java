package com.company.leetcode.bloomberg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 */
public class Lc205IsomorphicStrings {
    public static void main(String[] args) {
//        Input: s = "egg", t = "add"
        System.out.println(isIsomorphic("egg","add"));

//        Input: s = "foo", t = "bar"
        System.out.println(isIsomorphic("foo","bar"));

//        Input: s = "paper", t = "title"
        System.out.println(isIsomorphic("paper","title"));

        System.out.println(isIsomorphic("aba","baa"));

    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;

        return (compareString(s,t)&&compareString(t,s));

    }
    public static boolean compareString(String s, String t) {
        Character[] hash = new Character[256];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(hash[ch] != null){
                if(hash[ch] != t.charAt(i))
                    return false;
            }
            hash[ch] = t.charAt(i);
        }

        return true;
    }
}

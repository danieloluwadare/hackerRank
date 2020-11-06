package com.company.leetcode;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */
public class Lc49GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));


    }

    public static List<List<String>> groupAnagrams(String [] strs){

        Map<Integer, Set<String>> map = new HashMap<>();
        for(String str : strs){
            int asciiValue = 0;
            for(char ch : str.toCharArray()){
                asciiValue+=ch;
            }

            if(!map.containsKey(asciiValue))
                map.put(asciiValue,new HashSet<>());

            map.get(asciiValue).add(str);
        }

        List<List<String>> lists = new ArrayList<>();
        List<String> list;
        for(int key : map.keySet()){
             list = new ArrayList<>(map.get(key));
            lists.add(list);
        }

        return lists;
    }

}

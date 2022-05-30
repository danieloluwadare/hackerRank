package com.company.leetcode22.hashing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. Group Anagrams
 * Medium
 *
 * Add to List
 *
 * Share
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
 * strs[i] consists of lowercase English letters.
 */
public class Lc49GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));

//        int a = 0;
//        String s = "ill";//duh
////        String s = "duh";//duh
//
//        for(char ch :s.toCharArray())
//            a+=ch-'a';
//        System.out.println(a);

        int arr [] = new int [5];
        System.out.println(Arrays.toString(arr));

        PriorityQueue<Integer> leaderBoard = new PriorityQueue<>();
        leaderBoard.add(1);
        leaderBoard.add(5);
        leaderBoard.add(9);

        List<Integer> list = new ArrayList<>(leaderBoard);
        System.out.println(list);
        leaderBoard.size();
        System.out.println(leaderBoard.poll());
        System.out.println(leaderBoard.poll());

//        while (!leaderBoard.isEmpty()){
//            System.out.println(leaderBoard.poll());
//        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for(String str : strs){
            Arrays.fill(count,0);
            for (char ch : str.toCharArray())
                count[ch-'a']++;
            StringBuilder sb = new StringBuilder();
            for(int i =0; i < 26; i++){
                sb.append("*");
                sb.append(count[i]);
            }
            if(!map.containsKey(sb.toString()))
                map.put(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

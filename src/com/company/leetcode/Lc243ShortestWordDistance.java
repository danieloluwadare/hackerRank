package com.company.leetcode;

import java.util.*;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class Lc243ShortestWordDistance {
    public static void main(String[] args) {
        System.out.println(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding","practice"
                ));
        System.out.println(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes","practice"
        ));
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        if(words.length < 2)
            return 0;

        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i]))
                map.put(words[i], new HashSet<>());

            map.get(words[i]).add(i);
        }
        Set<Integer> word1List = map.get(word1);
        Set<Integer> word2List = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int word1Index : word1List){
            for (int word2Index : word2List){
               min= Math.min(Math.abs(word1Index-word2Index), min);
            }
        }

        return min;
    }
    public int shortestDistance2(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }
}

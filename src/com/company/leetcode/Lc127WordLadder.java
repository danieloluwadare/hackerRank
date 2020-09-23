package com.company.leetcode;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class Lc127WordLadder {

    public static void main(String[] args) {
//        beginWord = "hit",
//                endWord = "cog",
//                wordList = ["hot","dot","dog","lot","log","cog"]
        System.out.println(ladderLength("hit","cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));

//        beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]

        System.out.println(ladderLength("hit","cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log"})));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord))
            return 0;

        Map<String,Set<String>> genericWords = new HashMap<>();
//        create set of possible words
        for(String word : wordSet){
            for(int i =0; i < word.length(); i++){
                String newGenericWord = word.substring(0,i).concat("*").concat(word.substring(i+1));
                if(!genericWords.containsKey(newGenericWord)){
                    genericWords.put(newGenericWord,new HashSet<>());
                }
                genericWords.get(newGenericWord).add(word);
            }
        }

//
        Queue<Set<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
//
        queue.offer(new HashSet<String>(Collections.singleton(beginWord)));
        int level = 0;

        while(!queue.isEmpty()){
            Set<String> children = new HashSet<>();
            Set<String> currentLevel = queue.poll();
            if(currentLevel.size() > 0){
                for(String child : currentLevel){
                    if(visited.contains(child))
                        continue;

                    visited.add(child);

                    if(endWord.equalsIgnoreCase(child))
                        return level + 1;

                    for(int i = 0; i < child.length(); i++){
                        String keyWord = child.substring(0,i).concat("*").concat(child.substring(i+1));
                        if(genericWords.containsKey(keyWord))
                            children.addAll(genericWords.get(keyWord));
                    }

                }
                level++;
                queue.add(children);
            }


        }

        return 0;
    }
}

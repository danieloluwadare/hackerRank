package com.company.revision;

import java.util.*;

/**
 * Given a list of words, each word consists of English lowercase letters.
 *
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1
 * to make it equal to word2.
 * For example, "abc" is a predecessor of "abac".
 *
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor
 * of word_2, word_2 is a predecessor of word_3, and so on.
 *
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chain is "a","ba","bda","bdca".
 *
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of English lowercase letters
 */
public class RevLc1048LongestStringChain {
    public static void main(String[] args) {
//        System.out.println("asd".substring(0,0)+"asd".substring(1));
//        System.out.println("asd".substring(0,1)+"asd".substring(2));
//        System.out.println("asd".substring(0,2)+"asd".substring(3));

        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
    public static int longestStrChain(String[] words) {
        Map<String,Set<String>> graph = buildGraph(words);
        Set<String> visited = new HashSet<>();
        Map<String, Integer> pathLength  = new HashMap<>();
        for(String key : graph.keySet()){
            if(!visited.contains(key))
                dfsGraph(key,pathLength,visited,graph);
        }
        int longestPath = 0;
        for(String key : pathLength.keySet()){
            longestPath = Math.max(pathLength.get(key),longestPath);
        }
        return longestPath;
    }

    private static void dfsGraph(String key, Map<String, Integer> pathLength,
                                 Set<String> visited, Map<String, Set<String>> graph) {
        if(visited.contains(key))
            return;
        visited.add(key);
        if(graph.containsKey(key)){
            for(String child : graph.get(key)){
                if(!visited.contains(child))
                    dfsGraph(child,pathLength,visited,graph);
                int longestPath = Math.max(pathLength.getOrDefault(key,0),
                        pathLength.getOrDefault(child,1)+1);
                pathLength.put(key,longestPath);
            }
        }
    }

    public static Map<String, Set<String>> buildGraph(String [] words){
        Set<String> set = new HashSet<>(Arrays.asList(words));

        Map<String,Set<String>> graph = new HashMap<>();
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                String newWord = word.substring(0,i).concat(word.substring(i+1));
                if(set.contains(newWord)){
                    if(!graph.containsKey(newWord))
                        graph.put(newWord,new HashSet<>());
                    graph.get(newWord).add(word);
                }
            }
        }

        System.out.println(graph);
        return graph;
    }
}

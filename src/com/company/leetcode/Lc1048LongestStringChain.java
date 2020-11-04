package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc1048LongestStringChain {
    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }

    public static int longestStrChain(String[] words) {
        if(words==null || words.length==0)
            return 0;
        Map<String, Set<String>> graph = buildGraph(words);
        Map<String, Integer> nodeLongestPath = new HashMap<>();
        Set<String> visited  = new HashSet<>();
        for(String node : graph.keySet()){
            if(!visited.contains(node)){
                dfsHelper(node,graph,nodeLongestPath,visited);
            }
        }

        int max = 1;
        for(String node : nodeLongestPath.keySet()){
            max = Math.max(max, nodeLongestPath.get(node));
        }

        return max;
    }

    static void dfsHelper(String node, Map<String, Set<String>> graph,Map<String, Integer> nodeLongestPath, Set<String> visited){
        if(visited.contains(node))
            return;
        visited.add(node);
        if(graph.containsKey(node)){
            for (String childrenNode : graph.get(node)){
                if(!visited.contains(childrenNode))
                    dfsHelper(childrenNode,graph,nodeLongestPath,visited);
                int longest = Math.max(nodeLongestPath.getOrDefault(node, 0), nodeLongestPath.getOrDefault(childrenNode,1)+1);
                nodeLongestPath.put(node, longest);
            }
        }

    }

    static Map<String, Set<String>> buildGraph(String[] words){
        Set<String> setOfWords = new HashSet<>();
        for(String word : words)
            setOfWords.add(word);

        Map<String, Set<String>> graph = new HashMap<>();
        for(String word : words){
            for(int i = 0; i<word.length();i++){
                String subWord = word.substring(0,i).concat(word.substring(i+1));
                if(setOfWords.contains(subWord)){
                    if(!graph.containsKey(subWord)){
                        Set<String> children = new HashSet<>();
                        graph.put(subWord,children);
                    }
                    graph.get(subWord).add(word);
                }

            }
        }
        return graph;
    }
}

package com.company.leetcode;
/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j]
 */

import java.util.*;

public class Lc886PossibleBipartition {

    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}}));
        System.out.println(possibleBipartition(3, new int[][]{{1,2},{1,3},{2,3}}));
        System.out.println(possibleBipartition(5, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));
        System.out.println(possibleBipartition(10, new int[][]{{1,2},{2,5},{5,6},{1,6}}));
        System.out.println(possibleBipartition(10, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));

    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        if(N < 1)
            return false;
        if(N > 0 && dislikes.length == 0)
            return true;

//        partition contains only 2 group
//        0 && 1
//        partition of node to group
        Map<Integer,Integer> partition = new HashMap<>();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int [] dislike : dislikes){
            int firstDislike = dislike[0];
            int secondDislike = dislike[1];

            if(!graph.containsKey(firstDislike))
                graph.put(firstDislike, new HashSet<>());
            if(!graph.containsKey(secondDislike))
                graph.put(secondDislike, new HashSet<>());

            graph.get(firstDislike).add(secondDislike);
            graph.get(secondDislike).add(firstDislike);
        }

        for(int i =1; i <= N; i++){
            if(partition.containsKey(i))
                continue;
            if(!dfsHelperFindCycle(i, 0, partition,graph))
                return false;
        }
        return true;
    }


    public static boolean dfsHelperFindCycle(int node, int group, Map<Integer,Integer> partition, Map<Integer, Set<Integer>> graph) {
        if(partition.containsKey(node))
            return partition.get(node)==group;

        partition.put(node,group);
//        get children and run dfs with opposite group
        if(graph.containsKey(node)){
            for(int child : graph.get(node)) {
                int oppositeGroup = (group == 0) ? 1 : 0;
                if (!dfsHelperFindCycle(child, oppositeGroup, partition, graph)){
                    return false;
                }
            }
        }

        return true;
    }


}

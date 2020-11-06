package com.company.leetcode;

// Suppose we have some input val describing a graph of relationships between parents and children over multiple
// generations. The val is formatted as a list of (parent, child) pairs, where each individual is assigned a unique
// integer identifier.
// For example, in this diagram, 6 and 8 have a common ancestor of 4.
//          14  13
//          |   |
// 1   2    4   12
//  \ /   / | \ /
//   3   5  8  9
//    \ / \     \
//     6   7     11
// parentChildPairs1 = [
//     (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
//     (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
// ]
// Write a function that takes the graph, as well as two of the individuals in our dataset,
// as its inputs and returns true if and only if they share at least one ancestor.
// Sample input and output:
// hasCommonAncestor(parentChildPairs1, 3, 8) => false
// hasCommonAncestor(parentChildPairs1, 5, 8) => true
// hasCommonAncestor(parentChildPairs1, 6, 8) => true
// hasCommonAncestor(parentChildPairs1, 6, 9) => true
// hasCommonAncestor(parentChildPairs1, 1, 3) => false
// hasCommonAncestor(parentChildPairs1, 7, 11) => true
// hasCommonAncestor(parentChildPairs1, 6, 5) => true
// hasCommonAncestor(parentChildPairs1, 5, 6) => true
// Additional example: In this diagram, 4 and 12 have a common ancestor of 11.
//         11
//        /  \
//       10   12
//      /  \
// 1   2    5
//  \ /    / \
//   3    6   7
//    \        \
//     4        8
// parentChildPairs2 = [
//     (11, 10), (11, 12), (10, 2), (10, 5), (1, 3),
//     (2, 3), (3, 4), (5, 6), (5, 7), (7, 8),
// ]
// hasCommonAncestor(parentChildPairs2, 4, 12) => true
// hasCommonAncestor(parentChildPairs2, 1, 6) => false
// hasCommonAncestor(parentChildPairs2, 1, 12) => false


import java.util.*;

public class HasCommonAncestor {

    public static void main(String[] args) {
//        create graph using hashmap of child to set of parents
//        e.g 30->1,2| 2->10
//        use bfs to transverse each childs parents and parents parents to get all ancestors.
//          (parent, child)
        int[][] parentChildPairs1 = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}
        };
        int[][] parentChildPairs2 = new int[][] {
                {11, 10}, {11, 12}, {10, 2}, {10, 5}, {1, 3},
                {2, 3}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
        };

//        System.out.println(hasCommonAncestors(parentChildPairs1, 3, 8));
//        System.out.println(hasCommonAncestors(parentChildPairs1, 5, 8));
//        System.out.println(hasCommonAncestors(parentChildPairs1, 6, 8));
//        System.out.println(hasCommonAncestors(parentChildPairs1, 6, 9));
//        System.out.println(hasCommonAncestors(parentChildPairs1, 1, 3));
//        System.out.println(hasCommonAncestors(parentChildPairs1, 7, 11));
//        System.out.println(hasCommonAncestors(parentChildPairs1, 6, 5));
//        System.out.println(hasCommonAncestors(parentChildPairs1, 5, 6));
//        System.out.println(hasCommonAncestors(parentChildPairs1, 5, 8));

        System.out.println(hasCommonAncestors(parentChildPairs2, 4, 12));
        System.out.println(hasCommonAncestors(parentChildPairs2, 1, 6));
        System.out.println(hasCommonAncestors(parentChildPairs2, 1, 12));




    }

    public static boolean hasCommonAncestors(int [][] parentChild, int childOne, int childTwo){
        Map<Integer,Set<Integer>> childParentGraph = generateGraph(parentChild);
        Set<Integer>childOneAncestors = getAllAncestorsForAChild(childParentGraph, childOne);
        Set<Integer>childTwoAncestors = getAllAncestorsForAChild(childParentGraph, childTwo);

        for(int ancestor : childOneAncestors){
            if(childTwoAncestors.contains(ancestor)){
                return true;
            }
        }

        return false;

    }

    public static Map<Integer,Set<Integer>> generateGraph(int [][] parentChild){
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i<parentChild.length; i++){
            int parent = parentChild[i][0];
            int child = parentChild[i][1];

            if(graph.containsKey(child)){
                graph.get(child).add(parent);
            }
            else {
                Set<Integer> set = new HashSet<>();
                set.add(parent);
                graph.put(child,set);
            }
        }
        return graph;
    }

    public static Set<Integer> getAllAncestorsForAChild(Map<Integer,Set<Integer>>graph, int child){
        Set<Integer> ancestors = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = graph.get(child);
        if(set !=null && !set.isEmpty()){
            queue.addAll(set);
        }
        while (!queue.isEmpty()){
            int ancestor = queue.remove();
            ancestors.add(ancestor);
            Set<Integer> parents = graph.get(ancestor);
            if(parents != null && !parents.isEmpty()){
                queue.addAll(parents);
            }

        }
        return ancestors;
    }

}



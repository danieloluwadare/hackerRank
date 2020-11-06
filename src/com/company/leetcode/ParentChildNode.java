/*
Suppose we have some input val describing a graph of relationships between parents and children over multiple generations. The val is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4
 \ /   / | \
  3   5  8  9
   \ / \     \
    6   7    11


Sample input/output (pseudodata):

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6),
    (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
]


Write a function that takes this val as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.


Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 4],       // Individuals with zero parents
  [5, 7, 8, 9, 11] // Individuals with exactly one parent
]

n: number of pairs in the input
*/


package com.company.leetcode;

import java.util.*;


public class ParentChildNode {

    public static void main(String[] argv) {

//     {a->parent, b->child}

        int[][] parentChildPairs = new int[][] {
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {9, 11}
        };

        System.out.println("Answers =======");
        Map<Integer, Set<Integer>> resultset = findNodesWithZeroAndOneParents(parentChildPairs);

        for(Integer key : resultset.keySet()){
            Set<Integer>  parentChild = resultset.get(key);
            for(Integer child : parentChild){
                System.out.print(child);
            }

            System.out.println("-----------------------");

        }
    }

    public static Map<Integer, Set<Integer>> findNodesWithZeroAndOneParents(int [][] arr){
        Map<Integer,List<Integer>> map = new HashMap<>();
//     Generate the graph for child to parent
        for(int i = 0; i <arr.length; i++){
            int parent = arr[i][0];
            int child = arr[i][1];

            if(map.containsKey(child)){
                map.get(child).add(parent);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(parent);
                map.put(child, list);
            }

        }

        for(Integer key : map.keySet()){
            System.out.println("Child "+key+" parents->");
            List<Integer>  parentChild = map.get(key);
            for(Integer child : parentChild){
                System.out.println(child);
            }

            System.out.println("-----------------------");

        }





        Map<Integer, Set<Integer>> result = new HashMap<>();

        Set<Integer> zeroParents = new HashSet<>();
//     Get the list of child with no parent
        for(int i =0; i<arr.length; i++){
            int pontentialChildWithNoParent1 = arr[i][0];
            int pontentialChildWithNoParent2 = arr[i][1];



            if(!map.containsKey(pontentialChildWithNoParent1)){
                zeroParents.add(pontentialChildWithNoParent1);
            }
//            if(!map.containsKey(pontentialChildWithNoParent2)){
//                zeroParents.add(pontentialChildWithNoParent2);
//            }

        }



//     get list of children with just 1 parent

        Set<Integer> oneParent = new HashSet<>();

        for(int i =0; i<arr.length; i++){
            int pontentialChildWithOneParent1 = arr[i][0];
            int pontentialChildWithOneParent2 = arr[i][1];

            if(map.containsKey(pontentialChildWithOneParent1)){
                int parentSize =  map.get(pontentialChildWithOneParent1).size();
                if(parentSize==1){
                    oneParent.add(pontentialChildWithOneParent1);
                }
            }

            if(map.containsKey(pontentialChildWithOneParent2)){
                int parentSize =  map.get(pontentialChildWithOneParent2).size();
                if(parentSize==1){
                    oneParent.add(pontentialChildWithOneParent2);
                }
            }

//       if(!map.containsKey(pontentialChildWithNoParent2)){
//         zeroParents.add(pontentialChildWithNoParent2);
//       }

        }


        result.put(0,zeroParents);
        result.put(1,oneParent);

        return result;

    }


}


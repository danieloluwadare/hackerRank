package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *
 * Example 1:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 *
 *
 * Example 2:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 *
 *
 *
 * Constraints:
 *
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 */
public class Lc547FriendCircles {

    public static void main(String[] args) {
        int [][] arr = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        int [][] arr2 = {
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };

        int [][] arr3 = {
                {1}
        };

        System.out.println(findCircleNum(arr));
        System.out.println(findCircleNum(arr2));
        System.out.println(findCircleNum(arr3));

    }

    public static int findCircleNum(int[][] M) {

        if(M.length <= 1)
            return 0;
        //build graph

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[i].length;j++){
                if(i==j)
                    continue;
                if(M[i][j]==1){
                    if(!map.containsKey(i))
                        map.put(i,new HashSet<>());
                    map.get(i).add(j);

                    if(!map.containsKey(j))
                        map.put(j,new HashSet<>());
                    map.get(j).add(i);
                }
            }
        }

        int friendCircle= 0;
        boolean [] visited = new boolean[M.length];

        for(int i = 0; i < M.length; i++) {
            if(!visited[i]){
                dfsHelper(i,map,visited);
                friendCircle++;
            }
        }
        return friendCircle;
    }

    public static void dfsHelper(int i, Map<Integer, Set<Integer>> map,boolean [] visited){
        if(visited[i]){
            return;
        }
        visited[i]=true;
        if(map.containsKey(i)){
            for(int children : map.get(i)){
                dfsHelper(children,map,visited);
            }
        }

    }
}

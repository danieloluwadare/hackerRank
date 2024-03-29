package com.company.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 *
 * Suppose you are at a party with n people (labeled from 0 to n - 1), and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her, but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one.
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B.
 * You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n).
 * There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party.
 * If there is no celebrity, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j,
 * otherwise graph[i][j] = 0 means person i does not know person j.
 * The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
 *
 * Example 2:
 *
 * Input: graph = [[1,0,1],[1,1,0],[0,1,1]]
 * Output: -1
 * Explanation: There is no celebrity.
 *
 *
 *
 * Constraints:
 *
 *     n == graph.length
 *     n == graph[i].length
 *     2 <= n <= 100
 *     graph[i][j] is 0 or 1.
 *     graph[i][i] == 1
 *
 *
 * Follow up: If the maximum number of allowed calls to the API knows is 3 * n, could you find a solution without exceeding the maximum number of calls?
 */

public class Lc277FindTheCelebrity {


    public static void main(String[] args) {
        int [][] graph = new int[][]{
                {1,1,0},
                {0,1,0},
                {1,1,1}
        };
        Solution solution = new Solution(graph);
        try {
            System.out.println(solution.findCelebrity(3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        graph = new int[][]{
                {1,0,1},
                {1,1,0},
                {0,1,1}
        };
        solution = new Solution(graph);
        try {
            System.out.println(solution.findCelebrity(3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        graph = new int[][]{
                {1,1},
                {1,1}
        };
        solution = new Solution(graph);
        try {
            System.out.println(solution.findCelebrity(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    public static class Solution extends Relation {
        public Solution(int[][] arr) {
            super(arr);
        }

        public int findCelebrity(int n) throws Exception {
//            Find potential celebrity;
            int potentialCelebrity = 0;
            for (int i = 1; i < n; i++){
                if(knows(potentialCelebrity,i)){
                    potentialCelebrity = i;
                }
            }

//            Check if potential celebrity is know by every one
            for (int i = 0; i < n; i++){
                if(i != potentialCelebrity && !knows(i, potentialCelebrity))
                    return -1;
                if(i != potentialCelebrity && knows(potentialCelebrity, i))
                    return -1;
            }

            return potentialCelebrity;
        }
    }

    public static class Relation{
        int [][] arr;
        int count;
        public Relation(int[][] arr) {
            this.arr = arr;
            this.count=0;
        }

        public boolean knows(int a, int b) throws Exception {
            if(count == 3 * arr.length)
                throw new Exception("Maximum call reached");
            count++;
            return arr[a][b] == 1;
        }

        public int getCount() {
            return count;
        }
    }
}

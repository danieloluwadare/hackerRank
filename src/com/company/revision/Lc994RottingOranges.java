package com.company.revision;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * Medium
 *
 * 4066
 *
 * 227
 *
 * Add to List
 *
 * Share
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
public class Lc994RottingOranges {

    public static void main(String[] args) {
        int [][] grid = new int[][]
                {
                        {2,1,1},
                        {1,1,0},
                        {0,1,1}
                };
        System.out.println(orangesRotting(grid));
        grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(grid));
        grid = new int[][]{{0,2}};
        System.out.println(orangesRotting(grid));
        grid = new int[][]{{0,1,1},{1,0,2},{2,0,1}};
        System.out.println(orangesRotting(grid));

        grid = new int[][]{{0}};
        System.out.println(orangesRotting(grid));

        grid = new int[][]{{0,2,2}};
        System.out.println(orangesRotting(grid));

        grid = new int[][]{{2,1,1},{1,1,1},{0,1,2}};
        System.out.println(orangesRotting(grid));

    }

    public static int orangesRotting(int[][] grid) {

        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int numOfGoodOranges = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)
                    queue.add(new Pair<>(i, j));
                else if (grid[i][j] == 1){
                    numOfGoodOranges++;
                }

            }
        }

        int [][] xyOrdinates = {{-1,0},{1,0},{0,-1},{0,1}};
//        This is our marker
        queue.add(new Pair<>(-1,-1));
        int minutesCount = -1;

         while (!queue.isEmpty()){
             Pair<Integer, Integer> pair = queue.poll();
             int i = pair.getKey();
             int j = pair.getValue();
             if(i == -1){
                 minutesCount++;
                 if(!queue.isEmpty()) queue.add(new Pair<>(-1,-1));
             }else{
                 for(int [] xy : xyOrdinates){
                     int row = i + xy[0];
                     int col = j + xy[1];
                     if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1){
                         continue;
                     }
                     grid[row][col] = 2;
                     numOfGoodOranges--;
                     queue.add(new Pair<>(row,col));
                 }
             }
         }


         return numOfGoodOranges == 0 ? minutesCount : -1;

    }



}

package com.company.leetcode2;

/**
 * 695. Max Area of Island
 * Medium
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Lc695MaxAreaOfIsland {
    public static void main(String[] args) {
        int [][] arr = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(arr));
        int [][] arr2 = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(maxAreaOfIsland(arr2));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        int maxArea = 0;
        for(int i =0; i < grid.length; i++){
            for (int j =0; j < grid[0].length; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    maxArea = Math.max(maxAreaOfIslandHelper(grid,i,j,visited),maxArea);
                }
            }
        }

        return maxArea;
    }

    private static int maxAreaOfIslandHelper(int[][] grid, int i, int j, boolean[][] visited) {
        if(i<0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == 0 || visited[i][j] )
            return 0;
        visited[i][j]=true;
        return 1 + maxAreaOfIslandHelper(grid,i+1,j,visited)
        + maxAreaOfIslandHelper(grid,i,j+1,visited)
        + maxAreaOfIslandHelper(grid,i-1,j,visited)
        + maxAreaOfIslandHelper(grid,i,j-1,visited);
    }
}

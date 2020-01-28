package com.company.leetcode;

import java.util.Arrays;

public class NumberofIslands200 {
    public static void main(String[] args) {
        char [][] arr = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}

        };
        char [][] arr2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}

        };

        System.out.println(numIslands(arr));
        System.out.println(numIslands(arr2));

//        char [][] arr2 = {
//                {'1','2','3','1','0'},
//                {'4','5','6','1','0'},
//                {'7','8','9','0','0'},
//                {'0','0','0','0','0'}
//
//        };
//        getSurroundingNeigbors(arr2, 1, 0);
    }

    public static int numIslands(char[][] grid) {
        int numOfIsland = 0;
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){

                if(visited[i][j] || grid[i][j] == '0'){
                    continue;
                }

                numOfIsland++;
                getSurroundingIslands(grid, visited, i, j);

            }
        }
        return numOfIsland;
    }

    public static void getSurroundingIslands(char [][] arr, boolean [][] visited, int i, int j){
        if((i>=0 && i<arr.length) &&  (j>=0 && j<arr[0].length) && !visited[i][j]) {
            visited[i][j] = true;
            if (arr[i][j] != '0') {
                getSurroundingIslands(arr, visited, i-1, j);
                getSurroundingIslands(arr, visited, i, j-1);
                getSurroundingIslands(arr, visited, i, j+1);
                getSurroundingIslands(arr, visited, i+1, j);
            }
        }
    }
}

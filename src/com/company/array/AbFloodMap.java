package com.company.array;

import java.util.HashSet;
        import java.util.Set;
public class AbFloodMap {
    public static void main(String[] args) {
        // write your code here
//        Solution sol = new Solution();
//        int[][] testInput = {
//                {1, 1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0},
//                {1, 1, 1, 0, 0, 0},
//                {0, 0, 2, 4, 4, 0},
//                {0, 0, 0, 2, 0, 0},
//                {0, 0, 1, 2, 4, 0}
//        };
//        int[][] testOutput = sol.findHighPoints(testInput);
//        Solution2 sol = new Solution2();
//        int[][] testInput = {{1,2,1,3,4}, {1,5,2,2,2}, {4,5,1,9,7}, {3,5,3,7,6}, {4,3,1,7,3}};
//        int[][] testOutput = sol.findRiskScores(testInput);
        Solution3 sol = new Solution3();
        int[][] testInput = {{1,2,1,3,4}, {1,5,2,2,2}, {4,5,1,9,7}, {3,5,3,7,6}, {4,3,1,7,3}};
        boolean[][] testOutput = sol.findHighPoints3(testInput);
        for(int i=0; i < testOutput.length; i++){
            for(int j=0; j< testOutput[0].length; j++){
                System.out.print(testOutput[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
/// QUESTION 3
class Solution3{
    public boolean[][] findHighPoints3(int[][] elevations) {
        boolean[][] returnArr = new boolean[elevations.length][elevations[0].length];
        for(int i = 0; i < elevations.length; i++){
            for(int j = 0; j< elevations[0].length; j++){
                int center = elevations[i][j];
                if(center >= maxNeighbours3(elevations, i, j)){
                    returnArr[i][j] = true;
                } else{
                    returnArr[i][j] = false;
                }
            }
        }
        return returnArr;
    }
    public int maxNeighbours3(int[][] arr, int i, int j){
        int maxVal = Integer.MIN_VALUE;
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k >= 0 && k < arr.length) && (m >= 0 && m < arr.length) && (!(k==i&&m==j)) ){
                    maxVal = Math.max(maxVal, arr[k][m]);
                }
            }
        }
        return maxVal;
    }
}
//// QUESTION TWO SOLUTION
class Solution2{
    public int[][] findRiskScores(int[][] elevations){
        int[][] highPoints = findHighPoints(elevations);
        int[][] returnArr = new int[elevations.length][elevations[0].length];
        Set<String> indices;
        for(int i=0; i < highPoints.length; i++){
            for(int j=0; j < highPoints[0].length; j++){
                if(highPoints[i][j] == 1){
                    //call function
                    indices = new HashSet<>();
                    floodPoint(elevations, i, j, returnArr, indices);
                }
            }
        }
        return returnArr;
    }
    public void floodPoint(int[][] elevation, int i, int j, int[][] retA, Set<String> set){
        retA[i][j] +=1;
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k >= 0 && k < elevation.length) && (m >= 0 && m < elevation[0].length) && (!(k==i&&m==j)) ){
                    if(elevation[k][m] < elevation[i][j]){
                        if(!set.contains(String.valueOf(k) + String.valueOf(m))){
                            set.add(String.valueOf(k) + String.valueOf(m));
                            floodPoint(elevation, k, m, retA, set);
                        }
                    }
                }
            }
        }
    }
    public int[][] findHighPoints(int[][] elevations) {
        int[][] returnArr = new int[elevations.length][elevations[0].length];
        for(int i = 0; i < elevations.length; i++){
            for(int j = 0; j< elevations[0].length; j++){
                int center = elevations[i][j];
                if(center > maxNeighbours2(elevations, i, j)){
                    returnArr[i][j] = 1;
                } else{
                    returnArr[i][j] = 0;
                }
            }
        }
        return returnArr;
    }
    public int maxNeighbours2(int[][] arr, int i, int j){
        int maxVal = Integer.MIN_VALUE;
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k >= 0 && k < arr.length) && (m >= 0 && m < arr.length) && (!(k==i&&m==j)) ){
                    maxVal = Math.max(maxVal, arr[k][m]);
                }
            }
        }
        return maxVal;
    }
}
/// QUESTION ONE SOLUTION
class Solution{
    public int[][] findHighPoints(int[][] elevations) {
        int[][] returnArr = new int[elevations.length][elevations[0].length];
        for(int i = 0; i < elevations.length; i++){
            for(int j = 0; j< elevations[0].length; j++){
                int center = elevations[i][j];
                if(center > maxNeighbours(elevations, i, j)){
                    returnArr[i][j] = 1;
                } else{
                    returnArr[i][j] = 0;
                }
            }
        }
        return returnArr;
    }
    public int maxNeighbours(int[][] arr, int i, int j){
        int maxVal = Integer.MIN_VALUE;
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k >= 0 && k < arr.length) && (m >= 0 && m < arr.length) && (!(k==i&&m==j)) ){
                    maxVal = Math.max(maxVal, arr[k][m]);
                }
            }
        }
        return maxVal;
    }
}
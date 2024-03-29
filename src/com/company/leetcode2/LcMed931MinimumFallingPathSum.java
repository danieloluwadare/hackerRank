package com.company.leetcode2;

/**
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and chooses one element from each row.
 * The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 *
 *
 * Constraints:
 *
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
public class LcMed931MinimumFallingPathSum {

    public static void main(String[] args) {
//        [[1,2,3],[4,5,6],[7,8,9]]
//        System.out.println(minFallingPathSum(new int[][]{
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        }));

        System.out.println(minFallingPathSum(new int[][]{
                {-80,-13,22},
                {83,94,-5},
                {73,-48,61}
        }));
    }

    public static int minFallingPathSum(int[][] A) {
        int row = A.length;
        int col = A.length;
        for(int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                if(j == 0)
                    A[i][j] = Math.min(A[i-1][j], A[i-1][j+1]) + A[i][j];
                else if(j == col-1)
                    A[i][j] = Math.min(A[i-1][j],A[i-1][j-1]) + A[i][j];
                else
                    A[i][j] = Math.min( Math.min(A[i-1][j],A[i-1][j-1]), A[i-1][j+1]) + A[i][j];
            }
        }
        int minFallingPathSum = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++){
            minFallingPathSum = Math.min(A[row-1][i], minFallingPathSum);
        }
        return  minFallingPathSum;
    }
}

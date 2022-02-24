package com.company.leetcode;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 *
 *
 *
 * Example:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 *
 * Explanation:
 *
 *
 *
 * Note:
 *
 * The total number of elements of the given matrix will not exceed 10,000.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lc498DiagonalTraverse {

    public static void main(String[] args) {
        findDiagonalOrder(new int[][]{
                { 1, 2, 3 }, // 00 01 12
                { 4, 5, 6 }, // 10 11 12
                { 7, 8, 9 }  // 20 21 22
        });
        findDiagonalOrder(new int[][]{
                { 1, 2}, // 00 01 12
                { 4, 5}, // 10 11 12
                { 7, 8}  // 20 21 22
        });
//        [[2,5],[8,4],[0,-1]]
        findDiagonalOrder(new int[][]{
                { 1, 2 }, // 00 01 12
        });

        findDiagonalOrder(new int[][]{
                { 1 }, // 00 01 12
                { 5 }, // 00 01 12

        });
    }

    public static int[] findDiagonalOrder(int[][] matrix) {

        if(matrix.length == 0)
            return new int[]{};

        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        int [] result = new int[rowLen * columnLen];


        List<Integer> list;
        int k = 0;
        for (int i = 0; i < rowLen + columnLen - 1; i++) {
            int row, col;
            list = new ArrayList<>();
            if (i < columnLen) {
                row = 0;
                col = i;
            } else {
                row = i - columnLen + 1;
                col = columnLen - 1;
            }
            while (row < rowLen && col > -1) {
                list.add(matrix[row][col]);
                row++;
                col--;
            }

            if (i > 1 && i % 2 == 0) {
                Collections.reverse(list);
            }

            for (int j = 0; j < list.size(); j++) {
                result[k++] = list.get(j);
            }
        }

        System.out.println(Arrays.toString(result));

        return result;
    }

    public static int[] findDiagonalOrder2(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N*M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note.txt of the index math to go down the diagonal
            while (r < N && c > -1) {

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }

        System.out.println(Arrays.toString(result));

        return result;
    }
}

package com.company.firecode;

import java.math.BigDecimal;
import java.util.Arrays;

public class RotateASquareImageClockwise {

    public static void main(String[] args) {

        int [][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
//        {
                // {7,4,1},
                // {8,5,2},
                // {9,6,3}
// }
        rotateSquareImageCW(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public static void rotateSquareImageCW(int[][] matrix) {
        for (int i=0; i < matrix.length/2; i++){
            int maximumj = matrix.length - 1 -i;
            for(int j = i; j<maximumj; j++){

                int top = matrix[i][j];
                int right = matrix[j][maximumj];
                int bottom = matrix[maximumj][maximumj-j];
                int left =matrix[maximumj-j][i];


//                bottom to left
                matrix[maximumj-j][i] = bottom;
//                right to bottom
                matrix[maximumj][maximumj-j]=right;

//                top to right
                matrix[j][maximumj]=top;

//                left to top
                matrix[i][j]= left;
            }
        }
    }

    public static void rotateSquareImageCW2(int[][] matrix) {
        transposeMatrix(matrix);
        flipVerticalAxis(matrix);
    }


    public static void transposeMatrix(int[][] matrix) {
        int n = matrix.length - 1;
        int temp = 0;
        for(int i = 0; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    private static void flipVerticalAxis(int[][] matrix) {
        int n = matrix.length - 1;
        int temp = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j];
                matrix[i][n-j] = temp;
            }
        }
    }
}

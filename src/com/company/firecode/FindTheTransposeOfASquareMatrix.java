package com.company.firecode;

public class FindTheTransposeOfASquareMatrix {

    public static void main(String[] args) {
        int [][] matrix = {
                {1,0,1},
                {1,0,1},
                {1,0,1}
        };

        transposeMatrix(matrix);
    }

    public static void transposeMatrix(int[][] matrix) {
        for(int i = 0; i <= matrix.length/2; i++){
            for(int j = i+1; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

}

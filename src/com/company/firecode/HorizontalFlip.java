package com.company.firecode;

public class HorizontalFlip {

    public static void main(String[] args) {

    }


    public static void flipHorizontalAxis(int[][] matrix) {
        for(int i = 0; i<matrix.length/2; i++){
            for(int j = 0; j< matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j]=temp;
            }
        }
    }
}

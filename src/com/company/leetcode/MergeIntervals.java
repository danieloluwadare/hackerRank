package com.company.leetcode;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] input = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };


    }

    public static int[][] mergeIntervals(int[][] inputs){
        for (int i=0; i<inputs.length; i++){
            int secondItemOfCurrentIteration= inputs[i][1];
            if(i+1 != inputs.length){
                int firstItemofNextIteration = inputs[i+1][0];

                if(secondItemOfCurrentIteration >= firstItemofNextIteration){

                }

            }
        }
        return new int [2][2];
    }
}

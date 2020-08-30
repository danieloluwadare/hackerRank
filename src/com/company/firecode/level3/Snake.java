package com.company.firecode.level3;

import java.util.ArrayList;

public class Snake {
    public static void main(String[] args) {
        int [][] arr= {
                {1, 2, 3},

                {4, 5, 6},

                {7, 8, 9},
        };    }

    public static ArrayList<Integer> findSpiral(int[][] arr) {

        for (int i =0; i < arr.length/2; i++){
            int length = arr.length - i;
            // to traverse the top
            for(int top = i; i < length ; i++){
                System.out.println(arr[i][top]);
            }

            // to traverse the right
            for(int right = i+1; i <length; right++){
                System.out.println(arr[right][length]);
            }

            // to traverse bottom

            for(int bottom = length-1; i <length; bottom++){
                System.out.println(arr[bottom][length]);
            }

            //  to traverse left

        }

        return null;
    }
}

package com.company.leetcode;
/**

 Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

 The image you get is known to have potentially many distinct rectangles of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

 image1 = [
 [0, 1, 1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1, 1, 1],
 [0, 1, 1, 0, 0, 0, 1],
 [1, 0, 1, 0, 0, 0, 1],
 [1, 0, 1, 1, 1, 1, 1],
 [1, 0, 1, 0, 0, 1, 1],
 [1, 1, 1, 0, 0, 1, 1],
 [1, 1, 1, 1, 1, 1, 0],
 ]

 Sample output variations (only one is necessary):

 findRectangles(image1) =>
 // (using top-left-row-column and bottom-right):
 [
 [[0,0],[0,0]],
 [[2,0],[2,0]],
 [[2,3],[3,5]],
 [[3,1],[5,1]],
 [[5,3],[6,4]],
 [[7,6],[7,6]],
 ]
 // (using top-left-x-y and width/height):
 [
 [[0,0],[1,1]],
 [[0,2],[1,1]],
 [[3,2],[3,2]],
 [[1,3],[1,3]],
 [[3,5],[2,2]],
 [[6,7],[1,1]],
 ]

 Other test cases:

 image2 = [
 [0],
 ]

 findRectangles(image2) =>
 // (using top-left-row-column and bottom-right):
 [
 [[0,0],[0,0]],
 ]

 // (using top-left-x-y and width/height):
 [
 [[0,0],[1,1]],
 ]

 image3 = [
 [1],
 ]

 findRectangles(image3) => []

 image4 = [
 [1, 1, 1, 1, 1],
 [1, 0, 0, 0, 1],
 [1, 0, 0, 0, 1],
 [1, 0, 0, 0, 1],
 [1, 1, 1, 1, 1],
 ]

 findRectangles(image4) =>
 // (using top-left-row-column and bottom-right or top-left-x-y and width/height):
 [
 [[1,1],[3,3]],
 ]

 n: number of rows in the input image
 m: number of columns in the input image

 */
import java.io.*;
import java.util.*;


public class Kar {



//    public class Solution {
        public static void main(String[] argv) {

            int[][] image1 = {
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 0, 0, 0, 1},
                    {1, 1, 1, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1}
            };

            int[][] image2 = {
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0}
            };

            int[][] image3 = {
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 0, 0},
                    {1, 1, 1, 1, 1, 0, 0}
            };

            int[][] image4 = {
                    {0, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1}
            };

            int[][] image5 = {
                    {0}
            };


            int[][] image2_1 = {
                    {0, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {0, 1, 1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 1},
                    {1, 0, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 0, 1, 1},
                    {1, 1, 1, 0, 0, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0},
            };

            int[][] image2_2 = {
                    {0},
            };

            int[][] image2_3 = {
                    {1},
            };

            int[][] image2_4 = {
                    {1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1},
            };


//     findRectangle(image1);
//     System.out.println("---------------------------");
//     findRectangle(image2);
//     System.out.println("---------------------------");
//     findRectangle(image3);
//     System.out.println("---------------------------");
//     findRectangle(image4);
//     System.out.println("---------------------------");
//     findRectangle(image5);

            List<List<Integer>> result = findRectangle(image5);
            System.out.println("---------------------------");
            System.out.println(result.get(0));
            System.out.println(result.get(1));

            result = findRectangle(image1);
            System.out.println("---------------------------");
            System.out.println(result.get(0));
            System.out.println(result.get(1));

            result = findRectangle(image3);
            System.out.println("---------------------------");
            System.out.println(result.get(0));
            System.out.println(result.get(1));

        }

        public static List<List<Integer>> findRectangle(int [][] arr){

            List<Integer>firstAxis = new ArrayList<>();
            List<Integer>secondAxis = new ArrayList<>();
            int x=-1 ;
            int y=-1;
            boolean foundFirstZero=false;
            for(int i = 0; i < arr.length; i++){
                for(int j =0; j < arr[0].length; j++){
                    if(arr[i][j] == 0 && !foundFirstZero){
                        firstAxis.add(i);
                        firstAxis.add(j);
                        foundFirstZero=true;
                    }
                    else if(arr[i][j]==0 && foundFirstZero){
                        x=i;
                        y =j;
                    }
                }
            }

            if(x==-1 && y==-1){
                x=firstAxis.get(0);
                y=firstAxis.get(1);
            }

            System.out.println("firstzero x="+firstAxis.get(0));
            System.out.println("firstzero y="+firstAxis.get(1));

            System.out.println("secodZero x="+x);
            System.out.println("secondzero y="+y);

            secondAxis.add(x);
            secondAxis.add(y);

            List<List<Integer>> result = new ArrayList<>();
            result.add(firstAxis);
            result.add(secondAxis);

            return result;




        }
//    }

}

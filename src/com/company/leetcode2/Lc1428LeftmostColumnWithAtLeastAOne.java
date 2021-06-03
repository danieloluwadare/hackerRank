package com.company.leetcode2;

import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix {
     public int get(int row, int col);
     public List<Integer> dimensions() ;
};
public class Lc1428LeftmostColumnWithAtLeastAOne {
    public static void main(String[] args) {

        int [][] arr = {
                {0,0,0,1},
                {0,0,1,1},
                {0,1,1,1}
        };
        BinaryMatrix binaryMatrix = new BinaryMatrixImpl(arr);
        System.out.println(leftMostColumnWithOne(binaryMatrix));

        arr = new int[][]{
                {0, 0},
                {0, 0}
        };
        binaryMatrix = new BinaryMatrixImpl(arr);
        System.out.println(leftMostColumnWithOne(binaryMatrix));

        arr = new int[][]{
                {0, 0},
                {0, 1}
        };
        binaryMatrix = new BinaryMatrixImpl(arr);
        System.out.println(leftMostColumnWithOne(binaryMatrix));

        arr = new int[][]{
                {0, 0},
                {1, 1}
        };
        binaryMatrix = new BinaryMatrixImpl(arr);
        System.out.println(leftMostColumnWithOne(binaryMatrix));

//        int [] arr2 = {0,0,0,0};
//        int li = 0;
//        int ri = arr2.length-1;
//        while(li < ri){
//            int mid = (li + ri) / 2;
//            if(arr2[mid] == 0){
//                li = mid + 1;
//            }else {
//                ri=mid;
//            }
//        }
//        System.out.println(li);
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        return optimizedLeftMostColumnWithOne(binaryMatrix);
//        return optimizedBinarySearch(binaryMatrix);
    }

    private static int optimizedLeftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int rows = list.get(0);
        int cols = list.get(1);
        int row = 0;
        int col = cols-1;

        while (row < rows && col >= 0){
            if(binaryMatrix.get(row,col) == 1)
                col--;
            else
                row++;
        }

       return (col == cols -1) ? -1 : col+1;
    }

    public static int optimizedBinarySearch(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int rows = list.get(0);
        int cols = list.get(1);
        int midElement = binaryMatrix.get(0,cols-1);
        int startRow = 0;
        int mid = cols-1;
        if(midElement == 0){
            startRow=1;
        }else {
            mid--;
        }

        boolean foundAOne = false;
        for (int row = startRow; row < rows; row++){
            int index = optimizedBinarySearchHelper(row, binaryMatrix, mid);
            if(binaryMatrix.get(row,index)==1){
                foundAOne=true;
                mid = Math.min(mid,index);
            }
        }

        return (foundAOne) ? mid : -1;
    }

    private static int optimizedBinarySearchHelper(int row, BinaryMatrix binaryMatrix, int mid) {
        int li = 0;
        int ri = mid;
        while(li < ri){
            mid = (li + ri) / 2;
            if(binaryMatrix.get(row, mid) == 0){
                li = mid + 1;
            }else {
                ri=mid;
            }
        }
        return li;
    }


}

class BinaryMatrixImpl implements BinaryMatrix{

    int [][] arr ;
    List<Integer> dimension;

    public BinaryMatrixImpl(int[][] arr) {
        this.arr = arr;
        dimension=new ArrayList<>();
        dimension.add(arr.length);
        dimension.add(arr[0].length);
    }

    @Override
    public int get(int row, int col) {
        return arr[row][col];
    }

    @Override
    public List<Integer> dimensions() {
        return dimension;
    }
}

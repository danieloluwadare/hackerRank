package com.company.firecode;

public class BinarySearchOnArrayOfInteger {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int []{2,5,7,8,9},9));
    }

    public static Boolean binarySearch(int[] arr, int n){
        if(arr.length <= 0){
            return false;
        }

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while(leftIndex <= rightIndex){
            int midIndex = (rightIndex - leftIndex) / 2;
            int offsetIndex = leftIndex + midIndex;
            if(arr[offsetIndex] == n){
                return true;
            }
            else if(arr[offsetIndex] > n){
                rightIndex = offsetIndex - 1;
            }
            else{
                leftIndex=offsetIndex + 1;
            }
        }

        return false;

    }
}

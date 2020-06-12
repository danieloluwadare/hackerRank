package com.company.firecode;

import java.util.Arrays;

public class RotateLinearArray {

    public static void main(String[] args) {
//        ({1,2,3,4,5},2
        int [] result = rotateLeft(new int[]{1,2,3,4,5}, 3);
        System.out.println(Arrays.toString(result));
    }

    public static int[] rotateLeft(int[] arr, int k) {
        for(int i = 0; i<k; i++){

            int temp = arr[0];
            for(int j =1; j<arr.length; j++){
                arr[j-1]=arr[j];
            }

            arr[arr.length-1]=temp;
        }

        return arr;
    }

    public static int[] rotateLeft2(int[] arr, int k)  {
        if (arr == null) return null;
        int actualShifts = k % arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, arr.length - actualShifts-1);
        reverse(arr, arr.length - actualShifts, arr.length-1);
        return arr;
    }

    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1) return;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

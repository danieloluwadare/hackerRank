package com.company.firecode;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {4,12,4,78,7,-1};
        selectionSortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] selectionSortArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j< arr.length; j++){

                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }

            }
        }





        return arr;
    }
}

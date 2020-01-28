package com.company.firecode;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {4,12,4,78,7,-1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
//        Arrays.deepToString(a;
        StringBuilder sb = new StringBuilder("Hello ");
        String str = null;
        System.out.println(str==null);
    }

    public static  void sort(int [] arr){
        int tail = arr.length;
        for(int i = 0; i< tail; tail--){
            int index = i;
            for(int j=index + 1; j<tail; j++){
                int previousIndex = arr[index];
                int nextIndex = arr[j];
                if(previousIndex > nextIndex){
                    arr[index] = nextIndex;
                    arr[j] = previousIndex;
                }
                index++;
            }
        }
    }


    public static int[] bubbleSortArray(int[] arr){
        // Find the length of the input array
        int len = arr.length;

        // Run a for loop from the end to the first element. The index will be
        // the tail pointer. Everything to the right of the tail pointer will be
        // assumed sorted as the largest elements would bubble to the tail pointer.
        for(int bubblePosition = len-1; bubblePosition >= 0;bubblePosition--){
            // Run an inner for loop from 0 to the current position of the tail
            // pointer.
            for(int i=0;i<bubblePosition;i++){
                // If the current element > next element, swap the two
                if(arr[i]>arr[i+1]){
                    // Use a temporary variable to perform the swap
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }
}

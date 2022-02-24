package com.company.revision;

import java.util.Arrays;
import java.util.Map;

public class RevLc1300SumOfMutatedArrayClosestToTarget {

    public static void main(String[] args) {
//        System.out.println(findBestValue(new int[]{4,9,3},10));

        System.out.println(2*Math.random());
//        System.out.println(findBestValue(new int[]{2,5,3},10));
//        System.out.println(findBestValue(new int[]{60864,25176,27249,21296,20204},56803));



    }
    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length;

        for(int i =0; i < length; i++){
            int solution = Math.round((target)/(length-i));
            if(arr[i] >= solution)
                return solution;
            target-=arr[i];

        }

        return arr[length-1];
    }
}

package com.company.leetcode;

import java.util.Arrays;

public class Lc1480RunningSumOf1dArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int []{1,2,3,4,5})));
    }
    public static int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;
    }
}

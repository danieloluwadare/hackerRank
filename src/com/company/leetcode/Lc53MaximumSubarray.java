package com.company.leetcode;

public class Lc53MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{-7,-4, -3, -1}));

    }

    public static int maxSubArray(int[] nums) {
        int maxMumSubArray = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(currentSum<0)
                currentSum=0;
            currentSum+=nums[i];
            maxMumSubArray=Math.max(currentSum,maxMumSubArray);
        }
        return maxMumSubArray;
    }
}

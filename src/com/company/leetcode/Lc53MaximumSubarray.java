package com.company.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
 * sum and return its sum.
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer
 * approach, which is more subtle.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [0]
 * Output: 0
 * Example 4:
 *
 * Input: nums = [-1]
 * Output: -1
 * Example 5:
 *
 * Input: nums = [-2147483647]
 * Output: -2147483647
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 */
public class Lc53MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 2);
//        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(maxSubArray(new int[]{-7,-4, -3, -1}));

    }

    public static int maxSubArray2(int[] nums) {
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

    public static int maxSubArray(int[] nums) {
//         Daniel D
        int maxMumSubArray = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max(currentSum, currentSum + i);
            maxMumSubArray=Math.max(currentSum,maxMumSubArray);
        }
        return maxMumSubArray;
    }
}

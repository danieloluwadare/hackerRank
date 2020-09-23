package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * Medium
 *
 * 765
 *
 * 32
 *
 * Add to List
 *
 * Share
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * Example 2:
 *
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * Example 3:
 *
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 */
public class Lc1438LongestContinuousSubarrayWithAbsoluteDiffLessThanEqualLimit {
    public static void main(String[] args) {
//        System.out.println(longestSubarray(new int[]{10,1,2,4,7,2}, 5));//4
//        System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));//2
//        System.out.println(longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0)); //3
        System.out.println(longestSubarray(new int[]{24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,14,33,94,66,27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39}, 87)); //3

    }

    public static int longestSubarray(int[] nums, int limit) {
//        36, 32, 35, 15, 80, 24, 45, 38, 9, 22, 21, 33, 68, 22, 85, 35, 83, 92, 38, 59, 90, 42, 64, 61, 15
        //        Daniel's solution
        //        Daniel's solution
        if(nums==null || nums.length==0)
            return 0;

        int maxCount = 1;
        int i = 0;
        int j = i+1;
        int min = nums[i];//initialize min to first num in array
        int max = nums[i];//initialize max to first num in array
        int nextI = 0;


        while (i < nums.length && j< nums.length){
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);
            int absoluteDifference = Math.abs(max-min);
            if(absoluteDifference <= limit){

                if(nextI < nums.length && nums[nextI]== nums[nextI+1])
                    nextI++;

                maxCount=Math.max(j-i+1,maxCount);
                j++;
            }else {
                i=(i == nextI)? i+1 : nextI;
                j=i+1;
                nextI=i;
                min = nums[i];
                max = nums[i];
            }

        }

        return maxCount ;

    }
}

package com.company.leetcode2;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 494. Target Sum
 * Medium
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 *
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 *
 * Constraints:
 *
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class Lc494TargetSum {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1},  3));
        Set<Integer> set = new LinkedHashSet<>();
    }
    public static int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWaysHelper(nums,0,0,0,S, new StringBuilder());
    }

    private static int findTargetSumWaysHelper(int[] nums, int index, int sum, int count, int target, StringBuilder sb) {

        if(sum==target && index == nums.length) {
            System.out.println(sb.toString());
            return count + 1;
        }
        if(index == nums.length)
            return count;

        int cnt1 = findTargetSumWaysHelper(nums,index + 1,sum + nums[index], count, target,
                new StringBuilder(sb.append("+").append(nums[index])));
        int cnt2 = findTargetSumWaysHelper(nums,index + 1, sum - nums[index], count,target,
                new StringBuilder(sb.append("-").append(nums[index])));

        return cnt1 + cnt2;
    }
}

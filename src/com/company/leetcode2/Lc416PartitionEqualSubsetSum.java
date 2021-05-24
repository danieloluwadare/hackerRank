package com.company.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * 416. Partition Equal Subset Sum
 * Medium
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * youtube link =https://www.youtube.com/watch?v=3N47yKRDed0
 */

public class Lc416PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition(new int[]{1,2,3,5}));
        System.out.println(canPartition(new int[]{1,2,11,4}));
        System.out.println(canPartition(new int[]{1,4,5}));
        System.out.println(canPartition(new int[]{1,6,3}));

    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            return false;

        Map<String,Boolean> map = new HashMap<>();
        return canPartitionHelper(nums,0,0, sum/2,map);
    }

    private static boolean canPartitionHelper(int[] nums, int index, int sum, int target, Map<String,Boolean> map) {
        String key = index + "" + sum;
        if(map.containsKey(key))
            return map.get(key);

        if (sum > target || index == nums.length)
            return false;
        if(sum==target)
            return true;

        boolean result = canPartitionHelper(nums,index+1,sum+nums[index],target,map) ||
                canPartitionHelper(nums,index+1,sum,target,map) ;

        map.put(key,result);

        return result;
    }
}

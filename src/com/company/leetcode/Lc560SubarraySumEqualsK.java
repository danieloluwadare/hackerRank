package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**

 *
 * Share
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 *
 * Constraints:
 *
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */

public class Lc560SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,1,2,1}, 3));
        System.out.println(subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));
        System.out.println(subarraySum(new int[]{-1,-1,1}, 0));

    }
    public static int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int count = 0, sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            sum +=nums[i];

            if(sum==k){
                count++;
            }
            if(map.containsKey(sum - k)){
                count+=map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return count;
    }
}

package com.company.revision;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class Lc525ContiguousArray {

    public static void main(String[] args) {
        findMaxLength(new int[]{0,1,0});
        findMaxLength(new int[]{1,1,0,0,1,1,0,1,1});

    }

    public static int findMaxLength(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            sum += (nums[i] == 1) ? 1 : -1;
            if(sum==0)
                max=Math.max(max, i+1);
            else if(map.containsKey(sum)){
                max = Math.max(max, i-map.get(sum));
            }else {
                if(!map.containsKey(sum) && sum != 0)
                    map.put(sum, i);
            }
        }
        System.out.println(max);
        return max;
    }
}

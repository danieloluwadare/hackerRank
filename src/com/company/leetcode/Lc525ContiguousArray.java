package com.company.leetcode;

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
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, sum =0;
        for (int i = 0; i < nums.length; i++){
//            any time we see a zero we we perform a -1 operation from sum
            sum += nums[i]==1 ? 1 : -1;
            if(sum==0){
//                 means from the begining of the array to this current index we have  sum of 0 and
//                 1 that ==0
                maxLength=Math.max(maxLength, i+1);
            }
            else if(map.containsKey(sum)){
                maxLength=Math.max(maxLength, i-map.get(sum));
            }
            else {
                if(!map.containsKey(sum))
                    map.put(sum, i);
            }
        }
        System.out.println(maxLength);
        return maxLength;
    }
}

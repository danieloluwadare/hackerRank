package com.company.revision;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums.
 *
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 *
 * Return the number of good pairs.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class RevLc1512NumberofGoodPairs {

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3}));

    }

    public static int numIdenticalPairs(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)){
                count += map.get(num);
                map.put(num, map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        return count;

    }
}
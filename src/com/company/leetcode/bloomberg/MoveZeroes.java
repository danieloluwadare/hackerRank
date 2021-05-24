package com.company.leetcode.bloomberg;
/**
 * 283. Move Zeroes
 * Easy
 *
 * 5330
 *
 * 167
 *
 * Add to List
 *
 * Share
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you minimize the total number of operations done?
 */

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int [] arr = new int []{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
//        [0,1,0,3,12]
        int i = 0;
        int j = 0;

        while (i<nums.length){
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j]= nums[i];
                nums[i]=temp;
                j++;
            }

            i++;
        }
    }
}

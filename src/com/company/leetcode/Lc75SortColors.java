package com.company.leetcode;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Follow up:
 *
 * Could you solve this problem without using the library's sort function?
 * Could you come up with a one-pass algorithm using only O(1) constant space?
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 */
public class Lc75SortColors {

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
        sortColors(new int[]{2,0,1});
        sortColors(new int[]{0});
        sortColors(new int[]{1});

    }

    public static void sortColors(int[] nums) {
        int l=0;
        int r=nums.length -1 ;
        int i = 0;

        while (i <= r){
            int temp = nums[i];
            if(nums[i]==0){
                nums[i]=nums[l];
                nums[l]=temp;
                i++;
                l++;
            }
            else if(nums[i]==2){
                nums[i]=nums[r];
                nums[r]=temp;
                r--;
            }else{
                i++;
            }

        }

        System.out.println(Arrays.toString(nums));
    }
}

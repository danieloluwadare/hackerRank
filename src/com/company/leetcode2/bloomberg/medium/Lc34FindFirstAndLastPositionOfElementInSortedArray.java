package com.company.leetcode2.bloomberg.medium;

import java.util.Arrays;

/**
 * Share
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class Lc34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        searchRange2(new int[]{5,7,7,8,8,10},8);
        searchRange2(new int[]{2,2},2);
        searchRange2(new int[]{},0);

    }
    public static int[] searchRange(int[] nums, int target) {
        int li = 0;
        int ri = nums.length-1;
        int targetIndex = -1;
        while (li <= ri){
            int mid = (ri - li) / 2 ;
            int offset = li + mid;

            if(nums[offset] == target){
                targetIndex=offset;
                break;
            }else if(nums[offset] > target){
                ri = offset - 1;
            }else {
                li = offset + 1;
            }
        }
        System.out.println(targetIndex);

        if(targetIndex == -1)
            return new int[]{-1,-1};

        int startIndex = 0;
        for(int i = targetIndex; i >=0; i--){
            if(nums[i] != target){
                startIndex=i+1;
                break;
            }
        }

        int endIndex = 0;
        for(int i = targetIndex; i < nums.length; i++){
            if(nums[i] != target){
                endIndex = i-1;
                break;
            }
            if(i == ri){
                endIndex = i;
                break;
            }
        }

        System.out.println(startIndex);
        System.out.println(endIndex);

        return new int[]{startIndex, endIndex};
    }

    public static int[] searchRange2(int[] nums, int target){
        int [] result = {-1,-1};

        int leftIndex = binarySearchOptimizer(nums,target, true);
        if(leftIndex >= nums.length || nums[leftIndex] != target)
            return result;

        int rightIndex = binarySearchOptimizer(nums,target, false) - 1;
        result[0]=leftIndex;
        result[1] = rightIndex;
        System.out.println(Arrays.toString(result));
        return result;
    }

    private static int binarySearchOptimizer(int[] nums, int target, boolean checkLeft) {
        int li = 0;
        int ri = nums.length;

        while (li < ri){
            int mid = (li + ri) / 2;
            if(nums[mid] > target || (checkLeft && nums[mid]==target)){
                ri=mid;
            }else {
                li=mid + 1;
            }
        }
        return  li;
    }
}

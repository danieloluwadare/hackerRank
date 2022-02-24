package com.company.leetcode;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class Lc209MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int result = 0;
        int sum = 0;
        int i=0, j =0 ;
        while (i < nums.length && j < nums.length){
            if(sum < s){
               sum += nums[j];
               if(sum >= s){
                   if(result==0)
                       result =j - i + 1;

                   result=Math.min(result, j - i + 1);
               }else {
                j++  ;
               }
            }

            else {
                sum -= nums[i];
                if(sum >= s){
                    i++;
                    result=Math.min(result, j - i + 1);

                }else {
                    i++;
                    j++  ;
                }
            }
        }
        return result;
    }
    public static int minSubArrayLen2(int s, int[] nums) {
        if(nums.length==0)
            return 0;
        int sum = 0;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;

        while (i < nums.length && j < nums.length){
            if(sum < s){
                sum += nums[j];
                if(sum >= s){
                    min = Math.min(min,j-i+1);
                }else {
                    j++;
                }
            }else {
                sum -= nums[i];
                i++;
                if(sum >= s){
                    min = Math.min(min,j-i+1);
                }else {
                    j++;
                }
            }
        }
        if(min==Integer.MAX_VALUE)
            return 0;
        return min;
    }

}

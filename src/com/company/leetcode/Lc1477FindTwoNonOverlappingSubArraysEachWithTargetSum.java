package com.company.leetcode;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lc1477FindTwoNonOverlappingSubArraysEachWithTargetSum {

    /**
     * Given an array of integers arr and an integer target.
     *
     * You have to find two non-overlapping sub-arrays of arr each with sum equal target.
     * There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.
     *
     * Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two sub-arrays.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [3,2,2,4,3], target = 3
     * Output: 2
     * Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
     * Example 2:
     *
     * Input: arr = [7,3,4,7], target = 7
     * Output: 2
     * Explanation: Although we have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and [7]), but we will choose the first and third sub-arrays as the sum of their lengths is 2.
     * Example 3:
     *
     * Input: arr = [4,3,2,6,2,3,4], target = 6
     * Output: -1
     * Explanation: We have only one sub-array of sum = 6.
     * Example 4:
     *
     * Input: arr = [5,5,4,4,5], target = 3
     * Output: -1
     * Explanation: We cannot find a sub-array of sum = 3.
     * Example 5:
     *
     * Input: arr = [3,1,1,1,5,1,2,1], target = 3
     * Output: 3
     * Explanation: Note that sub-arrays [1,2] and [2,1] cannot be an answer because they overlap.
     *
     *
     * Constraints:
     *
     * 1 <= arr.length <= 10^5
     * 1 <= arr[i] <= 1000
     * 1 <= target <= 10^8
     *
     *
     */

    public static void main(String[] args) {

//        minSumOfLengths(new int[]{3,2,2,4,3}, 3);
        minSumOfLengths(new int[]{7,3,4,7}, 7);
//        minSumOfLengths(new int[]{4,3,2,6,2,3,4}, 6);
//        minSumOfLengths(new int[]{5,5,4,4,5}, 3);
//        minSumOfLengths(new int[]{3,1,1,1,5,1,2,1}, 3);
//        minSumOfLengths(new int[]{1,6,1}, 7);
//        minSumOfLengths(new int[]{2,1,3,3,2,3,1}, 6);
    }

    public static int minSumOfLengths(int[] arr, int target) {

        Queue<Integer> queue = new PriorityQueue<>((x, y)->{ return y-x; });
        int i = 0;int j = 0;
        int sum = 0;
        while(i < arr.length){
            int currentElement = arr[i];
            if(currentElement==target){
                queue.add(1);
                i++;
            }
            else if(currentElement > target){
                i++;
            }
            else {
                j=i+1;
                sum = currentElement;
                while (j < arr.length && sum <= target){
                    sum += arr[j];
                    if(sum==target){
                        queue.add(j-i+1);
                        break;
                    }
                    j++;
                }
                i++;
//                i = sum==target ? j+1 : i+1;
            }

            if(queue.size() > 2)
                queue.poll();

        }

        if(queue.size() < 2){
            System.out.println(-1);
            return -1;
        }

        sum = queue.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        return sum;
    }


}

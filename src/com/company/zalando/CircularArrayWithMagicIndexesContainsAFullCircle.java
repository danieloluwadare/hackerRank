package com.company.zalando;

/**
 * Determine whether a circular array with magic indexes contains a full circle. The array is circular in the sense that,
 * -The entry A[i] points to entry A[A[i]]. Full circle means it covers all the elements of the array. As a follow-up,
 * -I was asked to solve the problem in O(1) space.
 *
 * Example:
 *
 * Input: [2,3,1,4,0], Output: true
 *
 * Input: [2,3,2,4,9], Output: false
 */
public class CircularArrayWithMagicIndexesContainsAFullCircle {
    public static void main(String[] args) {
        System.out.println(findCircularArrayWihMagicIndexesContainsAFullCircle(new int[]{2,3,1,4,0}));
        System.out.println(findCircularArrayWihMagicIndexesContainsAFullCircle(new int[]{2,3,2,4,9}));

    }

    public static boolean findCircularArrayWihMagicIndexesContainsAFullCircle(int [] nums) {
        int arrLength = nums.length - 1 ;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > arrLength)
                return false;
        }
        return true;
    }
}

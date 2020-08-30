package com.company.leetcode.bloomberg;

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

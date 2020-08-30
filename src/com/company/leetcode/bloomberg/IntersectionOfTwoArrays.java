package com.company.leetcode.bloomberg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int [] arr = intersection(new int[]{1,2}, new int[]{4,7,5,1});
        System.out.println(Arrays.toString(arr));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
//         Daniel's solution

        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }

        for(int i = 0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }

        int [] array = new int[result.size()];
        int k = 0;
        for (Integer i: result)
            array[k++] = i;


        return array;

    }
}

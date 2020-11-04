package com.company.leetcode;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lc26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int []{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int []{1,1,2}));
        System.out.println(removeDuplicates(new int []{}));
        System.out.println(removeDuplicates(null));

    }

    public static int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0 )
            return 0;
        int count = 1;
        for(int i = 0, j=1; j < nums.length; j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
                count++;
            }
        }
        System.out.println( IntStream.of(nums).boxed()
                .collect(Collectors.toList()));
        return count;
    }
}

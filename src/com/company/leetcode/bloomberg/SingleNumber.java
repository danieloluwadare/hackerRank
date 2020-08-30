package com.company.leetcode.bloomberg;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;

public class SingleNumber {

    public static void main(String[] args) {
        int res = 0;
        System.out.println(res);
        res = 5 ^ 8;
        System.out.println(res);
        res ^= 8;
        System.out.println(res);
        System.out.println(6 ^ 5 );

        System.out.println(singleNumber(new int []{4,1,2,1,2}));
    }


    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
            sum+=nums[i];
        }
        int total = 2 * (set.stream().mapToInt(Integer::intValue).sum());
        return total - sum;
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }


}

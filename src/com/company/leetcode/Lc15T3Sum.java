package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc15T3Sum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{-2,0,0,2,2}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
//        Daniel's Solution
        List<List<Integer>> output = new ArrayList<>();
        if(nums.length < 3){
            return output;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;i++){
            if(i==0 || nums[i] != nums[i-1]){
                int l = i+1;
                int r= nums.length-1;
                while (l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum > 0)
                        r--;
                    else if(sum < 0)
                        l++;
                    else {
                        output.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        r--;
                        l++;
                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                    }
                }

            }
        }
        return output;
    }
}

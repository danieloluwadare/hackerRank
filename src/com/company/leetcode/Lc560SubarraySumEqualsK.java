package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc560SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println('B'-'A'+1);
//        System.out.println(subarraySum(new int[]{1,2,1,2,1}, 3));
//        System.out.println(subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));
//        System.out.println(subarraySum(new int[]{-1,-1,1}, 0));


    }
    public static int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int count = 0, sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            sum +=nums[i];

            if(sum==k){
                count++;
            }
            if(map.containsKey(sum - k)){
                count+=map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return count;
    }
}

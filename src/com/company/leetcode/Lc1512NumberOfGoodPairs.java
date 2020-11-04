package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc1512NumberOfGoodPairs {

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int []{1,2,3,1,1,3}));
        System.out.println(numIdenticalPairs(new int []{1,1,1,1}));
        System.out.println(numIdenticalPairs(new int []{1,2,3}));

    }
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int pairCount = 0;
        for(int i =0; i<nums.length; i++){
            int element = nums[i];
            if(map.containsKey(element)) {
                pairCount += map.get(element);
                map.put(element,map.get(element)+1);

            }else {
                map.put(element, 1);
            }
        }
        return pairCount;
    }
}

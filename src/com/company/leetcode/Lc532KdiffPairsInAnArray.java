package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc532KdiffPairsInAnArray {

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5},2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5},1));

    }

    public static int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i : nums)
            map.put(i, map.getOrDefault(i,0)+1);

        for(int i : map.keySet()){
            if(k > 0 && map.containsKey(i+k)){
                count++;
            }else if(k==0 && map.get(i)>1){
                count++;
            }
        }
        return  count;
    }
}

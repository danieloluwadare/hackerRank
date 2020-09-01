package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc169MajorityElement {

    public static void main(String[] args) {
        int [] arr =   {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement( new int[]{3,2,3} ));

    }

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length / 2;

        for(int i : nums){
            if(map.containsKey(i)){
                int count = map.get(i);
                count=count+1;
                map.replace(i,count);
            }else{
                map.put(i, 1);
            }

        }

        for(int key : map.keySet()){
            int count = map.get(key);
            if(count > length)
                return key;
        }

        return 0;
    }

    public static int majorityElementOptimal(int[] nums) {
        return -1;

    }
}

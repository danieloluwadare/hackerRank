package com.company.revision;

import java.util.HashMap;
import java.util.Map;

public class RevLc169MajorityElement {

    public static void main(String[] args) {
        int [] arr =   {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement( new int[]{3,2,3} ));

    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majorCount = 0;
        for(int i = 0; i < nums.length; i++){
            int currElement = nums[i];
            map.put(currElement, map.getOrDefault(currElement,0)+1);
            majorCount = Math.max(majorCount,map.get(currElement));
        }
        for (int i : map.keySet()){
            if(majorCount==map.get(i))
                return i;
        }

        return -1;
    }
}

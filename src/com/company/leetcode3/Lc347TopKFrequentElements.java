package com.company.leetcode3;

import java.util.*;

public class Lc347TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3},2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        for(int num : nums)
            map.put(num, map.getOrDefault(num,0)+1);

        queue.addAll(map.keySet());
        System.out.println(queue);
        int [] result = new int[k];
        for (int i =0; i < k; i++)
            result[i]=queue.poll();
        return result;
    }
}

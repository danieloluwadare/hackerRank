package com.company.leetcode2;

import java.util.*;

/**
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 */
public class LcMed1481LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {

//        for(char i = 'a'; i<='z';i++){
//            System.out.println(i-'a');
//        }

        System.out.println("abcabcd".substring(0, 1));
        System.out.println("abcabcd".substring(1));

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(4);
//        list.add(110);
//        list.add(3);
//
//        list.sort((a,b)->a-b);
//        System.out.println(list);
//        System.out.println(findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2},3));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i,map.getOrDefault(i,0)+1);
//        System.out.println(map);
        Queue<Integer> heap = new PriorityQueue<>((a,b)->a-b);
        heap.addAll(map.values());

        int countOfRemoved = 0;
        int uniqueValuesRemoved = 0;

        for(int i = 0; i < map.values().size() ; i++){
            countOfRemoved += heap.poll();
            if(countOfRemoved <= k)
                uniqueValuesRemoved++;
            else
                break;
        }

        return map.values().size() - uniqueValuesRemoved;
    }
}

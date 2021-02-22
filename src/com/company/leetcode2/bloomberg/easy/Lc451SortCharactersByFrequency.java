package com.company.leetcode2.bloomberg.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lc451SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));

    }

    public static String frequencySort(String s) {
        if(s==null || s.length()==0)
            return null;

        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1 );
        }
        Queue<Character> queue = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        queue.addAll(map.keySet());
        System.out.println(queue);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            char ch = queue.poll();
            int count = map.get(ch);
            for(int i = 0; i < count; i++){
                sb.append(ch);
            }
        }
//        System.out.println(map);

        return sb.toString();
    }
}

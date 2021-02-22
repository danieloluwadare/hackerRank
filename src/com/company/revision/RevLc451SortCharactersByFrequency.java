package com.company.revision;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RevLc451SortCharactersByFrequency {

    public static void main(String[] args) {
//        Queue<Integer> queue = new PriorityQueue<>();
//        queue.add(3);
//        queue.add(4);
//        queue.add(1);
//        System.out.println(queue);
//        System.out.println(queue.poll());
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));

    }
    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);

        }
        Queue<Character> queue = new PriorityQueue<>((x,y)->{
            return map.get(y)-map.get(x);
        });
        queue.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            char key = queue.poll();
            int count = map.get(key);
            for(int i = 0; i < count; i++){
                sb.append(key);
            }
        }


        return sb.toString();
    }
}

package com.company.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc797AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        allPathsSourceTarget(new int[][]{
                {1,2},{3},{3},{}
        });

        allPathsSourceTarget(new int[][]{
                {4,3,1},{3,2,4},{3},{4},{}
        });
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        int target = graph.length - 1;

//        get all the children for 0
        for(int i : graph[0]){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(i);
            queue.add(list);
        }

        while (!queue.isEmpty()){
            List<Integer> list=queue.poll();
            int lastNode = list.get(list.size()-1);
            if(lastNode == target){
                lists.add(list);
                continue;
            }
            for(int i : graph[lastNode]){
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(i);
                queue.add(newList);
            }

        }

        System.out.println(lists);
        return lists;
    }
}

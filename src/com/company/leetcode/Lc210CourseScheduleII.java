package com.company.leetcode;

import java.util.*;

public class Lc210CourseScheduleII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}})));
        System.out.println(Arrays.toString(findOrder(2,new int[][]{{1,0}})));
        System.out.println(Arrays.toString(findOrder(0,new int[][]{{1,0}})));
        System.out.println(Arrays.toString(findOrder(1,new int[][]{{1,0}})));
        System.out.println(Arrays.toString(findOrder(2,new int[][]{})));

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return new int[]{};

        if (numCourses == 1)
            return new int[]{0};

        int[] inDegrees = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int prerequisite = pre[1];
            int mainCourse = pre[0];
            if (!graph.containsKey(prerequisite)) {
                graph.put(prerequisite, new HashSet<>());
            }
            graph.get(prerequisite).add(mainCourse);
            inDegrees[mainCourse]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i =0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] courseOrderArray = new int[numCourses];
        int k =0;
        while (!queue.isEmpty()) {
            int zeroInDegree = queue.poll();
            courseOrderArray[k++]=zeroInDegree;
            if (graph.containsKey(zeroInDegree)) {
                for (int children : graph.get(zeroInDegree)) {
                    inDegrees[children]--;
                    if (inDegrees[children] == 0) {
                        queue.offer(children);
                    }
                }
            }
        }


        for (int i =0; i < inDegrees.length; i++) {
            if (inDegrees[i] != 0) {
                return new int[]{};
            }
        }



        return courseOrderArray;
    }
}

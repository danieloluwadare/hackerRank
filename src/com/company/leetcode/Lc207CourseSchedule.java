package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc207CourseSchedule {

    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
     *
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     *
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     *
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     *
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0, and to take course 0 you should
     *              also have finished course 1. So it is impossible.
     */

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println(canFinish(2, new int[][]{{1,0},}));

    }



    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0)
            return false;
        if(prerequisites==null || prerequisites.length==0)
            return true;
        Map<Integer, Set<Integer>> graph = new HashMap<>();

//         build directed graph
        for(int [] arr : prerequisites){
            int course = arr[0];
            int prerequisiteCourse = arr[1];
            if (!graph.containsKey(course)){
                graph.put(course,new HashSet<>());
            }
            graph.get(course).add(prerequisiteCourse);
        }
//      transverse each course
        Set<Integer> visited = new HashSet<>();
        for(int i =0; i < numCourses; i++){

            if(!dfsCanFinishCourse(i,graph,visited)){
                return false;
            }
        }
        return true;
    }

    static boolean dfsCanFinishCourse(int course,Map<Integer, Set<Integer>> graph,Set<Integer>visited){
        if(visited.contains(course))
            return false;
        visited.add(course);
        if(graph.containsKey(course)){
            for(int prerequisite : graph.get(course)){
                if(!dfsCanFinishCourse(prerequisite,graph,visited))
                    return false;
            }
        }

        visited.remove(course);
        return true;
    }
}

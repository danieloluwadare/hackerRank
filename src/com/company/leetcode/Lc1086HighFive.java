package com.company.leetcode;

import java.util.*;

/**
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 *
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.
 * The average score is calculated using integer division.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 *
 *
 * Note:
 *
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 */
public class Lc1086HighFive {
    public static void main(String[] args) {
        int [][] arr = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        highFive(arr);
    }

    public static int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map= new TreeMap<>();

        for(int i = 0; i < items.length; i++){
            int studentId = items[i][0];
            int studentScore = items[i][1];
             if(!map.containsKey(studentId)){
                 map.put(studentId,new PriorityQueue<>());
             }

            map.get(studentId).add(studentScore);
            Queue<Integer> queue = map.get(studentId);
             if(queue.size()>5){
                 queue.poll();
             }
        }

        int [][] result = new int [map.size()][2];
        int i = 0;
        for(int key :map.keySet()){
            Queue<Integer> queue = map.get(key);
            int sum = queue.stream().mapToInt(Integer::intValue).sum();
            result[i][0] = key;
            result[i][1] = sum/5;
            i++;
        }

        System.out.println(Arrays.deepToString(result));

        return new int[][]{{0}};
    }
}

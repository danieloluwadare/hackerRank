package com.company.leetcode2.bloomberg.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lc253MeetingRoomsII {
    public static void main(String[] args) {
        int [][] intervals = {{0,30},{5,10},{15,20}};
        minMeetingRooms(intervals);

        int [][] intervals2 = {{0,30},{7,10},{0,15},{5,10},{15,20}};
        minMeetingRooms(intervals2);

        int [][] intervals3 = {{9,10},{4,9},{4,17}};
        minMeetingRooms(intervals3);

//        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
//        queue.add(3);
//        queue.add(4);
//        queue.add(1);

//        System.out.println(queue.poll());

    }

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null ||intervals.length == 0)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        int countOfMinMeetingRoom = 1;
        System.out.println(Arrays.deepToString(intervals));
        queue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++){

            int currentIntervalStartTime = intervals[i][0];
            int leastEndTimeInterval  = queue.peek();
            if(currentIntervalStartTime >= leastEndTimeInterval){
                queue.poll();
                queue.add(intervals[i][1]);
            }else {
                queue.add(intervals[i][1]);
            }

        }

        System.out.println("countOfMinMeetingRoom==> "+queue.size());
        return queue.size();
    }
}




package com.company.leetcode2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 253. Meeting Rooms II
 * Medium
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = []
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */
public class Lc253MeetingRoomsII {

    public static void main(String[] args) {
        Queue<int[]> queue = new PriorityQueue<>((a,b)-> a[1]-b[1]);
//        Queue<String> queuew = new PriorityQueue<>((x,y)->x.length()-y.length());

//        [0,30],[5,10],[15,20]
//        queue.add(new int[]{0, 30});
//        queue.add(new int[]{5, 10});
//        queue.add(new int[]{15, 20});

        int [][] arr = {
                {0,30},
                {5,10},
                {15,20}
        };
        int [][] arr2 = {
                {7,10},{2,4}
        };
        int [][] arr3 = {
                {9,10},{4,9},{4,17}
        };

        System.out.println(minMeetingRooms(arr));
        System.out.println(minMeetingRooms(arr2));
        System.out.println(minMeetingRooms(arr3));

//        Arrays.sort(arr, (a,b)->a[0]-b[0]);
//        System.out.println(Arrays.deepToString(arr));
//
//        System.out.println(Arrays.toString(queue.poll()));
//        System.out.println(Arrays.toString(queue.poll()));
//        System.out.println(Arrays.toString(queue.poll()));

    }
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length==0)
            return 0;

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        Queue<int[]> queue = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        queue.add(intervals[0]);
        for(int i =1; i<intervals.length; i++){
            int [] arr = intervals[i];
            if(!queue.isEmpty() && queue.peek()[1] > arr[0]){
                queue.add(arr);
            }else {
                queue.poll();
                queue.add(arr);

            }
        }

        return queue.size();
    }
}

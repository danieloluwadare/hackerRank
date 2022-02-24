package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 *
 *
 * Example 1:
 *
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * Example 2:
 *
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] is in the format "HH:MM".
 */
public class Lc539MinimumTimeDifference {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("23:59","00:00");
        System.out.println(findMinDifference(list));

        list = Arrays.asList("00:00","23:59","00:00");
        System.out.println(findMinDifference(list));

    }

    public static int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for(String timePoint : timePoints){
            String [] arrTimePoint =timePoint.split(":");
            int timePointInMinutes =  Integer.parseInt(arrTimePoint[0]) * 60 + Integer.parseInt(arrTimePoint[1]);
            list.add(timePointInMinutes);
        }

        Collections.sort(list);

        for(int i = 1; i < list.size(); i++){
            min = Math.min(min,list.get(i)-list.get(i-1));
        }

        min = Math.min(min,1440 - list.get(list.size()-1) + list.get(0));

        return min;
    }
}

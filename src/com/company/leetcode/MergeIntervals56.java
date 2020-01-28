package com.company.leetcode;

import java.util.*;

public class MergeIntervals56 {


    public int[][] merge(int[][] intervals) {
         List<Interval> intervalz = new ArrayList<>();
         intervalz = Interval.generateInterVals(intervals);
//        for (Interval interval: intervalz) {
//            System.out.println(String.format("%s %s", interval.start, interval.end));
//        }

        Comparator<Interval> cm1=Comparator.comparing(Interval::getStart);
        Collections.sort(intervalz, cm1);


        LinkedList<Interval> mergedIntervals = new LinkedList<>();
//        mergedIntervals.add(intervalz.get(0));
        for (Interval interval: intervalz) {
            Interval insertedInterval = mergedIntervals.peekLast();
            if( mergedIntervals.isEmpty() || interval.start > insertedInterval.end){
                mergedIntervals.add(interval);
            }
            else {
                insertedInterval.end = (insertedInterval.end < interval.end) ? interval.end : insertedInterval.end;

            }


//            System.out.println(String.format("%s %s", interval.start, interval.end));
        }

        int [][] newArr = new int [mergedIntervals.size()][2];
        for(int i = 0; i< mergedIntervals.size();i++){

            newArr[i][0]=mergedIntervals.get(i).start;
            newArr[i][1]=mergedIntervals.get(i).end;

        }
        System.out.println(Arrays.deepToString(newArr));

        return  newArr;


    }

}

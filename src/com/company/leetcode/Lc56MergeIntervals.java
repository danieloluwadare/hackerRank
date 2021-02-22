package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lc56MergeIntervals {

    public static void main(String[] args) {
        int [][] arr = {{8,10},{15,18},{1,7},{2,6}};
        int [][] arr2 = {{1,4},{0,2},{3,5}};

//        System.out.println(Arrays.deepToString(arr));
//        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
//        System.out.println(Arrays.deepToString(arr));
        merge(arr);
        merge(arr2);
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            int [] arr = {intervals[i][0], intervals[i][1]};
            if(list.size()==0 || list.get(list.size()-1)[1] < arr[0] ) {
                list.add(arr);
            }else {
                int max = Math.max(list.get(list.size()-1)[1],arr[1]);
                list.get(list.size()-1)[1]=max;
            }

        }
        int [][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
            result[i][0]=list.get(i)[0];
            result[i][1]=list.get(i)[1];
        }
        System.out.println(Arrays.deepToString(result));

        return result;

    }
}

package com.company.leetcode;

import java.util.*;

public class MinimumTimeDifference539 {

    public static void main(String[] args) {
//        ["23:59","00:00"]
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        list.add("14:05");

//        System.out.println(findMinDifference(list));

    }


    public static int findMinDifference(List<String> timePoints) {
        List<Integer>minutes = new ArrayList<>();
        timePoints.stream().forEach(timePoint ->{
            int timeInMinutes = Integer.parseInt(timePoint.substring(0, 2)) * 60
                    + Integer.parseInt(timePoint.substring(3,5));
            minutes.add(timeInMinutes);
        });


//        timePoints.stream().map()

        Collections.sort(minutes);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < minutes.size(); i++){
            min = Math.min(minutes.get(i)-minutes.get(i-1),min);
        }




        int timeDifferenceBetweenLastFirst = 1440 - minutes.get(minutes.size()-1) + minutes.get(0);
        min = Math.min(timeDifferenceBetweenLastFirst, min);



        return min;
    }

//    def isOneByte(string, i):
//            return len(string) - i >= 8 and string[i] == "0"
//
//    def isTwoBytes(string, i):
//            return len(string) - i >= 16 and string[i: i+3] == "110" and string[i+8: i+10] == "10"
//
//    def isThreeBytes(string, i):
//            return len(string) - i >= 24 and string[i: i+4] == "1110" and string[i+8: i+ 10] == "10" and string[i+16: i+18] == "10"
//
//
//    public boolean validUtf8(string data) {
//        if (len(data) % 8 != 0):
//        return false
//
//        for char in string:
//        if char != "1" or char != "0":
//        return false
//
//        i = 0
//        while i < len(string):
//        if isOneByte(string, i):
//        i += 7
//        elif isTwoByte(string, i):
//        i += 15
//        elif isThreeByte(string, i):
//        i += 23
//            else:
//        return false
//
//        return true
//
//
//    }
}

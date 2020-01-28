package com.company.firecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoupleSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(coupleSum(new int []{1,2,9,11,25},20)));
    }

    public static int[] coupleSum(int[] numbers, int target) {
        int[]result = new int [2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i< numbers.length; i++){
            int remainder = target - numbers[i];
            if(map.	containsKey(remainder)){
                result[0]=map.get(remainder) + 1;
                result[1]=i + 1;
                break;
            }

            map.put(numbers[i],i);

        }

        return result;

    }
}

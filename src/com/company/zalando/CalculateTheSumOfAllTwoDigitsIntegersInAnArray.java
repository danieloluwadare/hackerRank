package com.company.zalando;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 I want to calculate the sum of all integers in an array which contain two digits. For example:

 int[] arr1 = {1, 23, 4, 55};
 int[] arr2 = {2, 5, -66, 23};

 The result for the first array should be 23 + 55 = 78, while the result for the second array should be -66 + 23 = -43. How can I achieve this?

 */
public class CalculateTheSumOfAllTwoDigitsIntegersInAnArray {

    public static void main(String[] args) {
        System.out.println(findTheSumOfAllTwoDigitsIntegersInAnArray(new int[]{1, 23, 4, 55}));
        System.out.println(findTheSumOfAllTwoDigitsIntegersInAnArray(new int[]{2, 5, -66, 23}));

        TreeSet<String> set = new TreeSet<>();
        set.add("okay");
        set.add("yulk");
        set.isEmpty();

        System.out.println(set.pollFirst());

//        Arrays.sort();

    }

    public static int findTheSumOfAllTwoDigitsIntegersInAnArray(int [] arr) {
        int sum = 0;
        for(int i : arr){
            if(i < -9 || i > 9) sum+=i;
        }
        return sum;
    }
}

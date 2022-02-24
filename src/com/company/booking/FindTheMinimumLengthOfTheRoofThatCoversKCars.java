package com.company.booking;

import java.util.Arrays;

public class FindTheMinimumLengthOfTheRoofThatCoversKCars {

    public static void main(String[] args) {
        System.out.println(minRoof(new int[]{12, 6, 5, 2},3));
        System.out.println(minRoof(new int[]{12, 6, 5, 2},5));
        System.out.println(minRoof(new int[]{12, 9, 6, 5, 2},4));

    }

    public static int minRoof(int[] pos, int k) {
        if(pos.length == 0 || k > pos.length)
            return 0;

        Arrays.sort(pos);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < pos.length && i+k<pos.length; i++ ){
            min = Integer.min(min, pos[i+k-1]- pos[i] + 1);
        }
        return min;
    }
}
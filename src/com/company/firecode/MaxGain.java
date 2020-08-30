package com.company.firecode;

import java.util.List;

public class MaxGain {
    public static void main(String[] args) {

    }

    public static int maxGain(int[] a) {
        int max = 0;
        int min = a[0];

        for(int i = 1; i< a.length; i++){
            min = Math.min(min,a[i]);
            max = Math.max(max, a[i]-min);
        }

        return max;
    }


}

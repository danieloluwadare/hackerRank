package com.company.leetcode.bloomberg;

import java.util.Arrays;

public class TwoCityScheduling {
    public static void main(String[] args) {

    }

    public int twoCitySchedCost(int[][] costs) {
//         Daniel's solution
        Arrays.sort(costs,(a, b)->(a[0]-a[1])-(b[0]-b[1]));
        int sum = 0;
        int mid = costs.length/2;
        for(int i = 0; i<mid; i++){
            sum +=  costs[i][0] + costs[i+mid][1];
        }

        return sum;
    }
}

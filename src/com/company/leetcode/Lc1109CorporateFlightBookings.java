package com.company.leetcode;

import java.util.Arrays;

/**
 * There are n flights, and they are labeled from 1 to n.
 *
 * We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.
 *
 * Return an array answer of length n, representing the number of seats booked on each flight in order of their label.
 *
 *
 *
 * Example 1:
 *
 * Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * Output: [10,55,45,25,25]
 *
 *
 * Constraints:
 *
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 */
public class Lc1109CorporateFlightBookings {
    public static void main(String[] args) {
        corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}},  5);
        corpFlightBookings2(new int[][]{{1,2,10},{2,3,20},{2,5,25}},  5);

//        bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        int [] total = new int[n];

        for(int [] booking : bookings){
            int flightStart = booking[0] - 1;
            int flightEnd = booking[1] - 1;
            int bookedSeat = booking[2];
            for (int i = flightStart; i <= flightEnd; i++){
                if(i > n){
                    break;
                }
                total[i]+=bookedSeat;
            }
        }

        System.out.println(Arrays.toString(total));

        return total;
    }

    public static int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] res = new int[n];

        // place the seat num (k) at the
        // startIndex and it's negative at
        // endIndex+1 to stop sum of that value
        for(int[] bk: bookings){
            res[bk[0]-1] += bk[2];
            if(bk[1] < n) res[bk[1]] += - bk[2];
        }

        // Sum the values from left to right
        for(int i=1; i<n; i++) res[i] += res[i-1];
        System.out.println(Arrays.toString(res));

        return res;
    }
}

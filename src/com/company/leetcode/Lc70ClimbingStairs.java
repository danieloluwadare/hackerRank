package com.company.leetcode;

public class Lc70ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
    }

    public static int climbStairs(int n) {

       int [] arr = new int[n];

       int numways = climbStairs(n-1, arr)+ climbStairs(n-2, arr);

        return numways;

    }

    public static int climbStairs(int n, int [] arr) {
        if(n<0)
            return 0;
        if(n==1 || n==0 )
            return 1;
        if(n== 2)
            return 2;
        if(arr[n] != 0)
            return arr[n];

        arr[n] = climbStairs(n-1, arr)+ climbStairs(n-2, arr);
        return arr[n];

    }

}

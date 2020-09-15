package com.company.leetcode;

import java.util.Arrays;

public class Lc91DecodeWays {
    public static char [] alphabet = {
            ' ','A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z'
    };
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));

//        System.out.println("2345".substring(0,2));
    }

    public static int numDecodings(String s) {
        int [] dp = new int [s.length()+1];
        return numDecodings(s, s.length(), dp);
    }

    public static int numDecodings(String s, int len, int [] dp) {
        if(len==0)
            return 1;

        int j = s.length()-len;
        if(s.charAt(j)=='0')
            return 0;

        if(dp[len] != 0){
            return dp[len];
        }

        int result = numDecodings(s,len-1, dp);
        if(len >= 2 && Integer.parseInt(s.substring(j, j+2))<= 26){
            result += numDecodings(s, len-2, dp);
        }

        dp[len]=result;

        return result;
    }
}

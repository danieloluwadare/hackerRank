package com.company.leetcode3;

/**
 * 441. Arranging Coins
 *
 * Share
 * You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins.
 * The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 *
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 */
public class Lc441ArrangingCoins {

    public static void main(String[] args) {
//        System.out.println(arrangeCoins(5));
//        System.out.println(arrangeCoins(8));
//        System.out.println(arrangeCoins(2));
//        System.out.println(arrangeCoins(6));
        System.out.println(arrangeCoins(10));


    }
    public static int arrangeCoins(int n) {
        if(n==1 ||  n== 2)
            return 1;

        int step = 0;
        int count = 0;
        for(int i = 1; step <= n; ++i){
            step += i;
            n-=i;
            count++;
        }
        return count;
    }
}

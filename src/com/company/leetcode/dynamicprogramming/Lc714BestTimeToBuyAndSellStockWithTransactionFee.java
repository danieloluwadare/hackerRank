package com.company.leetcode.dynamicprogramming;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * Medium
 *
 * 2395
 *
 * 71
 *
 * Add to List
 *
 * Share
 * ---------------------------------
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee
 * for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Example 2:
 *
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 < prices.length <= 5 * 104
 * 0 < prices[i], fee < 5 * 104
 */
public class Lc714BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
    public static int maxProfit(int[] prices, int fee) {
        if(prices.length <= 1)
            return 0;
        int [][] dp = new int[prices.length][2];
//        0=> i sold 1= i bought

        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        dp[1][0] = Math.max(dp[0][1] + prices[1],dp[0][0]);
        dp[1][1] = Math.max(dp[0][0]-prices[1]-fee, dp[0][1]);

        for (int i = 2; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i]-fee, dp[i-1][1]);
        }

        return dp[prices.length-1][0];
    }
}

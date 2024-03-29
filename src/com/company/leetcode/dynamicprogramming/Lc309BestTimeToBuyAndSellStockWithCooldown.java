package com.company.leetcode.dynamicprogramming;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * Medium
 *
 * 3496
 *
 * 112
 *
 * Add to List
 *
 * Share
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the
 * stock multiple times) with the following restrictions:
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 *
 * Input: prices = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
public class Lc309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;

        int [][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][1] + prices[1],dp[0][0]);
        dp[1][1] = Math.max(0 - prices[1], dp[0][1]);

        for(int i = 2; i < prices.length; i++){
            dp[i][0]=Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-2][0] - prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][0];
    }
}

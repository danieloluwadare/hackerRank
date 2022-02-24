package com.company.leetcode2;

public class Lc309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int [][] dp = new int[prices.length][2];
//        0 = sell
//        1 = buy
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for(int i = 2; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }


}

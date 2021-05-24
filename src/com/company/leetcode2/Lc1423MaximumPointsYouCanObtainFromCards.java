package com.company.leetcode2;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 * Medium
 *
 *
 * Share
 * There are several cards arranged in a row, and each card has an associated number of points The points are given in
 * the integer array cardPoints.
 *
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 *
 * Your score is the sum of the points of the cards you have taken.
 *
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 *
 *
 *
 * Example 1:
 *
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize
 * your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * Example 2:
 *
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 * Example 3:
 *
 * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 * Output: 55
 * Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 * Example 4:
 *
 * Input: cardPoints = [1,1000,1], k = 1
 * Output: 1
 * Explanation: You cannot take the card in the middle. Your best score is 1.
 * Example 5:
 *
 * Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * Output: 202
 *
 *
 * Constraints:
 *
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 */
public class Lc1423MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{9,7,7,9,7,7,9}, 7));
        System.out.println(maxScore(new int[]{1,1000,1}, 1));
        System.out.println(maxScore(new int[]{1,79,80,1,1,1,200,1}, 3));

    }

    public static int maxScore(int[] cardPoints, int k) {
        if(k==1) return Math.max(cardPoints[0],cardPoints[cardPoints.length-1]);
        int sum = 0;
        for(int i : cardPoints)
            sum+=i;

        int maxSum = 0;
        int total = 0;
        for(int i =0; i < cardPoints.length-k; i++){
            total+=cardPoints[i];
        }
        maxSum=Math.max(maxSum,sum-total);
        int i =0;
        for(int j=cardPoints.length-k; j < cardPoints.length; j++){
            total+=cardPoints[j]-cardPoints[i++];
            maxSum=Math.max(maxSum, sum - total);
        }

        return maxSum;
    }

    public static int maxScore2(int[] cardPoints, int k) {
        int [][] cache = new int[cardPoints.length][cardPoints.length];
        return maxScoreHelper(cardPoints,0,cardPoints.length-1,k,cache);
    }

    private static int maxScoreHelper(int[] cardPoints, int left, int right, int k, int[][] cache) {
        if(k==1) return Math.max(cardPoints[left],cardPoints[right]);
        if(cache[left][right] != 0) return cache[left][right];

        int leftRecursion = maxScoreHelper(cardPoints,left+1,right,k-1,cache);
        int leftAnswer = cardPoints[left] + leftRecursion;
        cache[left+1][right]=leftRecursion;

        int rightRecursion = maxScoreHelper(cardPoints, left, right-1, k-1, cache);
        int rightAnswer = cardPoints[right] + rightRecursion;
        cache[left][right-1]=rightRecursion;


        int result = Math.max(leftAnswer,rightAnswer);
        cache[left][right]=result;
        return result;
    }
}

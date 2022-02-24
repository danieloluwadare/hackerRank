package com.company.leetcode2;

import java.util.Arrays;

/**
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 * Medium
 *
 * 348
 *
 * 125
 *
 * Add to List
 *
 * Share
 * Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
 *
 * Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in
 * the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 * Output: 4
 * Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal
 * and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
 *
 * Example 2:
 *
 * Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 * Output: 6
 * Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts.
 * After you cut the cake, the green and yellow pieces of cake have the maximum area.
 *
 * Example 3:
 *
 * Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 2 <= h, w <= 10^9
 * 1 <= horizontalCuts.length < min(h, 10^5)
 * 1 <= verticalCuts.length < min(w, 10^5)
 * 1 <= horizontalCuts[i] < h
 * 1 <= verticalCuts[i] < w
 * It is guaranteed that all elements in horizontalCuts are distinct.
 * It is guaranteed that all elements in verticalCuts are distinct.
 */
public class Lc1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public static void main(String[] args) {
        System.out.println(maxArea( 5,  4, new int[]{1,2,4}, new int[]{1,3}));
    }
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long horizontal  = helper(h, horizontalCuts);
        long vertical  = helper(w, verticalCuts);
        long result = (horizontal * vertical) % 1000000007L;
        return (int) result;
    }

    public static int helper(int size, int[] cuts){
        Arrays.sort(cuts);
        int max = cuts[0];
        for(int i = 1; i < cuts.length; i++){
            max =Math.max(max,cuts[i]-cuts[i-1]);
        }
        max=Math.max(max, size-cuts[cuts.length-1]);

        return max;
    }
}

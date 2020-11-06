package com.company.leetcode;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class Lc42TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        System.out.println(trap2(new int[]{2,0,2}));

    }

//    brute force approach
    public static int trap(int[] height) {
        int sumOfWaterHoldingCapacity = 0;
        if(height.length==0)
            return sumOfWaterHoldingCapacity;

        int maximumLeft= height[0];
        for(int i = 1; i < height.length; i++){
            int currentHeight = height[i];
            maximumLeft= Math.max(maximumLeft,currentHeight);
            int maximumRight=0;
            for(int j= i+ 1; j<height.length; j++){
                maximumRight=Math.max(maximumRight,height[j]);
            }

            int minOfMaxRightAndMaxLeft = Math.min(maximumLeft,maximumRight) - currentHeight;
            sumOfWaterHoldingCapacity+= Math.max(minOfMaxRightAndMaxLeft, 0);
        }

        return sumOfWaterHoldingCapacity;
    }

    public static int trap2(int[] height) {
        int sumOfWaterHoldingCapacity = 0;
        if(height.length==0)
            return sumOfWaterHoldingCapacity;

        int [] maximumLeft= new int[height.length];
        maximumLeft[0]=height[0];
        for(int i = 1; i < height.length; i++){
            maximumLeft[i]=Math.max(height[i],maximumLeft[i-1]);
        }

        int [] maximumRight= new int[height.length];
        maximumRight[height.length-1]=height[height.length-1];
        for(int i = height.length - 2; i >= 0; i--){
            maximumRight[i]=Math.max(height[i],maximumRight[i+1]);
        }

        for(int i = 1; i < height.length; i++){
            int minOfMaxRightAndMaxLeft = Math.min(maximumLeft[i],maximumRight[i]) - height[i];
            sumOfWaterHoldingCapacity+= Math.max(minOfMaxRightAndMaxLeft, 0);
        }

        System.out.println(Arrays.toString(maximumLeft));
        System.out.println(Arrays.toString(maximumRight));

        return sumOfWaterHoldingCapacity;
    }
}

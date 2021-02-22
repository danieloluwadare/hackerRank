package com.company.leetcode2;

public class Lc11MedContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,2,1}));
//
        System.out.println(maxArea(new int[]{ 2,3,4,5,18,17,6}));

    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int leftHeight = 0;
        int rightHeight = height.length-1;
        while(leftHeight != rightHeight){
            int area = Math.min(height[leftHeight],height[rightHeight]) * (rightHeight-leftHeight);
            maxArea= Math.max(maxArea,area);
            if(height[leftHeight] > height[rightHeight])
                rightHeight--;
            else leftHeight++;
        }

        return maxArea;
    }
}

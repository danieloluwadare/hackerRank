package com.company.leetcode;

public class Lc162FindPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement(new int[]{1,2}));

        System.out.println("findPeakElement2");

        System.out.println(findPeakElement2(new int[]{1,2,3,1}));
        System.out.println(findPeakElement2(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement2(new int[]{1,2}));

    }

    public static int findPeakElement(int[] nums) {
        if(nums.length <= 1) return 0;
        int len = nums.length;
        int i = 1;
        while (i < len){
            if(nums[i] > nums[i-1]){
                i++;
                continue;
            }
            return i-1;
        }

        return i-1;
    }

    public static int findPeakElement2(int[] nums) {
        int r = nums.length-1;
        int l = 0;

        while (l < r){
            int mid = (l+r)/2;
            if(nums[mid] > nums[mid+1]){
                r=mid;
            }else {
                l=mid+1;
            }
        }

        return l;
    }
}

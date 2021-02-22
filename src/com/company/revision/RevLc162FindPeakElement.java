package com.company.revision;

public class RevLc162FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement(new int[]{1,2}));

        System.out.println("findPeakElement2");

//        System.out.println(findPeakElement2(new int[]{1,2,3,1}));
//        System.out.println(findPeakElement2(new int[]{1,2,1,3,5,6,4}));
//        System.out.println(findPeakElement2(new int[]{1,2}));

    }

    public static int findPeakElement(int[] nums) {
        int maxElement=nums[0];
        int maxIndex =0;
        for(int i =1; i < nums.length; i++){
            int num = nums[i];
            if(num > maxElement){
                maxElement=num;
                maxIndex=i;
            }else {
                break;
            }
        }
        return maxIndex;
    }
}

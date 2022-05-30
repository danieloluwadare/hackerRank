package com.company.leetcode22;

public class Lc41FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{
                98,93,95,10,91,4,90,88,56,84,65,62,83,80,78,60,73,77,76,29,63,12,57,17,69,68,50,11,31,33,8,42,38,7,0,
                37,48,26,20,44,46,43,52,51,47,18,49,58,2,39,30,81,22,55,36,40,15,27,21,32,64,41,53,19,
                28,24,9,25,3,59,66,82,61,70,23,34,71,54,74,-1,1,45,14,79,5,35,13,72,75,85,87,6,16,86,67,89,94,92,96,97
        }));
    }

    public static int firstMissingPositive(int[] nums) {
//        System.out.println(nums.length);
        int [] A = nums;
        for(int i = 0; i < A.length; i++){
            if(A[i] < 0)
                A[i] = 0;
        }

        for(int i : A){
            int index = Math.abs(i) - 1;
            if(index >= 1 && index < A.length){
                if(A[index]==0)
                    A[index]= (-1) * (A.length + 1);
                else if(A[index] > 0)
                    A[index] *= -1;
            }
        }

        for(int i = 1; i < A.length + 1; i++){
            if(A[i-1] >= 0) return i;
        }

        return A.length + 1;
    }
}


package com.company.leetcode3;

import java.util.Arrays;
import java.util.Random;

public class Lc528RandomPickWithWeight {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,2,3});
        System.out.println(solution.pickIndex());
    }

    static class Solution {
        private int [] arr ;
        private int sum;
        private Random random;
        public Solution(int[] w) {
            random = new Random();
            arr = w;
            sum = 0;
            for(int i = 0; i < w.length; i++){
                sum += w[i];
                arr[i] = sum;
            }

        }

        public int pickIndex() {
            System.out.println(Arrays.toString(arr));
            double rand = random.nextDouble();
            int x =  (int) (rand * sum);
            return binarySearch(x);
        }

        public int binarySearch(int value){
            int leftIndex = 0;
            int rightIndex = arr.length - 1;
            int index = 0;
            while(leftIndex <= rightIndex){
                int midIndex = (rightIndex - leftIndex); // 2;
                int offsetIndex = leftIndex + midIndex;
                if(value < arr[offsetIndex]){
                    index = offsetIndex;
                    rightIndex = offsetIndex-1;
                }
                else{
                    leftIndex=offsetIndex + 1;
                }
            }

            return index;

        }
    }
}

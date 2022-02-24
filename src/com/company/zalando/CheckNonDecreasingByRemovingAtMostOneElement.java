package com.company.zalando;

/**
 * Given an array with n integers, check if it could become non-decreasing by removing at most 1 element.
 *
 * Example:
 *
 * Input: [3,2,4,3], Output: false
 *
 * Input:[1, 4, 2, 3], Output: true
 *
 * Input:[4, 3, 2], Output: false
 *
 * Input:[1, 2, 3], Output: true
 */
public class CheckNonDecreasingByRemovingAtMostOneElement {

    public static void main(String[] args) {
        System.out.println(checkIfNonDecreasingByRemovingAtMostOneElement(new int[]{3, 2, 4, 3}));
        System.out.println(checkIfNonDecreasingByRemovingAtMostOneElement(new int[]{1, 4, 2, 3}));
        System.out.println(checkIfNonDecreasingByRemovingAtMostOneElement(new int[]{4, 3, 2}));
        System.out.println(checkIfNonDecreasingByRemovingAtMostOneElement(new int[]{1, 2, 3}));

    }

    public static boolean checkIfNonDecreasingByRemovingAtMostOneElement(int [] nums){

        boolean foundFirstDecreasing = false;
        for(int i = 1; i < nums.length; i++){
            boolean findDecreasing = nums[i] < nums[i-1];
            if(!foundFirstDecreasing && findDecreasing){
                foundFirstDecreasing=true;
            }
            else if(foundFirstDecreasing && findDecreasing){
                return false;
            }
        }
        return true;
    }
}


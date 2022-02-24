package com.company.revision;

public class RevLc941ValidMountainArray {

    public static void main(String[] args) {

        System.out.println(validMountainArray(new int[]{0,3,2,1}));
        System.out.println(validMountainArray(new int[]{3,5,5}));
        System.out.println(validMountainArray(new int[]{2,1}));
        System.out.println(validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}));
        System.out.println(validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));
//        System.out.println(validMountainArrayAhmed(new int[]{0,3,2,1}));
    }
    public static boolean validMountainArray(int[] A) {
        if(A.length < 3)
            return false;

        boolean foundPivot = false;
        for(int i = 1; i < A.length; i++){

            if(i != 1 &&  A[i] < A[i-1])
                foundPivot=true;

            if(foundPivot && A[i] >= A[i-1] ) // A[i - 1] <= A[i]
                return false;

            if(!foundPivot && A[i] <= A[i-1])  // A[i - 1] >= A[i]
                return false;



        }
        return foundPivot;
    }
}

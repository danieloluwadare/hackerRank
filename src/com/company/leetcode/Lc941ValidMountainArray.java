package com.company.leetcode;

public class Lc941ValidMountainArray {

    public static void main(String[] args) {

        System.out.println(validMountainArray(new int[]{0,3,2,1}));
//        System.out.println(validMountainArray(new int[]{3,5,5}));
//        System.out.println(validMountainArray(new int[]{2,1}));
//        System.out.println(validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}));
//        System.out.println(validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));


        System.out.println(validMountainArrayAhmed(new int[]{0,3,2,1}));


    }
    public static boolean validMountainArray(int[] A) {
//        Daniel D solution

        if(A.length < 3){
            return false;

        }


//       1==up 0 == down
        boolean increasedUpward=false;
        boolean decreasedDownward=false;
        int direction = 1;
        int i = 1;
        while (i < A.length){

            if (direction==1){
                if(A[i] > A[i-1] ){
                    increasedUpward=true;
                    i++;
                    continue;
                }
                else if(A[i]==A[i-1]){
                    return false;
                }
                else {
                    direction=0;

                }
            }else {
                if(A[i] < A[i-1]){
                    decreasedDownward=true;
                    i++;
                    continue;
                }
                else if(A[i]==A[i-1]){
                    return false;
                }
                else {
                    return false;
                }
            }


        }
//        This means there is no slope from the peak of the mountain
        if (increasedUpward && decreasedDownward)
            return true;
        return false;

    }

    //        System.out.println(validMountainArray(new int[]{0,2,3,2,1}));

    //Adebisi Ahmed
    public static boolean validMountainArrayAhmed(int[] A) {
        if(A == null || A.length < 3) return false;

        boolean foundPivot = false;
        for(int i = 1; i< A.length; i++) {



            if(i != 1 && A[i - 1] > A[i]) {
                foundPivot = true;
            }

            if(foundPivot && A[i - 1] <= A[i])  {
                return false;
            }

            if(!foundPivot && A[i - 1] >= A[i])  {
                return false;
            }



        }
        return foundPivot;
    }
}

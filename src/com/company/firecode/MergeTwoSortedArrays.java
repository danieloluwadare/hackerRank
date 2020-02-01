package com.company.firecode;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int [] arr = merge(new int[]{1,3,4,6,9}, new int[]{2, 3, 5, 10, 12});
        System.out.println(Arrays.toString(arr));
    }

    public static int[] merge(int[] arrLeft, int[] arrRight){


        if(arrLeft.length==0 && arrRight.length==0){

            return new int [0];
        }

        if((arrLeft.length!=0 && arrRight.length==0) || (arrLeft.length==0 && arrRight.length!=0) ){
            if(arrRight.length != 0) return arrRight;
            if(arrLeft.length != 0) return arrLeft;
        }

        int l = 0;
        int r = 0;
        int count= 0;
        int totalLength = arrLeft.length + arrRight.length;

        int [] mergeArr = new int [totalLength];

        while(count<totalLength){

            if(l<=arrLeft.length-1 && r<=arrRight.length-1){
                if(arrLeft[l] > arrRight[r]){
                    mergeArr[count]=arrRight[r];
                    r++;
                }
                else{
                    mergeArr[count]=arrLeft[l];
                    l++;
                }
            }
            else{
                if(l>arrLeft.length-1){
                    mergeArr[count]=arrRight[r];
                    r++;
                }else{
                    mergeArr[count]=arrLeft[l];
                    l++;
                }

            }

            count ++;
        }

        return mergeArr;


    }
}

package com.company.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwodArrayHourGlass {

    public static void main(String[] args) {

        int arr[][]={
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int arr2[][]={
                {-1, 1, -1, 0, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {-1, -1, -1, 0, 0, 0},
                {0, -9, 2, -4, -4, 0},
                {-7, 0, 0, -2, 0, 0,},
                {0, 0, -1, -2, -4, 0}
        };

//        System.out.println(arr.length);
//        System.out.println(arr[5][4]);
        System.out.println(hourglassSum(arr2));



    }

    static int hourglassSum(int[][] arr) {
        Stack<Integer> stack =new Stack<>();
        stack.push(Integer.MIN_VALUE);
        int resultArray [][] =new int[4][4];
        int sum=0;
        for(int i =0; i<arr.length-2; i++){
            for(int j=0; j<arr.length-2; j++){
                for(int k=0; k<3; k++){
                    sum += arr[i][j+k];
                    if(k==1){
                        sum += arr[i+1][j+k];
                    }
                    sum += arr[i+2][j+k];



                }
                performMaxoperation(stack,sum);
                resultArray[i][j]=sum;
                sum=0;
            }
        }

        return stack.peek();

    }

    static void performMaxoperation(Stack<Integer> stack, int value){
        if(stack.empty()){
            stack.push(value);
        }else if (value>stack.peek()){
            stack.push(value);
        }
    }
}

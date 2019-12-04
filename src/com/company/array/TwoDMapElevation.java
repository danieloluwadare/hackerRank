package com.company.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoDMapElevation {
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

        int arr3[][]={
                {1,2,1,3,4},
                {1,5,2,2,2},
                {4,5,1,9,7},
                {3,5,3,7,6},
                {4,3,1,7,3}
        };

//        System.out.println(arr.length);
//        System.out.println(arr[5][4]);
//        System.out.println(hourglassSum(arr2));

//        optimizedTransversal(arr,3,  0);
//        getAllsurroundingElement(arr,3,  0);
//        getAllsurroundingElement(arr, 3, 3);
//        System.out.println(arr[2][0]);
        System.out.println(optimizedTransversalForElevation(arr3,2,3));
//
//        int newArr[][]=new int[arr3.length][arr3.length];
//
//        for(int i=0; i <arr3.length; i++){
//            for(int j=0; j <arr3.length; j++){
//                newArr[i][j]=optimizedTransversalForElevation(arr3, i, j);
//            }
//        }
//
//        for(int i=0; i <newArr.length; i++){
//            for(int j=0; j <newArr.length; j++){
//                System.out.print(newArr[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    public static int getAdjacentNeighbor(int arr[][], int i, int j){
        Stack<Integer> stack =new Stack<>();
        int arr3 [] = new int [8];
        for(int k = 0; k<8; k++){

            if(k==0){
                performMaxoperation(stack,getValueAtIndex(arr, i-1, j));
            }
            else if(k==1){
                performMaxoperation(stack,getValueAtIndex(arr, i-1, j+1));
            }
            else if(k==2){
                performMaxoperation(stack,arr3[k] =getValueAtIndex(arr, i, j+1) );
            }
            else if(k==3){
                performMaxoperation(stack,arr3[k] =getValueAtIndex(arr, i+1, j+1));
            }
            else if(k==4){
                performMaxoperation(stack,getValueAtIndex(arr, i+1, j)) ;
            }
            else if(k==5){
                performMaxoperation(stack,arr3[k] =getValueAtIndex(arr, i+1, j-1)) ;
            }
            else if(k==6){
                performMaxoperation(stack,getValueAtIndex(arr, i, j-1)) ;
            }
            else if(k==7){
                performMaxoperation(stack,getValueAtIndex(arr, i-1, j-1)) ;
            }
        }

        if(arr[i][j] > stack.peek()){
            return 1;
        }

        return 0;
    }

    static void performMaxoperation(Stack<Integer> stack, int value){
        if(stack.empty()){
            stack.push(value);
        }else if (value>stack.peek()){
            stack.push(value);
        }
    }



    public static int optimizedTransversalForElevation(int arr[][], int i, int j){
        int returnValue=1;
        boolean breakLoop=false;
        for(int k = 0; k<2; k++){
            breakLoop=false;
            returnValue=1;
            for( int z = 0; z<2; z++){

                if(k==0 && z==0){
                    continue;
                }

                int positiveRow = i+k;
                int positiveCol = j+z;

                int negativeRow  = i-k;
                int negativeCol = j-z;

                int adjacentValueForPositiveAxis=-1;
                int adjacentValueForNegativeAxis=-1;

                try {
                    adjacentValueForPositiveAxis = arr[positiveRow][positiveCol];
                }
                catch (Exception e){
                }

                try {
                    adjacentValueForNegativeAxis = arr[negativeRow][negativeCol];
                }
                catch (Exception e){
                }


                if(arr[i][j] <= adjacentValueForPositiveAxis || arr[i][j] <= adjacentValueForNegativeAxis){
                    returnValue=0;
                    breakLoop=true;
                    break;
                }


            }

            if(breakLoop){
                break;
            }

        }

        return returnValue;


    }

    public static void optimizedTransversal(int arr[][], int i, int j){
        List<Integer>list =new ArrayList<>();
//        int i = i-1;
//        int z = j-1;

        int max=j+1;
        for(int k = i-1; k<=max; k++){
            for( int z = j-1; z<=max; z++){
                if(k==i && z==j){
                    continue;
                }
                int adjacentValue=-9;
                try {
                    adjacentValue = arr[k][z];
                }
                catch (Exception e){
                }
                list.add(adjacentValue);
            }
        }

        for(int d:list){
            System.out.println(d);
        }
    }

    public static int[][] getAllsurroundingElement(int arr[][], int i, int j){
        int arr3 [] = new int [8];
        for(int k = 0; k<8; k++){

            if(k==0){
                arr3[k]=arr[i-1][j];
            }
            else if(k==1){
                arr3[k]=getValueAtIndex(arr, i-1, j+1);
            }
            else if(k==2){
                arr3[k] =getValueAtIndex(arr, i, j+1) ;
            }
            else if(k==3){
                arr3[k] =getValueAtIndex(arr, i+1, j+1) ;
            }
            else if(k==4){
                arr3[k] =getValueAtIndex(arr, i+1, j) ;
            }
            else if(k==5){
                arr3[k] =getValueAtIndex(arr, i+1, j-1) ;
            }
            else if(k==6){
                arr3[k] =getValueAtIndex(arr, i, j-1) ;
            }
            else if(k==7){
                arr3[k] =getValueAtIndex(arr, i-1, j-1) ;
            }
        }

        for(int l : arr3){
            System.out.println(l);
        }
        return null;
    }

    public static int getValueAtIndex(int arr[][], int i, int j){
        int adjacentValue=-9;
        try {
            adjacentValue = arr[i][j];
        }
        catch (Exception e){
        }
        return adjacentValue;
    }




}

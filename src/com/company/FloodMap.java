package com.company;

import java.util.Stack;

public class FloodMap {
    public static void main(String[] args) {
        int arr3[][]={
                {1,2,1,3,4},
                {1,5,2,2,2},
                {4,5,1,9,7},
                {3,5,3,7,6},
                {4,3,1,7,3}
        };

        int boolArray [][]=findHighPoints3(arr3);

        for(int i=0; i <boolArray.length; i++){
            for(int j=0; j <boolArray.length; j++){
                System.out.print(boolArray[i][j]);
            }
            System.out.println();
        }

//        System.out.println(getMaxNeighbors(arr3,0,4));

    }

    public static int[][] findHighPoints3(int[][] elevations) {
        int arr [][]  = new int [elevations.length][elevations.length];
        for(int i=0; i<elevations.length; i++){
            for (int j=0; j<elevations.length; j++){
                arr[i][j]=getMaxNeighbors(elevations,i,j);
            }
        }

        return arr;
    }

    private static int getMaxNeighbors (int arr[][], int i, int j){
        Stack<Integer> stack= new Stack<>();
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k>=0 && k<arr.length ) && (m>=0 && m<arr.length ) && !(k==i && m==j)){
//                    if(k==i && m==j){
//                        continue;
//                    }

                    int value=getValueAtIndex(arr,k, m);
                    performMaxOperation(stack, value);
//                    System.out.println(value);
                }

            }
        }
        return comparePoints(stack,arr[i][j]);
    }

    static void performMaxOperation(Stack<Integer> stack, int value){
        if(stack.empty()){
            stack.push(value);
        }else if (value>stack.peek()){
            stack.push(value);
        }
    }

    static int comparePoints(Stack<Integer> stack, int value){
        if(value>stack.peek()){
            return 1;
        }else {
            return 0;
        }
    }

    public static int getValueAtIndex(int arr[][], int i, int j){
        int adjacentValue=0;
        try {
            adjacentValue = arr[i][j];
        }
        catch (Exception e){
        }
        return adjacentValue;
    }
}

package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FloodMapHighPointPlateau {
    public static void main(String[] args) {
        int arr3[][]={
                {1,2,1,3,4},
                {1,5,2,2,2},
                {4,5,1,9,7},
                {3,5,3,7,6},
                {4,3,1,7,3}
        };

        int boolArray [][]=findHighPointsWithPlateau(arr3);

        for(int i=0; i <boolArray.length; i++){
            for(int j=0; j <boolArray.length; j++){
                System.out.print(boolArray[i][j]);
            }
            System.out.println();
        }

//        System.out.println(getMaximumNeighbors2(arr3,4,3, new HashSet<Integer>(), new HashSet<String>()));

//        System.out.println();

    }

    public static int[][] findHighPointsWithPlateau(int[][] elevations) {
        Set<Integer> result;
        Set<String> visited;
        int arr [][]  = new int [elevations.length][elevations.length];
        for(int i=0; i<elevations.length; i++){
            for (int j=0; j<elevations.length; j++){
                result=new HashSet<>();
                visited=new HashSet<>();
                arr[i][j]=getMaximumNeighbors2(elevations, i, j, result, visited).contains(0) ? 0 : 1;
            }
        }

        return arr;
    }

    private static Set<Integer> getMaximumNeighbors2 (int arr[][], int i, int j, Set<Integer>result,Set<String>visited){
        Set<String>indices=new HashSet<>();
        visited.add(String.valueOf(i).concat(String.valueOf(j)));
        int maxNumber = Integer.MIN_VALUE;
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k>=0 && k<arr.length ) && (m>=0 && m<arr.length ) && !(k==i && m==j)){
                    int value=getValueAtIndex(arr,k, m);
                    maxNumber=Math.max(value,maxNumber);
                    if(arr[i][j] == value && arr[i][j] >= maxNumber ){
                        if(!visited.contains(String.valueOf(k).concat(String.valueOf(m)))){
                            result.add(1);
                            indices.add(String.valueOf(k).concat(String.valueOf(m)));
                            getMaximumNeighbors2(arr, k, m, result, visited);
                        }
                    }
                }

            }
        }

        if(arr[i][j] >= maxNumber){
            result.add(1);
        }
//        else if(arr[i][j]==maxNumber){
//            result.add(1);
//            for (String indexes : indices) {
////                if(result.contains(0)){
////                    return result;
////                }
//                int y=Character.getNumericValue(indexes.charAt(0));
//                int z=Character.getNumericValue(indexes.charAt(1));
//
//                getMaximumNeighbors(arr, y, z, result, visited);
//                System.out.println(indexes+"=="+arr[y][z]);
//            }
//
//        }
        else {
            result.add(0);
        }


        return result;

//        return comparePoints(maxNumber,arr[i][j]);
    }


    private static Set<Integer> getMaximumNeighbors (int arr[][], int i, int j, Set<Integer>result,Set<String>visited){
        Set<String>indices=new HashSet<>();
        visited.add(String.valueOf(i).concat(String.valueOf(j)));
        int maxNumber = Integer.MIN_VALUE;
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k>=0 && k<arr.length ) && (m>=0 && m<arr.length ) && !(k==i && m==j)){
                    int value=getValueAtIndex(arr,k, m);
                    maxNumber=Math.max(value,maxNumber);
                    if(arr[i][j] == value && arr[i][j] >= maxNumber ){
                        if(!visited.contains(String.valueOf(k).concat(String.valueOf(m)))){
                            indices.add(String.valueOf(k).concat(String.valueOf(m)));
                        }
                    }
                }

            }
        }

        if(arr[i][j] > maxNumber){
            result.add(1);
        }else if(arr[i][j]==maxNumber){
            result.add(1);
            for (String indexes : indices) {
//                if(result.contains(0)){
//                    return result;
//                }
                int y=Character.getNumericValue(indexes.charAt(0));
                int z=Character.getNumericValue(indexes.charAt(1));

                getMaximumNeighbors(arr, y, z, result, visited);
                System.out.println(indexes+"=="+arr[y][z]);
            }

        }else {
            result.add(0);
        }


        return result;

//        return comparePoints(maxNumber,arr[i][j]);
    }

    static int comparePoints(int maxValue, int currentArrayValue ){
        if(currentArrayValue>maxValue){
            return 1;
        }else {
            return 0;
        }
    }

    static void performMaxOperation(Stack<Integer> stack, int value){
        if(stack.empty()){
            stack.push(value);
        }else if (value>stack.peek()){
            stack.push(value);
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

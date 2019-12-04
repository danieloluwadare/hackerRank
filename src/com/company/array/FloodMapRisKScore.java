package com.company.array;

import java.util.HashSet;
import java.util.Set;

public class FloodMapRisKScore {

    public static void main(String[] args) {
        int arr3[][]={
                {1,2,1,3,4},
                {1,5,2,2,2},
                {4,5,1,9,7},
                {3,5,3,7,6},
                {4,3,1,7,3}
        };

        int [][] result = findRiskScore(arr3);

        for(int i=0; i < result.length; i++){
            for (int j=0; j<result.length; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }




    public static int[][] findRiskScore(int[][] elevations) {
        int [][] highpoints = findHighPoints3(elevations);
        int [][] arr3 = new int[elevations.length][elevations[0].length];
        Set<String> set;
        for(int i=0; i<highpoints.length; i++){
            for (int j=0; j<highpoints.length; j++){

                if(highpoints[i][j]==1){
                    set= new HashSet<>();
                    floodPoint(elevations, i, j, set,arr3);

                }
            }
        }

        return arr3;

    }


    public static void floodPoint(int arr[][], int i, int j, Set<String>set, int retArr[][]){
        retArr[i][j] += 1;
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k>=0 && k<arr.length ) && (m>=0 && m<arr.length ) && !(k==i && m==j)){
                    if(arr[i][j] > arr[k][m]){
                        if(!set.contains(String.valueOf(k).concat(String.valueOf(m)))){
                            set.add(String.valueOf(k).concat(String.valueOf(m)));
                            floodPoint(arr,k,m,set,retArr);
                        }

                    }

                }

            }
        }
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
        int maxNumber = Integer.MIN_VALUE;
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k>=0 && k<arr.length ) && (m>=0 && m<arr.length ) && !(k==i && m==j)){

                    int value=arr[k][m];
                    maxNumber=Math.max(value,maxNumber);
                }

            }
        }
        return comparePoints(maxNumber,arr[i][j]);
//        return comparePoints(stack,arr[i][j]);
    }

    static int comparePoints(int maxValue, int currentArrayValue ){
        if(currentArrayValue>maxValue){
            return 1;
        }else {
            return 0;
        }
    }
}

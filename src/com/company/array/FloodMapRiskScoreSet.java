package com.company.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FloodMapRiskScoreSet {
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
            for (int j=0; j<result[0].length; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] findRiskScore(int[][] elevations) {
        int [][] highpoints = findHighPoints3(elevations);
        int [][] arr3 = new int[elevations.length][elevations[0].length];
        Set<String> set;
        Map<String, Integer> map=new HashMap<>();
        for(int i=0; i<highpoints.length; i++){
            for (int j=0; j<highpoints[0].length; j++){

                if(highpoints[i][j]==1){
                    set= new HashSet<>();
                    floodPoint(elevations, i, j, set,map);

                }
            }
        }

        for(int i=0; i<highpoints.length; i++){
            for (int j=0; j<highpoints.length; j++){
                String key= String.valueOf(i).concat(String.valueOf(j));
                arr3[i][j]=map.containsKey(key) ? map.get(key) : 0;
            }
        }

        return arr3;

    }


    public static void floodPoint(int arr[][], int i, int j, Set<String>set, Map<String,Integer>map){
        if(map.containsKey(String.valueOf(i).concat(String.valueOf(j)))){
            int initialScore = map.get(String.valueOf(i).concat(String.valueOf(j)));
            initialScore++;
            map.replace(String.valueOf(i).concat(String.valueOf(j)),initialScore);
        }else {
            map.put(String.valueOf(i).concat(String.valueOf(j)), 1);
        }
//        retArr[i][j] += 1;
        for(int k=i-1; k<=i+1; k++){
            for(int m=j-1; m<=j+1; m++){
                if((k>=0 && k<arr.length ) && (m>=0 && m<arr[0].length ) && !(k==i && m==j)){
                    if(arr[i][j] > arr[k][m]){
                        if(!set.contains(String.valueOf(k).concat(String.valueOf(m)))){
                            set.add(String.valueOf(k).concat(String.valueOf(m)));
                            floodPoint(arr,k,m,set,map);
                        }

                    }

                }

            }
        }
    }


    public static int[][] findHighPoints3(int[][] elevations) {
        int arr [][]  = new int [elevations.length][elevations.length];
        for(int i=0; i<elevations.length; i++){
            for (int j=0; j<elevations[0].length; j++){
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

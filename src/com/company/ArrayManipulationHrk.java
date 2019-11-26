package com.company;

import java.util.*;

public class ArrayManipulationHrk {

    public static void main(String[] args) {

        int arr[][]={
                {1, 5, 3},
                {4, 8, 7},
                {6, 9, 1}
        };

        int array [][]={
                {2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}
        };
//        arrayManipulation(10,arr);

        System.out.println(arrayManipulation(10,array));
//        System.out.println(arr[5][4]);
//        System.out.println(hourglassSum(arr2));



    }

    static long arrayManipulation(int n, int[][] queries) {
        long maxNumber = Integer.MIN_VALUE;
        long sum = 0;
        int [] resultant = new int[n + 2];
        for(int i = 0; i<queries.length; i++){
            resultant[queries[i][0]] += queries[i][2];
            resultant[(queries[i][1] + 1)] -= queries[i][2];
        }
        for(int i : resultant){
            sum +=i;
            maxNumber=Math.max(maxNumber,sum);
        }


//        Map<Integer, Integer> map = new LinkedHashMap<>();
//        boolean check=true;
//        long maxNumber = Integer.MIN_VALUE;
//        int sum = 0;

//        for(int i = 0; i<queries.length; i++){
//            for(int j =0; j<2; j++){
//                if(check==true){
//                    if(map.containsKey(queries[i][j])){
//                        int newValue = map.get(queries[i][j]) + queries[i][2];
//                        map.replace(queries[i][j],newValue);
//
//                    }else {
//                        map.put(queries[i][j],queries[i][2]);
//
//
//                    }
//                    check=!check;
//                    continue;
//                }
//                else {
//                    if(map.containsKey(queries[i][j])){
//                        int newValue = map.get(queries[i][j]) + -queries[i][2];
//                        map.replace(queries[i][j],newValue);
//
//                    }else{
//                        map.put(queries[i][j],-queries[i][2]);
//
//                    }
//                    check=!check;
//                }
//
////                System.out.print(queries[i][j]);
//            }
////            System.out.println();
//        }

//        for (Object i: map.keySet()) {
//            System.out.println("key="+i+" value= "+map.get(i));
//        }
//
//        for(Integer i : map.values()){
//            sum +=i;
//            maxNumber=Math.max(maxNumber,sum);
//        }



//        for(int i =0; i<queries.length; i++){
//            int leftIndex = queries[i][0] - 1;
//            int rightIndex = queries[i][1] - 1;
//            int summand = queries[i][2];
//
//            for(int j = leftIndex; j<=rightIndex; j++){
//                arr3[j]+=summand;
//                maxNumber=Math.max(maxNumber,arr3[j]);
//            }
//
//            for(int k : arr3){
//                System.out.print(k);
//            }
//
//            System.out.println();
//        }

        return maxNumber;

    }
}

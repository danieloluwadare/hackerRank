package com.company.array;

public class CavityMap {
    public static void main(String[] args) {
        String [] arr= {"1112","1912","1892","1234"};
        String [] arr3={"12","12"};
        int [][] cyclicArray= {
                {1,0,2,1,2},
                {1,3,5,4,3},
                {4,5,2,5,3},
                {3,5,3,5,4},
                {4,4,5,3,0}
        };
       String [] arr2 =  cavityMap(arr3);
        for(int i=0; i<arr2.length; i++){
            System.out.println(arr2[i]);
        }

//        findCavity(cyclicArray,2,2);

    }

    static String[] cavityMap(String[] grid) {
        int [][] newArr= new int [grid.length][grid.length];
        String[] retArr = new String[grid.length];
        for(int i=0; i<grid.length; i++){
            String tempArray = grid[i];
            for(int j=0; j<grid.length; j++){
                newArr[i][j]= Character.getNumericValue(tempArray.charAt(j)); //;
//                System.out.print(newArr[i][j]);
            }
//            System.out.println();
        }

        for(int i=0; i<grid.length; i++){
            String temp ="";
            for(int j=0; j<grid.length; j++){
                boolean bool = isCavity(newArr, i, j);
                temp=temp.concat((bool) ? "X" : String.valueOf(newArr[i][j]));
//                System.out.print((bool) ? "X" : String.valueOf(newArr[i][j]));
            }
//            System.out.println();
            retArr[i]=temp;
//            System.out.println(temp);
            temp="";
        }

        return retArr;

    }

    static boolean isCavity(int[][]array, int i, int j){
        if(j==0 || j==array.length-1 || i==0 || i ==array.length-1){
            return false;
        }
        int max=Integer.MIN_VALUE;
        boolean skip=true;
        for(int k= i-1; k <= i+1; k++){
            for(int m = j-1; m <= j+1; m++){
                if(skip){
                    skip=!skip;
                    continue;
                }
                if((k>=0 && k< array.length) && (m >= 0 && m<array.length) ){
                    max=Math.max(array[k][m],max);
                    skip=!skip;

                }

            }
        }

        if(array[i][j] > max){
            return true;
        }

        return false;
    }


}

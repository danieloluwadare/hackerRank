package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myNum = {10, 20, 30, 40};
        int [] reversedArray = new int [myNum.length];

//        System.out.println(myNum[2]);
        for(int i = myNum.length-1, j=0; i>=0; i--, j++){
            reversedArray[j]=myNum[i];
            System.out.print(myNum[i]+" ");
        }

        System.out.println("---------------");

        for (int i: reversedArray) {
            System.out.print(i+" ");
        }

        System.out.println(reversedArray);

    }
}

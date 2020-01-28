package com.company.firecode;

public class PowerOf2 {

    public static void main(String[] args) {
        System.out.println(isPowOfTwo(2));
        System.out.println(isPowOfTwo(4));
        System.out.println(isPowOfTwo(10));

    }

    public static boolean isPowOfTwo(int num) {
        // if(num==1) return true
        int prevNumber = num-1;
        if((num & prevNumber) == 0) {
            return true;
        }else{
            return false;
        }


    }
}

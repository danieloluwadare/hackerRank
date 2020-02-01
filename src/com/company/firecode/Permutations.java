package com.company.firecode;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(permutation("cat","tac"));
        System.out.println(permutation("rat","tac"));
    }

    public static boolean permutation(String str1, String str2) {

        int str1length = str1.length();
        int str2Length = str2.length();
        if(str1length!=str2Length) return false;
        int [] hash = new int [256];
        for(int i = 0; i<str1length; i++){
            int numericValue = str1.charAt(i);
            hash[numericValue]++;
        }

        for(int i = 0; i < str2Length; i++){
            int numericValue = str2.charAt(i);
            hash[numericValue]--;
            if(hash[numericValue] < 0){
                return false;
            }
        }

        return true;
    }
}

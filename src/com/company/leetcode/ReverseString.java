package com.company.leetcode;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String test = "  the   sky is blue  ";
//        System.out.println(reverseWords(test));

        System.out.println(rw(test));

    }

    public static String reverseWords(String s) {

        String [] splitedString = s.split(" ");
        System.out.println(Arrays.toString(splitedString));
        int splitedStringLength = splitedString.length;
        String reverseWord="";
        for(int i = splitedStringLength - 1; i>=0; i--){
            if (splitedString[i].equals("")) {
                continue;
            }

            reverseWord = String.join(" ",reverseWord,splitedString[i]);

        }

        return reverseWord.trim();

    }

    public static String rw (String s){
        StringBuilder sb = new StringBuilder();
        //Split the string based on space and convert to array
        String[] split = s.split("\\s+");
        for(String str: split){
            sb.insert(0," ");
            sb.insert(0,str);
        }
        //remove trailling space
        return sb.toString().trim();
    }

//    public static String performWordReversal(String s){
//        int stringLength = s.length();
//        String reversedString="";
//        for(int i = stringLength-1; i>=0; i--){
//            reversedString =  reversedString.concat(Character.toString(s.charAt(i)));
//        }
//
//        return reversedString;
//    }
}

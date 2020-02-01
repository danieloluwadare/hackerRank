package com.company.firecode;

public class ReverseAString {
    public static void main(String[] args) {
        System.out.println(reverseString("abbcd"));
    }

    public static String reverseString(String str){
        if(str==null || str.equals("")){
            return str;
        }

        String inputString = str;
        String outputString = null;
        StringBuilder sb = new StringBuilder();
        for(int i = inputString.length()-1; i>=0; i--){
            sb.append(inputString.charAt(i));
            // outputString=outputString.concat(Character.toString(inputString.charAt(i)));
        }

        outputString=sb.toString();

        return outputString;
    }
}

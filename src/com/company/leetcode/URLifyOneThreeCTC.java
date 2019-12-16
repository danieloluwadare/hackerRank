package com.company.leetcode;

public class URLifyOneThreeCTC {
    public static void main(String[] args) {
        String test = "Mr John Smith ";
        System.out.println(replaceSpace(test));

    }

    public static String replaceSpace(String input){
        input=input.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0; i<input.length(); i++){
            if(input.charAt(i) == ' '){
                stringBuilder.append("%20");
                continue;
            }
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }

}

package com.company.leetcode;

public class UTF8Validation393 {
    public static void main(String[] args) {
        System.out.println(validUtf8("110001011000001000000001"));
        System.out.println(validUtf8("111010111000110000000100"));
    }

    private static boolean validUtf8(String input) {
        if(input.length() % 8 != 0){
            return false;
        }

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != '0'  && input.charAt(i) !=  '1'){
                return  false;
            }
        }

        int i = 0;
        while (i < input.length()){
            if(isOneByteEnconded(i, input)){
                i+=8;
            }
            else if(isTwoByteEnconded(i, input)){
                i+=16;
            }
            else if(isThreeByteEnconded(i, input)){
                i+=24;
            }
            else if(isFourByteEnconded(i, input)){
                i+=32;
            }
            else {
                return false;
            }

        }

        return true;

    }

    private static boolean isOneByteEnconded(int i, String input){
        return  input.length() - i >= 8  && input.charAt(i)=='0';
    }

    private static boolean isTwoByteEnconded(int i, String input){
        return  input.length() - i >= 16  && input.substring(i, i + 3).equals("110")
                && input.substring(i + 8, i + 10).equals("10");
    }

    private static boolean isThreeByteEnconded(int i, String input){
        return  input.length() - i >= 24  && input.substring(i, i + 4).equals("1110")
                && input.substring(i + 8, i + 10).equals("10")
                && input.substring(i + 16, i + 18).equals("10");
    }

    private static boolean isFourByteEnconded(int i, String input){
        return  input.length() - i >= 32  && input.substring(i, i + 5).equals("11110")
                && input.substring(i + 8, i + 10).equals("10")
                && input.substring(i + 16, i + 18).equals("10")
                && input.substring(i + 24, i + 26).equals("10");
    }


}

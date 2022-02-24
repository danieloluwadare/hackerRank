package com.company.leetcode;

public class Lc393UTF8Validation {

    public static void main(String[] args) {
//        System.out.println(validUtf8(new int[]{197, 130, 1}));
//        System.out.println(validUtf8(new int[]{235, 140, 4}));
//        System.out.println(validUtf8(new int[]{237}));
        System.out.println(validUtf8(new int[]{240,162,138,147,145}));
//        System.out.println(validUtf8(new int[]{240,162,138,147,17}));

//        System.out.println("abc".substring(3).length());
    }

    public static boolean validUtf8(int[] data) {
        StringBuilder sb = new StringBuilder();
        for(int i : data){
            String x = String.format("%0"+ 8 +"d",Integer.parseInt(Integer.toBinaryString(i)));
            sb.append(x);
            System.out.println(x);
        }

        if(sb.length() % 8 != 0)
            return false;

        boolean isUtfValid = true;
        while(sb.length() > 0 && isUtfValid){

            if( sb.charAt(0)=='0') {
                isUtfValid = true;
                sb = new StringBuilder(sb.substring(8));

            }


            else if(sb.substring(0,3).equalsIgnoreCase("110") && sb.length() >=10){
                isUtfValid = (sb.substring(8,10).equalsIgnoreCase("10"));
                sb = new StringBuilder(sb.substring(16));

            }

            else if(sb.substring(0,4).equalsIgnoreCase("1110") && sb.length() >=18){
                isUtfValid = (sb.substring(8,10).equalsIgnoreCase("10")
                        && sb.substring(16,18).equalsIgnoreCase("10"));
                sb = new StringBuilder(sb.substring(24));

            }


            else if(sb.substring(0,5).equalsIgnoreCase("11110") && sb.length() >=26){
                isUtfValid = (sb.substring(8,10).equalsIgnoreCase("10")
                        && sb.substring(16,18).equalsIgnoreCase("10")
                        && sb.substring(24,26).equalsIgnoreCase("10"));
                sb = new StringBuilder(sb.substring(32));

            }

            else
                isUtfValid=false;

        }

        return isUtfValid;

    }
}

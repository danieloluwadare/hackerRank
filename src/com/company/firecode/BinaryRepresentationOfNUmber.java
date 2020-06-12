package com.company.firecode;

public class BinaryRepresentationOfNUmber {

    public static void main(String[] args) {
        System.out.println(computeBinary(5));
    }

    public static String computeBinary(int val) {
        if(val==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(val != 0){
            int remainder = val % 2;
            val = val / 2;
            sb.insert(0, remainder);
        }

        return sb.toString();

    }
}

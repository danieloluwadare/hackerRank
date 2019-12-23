package com.company.CrackTheCode;

//CTC=Cracking the code
public class StringIsUniqueOneOneCTC {
    public static void main(String[] args) {
//        Using standard ascii = 128
//        using extended ascii = 256

        String testCase1= "hello";
        String testCase2="back";
        System.out.println(String.format("is %s unique ? %b", testCase1, isStringUnique(testCase1)));
        System.out.println(String.format("is %s unique ? %b", testCase2, isStringUnique(testCase2)));

    }

    public static boolean isStringUnique(String input){
//        using standard ascii = 128
        int stringLength = input.length();
        if(stringLength > 128){
            return false;
        }

        boolean [] ascii = new boolean[128];


        for(int i = 0; i<stringLength; i++){
            int character = input.charAt(i);
            if(ascii[character]){
                return false;
            }

            ascii[character]=true;

        }

        return true;
    }
}

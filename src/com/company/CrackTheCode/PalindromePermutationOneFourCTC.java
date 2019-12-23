package com.company.CrackTheCode;

public class PalindromePermutationOneFourCTC {

    public static void main(String[] args) {
        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('z'));
        System.out.println(Character.getNumericValue('z') - Character.getNumericValue('a') + 1);
        String string="Tactb Coa";
        System.out.println(String.format("is %s a permutationOfAPalindrome == %b",string, checkPalindromePermutation(string)));
        System.out.println(String.format("is %s a permutationOfAPalindrome2 == %b",string, checkPalindromePermutation2(string)));

    }
    public static boolean checkPalindromePermutation (String input){

        int asciiLength = Character.getNumericValue('z') - Character.getNumericValue('a') + 1;

        int [] ascii = new int [asciiLength];

        for(int i = 0; i < input.length(); i++){
            int character = getCharNumericValue(input.charAt(i)) ;
            if(character != -1){
                ascii[character]++;
            }
        }


        boolean checkIfFalseExist=false;

        for(int i = 0; i < ascii.length; i++){
            if(ascii[i] % 2 != 0){
                if(checkIfFalseExist){
                    return false;
                }

                checkIfFalseExist=true;
            }
        }



        return true;
    }

    public static boolean checkPalindromePermutation2 (String input){
        int countOdd = 0;
        int asciiLength = Character.getNumericValue('z') - Character.getNumericValue('a') + 1;

        int [] ascii = new int [asciiLength];

        for(int i = 0; i < input.length(); i++){
            int character = getCharNumericValue(input.charAt(i)) ;
            if(character != -1){
                ascii[character]++;
                if(ascii[character] % 2 == 1){
                    countOdd++;

                }else{
                    countOdd--;
                }
            }
        }

        boolean bool = countOdd <= 1;

        return bool;
    }

    public static int getCharNumericValue(char currentCharacter){
        int upperBound = Character.getNumericValue('z');
        int lowerBound = Character.getNumericValue('a');
        int initialValue = Character.getNumericValue(currentCharacter);
        int numericCharValue=-1;

        if(initialValue >= lowerBound && initialValue <= upperBound){
            numericCharValue = initialValue - lowerBound;
        }

        return numericCharValue;
    }
}

package com.company.airtel;

public class AirtelTest {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("google"));
    }

    public static char firstNonRepeatingCharacter(String input){
        int [] hash = new int[26];
        for(int i =0; i < input.length(); i++){
            hash[input.charAt(i)-'a']++;
        }
        for(int i =0; i < input.length(); i++){
            if(hash[input.charAt(i)-'a'] == 1){
                return input.charAt(i);
            }
        }

        return ' ';
    }
}

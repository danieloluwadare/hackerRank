package com.company.firecode;

public class UniqueCharsInAString {

    public static void main(String[] args) {
        System.out.println(areAllCharactersUnique("abcda"));
        System.out.println(areAllCharactersUnique("abcdfg"));

    }

    public static boolean areAllCharactersUnique(String str){
        if(str==null || str.length()==0) return true;

        boolean [] hash = new boolean[128];
        for(int i = 0; i<str.length(); i++){
            int numricValue = str.charAt(i);
            if(hash[numricValue]){
                return false;
            }

            hash[numricValue]=true;
        }

        return true;


    }
}

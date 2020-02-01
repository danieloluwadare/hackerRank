package com.company.firecode;

/**
 *
 *
 * 1. If the input is null, an empty String or a single Character, return the input itself.

 2. Check the first and the second characters.
 If they are the same, insert a star "*" in between the first and recursively obtained String with the Substring
 starting from second character. i.e. return s.substring(0,1) + "*" + insertPairStar(s.substring(1,s.length()));

 3. Else, return the first character + the recursive call of the Substring from the second character.
 i.e. return s.substring(0,1) + insertPairStar(s.substring(1,s.length()));




 */
public class InsertStars {

    public static void main(String[] args) {
        System.out.println(insertPairStar("abba"));
    }

    public static String insertPairStar(String s) {
        if(s==null || s.equals("") || s.length()==1){
            return s;
        }
        else if(s.charAt(0) == s.charAt(1)){
            return s.substring(0,1) + "*" + insertPairStar(s.substring(1, s.length()));
        }else {
            return s.substring(0,1)  + insertPairStar(s.substring(1, s.length()));
        }

    }
}

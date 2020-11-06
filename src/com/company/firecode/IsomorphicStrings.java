package com.company.firecode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
//        System.out.println(isIsomorphic("abcd","aabb"));
//        System.out.println(isIsomorphic("add","egg"));

//        System.out.println(isIsomorphic2("abcd","aabb"));
//        System.out.println(isIsomorphic2("add","egg"));
        System.out.println(isIsomorphic2("aba","baa"));


    }


    public static boolean isIsomorphic(String input1, String input2) {
        if(input1.length() !=  input2.length()){
            return false;
        }

        if(
                (input1==null && input2== null) || (input1.length()==1 && input2.length()==1)
                ){
            return true;
        }
        return compareString(input1, input2) && compareString(input2, input1);


    }

    public static boolean compareString(String input1, String input2){
        Map<Character,Character> hash = new HashMap<>();
        int inputOnelength = input1.length();
        for(int i = 0; i<inputOnelength; i++){
            if(hash.containsKey(input1.charAt(i))){
                char intitalValue = hash.get(input1.charAt(i));
                if(intitalValue != input2.charAt(i)){
                    return false;
                }
            }
            else{
                hash.put(input1.charAt(i),input2.charAt(i));
            }
        }

        return true;
    }

//    The most efficient way

    public static boolean isIsomorphic2(String input1, String input2) {
        if(input1.length() != input2.length()) return false;
        else {
            HashMap<Character, Integer> hm1 = new HashMap<>();
            HashMap<Character, Integer> hm2 = new HashMap<>();
            for(int i=0; i < input1.length(); i++){
                Character c1 = input1.charAt(i);
                Integer val1 = hm1.get(c1) == null ? 1 : hm1.get(c1) + 1;
                hm1.put(c1,val1);

                Character c2 = input2.charAt(i);
                Integer val2 = hm2.get(c2) == null ? 1 : hm2.get(c2) + 1;
                hm2.put(c2,val2);

                if(!hm1.get(c1).equals(hm2.get(c2))) return false;
            }
            return true;
        }
    }

}

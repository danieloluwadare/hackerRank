package com.company.CrackTheCode;

import java.util.*;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
//        System.out.println(firstUniqueString("RACECAR"));
//        System.out.println(firstNonRepeatedCharacter("RACECAR"));

        System.out.println(1&0);

    }

    public static String firstUniqueString(String string){
        Map<Character,Integer> map = new TreeMap<>();
//        map.keySet()
//        map.getOrDefault();

        TreeSet<Integer> set = new TreeSet<>();
//        set.comparator();

        for(int i = 0; i<string.length(); i++){
            if(map.containsKey(string.charAt(i))){
                int count =map.get(string.charAt(i));
                count++;
                map.replace(string.charAt(i), count);
            }

            map.put(string.charAt(i), 1);
        }



        for(Character character : map.keySet()){
            if(map.get(character)==1){
                return String.valueOf(character);
            }
        }
        return  null;
    }

    public static Character firstNonRepeatedCharacter(String str) {

        int [] hashmap = new int [128];
        Map<Integer, Character> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            int numericCharacter = str.charAt(i);
            hashmap[numericCharacter]++;
            map.put(numericCharacter, str.charAt(i));
        }

        for(int i = 0; i<hashmap.length; i++){
            if(hashmap[i] ==1 ){
                return map.get(hashmap[i]);
            }
        }


        return null;


    }


}

package com.company.CrackTheCode;

import java.util.Map;
import java.util.TreeMap;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(firstUniqueString("RACECAR"));


    }

    public static String firstUniqueString(String string){
        Map<Character,Integer> map = new TreeMap<>();
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


}

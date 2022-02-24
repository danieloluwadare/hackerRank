package com.company.revision;

import java.util.*;

public class Rev771JewelsAndStones {

    public static void main(String[] args) {
//        System.out.println("a".contains("A"));
//        Set<Character> set = new HashSet<>();
//        set.add('a');
//        set.add('A');
//        System.out.println(set);

        numJewelsInStones("aA","aAAbbbb");
        numJewelsInStones("z","ZZ");

    }
    public static int numJewelsInStones(String J, String S) {
        if(J==null || S==null || J.length()==0 || S.length()==0)
            return 0;
        Set<Character>set= new HashSet<>();
        for(char c : J.toCharArray())
            set.add(c);
        int count=0;
        for(char s : S.toCharArray()){
            if(set.contains(s))
                count ++;
        }
        System.out.println(count);
        return count;
    }
}

package com.company.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Lc771JewelsAndStones {
    public static void main(String[] args) {
        System.out.println("a".contains("A"));
//        Set<Character> set = new HashSet<>();
//        set.add('a');
//        set.add('A');
//        System.out.println(set);

        numJewelsInStones("aA","aAAbbbb");
        numJewelsInStones("z","ZZ");

    }
    public static int numJewelsInStones(String J, String S) {
        if(S==null || S.length()==0 || J==null || J.length()==0 ){
            return -1;
        }

        int count = 0;

        Set<Character> set = new HashSet<>();
        char [] j = J.toCharArray();
        char [] s = S.toCharArray();

        for(Character i : j)
            set.add(i);
        for(Character i : s){
            if(set.contains(i))
                count++;
        }

        System.out.println(count);

        return count;
    }
}

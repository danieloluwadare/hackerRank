package com.company.firecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FindTheNumberThatAppearsOnce {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int []{1,2,3,4,1,2,4,3,5}));
        Stack<Integer> stack = new Stack<>();
        new ArrayList<>();
    }

    public static int singleNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< A.length; i++){
            if(map.containsKey(A[i])){
                int count = map.get(A[i]);
                count++;
                map.replace(A[i], count);
            }
            else{
                map.put(A[i],1);
            }
        }

        for(int i : map.keySet()){
            if(map.get(i)==1) return i ;
        }

        return 0;
    }
}

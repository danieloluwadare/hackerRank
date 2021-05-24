package com.company.leetcode2;

import java.util.*;

public class Lc946ValidateStackSequences {

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
        System.out.println(validateStackSequences(new int[] {1,2,3,5},new int[]{4,3,5,1,2}));
//        String [] arr = "baseball".split("ball");
//        System.out.println(Arrays.deepToString(arr));
//        Character.toUpperCase()
        System.out.println(ArrayChallenge(new String[] {"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"}));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || popped == null ||pushed.length != popped.length)
            return false;

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }


        return pushed.length  == j;
    }

    public static String ArrayChallenge(String[] strArr) {

        System.out.println(strArr[0]);
        System.out.println(strArr[1]);

        String original = strArr[0];
        String [] secondArr = strArr[1].split(",");
        Map<String, Set<String>> map = new HashMap<>();
        Map<String,String> retMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < secondArr.length; i++){

            if(map.containsKey(secondArr[i])){
                for(String s : map.get(secondArr[i])){
                    int length = secondArr[i].length();
                    int secLen = s.length();
                    if(length + secLen == original.length()){
                        sb.append(secondArr[i]);
                        retMap.put(secondArr[i], s);
                        break;
                    }
                }
            }
            else{
                String [] splitString = original.split(secondArr[i]);
                if(splitString.length != 0){
                    for(String ss : splitString){
                        if(ss.length() == 0)
                            continue;

                        if(!map.containsKey(ss)){
                            map.put(ss, new HashSet<>());
                        }
                        map.get(ss).add(secondArr[i]);
                    }



                }
            }

        }

        System.out.println("sb=="+sb);

        boolean checkIfFirst = true;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != original.charAt(i) ){
                checkIfFirst=false;
                break;
            }
        }

        StringBuilder sbb = new StringBuilder();
        if(checkIfFirst){
            sbb.append(sb);
            sbb.append(",");
            sbb.append(retMap.get(sb.toString()));
        }else{
            sbb.append(retMap.get(sb.toString()));
            sbb.append(",");
            sbb.append(sb);
        }

        System.out.println("returning");
        System.out.println(sbb.toString());

        return sbb.toString();

        // code goes here
        // return strArr[0];
    }
}

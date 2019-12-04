package com.company.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String input = "{[()]}";
        String input2 ="{[(])}";
        String input3 ="{{[[(())]]}}";
        System.out.println(isBalanced(input));
    }

    public static String isBalanced(String s) {
        int length = s.length();
//        if length of string  is odd
        if(length%2 != 0){
            return "NO";
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        Map<Character, Boolean> keyValuePair = new HashMap<>();
        keyValuePair.put('{', true);
        keyValuePair.put('[', true);
        keyValuePair.put('(', true);
        keyValuePair.put('}', false);
        keyValuePair.put(']', false);
        keyValuePair.put(')', false);



        String result = "YES";
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<length; i++){
            char currentString = s.charAt(i);
            if(keyValuePair.get(s.charAt(i))){
                stack.push(currentString);
            }
            else{
                Character inverseOfStringAtTopOfStack = map.get(stack.pop());
                if(currentString != inverseOfStringAtTopOfStack){
                    result="NO";
                    return result;
//                    break;
                }
            }
        }

        return result;

    }
}

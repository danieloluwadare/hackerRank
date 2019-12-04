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

        Map<String, String> map = new HashMap<>();
        map.put("{", "}");
        map.put("[", "]");
        map.put("(", ")");

        Map<String, Boolean> keyValuePair = new HashMap<>();
        keyValuePair.put("{", true);
        keyValuePair.put("[", true);
        keyValuePair.put("(", true);
        keyValuePair.put("}", false);
        keyValuePair.put("]", false);
        keyValuePair.put(")", false);



        String result = "YES";
        Stack<String> stack = new Stack<>();

        for (int i=0; i<length; i++){
            String currentString = Character.toString(s.charAt(i));
            if(keyValuePair.get(Character.toString(s.charAt(i)))){
                stack.push(currentString);
            }
            else{
                String inverseOfStringAtTopOfStack = map.get(stack.pop());
                if(!currentString.equalsIgnoreCase(inverseOfStringAtTopOfStack)){
                    result="NO";
                    return result;
//                    break;
                }
            }
        }

        return result;

    }
}

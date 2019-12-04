package com.company.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String input = "{[()]}";
        String input2 ="{[(])}";
        String input3 ="{{[[(())]]}}";
        System.out.println(isBalanced(input2));
    }

    public static String isBalanced(String s) {
        int length = s.length();
//        if length of string  is odd
        if(length%2 != 0){
            return "NO";
        }


        Stack<Character> stack = new Stack<>();

        for (int i=0; i<length; i++){
            char currentString = s.charAt(i);
            if(currentString == '{' || currentString == '[' || currentString == '('){
                stack.push(currentString);
            }
            else{
                if(stack.empty()){
                    return "NO";
                }else {
                    char poppedChar = stack.pop();
                    if(currentString=='}' && poppedChar!='{'){
                        return "NO";
                    }
                    else if(currentString==']' && poppedChar!='['){
                        return "NO";
                    }
                    else if(currentString==')' && poppedChar!='('){
                        return "NO";
                    }
                }

            }
        }
        if(stack.empty()){
            return "YES";
        }else {
            return "NO";
        }


    }
}

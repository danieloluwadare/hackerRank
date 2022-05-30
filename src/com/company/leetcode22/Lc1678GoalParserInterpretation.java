package com.company.leetcode22;

import java.util.Stack;

/**
 * You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
 * The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al".
 * The interpreted strings are then concatenated in the original order.
 *
 * Given the string command, return the Goal Parser's interpretation of command.
 *
 *
 *
 * Example 1:
 *
 * Input: command = "G()(al)"
 * Output: "Goal"
 * Explanation: The Goal Parser interprets the command as follows:
 * G -> G
 * () -> o
 * (al) -> al
 * The final concatenated result is "Goal".
 * Example 2:
 *
 * Input: command = "G()()()()(al)"
 * Output: "Gooooal"
 * Example 3:
 *
 * Input: command = "(al)G(al)()()G"
 * Output: "alGalooG"
 *
 *
 * Constraints:
 *
 * 1 <= command.length <= 100
 * command consists of "G", "()", and/or "(al)" in some order.
 */
public class Lc1678GoalParserInterpretation {
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
        System.out.println(interpret("G()()()()(al)"));
        System.out.println(interpret("(al)G(al)()()G"));

    }
    public static String interpret(String command) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < command.length(); i++){
            char ch = command.charAt(i);
            if(ch == ')' && result.charAt(result.length()-1)=='('){
                result.deleteCharAt(result.length()-1);
                result.append('o');
                continue;
            }
            if(ch == 'a')
                result.deleteCharAt(result.length()-1);
            if(ch == ')')
                continue;
            result.append(ch);
        }
        return result.toString();
    }
}

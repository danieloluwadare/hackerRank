package com.company.leetcode2;

/**
150. Evaluate Reverse Polish Notation
Medium

1515

519

Add to List

Share
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.



Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200]
 */
import java.util.Stack;

public class Lc150EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));

//        String [] arr = {"2","1","+","3","*"};
//        System.out.println(arr[0].charAt(0));

        System.out.println(Integer.parseInt("-33") + 3);
    }
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String token : tokens){
            if(token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-") || token.equalsIgnoreCase("*")
            || token.equalsIgnoreCase("/")){
                String operator = token;
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                int result = evaluate(operand1,operand2,operator);
                stack.push(String.valueOf(result));
            }else{
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public static int evaluate(String operand1, String operand2, String operator){
        int intOperand1 = Integer.parseInt(operand1);
        int intOperand2 = Integer.parseInt(operand2);

        if(operator.equalsIgnoreCase("+"))
            return intOperand1 + intOperand2;
        else if(operator.equalsIgnoreCase("-"))
            return intOperand1 - intOperand2;
        else if(operator.equalsIgnoreCase("*"))
            return intOperand1 * intOperand2;

        else
            return intOperand1 / intOperand2;

    }
}

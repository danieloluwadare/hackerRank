package com.company.firecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateCombinationsOfParentheses {

    // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

    public static void main(String[] args) {
        System.out.println(combParenthesis(3).toString());
    }

    public static ArrayList<String> combParenthesis(int pairs) {
        ArrayList<String> result = new ArrayList<>();

        if(pairs<=0){
            return result;
        }
        Queue<ParanthesisCombo> queue = new LinkedList<>();
        ParanthesisCombo parenthesisCombo = new ParanthesisCombo("(", 1, 0);
        queue.add(parenthesisCombo);
        while(!queue.isEmpty()){
            ParanthesisCombo parenthesis = queue.remove();
            int total = parenthesis.noLeftParanthesis + parenthesis.noRightParanthesis;
            if(total < (pairs * 2)){
                // addLeftParenthesis
                addLeftParenthesis(parenthesis,queue,pairs);
                // addRightParenthesis
                addRightParenthesis(parenthesis,queue);
            }else{
                result.add(parenthesis.paranthesis);
            }

        }

        return result;


    }

    public static void addLeftParenthesis(ParanthesisCombo p, Queue<ParanthesisCombo>queue, int pairs){
        String newParenthesis = p.paranthesis.concat("(");
        int newNoLeftParanthesis = p.noLeftParanthesis + 1;
        int noRightParanthesis = p.noRightParanthesis;

        if(newNoLeftParanthesis > pairs  ){
            return;
        }else{
            queue.add(new ParanthesisCombo(newParenthesis,newNoLeftParanthesis,noRightParanthesis));
        }
    }

    public static void addRightParenthesis(ParanthesisCombo p, Queue<ParanthesisCombo>queue){
        String newParenthesis = p.paranthesis.concat(")");
        int noLeftParanthesis = p.noLeftParanthesis;
        int newNoRightParanthesis = p.noRightParanthesis + 1;

        if(newNoRightParanthesis > noLeftParanthesis){
            return;
        }else{
            queue.add(new ParanthesisCombo(newParenthesis,noLeftParanthesis,newNoRightParanthesis));
        }
    }

    public static ArrayList<String> combParenthesis2(int pairs) {
        ArrayList<String> res = new ArrayList<String>();
        if (pairs > 0) {
            combParenthesis(pairs,pairs,"",res);
        }
        return res;
    }

    public static void combParenthesis(int left, int right, String tmp, ArrayList<String> res) {
        if (left == 0 && right == 0) {
            res.add(tmp);
        }
        else {
            if (left > 0) {
                combParenthesis(left-1,right,tmp+"(", res);
            }
            if (right > left) {
                combParenthesis(left,right-1,tmp+")", res);
            }
        }
        return;
    }


    static class ParanthesisCombo{
        String paranthesis;
        int noLeftParanthesis;
        int noRightParanthesis;

        ParanthesisCombo(String paranthesis, int noLeftParanthesis, int noRightParanthesis){
            this.paranthesis=paranthesis;
            this.noLeftParanthesis = noLeftParanthesis;
            this.noRightParanthesis = noRightParanthesis;
        }
    }
}

package com.company.leetcode;

public class Lc415AddStrings {
    public static void main(String[] args) {
        System.out.println('3'-'0');
        addStrings("131", "141");
        addStrings("1000937", "1");
        addStrings("500", "499");
    }


    public static String addStrings(String num1, String num2) {
        if(num1==null || num2 == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int num1Length = num1.length()-1;
        int num2Length = num2.length()-1;
        int carry = 0;

        while (num1Length>=0 && num2Length>=0){
            int firstNum = num1.charAt(num1Length) - '0';
            int secondNum = num2.charAt(num2Length) - '0';

            int sum = firstNum + secondNum + carry;

            sb.insert(0,sum % 10);
            carry = sum > 9 ? 1 : 0 ;

            num1Length--;
            num2Length--;
        }

        while (num1Length >= 0){
            int firstNum = num1.charAt(num1Length) - '0';
            int sum = firstNum + carry;
            sb.insert(0,sum % 10);
            carry = sum > 9 ? 1 : 0 ;

            num1Length--;

        }

        while (num2Length >= 0){
            int secondNum = num2.charAt(num2Length) - '0';
            int sum = secondNum + carry;
            sb.insert(0,sum % 10);
            carry = sum > 9 ? 1 : 0 ;

            num2Length--;

        }

        if(carry == 1 )
             sb.insert(0, carry);

        System.out.println(sb.toString());

        return sb.toString();

    }




}

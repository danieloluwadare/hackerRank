package com.company.revision;

public class RevLc415AddStrings {
    public static void main(String[] args) {

        int x = '3' - '0';
        int y = '4' - '0';
        System.out.println(x+y);
        addStrings("131", "141");
        addStrings("1000937", "1");
        addStrings("500", "499");
        addStrings("131", "149");
        addStrings("500", "599");


    }

    public static String addStrings(String num1, String num2) {
        if(num1.length() == 0 && num2.length() ==0)
            return "";
        if(num1.length() == 0 && num2.length() > 0)
            return num2;
        if(num1.length() > 0 && num2.length() == 0)
            return num1;

        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.max(len1,len2);
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = 1; i <= len; i++){
            int firstNumber = 0;
            int secondNumber = 0;

            if(i <= len1 )
                firstNumber= num1.charAt(len1 -i) - '0';
            if(i <= len2)
                secondNumber = num2.charAt(len2 -i ) - '0';
            int sum = firstNumber + secondNumber+ carry;
            carry = sum / 10;
            int remainder = sum % 10;
            sb.insert(0,remainder);
        }
        if(carry==1)
            sb.insert(0,1);
        System.out.println(sb.toString());
        return sb.toString();

    }

}
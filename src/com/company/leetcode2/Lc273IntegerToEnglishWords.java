package com.company.leetcode2;

/**
 * 273. Integer to English Words
 * Hard
 *
 * Convert a non-negative integer num to its English words representation.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 *
 * Example 2:
 *
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 *
 * Example 3:
 *
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * Example 4:
 *
 * Input: num = 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 *
 *
 * Constraints:
 *
 *     0 <= num <= 231 - 1
 */

import java.util.ArrayList;
import java.util.List;
public class Lc273IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(1234567891));
        System.out.println(numberToWords(1000));

    }
    public static String numberToWords(int num) {
        System.out.println(num);
        if(num <= 0)
            return "";

        List<String> list = getNumbersAsList(num);
//        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for(int i = list.size() - 1; i >=0; i--){
            String number = numberToWordsThree(list.get(i));
            if(!number.isEmpty()){
                sb.append(number);
                sb.append(" ");
                sb.append(getNumberChunk(i+1));
                sb.append(" ");
            }


        }
        return sb.toString().trim();
    }
    private static String numberToWordsThree(String num) {
        int number = Integer.parseInt(num);
        if(number == 0)
            return "";
        int hundred = number / 100;
        int tensOrUnit = number - (hundred * 100);

        StringBuilder sb = new StringBuilder();
        if(hundred != 0 && tensOrUnit != 0)
            return sb.append(getUnits(hundred)).append(" ").append("Hundred").append(" ").append(numberToWordsTWo(tensOrUnit)).toString().trim();
        else if(hundred == 0 && tensOrUnit != 0)
            return sb.append(numberToWordsTWo(tensOrUnit)).toString().trim();
        else
            return sb.append(getUnits(hundred)).append(" ").append("Hundred").toString().trim();
    }

    private static String numberToWordsTWo(int num) {

        StringBuilder sb = new StringBuilder();
        if(num > 19){
            int tens = num / 10;
            int unit = num - (tens * 10);
            return sb.append(getTensGreaterThan19(tens)).append(" ").append(getUnits(unit)).toString().trim();
        }
        else if(num > 9)
            return sb.append(getTensLessThan20(num)).toString().trim();
        else
            return sb.append(getUnits(num)).toString().trim();
    }
    private static String getNumberChunk(int num){
        switch(num) {
            case 2: return "thousand";
            case 3: return "million";
            case 4: return "billion";
        }
        return "";
    }
    private static String getUnits(int num){
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }
    private static String getTensLessThan20(int num){
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }
    private static String getTensGreaterThan19(int num){
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }
    private static List<String> getNumbersAsList(int num) {
        String numToString = String.valueOf(num);
        List<String> list = new ArrayList<>();
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = numToString.length() -1; i >= 0; i--){
            if(j==3){
                list.add(sb.toString());
                j=0;
                sb = new StringBuilder();
            }
            sb.insert(0,numToString.charAt(i));
            j++;
        }
        list.add(sb.toString());
        return list;
    }

//    Twelve thousand Three Hundred Forty Five
//    Twelve thousand Three Hundred Forty Five



}

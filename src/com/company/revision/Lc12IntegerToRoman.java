package com.company.revision;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 3
 * Output: "III"
 * Example 2:
 *
 * Input: num = 4
 * Output: "IV"
 * Example 3:
 *
 * Input: num = 9
 * Output: "IX"
 * Example 4:
 *
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= num <= 3999
 */
public class Lc12IntegerToRoman {

    private static Map<Integer, Character> map ;
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(1));
        System.out.println(intToRoman(3999));

    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length && num > 0; i++){
            while (values[i] <= num){
                num = num - values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }

    public static String intToRomanInefficientMethod(int num) {
//        1850/1000=1
        setMapOfIntegerToCharacter();
        int thousand  = num / 1000;
        int hundred = (num - (thousand *1000)) / 100;
        int tens = (num - (thousand * 1000) - (hundred * 100)) / 10 ;
        int unit = (num - (thousand * 1000) - (hundred * 100) - (tens * 10));

        StringBuilder sb = new StringBuilder();
        getThousand(thousand,sb);
        getHundred(hundred,sb);
        getTens(tens,sb);
        getUnit(unit,sb);

        return sb.toString();
    }

    public static void getThousand(int thousand, StringBuilder sb){
        if(thousand==0)return;
        int oneThousand = 1000;
        for(int i = 0; i < thousand;i++){
            sb.append(map.get(1000));
        }
    }

    public static void getHundred(int hundred, StringBuilder sb){
        if(hundred==0) return;
        int oneThousand = 1000;
        int oneHundred = 100;
        int fiveHundred = 500;
        hundred = hundred * oneHundred;
        if(hundred > 400){
            if(hundred == 900){
                sb.append(map.get(oneHundred));
                sb.append(map.get(oneThousand));
            }else {
                int count = (hundred - 500)/oneHundred;
                sb.append(map.get(fiveHundred));
                for (int i = 0; i < count; i++)
                    sb.append(map.get(oneHundred));
            }
        }else {
            if(hundred == 400){
                sb.append(map.get(oneHundred));
                sb.append(map.get(fiveHundred));
            }else {
                int count = hundred /oneHundred;
                for (int i = 0; i < count; i++)
                    sb.append(map.get(oneHundred));
            }
        }
    }

    public static void getTens(int tens, StringBuilder sb){
//         X can be placed before L (50) and C (100) to make 40 and 90.
        if(tens==0) return;
        int oneHundred = 100;
        int ten = 10;
        int fifty = 50;
        tens = tens * ten;
        if(tens > 40){
            if(tens == 90){
                sb.append(map.get(ten));
                sb.append(map.get(oneHundred));
            }else {
                int count = (tens - fifty) / ten;
                sb.append(map.get(fifty));
                for (int i = 0; i < count; i++)
                    sb.append(map.get(ten));
            }
        }else {
            if(tens == 40){
                sb.append(map.get(ten));
                sb.append(map.get(fifty));
            }else {
                int count = tens /ten;
                for (int i = 0; i < count; i++)
                    sb.append(map.get(ten));
            }
        }
    }

    public static void getUnit(int unit, StringBuilder sb){
//         X can be placed before L (50) and C (100) to make 40 and 90.
        if(unit == 0) return;
        int ten = 10;
        int five = 5;
        int one = 1;
        if(unit > 4){
            if(unit == 9){
                sb.append(map.get(one));
                sb.append(map.get(ten));
            }else {
                int count = (unit - 5) ;
                sb.append(map.get(five));
                for (int i = 0; i < count; i++)
                    sb.append(map.get(one));
            }
        }else {
            if(unit == 4){
                sb.append(map.get(one));
                sb.append(map.get(five));
            }else {
                int count =  unit ;
                for (int i = 0; i < count; i++)
                    sb.append(map.get(one));
            }
        }
    }


    private static void setMapOfIntegerToCharacter() {
        map=new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
    }
}

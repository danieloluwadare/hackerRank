package com.company.Fairmoney;

public class BreakPalindrome {
    public static void main(String[] args) {
        System.out.println(breakingPalindrome("madam"));
        System.out.println(breakingPalindrome("aba"));

    }


    //second job, lexigeograp, IMPOSSIBLE
    // breaking a pallindrome
    //madam == aadam, badam
    //abmmba = abamba, aammba
    // aba = aaa pallindrome IMPOSSIBLE
    // aaa = IMPOSSIBLE
    public static String breakingPalindrome(String palindromeStr){
        char[] array = palindromeStr.toCharArray();
        char a = 'a';
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == a) {
                continue;
            }
            if (i == (int) (array.length / 2)){
                return "IMPOSSIBLE";
            }
            array[i] = a;
            return String.valueOf(array);
//            return array.join();
        }
        return "IMPOSSIBLE";
    }
}

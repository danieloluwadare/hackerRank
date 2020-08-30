package com.company.leetcode.bloomberg;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("adgdsaaa"));
    }

    public static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            sb.append(S.charAt(i));
            if( i != 0 && sb.length() > 1 && sb.charAt(sb.length()-1)==sb.charAt(sb.length()-2)){
                sb.delete(sb.length()-2, sb.length());
            }
        }

        return sb.toString();
    }
}

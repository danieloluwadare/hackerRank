package com.company.leetcode22;

public class Lc1108DeFangingAnIPAddress {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));

    }
    public static String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char ch  : address.toCharArray()){
            if(ch == '.'){
                stringBuilder.append('[');
                stringBuilder.append(ch);
                stringBuilder.append(']');
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}

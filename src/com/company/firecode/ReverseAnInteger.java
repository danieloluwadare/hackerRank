package com.company.firecode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ReverseAnInteger {

    public static void main(String[] args) {
        System.out.println(reverseInt(1234));
    }

    public static int reverseInt(int x) {
        int reversed = 0;
        while (x != 0){
            reversed=(reversed * 10) + (x%10);
            x= x/10;
        }

        return reversed;

    }
}

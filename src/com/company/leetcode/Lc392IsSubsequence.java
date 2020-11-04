package com.company.leetcode;

public class Lc392IsSubsequence {
    public static void main(String[] args) {
//        Input: s = "abc", t = "ahbgdc"
        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequence("vbc","ahbgdc"));
        System.out.println(isSubsequence("vbc",""));
        System.out.println(isSubsequence("","vbc"));
        System.out.println(isSubsequence("vbcc","vbc"));
        System.out.println(isSubsequence("",""));

    }

    public static boolean isSubsequence(String s, String t) {
        if(s!=null &&  t!=null && s.length()==0 && t.length()==0)
            return true;

        if (t==null || t.length()==0)
            return false;
        if (s==null || s.length()==0)
            return true;
        if (s.length() > t.length())
            return false;

        int i=0 ,j=0 ;

        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
//                increment the i counter since it found
                i++;
            }
//            keep incrementing j no matter what happens
            j++;
        }

        if(i != s.length()){
            return false;
        }

        return true;
    }
}

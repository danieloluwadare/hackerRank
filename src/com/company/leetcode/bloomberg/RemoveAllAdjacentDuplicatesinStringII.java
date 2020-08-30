package com.company.leetcode.bloomberg;

public class RemoveAllAdjacentDuplicatesinStringII {
    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder("abcd");
//        System.out.println(sb.substring(0,2));
//        System.out.println(sb.delete(0,2));

        String r0 = removeDuplicates("abcd", 2);
        String r1 = removeDuplicates("deeedbbcccbdaa",3);
        String r2 = removeDuplicates("pbbcggttciiippooaais",2);

        System.out.println(r0);
        System.out.println(r1);
        System.out.println(r2);

    }

    public static String removeDuplicates(String s, int k) {

        StringBuilder sb = new StringBuilder(s);

        int length = sb.length();
        int i = 1;

        char prevChar = s.charAt(0);
        int startIndex = 0;
        int endIndex = 0;
        int count = 1;


        while(i < length){
            char currentChar = sb.charAt(i);
            if(prevChar != currentChar){
                prevChar = currentChar;
                startIndex = i;
                endIndex = i;
                count = 1;
                i++;
                continue;
            }

            endIndex++;
            count++;

            if(count==k){
                //perform Delete operation
                sb.delete(startIndex, endIndex+1);

                // reset all stuff
                length=sb.length();
                i = 1;

                prevChar=sb.charAt(0);
                startIndex = 0;
                endIndex = 0;
                count = 1;

                continue;
            }

            i++;
        }

        return sb.toString();
    }

    public static String removeDuplicates2(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count[] = new int[sb.length()];
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();

    }
}

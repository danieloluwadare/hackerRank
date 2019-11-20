package com.company;

public class SparseArrayHrk {
    public static void main(String[] args) {
        String [] inputs = {"abcde","sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf","na", "basdn","sdaklfj", "asdjf"};
        String [] queries = {"abcde","sdaklfj", "asdjf", "na", "basdn", };
        int [] result = matchingStrings(inputs,queries);
    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        int frequency = 0;
        int [] matchingStrings=new int [queries.length];
        for (int i =0; i<queries.length; i++) {
            for(String input : strings){
                if(queries[i].equals(input)){
                    frequency++;
                }
            }

            System.out.println(String.format("Query string %s frequency count = %d",queries[i], frequency));

            matchingStrings[i]=frequency;
            frequency=0;
        }
//        return matchingStrings;

        System.out.println("-------------------------");

        for (int s: matchingStrings) {
            System.out.println(s);
        }

        return  matchingStrings;
    }
}

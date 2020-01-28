package com.company.leetcode;

import java.util.*;

public class KaratInterview {
    public static void main(String[] args) {
        // counts = [ "900,google.com",
//      "60,mail.yahoo.com",
//      "10,mobile.sports.yahoo.com",
//      "40,sports.yahoo.com",
//      "300,yahoo.com",
//      "10,stackoverflow.com",
//      "20,overflow.com",
//      "2,en.wikipedia.org",
//      "1,m.wikipedia.org",
//      "1,mobile.sports",
//      "1,google.co.uk"]

        List<String> list = new ArrayList<>();
        list.add("900,google.com");
        list.add("60,mail.yahoo.com");
        list.add("10,mobile.sports.yahoo.com");
        list.add("40,sports.yahoo.com");
        list.add("300,yahoo.com");
        list.add("10,stackoverflow.com");
        list.add("20,overflow.com");
        list.add("2,en.wikipedia.org");
        list.add("1,m.wikipedia.org");
        list.add("1,mobile.sports");
        list.add("1,google.co.uk");

        getCount(list);

    }

    public static Map<String, Integer> getCount(List<String>inputs){
        Map<String, Integer> map = new HashMap<>();
        for (String input : inputs) {
            String[] splitedString = input.split(",");
            int count = Integer.parseInt(splitedString[0]);

            String domain = splitedString[1];
            String[] subDomains = domain.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = subDomains.length - 1; i >= 0; i--) {
                sb.insert(0, subDomains[i]);
                sb.insert(0, ".");

                String subDomain = sb.toString().substring(1, sb.length());
//                subDomain =

                if (map.containsKey(subDomain)) {
                    int newCount = map.get(subDomain) + count;
                    map.replace(subDomain, newCount);
                } else {
                    map.put(subDomain, count);
                }


            }
        }

        for(String string : map.keySet()){
            System.out.println(String.format("%s -> %d", string,map.get(string)));
        }


        return null;
    }



}

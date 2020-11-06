package com.company.leetcode;
// You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input val that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:
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
// Write a function that takes this input as a parameter and returns a val structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)
// Sample output (in any order/format):
// calculateClicksByDomain(counts) =>
// com:                     1340
// google.com:              900
// stackoverflow.com:       10
// overflow.com:            20
// yahoo.com:               410
// mail.yahoo.com:          60
// mobile.sports.yahoo.com: 10
// sports.yahoo.com:        50
// org:                     3
// wikipedia.org:           3
// en.wikipedia.org:        2
// m.wikipedia.org:         1
// mobile.sports:           1
// sports:                  1
// uk:                      1
// co.uk:                   1
// google.co.uk:            1
// n: number of domains in the input
// (individual domains and subdomains have a constant upper length)

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

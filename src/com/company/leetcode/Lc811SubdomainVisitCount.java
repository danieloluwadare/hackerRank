package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc811SubdomainVisitCount {

    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains==null || cpdomains.length==0)
            return null;

        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String cpdomain : cpdomains){
            String [] splitCpDomain = cpdomain.split(" ");
            int domainCount = Integer.parseInt(splitCpDomain[0]);
            String [] splitDomain = splitCpDomain[1].split("[.]");
            StringBuilder sb = new StringBuilder();
            for(int i = splitDomain.length-1; i >=0; i--){
                if(i == splitDomain.length-1){
                    sb.insert(0, splitDomain[i]);
                }else{
                    sb.insert(0,".");
                    sb.insert(0,splitDomain[i]);
                }
                map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+domainCount);
            }
        }
        for(String key : map.keySet()){
            result.add(String.format("%d %s", map.get(key), key));
        }
        return result;

    }
//    ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
}

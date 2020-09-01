package com.company.leetcode;

import java.util.*;

public class Lc997FindTheTownJudge {

    public static void main(String[] args) {

        int [][] trust1= {
                {1,3},{1,4},{2,3},{2,4},{4,3}
        };
        int [][] trust2= {
                {1,2},{2,3}
        };
        int [][] trust3= {
                {1,3},{2,3},{3,1}
        };
        int [][] trust4= {
                {1,3},{2,3}
        };
        int [][] trust5= {
                {1,2}
        };
//        System.out.println(findJudge(4, trust1));
//        System.out.println(findJudge(4, trust2));
//        System.out.println(findJudge(4, trust3));
//        System.out.println(findJudge(4, trust4));
//        System.out.println(findJudge(4, trust5));
        System.out.println(findJudge(1, trust5));


    }

    @SuppressWarnings("Duplicates")
    public static int findJudge(int N, int[][] trust) {
        if(N==1)
            return N;
        Map<Integer, Set<Integer>>trustGraph = new HashMap<>();
        Set<Integer> trustedSet = new HashSet<>();

//        build trust graph
        for(int i = 0; i < trust.length; i++){
            int truster = trust[i][0];
            int trusted = trust[i][1];
            if(trustGraph.containsKey(truster)){
                trustGraph.get(truster).add(trusted);
            }else {
                Set<Integer> set = new HashSet<>();
                set.add(trusted);
                trustGraph.put(truster,set);
            }
            trustedSet.add(trusted);
        }

//        remove from trustedSet those who trust.
        trustedSet.removeAll(trustGraph.keySet());

//      trusted set must be equal to 1
        if(trustedSet.size()==1){

            List<Integer> list = new ArrayList<>(trustedSet);
            int trustedJudge = list.get(0);
//            check if all trusters trust trusted judge
            for(Integer i : trustGraph.keySet()){
                boolean doesItrustTrustedJudge = trustGraph.get(i).contains(trustedJudge);
                if(!doesItrustTrustedJudge){
                    return -1;
                }
            }

            return trustedJudge;
        }

        return -1;
    }
}

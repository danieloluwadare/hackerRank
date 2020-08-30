package com.company.leetcode;

import java.util.*;

public class Lc1436DestinationCity {

    public static void main(String[] args) {

//        [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
        List<String>path1 = new ArrayList<>();
        path1.add("London");
        path1.add("New York");

        List<String>path2 = new ArrayList<>();
        path2.add("New York");
        path2.add("Lima");

        List<String>path3 = new ArrayList<>();
        path3.add("Lima");
        path3.add("Sao Paulo");

        List<List<String>> paths = new ArrayList<>();
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);

        System.out.println(destCity(paths));

    }

    public static String destCity(List<List<String>> paths) {

        Set<String> startDestination = new HashSet<>();
        Set<String> endDestinations = new HashSet<>();

        for(List<String> path : paths){
            startDestination.add(path.get(0));
            endDestinations.add(path.get(1));
        }

        for(String ed : endDestinations){
            if(!startDestination.contains(ed))
                return ed;
        }



        return null;
    }
}

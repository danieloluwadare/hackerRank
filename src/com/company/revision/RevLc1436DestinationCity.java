package com.company.revision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
 * Return the destination city, that is, the city without any path outgoing to another city.
 *
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 *
 *
 *
 * Example 1:
 *
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 * Example 2:
 *
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are:
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * Clearly the destination city is "A".
 * Example 3:
 *
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 */
public class RevLc1436DestinationCity {

    public static void main(String[] args) {

//        [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
        List<String> path1 = new ArrayList<>();
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
        Set<String> destination=new HashSet<>();
        Set<String> startingPoint = new HashSet<>();
        for(List<String> path : paths){
            startingPoint.add(path.get(0));
            destination.add(path.get(1));
        }

        destination.removeAll(startingPoint);
        Object [] destCity = destination.toArray();
        return destCity[0].toString();
    }
}

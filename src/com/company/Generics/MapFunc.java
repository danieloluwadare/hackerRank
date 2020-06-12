package com.company.Generics;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapFunc {

    public static void main(String[] args) {

        String test ="5|+6|";
        String [] arr = test.split("\\|");
        System.out.println(arr.length);


        System.out.println("The stream after applying "
                + "the function is : ");

        // Creating a list of Strings
        List<String> list = Arrays.asList("Geeks", "FOR", "GEEKSQUIZ",
                "Computer", "Science", "gfg");

        // Using Stream map(Function mapper) and
        // displaying the length of each String
//        Map<Boolean, List<Integer>> result2 =list.stream().map(str -> str.length()).collect();

        Map<Boolean, List<Integer>> result =list.stream().map(str -> str.length()).collect(Collectors.groupingBy(e -> e > 5));
        System.out.println(Arrays.deepToString(result.get(true).toArray()));
        System.out.println(Arrays.deepToString(result.get(false).toArray()));

        list.forEach(System.out::println);
    }
}

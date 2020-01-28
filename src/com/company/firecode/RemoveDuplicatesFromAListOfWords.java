package com.company.firecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class RemoveDuplicatesFromAListOfWords {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("Hello");
        list.add("Hey");
        list.add("Hi");
        list.add("Hello");
        list.add("Hey");
        System.out.println(Arrays.deepToString(removeDuplicates(list).toArray()));


    }


    public static ArrayList<String> removeDuplicates(List<String> input) {
        TreeSet<String> set = new TreeSet<>();
//        for(String s : input){
//            set.add(s);
//        }

        set.addAll(input);

        return  new ArrayList<>(set);
    }
}

package com.company.graphs;

import java.util.*;
import java.util.function.Predicate;

public class GraphBasics {
    private static Map<Integer, LinkedList<Integer>> graph;

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Test test = new Test();
        list.removeIf(test);

        for (int a: list) {
            System.out.println(a);
        }
        System.out.println("empty");

        graph= new HashMap<>();
        graph.put(1,new LinkedList<>());
        graph.put(2, new LinkedList<>());
        graph.put(3, new LinkedList<>());
    }
}

class Test implements Predicate<Integer>{

    @Override
    public boolean test(Integer integer) {
        return false;
    }
}

class MyGen<T extends Test>{
    private T myparam;

    public T getMyparam() {
        return myparam;
    }

    public void setMyparam(T myparam) {
        this.myparam = myparam;
    }
}

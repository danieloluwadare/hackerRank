package com.company.leetcode;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] input = {
                {1,3},
                {2,6},
                {5,7},
                {8,10},
                {15,18}
        };


        SolutionMergeInterval solutionMergeInterval = new SolutionMergeInterval();
        solutionMergeInterval.mergeIntervals(input);
    }

}
class SolutionMergeInterval{
    private List<Interval> intervals = new ArrayList<>();
    private HashMap<Interval, LinkedList<Interval>> graph = new HashMap<>();
    private HashMap<Integer, LinkedList<Interval>> graphConnection = new HashMap<>();
    private Set<Interval> visited = new HashSet<>();




    public int[][] mergeIntervals(int[][] arr){
        generateInterVals(arr);
        for (Interval interval: intervals) {
            System.out.println(String.format("%s %s", interval.start, interval.end));
        }

        builGraph();
        buildGraphConnection();

        List<Interval>mergedIntervals = new ArrayList<>();

        for(int index : graphConnection.keySet()){
            mergedIntervals.add(performMerge(graphConnection.get(index)));
        }

        System.out.println("--------------------------------------------------");


        System.out.println("Merged Intervals");

        for (Interval neighbor: mergedIntervals) {
            System.out.println(String.format("%s %s", neighbor.start, neighbor.end));
        }
        System.out.println("--------------------------------------------------");



        return null;

    }

    private static boolean overlap(Interval a, Interval b){
        return a.start <= b.end && b.start <= a.end;
//        return b.start <= a.end;
    }

    private Interval performMerge(List<Interval>nodes){
        int minNumber = nodes.get(0).start;
        int maxNumber = nodes.get(0).end;

        for(Interval interval: nodes){
            minNumber = Math.min(minNumber, interval.start);
            maxNumber = Math.max(maxNumber, interval.end);

        }

        return new Interval(minNumber,maxNumber);

    }

    private void performDfs(Interval interval, int index){
        Stack<Interval>stack = new Stack<>();
        stack.push(interval);

        while (!stack.empty()){
            Interval node = stack.pop();
            if(!visited.contains(node)){
                if(graphConnection.get(index)==null){
                    graphConnection.put(index,new LinkedList<>());
                }
                graphConnection.get(index).add(node);
                stack.addAll(graph.get(node));
                visited.add(node);

            }
        }


    }

    private void buildGraphConnection(){
        int index = 0;

        System.out.println("--------------------------------------------------");
        System.out.println("Graph built successfully");


        for (Interval interval : intervals){
            if(!visited.contains(interval)){
                performDfs(interval, index);

                    System.out.println("index "+ index);
                    System.out.println("nodes attached to it");
                    List<Interval>neighbors = graphConnection.get(index);
                    for (Interval neighbor: neighbors) {
                        System.out.println(String.format("%s %s", neighbor.start, neighbor.end));
                    }
                    System.out.println("--------------------------------------------------");


                index++;
            }
        }
    }

    private void builGraph(){
//        create all single nodes;
        for(Interval interval: intervals){
            graph.put(interval,new LinkedList<>());
        }

//        create edges between each node base on the overlap[ condition
        for(Interval interval1 : intervals){
            for (Interval interval2 : intervals){
                if(interval1 != interval2){
                    if(overlap(interval1, interval2)){
                        graph.get(interval1).add(interval2);
//                        graph.get(interval2).add(interval1);
//
                    }
                }
            }
        }

        System.out.println("Graphs");

        for (Interval interval: intervals) {
            System.out.println(String.format("%s %s", interval.start, interval.end));
            System.out.println("nodes attached to it");
            List<Interval>neighbors = graph.get(interval);
            for (Interval neighbor: neighbors) {
                System.out.println(String.format("%s %s", neighbor.start, neighbor.end));
            }
            System.out.println("--------------------------------------------------");

        }

    }

    private void generateInterVals(int[][] arr){

        for(int i =0; i <arr.length; i++){
            int start = arr[i][0];
            int end = arr[i][1];
            intervals.add(new Interval(start, end));
        }
    }



    class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

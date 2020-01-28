package com.company.leetcode;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] input = {
                {1,9},

                {2,5},

                {19,20},

                {10,11},

                {12,20},

                {0,3},

                {0,1},

                {0,2},
        };

        int [][] input2 = {
        };

//        System.out.println("000016191201155955001373009415".substring(0,6));
//        System.out.println("23:59".substring(0,2) + "===> "+ "23:59".substring(3,5));
//        SolutionMergeInterval solutionMergeInterval = new SolutionMergeInterval();
//        solutionMergeInterval.mergeIntervals(input);

//        SolutionMergeInterval2 solutionMergeInterval2 = new SolutionMergeInterval2();
//        solutionMergeInterval2.mergeIntervals(input);

        MergeIntervals56 mergeIntervals56 = new MergeIntervals56();
        mergeIntervals56.merge(input);
        mergeIntervals56.merge(input2);

    }

}
class SolutionMergeInterval{
    private List<Interval> intervals = new ArrayList<>();
    private HashMap<Interval, LinkedList<Interval>> graph = new HashMap<>();
    private HashMap<Integer, LinkedList<Interval>> graphConnection = new HashMap<>();
    private Set<Interval> visited = new HashSet<>();




    public int[][] mergeIntervals(int[][] arr){
        intervals = Interval.generateInterVals(arr);
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






}

class SolutionMergeInterval2{
    private List<Interval> intervals = new ArrayList<>();



    public int[][] mergeIntervals(int[][] arr){
        intervals = Interval.generateInterVals(arr);
        for (Interval interval: intervals) {
            System.out.println(String.format("%s %s", interval.start, interval.end));
        }

        Comparator<Interval> cm1=Comparator.comparing(Interval::getStart);
//        Collections.sort(intervals, new IntervalCompartor());
        Collections.sort(intervals, cm1);


        LinkedList<Interval> mergedIntervals = new LinkedList<>();
        mergedIntervals.add(intervals.get(0));

        for(int i = 1; i<intervals.size(); i++){
            Interval previousInterVal = mergedIntervals.peekLast();
            Interval currentInterval = intervals.get(i);
            if(!(currentInterval.start > previousInterVal.end)){
                if(currentInterval.end > previousInterVal.end){
                    mergedIntervals.getLast().end=currentInterval.end;
                }
            }else{
                mergedIntervals.add(currentInterval);
            }
        }


        System.out.println("--------------------------------------------------");


        System.out.println("Merged Intervals");

        for (Interval neighbor: mergedIntervals) {
            System.out.println(String.format("%s %s", neighbor.start, neighbor.end));
        }
        System.out.println("--------------------------------------------------");



        return null;

    }


    class IntervalCompartor implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start < o2.start){
                return -1;
            }
            else if(o1.start == o2.start){
                return 0;
            }
            else return  1;
        }
    }


}

class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public static List<Interval> generateInterVals(int[][] arr){

        List<Interval>intervals = new ArrayList<>();

        for(int i =0; i <arr.length; i++){
            int start = arr[i][0];
            int end = arr[i][1];
            intervals.add(new Interval(start, end));
        }

        return intervals;
    }
}

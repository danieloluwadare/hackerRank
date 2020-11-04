package com.company.leetcode;

import java.util.*;

public class Lc399EvaluateDivision {
    public static void main(String[] args) {
//        equations = [ ["a", "b"], ["b", "c"] ],
//        values = [2.0, 3.0],
//        queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]

        Lc399EvaluateDivision division = new Lc399EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        List<String> eqn = new ArrayList<>();
        eqn.add("a");
        eqn.add("b");
        equations.add(eqn);

        eqn = new ArrayList<>();
        eqn.add("b");
        eqn.add("c");
        equations.add(eqn);

        List<List<String>> queries = new ArrayList<>();
        List<String> query = new ArrayList<>();
        query.add("a");
        query.add("c");
        queries.add(query);

        query = new ArrayList<>();
        query.add("b");
        query.add( "a");
        queries.add(query);

        query = new ArrayList<>();
        query.add("a");
        query.add("e");
        queries.add(query);

        query = new ArrayList<>();
        query.add("a");
        query.add("a");
        queries.add(query);

        query = new ArrayList<>();
        query.add("x");
        query.add("x");
        queries.add(query);

        double[] ans = division.calcEquation(equations,new double[]{2.0, 3.0},queries);
        System.out.println(Arrays.toString(ans));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        Daniel's solution
        if(equations==null||equations.size()==0)
            return null;
        Map<String, Set<Node>> graph = buildGraph(equations, values);
        double [] answers = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            answers[i]=dfs(dividend,divisor,1.0,new HashSet<>(), graph);
        }
        return answers;
    }

    public double dfs(String source , String destination, double quotient, Set<String>visited, Map<String, Set<Node>> graph){
        if(visited.contains(source))
            return -1;
        if(!graph.containsKey(source))
//            Means source was not part of the given equation
            return -1;
        if(source.equalsIgnoreCase(destination))
            return quotient;

        visited.add(source);
        for(Node node : graph.get(source)){
            double newQuotient = quotient * node.weight;
            double answer = dfs(node.destination, destination, newQuotient, visited, graph);
            if(answer != -1)
                return answer;

        }

        return -1;
    }

    public Map<String, Set<Node>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Set<Node>> graph = new HashMap<>();

//        Dividend / Divisor = answer.
        for(int i =0; i < equations.size(); i++){
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double answer= values[i];

//          equation a/b=2.0
            if(!graph.containsKey(dividend))
                graph.put(dividend,new HashSet<>());
            graph.get(dividend).add(new Node(divisor,answer));

//          Invert the equation b/a=1/2.0
            if(!graph.containsKey(divisor))
                graph.put(divisor, new HashSet<>());
            graph.get(divisor).add(new Node(dividend, 1.0/answer));

        }

        return graph;

    }

    class Node{
        String destination;
        double weight;

        public Node(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}

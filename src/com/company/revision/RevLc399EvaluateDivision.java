package com.company.revision;

import com.company.leetcode.Lc399EvaluateDivision;

import java.util.*;

public class RevLc399EvaluateDivision {
    public static void main(String[] args) {
//        equations = [ ["a", "b"], ["b", "c"] ],
//        values = [2.0, 3.0],
//        queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]

        RevLc399EvaluateDivision division = new RevLc399EvaluateDivision();
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
        Map<String, Set<Node>> graph = buildGraph(equations,values);
        double [] ans  = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            ans[i]=dfs(dividend,divisor,1.0,new HashSet<>(),graph);

        }
        return ans;
    }

    private double dfs(String dividend, String divisor,
                       double quotient, HashSet<Object> visited, Map<String, Set<Node>> graph) {

        if(visited.contains(dividend))
            return -1.0;

        if(dividend.equalsIgnoreCase(divisor))
            return quotient;
        visited.add(dividend);

        if(graph.containsKey(dividend)){
            for(Node node : graph.get(dividend)){
                double newQuotient = node.weight * quotient;
                double answer = dfs(node.destination,divisor,newQuotient,visited,graph);
                if(answer != -1.0)
                    return answer;
            }
        }


        return -1.0;
    }

    public Map<String, Set<Node>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Set<Node>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            if(!graph.containsKey(dividend))
                graph.put(dividend,new HashSet<>());
            graph.get(dividend).add(new Node(divisor,value));

            if(!graph.containsKey(divisor))
                graph.put(divisor,new HashSet<>());
            graph.get(divisor).add(new Node(dividend,1/value));
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

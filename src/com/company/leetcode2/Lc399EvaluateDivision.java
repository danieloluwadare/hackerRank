package com.company.leetcode2;

import java.util.*;

/**
 * 399. Evaluate Division
 * Medium
 *
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent
 * the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 *
 * Constraints:
 *
 *     1 <= equations.length <= 20
 *     equations[i].length == 2
 *     1 <= Ai.length, Bi.length <= 5
 *     values.length == equations.length
 *     0.0 < values[i] <= 20.0
 *     1 <= queries.length <= 20
 *     queries[i].length == 2
 *     1 <= Cj.length, Dj.length <= 5
 *     Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
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

//        Double.toString(d)
//        String.valueOf(d)
        Map<String,List<Node>> graph = new HashMap<>();
        buildGraph(equations, values, graph);
        double [] answer  = new double[queries.size()];
        for(int i =0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            Set<String> visited = new HashSet<>();
            answer [i] = dfsHelper(query.get(0),query.get(1),1.0,graph,visited);
        }
        return answer;
    }

    private static double dfsHelper(String numerator, String denominator, double product,  Map<String, List<Node>> graph, Set<String> visited) {
        if(visited.contains(numerator))
            return -1.0;
        if(!graph.containsKey(numerator))
            return -1.0;

        visited.add(numerator);

        if(numerator.equals(denominator))
            return product;

        for(Node nodes : graph.get(numerator)){
             double answer = dfsHelper(nodes.denominator, denominator, nodes.weight * product, graph, visited);
             if(answer != -1.0)
                 return answer;
        }

        return -1.0;
    }

    private static void buildGraph(List<List<String>> equations, double[] values, Map<String, List<Node>> graph) {
        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String numerator = equation.get(0);
            String denominator = equation.get(1);
            double value = values[i];
            double inverseOfValue  = 1/value;
            
//            a/b=2
            if(!graph.containsKey(numerator))
                graph.put(numerator, new ArrayList<>());
            graph.get(numerator).add(new Node(denominator,value));
//            b/a=1/2
            if(!graph.containsKey(denominator))
                graph.put(denominator, new ArrayList<>());
            graph.get(denominator).add(new Node(numerator,inverseOfValue));
        }
    }

    static class Node{
        public String denominator;
        public double weight;

        public Node(String denominator, double weight) {
            this.denominator = denominator;
            this.weight = weight;
        }
    }


}

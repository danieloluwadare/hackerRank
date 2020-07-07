package com.company.Fairmoney;

import java.util.*;

public class Fm {

    public static void main(String[] args) {
        ////['1 2', '1 4', '7 8', '7 10'] k = 10

        List<String> list = new ArrayList<>();
        list.add("1 2");
        list.add("1 4");
        list.add("7 8");
        list.add("7 10");
        list.add("2 5");


        int connect = connectedSum(10, list);

        System.out.println(connect);

    }

    //missed 1 hackerrank
//all
//missed 1 meximum recursion depth
//first job
//TopArticles
//@return List<Strings>
// get json {data: List<Json>}
// fetch the title for each
    // !(story_title and title)  ignore
    // title (sup) story_tile (inf)
    //num_comment
// limit 7
// order by num_comments desc, but if there is a tie sort tie alphabetically (title)
//[title, comment]
// lambda expression sort(x: -x[1])




//
////3rd question Dynamic programming problem
////['1 2', '1 4', '7 8', '7 10'] k = 10
//
//// 1            3       5       6       7
//2     4                               8    10
//
//// 3            1       1       1       3
//
//// ciel(sqrt(3)) + ciel(sqrt(3)) + 1 + 1 + 1 == 5

    public static Map<Integer, Set<Integer>> createGraph(List<String> edges, Set<Integer> nodes) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (String edge: edges) {
            String[] e = edge.split(" ");
            int e0 = Integer.parseInt(e[0]);
            int e1 = Integer.parseInt(e[1]);
            nodes.add(e0);
            nodes.add(e1);
            if (!graph.containsKey(e0)){
                graph.put(e0, new HashSet<>());
            }
            graph.get(e0).add(e1);
        }
        return graph;
    }

//    List a = ['1 2', '1 4', '7 8', '7 10']

    public static int connectedSum(int k, List<String> edges) {
        Set<Integer> nodes = new HashSet<>();
        Map<Integer, Set<Integer>> graph = createGraph(edges, nodes);
        int isolatedSum = k - nodes.size();
        List<Integer> count = dfs(graph);
        return formatResult(count) + isolatedSum;
    }

    public static int formatResult(List<Integer> count) {
        int sum = 0;
        for (int num: count) {
            sum += Math.ceil(Math.sqrt(num));
        }
        return sum;
    }

    public static List<Integer> dfs(Map<Integer, Set<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> count  = new ArrayList<>();

        for (int i: graph.keySet()) {
            count.add(dfsHelper(graph, visited, count, i));
        }
        return count;
    }

    public static int dfsHelper(Map<Integer, Set<Integer>> graph, Set<Integer> visited, List<Integer> count, int i){
        if (visited.contains(i)){
            return 0;
        }

        visited.add(i);
        int counter = 1;
        Set<Integer> children = graph.get(i);
        if(children != null){
            for (int num: children){
                counter += dfsHelper(graph, visited, count, num);
            }
        }

        return counter;

    }

}


package com.company.booking;

import java.util.*;

/**
 * The interview lasted for 1hr and contained one (medium-hard) question:
 * Given a list of hotelId, parentHotelId and a score retrieve the top k root parentHotelIds with highest scores:
 *
 * [{0, 1, 10}, {1, 2, 20}, {3, 4, 10}, {7, 8, 5}] K = 2
 *
 * Result: [[2, 30], [4,10]]
 *
 *
 * [{0, 1, 10}, {1, 2, 20}, {3, 4, 10}, {7, 8, 5}],{9, 1, 10} K = 2
 *
 * Result: [[2, 40], [4,10]]
 *
 */
public class TopKCountOfHotels {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getTopKCountOfHotels(new int[][]{{0, 1, 10}, {1, 2, 20}, {3, 4, 10}, {7, 8, 5}}, 2)));
        System.out.println(Arrays.deepToString(getTopKCountOfHotels(new int[][]{{0, 1, 10}, {1, 2, 20}, {3, 4, 10}, {7, 8, 5},{9, 1, 10}}, 3)));
        System.out.println(Arrays.deepToString(
                getTopKCountOfHotels(new int[][]{{0, 1, 10}, {1, 2, 20}, {3, 4, 10}, {7, 8, 5},{9, 1, 10},{10, 2, 15}}, 3)));

    }

    public static int[][] getTopKCountOfHotels(int [][] items, int k){
        //{0=>hotelId, 1=>parentHotelId, 10=>score}
        Map<Integer, Integer> mapOfHotelIdToScore = new HashMap<>();
        Map<Integer, Set<Integer>> mapOfParentIdToChildId = new HashMap<>();
        for(int[] item : items){
            int hotelId = item[0];
            int score = item[2];
            mapOfHotelIdToScore.put(hotelId,score);
            int parentHotelId = item[1];
            if(!mapOfParentIdToChildId.containsKey(parentHotelId))
                mapOfParentIdToChildId.put(parentHotelId, new HashSet<>());

            mapOfParentIdToChildId.get(parentHotelId).add(hotelId);
        }
        System.out.println("mapOfHotelIdToScore");
        System.out.println(mapOfHotelIdToScore);
        System.out.println("mapOfParentIdToChildId");
        System.out.println(mapOfParentIdToChildId);

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int parentIdKey : mapOfParentIdToChildId.keySet()){
            Set<Integer> children = mapOfParentIdToChildId.get(parentIdKey);
            queue.addAll(children);
            while (!queue.isEmpty()){
                int child = queue.poll();
                if(!graph.containsKey(parentIdKey))
                    graph.put(parentIdKey,new HashSet<>());
                graph.get(parentIdKey).add(child);
                //get the children of the child from the already computed graph if child exist in graph
                if(graph.containsKey(child)){
                    graph.get(parentIdKey).addAll(graph.get(child));
                    graph.remove(child);
                }
                // get the children of the child from mapOfParentIdToChildIdpOfParentIdToChildId and add it to the queue
                else{
                    if(mapOfParentIdToChildId.containsKey(child))
                        queue.addAll(mapOfParentIdToChildId.get(child));
                }
            }
        }

        System.out.println("graph");
        System.out.println(graph);


        Map<Integer, Integer> mapOfHotelIdToTotalScore = new HashMap<>();
        queue = new PriorityQueue<>((x, y)-> mapOfHotelIdToTotalScore.get(x) - mapOfHotelIdToTotalScore.get(y));
//        queue = new PriorityQueue<>((x, y)-> mapOfHotelIdToTotalScore.get(y) - mapOfHotelIdToTotalScore.get(x));

        for(int parentId : graph.keySet()){
            int sum = 0;
            for(int child : graph.get(parentId))
                sum += mapOfHotelIdToScore.get(child);
            mapOfHotelIdToTotalScore.put(parentId, sum);
            queue.add(parentId);
            if(queue.size() > k)
                queue.poll();

        }
        System.out.println("mapOfHotelIdToTotalScore");
        System.out.println(mapOfHotelIdToTotalScore);

        System.out.println("queue");
        System.out.println(queue);

        int [][] result = new int[k][2];
        for(int i = k-1; i >= 0; i--){
            int parentId = queue.poll();
            result[i][0] = parentId;
            result[i][1] = mapOfHotelIdToTotalScore.get(parentId);
        }
        return result;
    }
}

package com.company.booking;

import java.util.*;

/**
 * Recently gave online assesment for Booking.com could pass only 5 test cases out of 7.
 *
 * Problem Statment:
 * Booking.com wants to recognize k performing hotels. These hotels are being identified by analyzing their user reviews and calculating a review score for each of the hotels.
 *
 * To calculate the score they have:
 *
 * A list of user reviews for each hotel
 * List of positive keywords
 * List of negative keywords
 * Positive keywords weigh 3 points each and negative keywords weigh -1 each.
 *
 * For example, given the input below:
 *
 * positive keywords: “breakfast beach city center location metro view staff price”,
 *
 * negative keywords: “not”,
 *
 * number of hotels: m = 5,
 *
 * array of hotel ids: [1,2,1,1,2],
 *
 * number of reviews: n=5,
 *
 * array of reviews: [
 *
 * “This hotel has a nice view of the city center. The location is perfect.”,
 *
 * “The breakfast is ok. Regarding location, it is quite far from city center but the price is cheap so it is worth.”,
 *
 * “Location is excellent, 5 minutes from the city center. There is also a metro station very close to the hotel.”,
 *
 * “They said I couldn’t take my dog and there were other guests with dogs! That is not fair.”,
 *
 * “Very friendly staff and a good cost-benefit ratio. Its location is a bit far from the city center.”
 *
 * ],
 *
 * number of hotels we want to award: k = 2,
 *
 * then top k Hotels will be 2, 1.
 *
 * Function Description:
 * The function must return a list of hotel ids sorted in descending order of their total score. Our function awardTopKHotels has the following parameter(s):
 *
 * positiveKeywords: a space-separated string of positive keywords in review
 * negativeKeywords : a space separated string of negative keywords in review
 * hotelIds[hotelIds[0]…hotelIds[m-1]] : an array of integers, which represents hotel IDs
 * reviews[reviews[0]…reviews[n-1]] : An array of String, which represents reviews.
 * reviews[i] is review for hotelIds[i]. reviews and hotel ids are one-to-one mapped.
 * k : the number of hotels we want to award.
 * Constraints:
 * m is always equal to n.
 * If two hotels have the same score, they should be sorted in the output based on their ID, smallest ID first.
 * The keywords to find will always be single words like “breakfast” or “noise”. Never double words like “swimming pool”.
 * Matching should be case-insensitive.
 * Dots and commas should be ignored.
 * If a word appears in a review twice, it should count twice.
 * 1 ≤ m ≤ 109 , 1 ≤ n ≤ 109 ,1 ≤ hotelIds[i] ≤ 105 , 1 ≤ k ≤ 109
 * In case one or more test cases time out, consider revisiting the runtime complexity of your algorithms.
 * If k is greater than the unique number of hotel ids, then list all the hotel ids
 * Input Format For Custom Testing:
 * Input from stdin will be processed as follows and passed to the function.
 *
 * The first line contains a sentence with space-separated positive keywords.
 * The second line contains a sentence with space-separated negative keywords.
 * The third line contains an integer M, the size of the array hotels Ids.
 * The next M lines each contain an element hotelIds[i].
 * Next line contains an integer N, the size of the array reviews.
 * The next N lines each contain an element review [i]
 * The next line contains an integer K, number of hotels we want to award.
 */
public class AwardTopKHotels {

    public static void main(String[] args) {
        System.out.println(awardTopKHotels("breakfast beach city center location metro view staff price",
                "not", Arrays.asList(1,2,1,1,2),
                Arrays.asList(
                        "This hotel has a nice view of the city center. The location is perfect.",
                        "The breakfast is ok. Regarding location, it is quite far from city center but the price is cheap so it is worth.",
                        "Location is excellent, 5 minutes from the city center. There is also a metro station very close to the hotel.",
                        "They said I couldn’t take my dog and there were other guests with dogs! That is not fair.",
                        "Very friendly staff and a good cost-benefit ratio. Its location is a bit far from the city center."),

                2));

        System.out.println(awardTopKHotels2("breakfast beach city center location metro view staff price",
                "not", Arrays.asList(1,2,1,1,2),
                Arrays.asList(
                        "This hotel has a nice view of the city center. The location is perfect.",
                        "The breakfast is ok. Regarding location, it is quite far from city center but the price is cheap so it is worth.",
                        "Location is excellent, 5 minutes from the city center. There is also a metro station very close to the hotel.",
                        "They said I couldn’t take my dog and there were other guests with dogs! That is not fair.",
                        "Very friendly staff and a good cost-benefit ratio. Its location is a bit far from the city center."),

                2));
    }

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords,
                                                List<Integer> hotelIds,
                                                List<String> reviews, int k) {

        Set<String> positiveWords = new HashSet<>();
        for(String word : positiveKeywords.split(" ") )
            positiveWords.add(word.toLowerCase());

        Set<String> negativeWords = new HashSet<>();
        for(String word : negativeKeywords.split(" ") )
            negativeWords.add(word.toLowerCase());

        Map<Integer, Integer> mapOfHotelsScores = new HashMap<>();
        for (int i = 0; i < reviews.size(); i++){
            int sum = 0;
            String review = reviews.get(i);
            for (String word : review.split(" ")){
                if(word.charAt(word.length() -1) == '.' || word.charAt(word.length() -1) == ',')
                    word = word.substring(0, word.length()-1);
                if(positiveWords.contains(word.toLowerCase()))
                    sum += 3;
                if(negativeWords.contains(word.toLowerCase()))
                    sum -= 1;
            }

            mapOfHotelsScores.put(hotelIds.get(i), mapOfHotelsScores.getOrDefault(hotelIds.get(i), 0) + sum );
        }

        mapOfHotelsScores.put(10, 10);
        mapOfHotelsScores.put(4, 10);

        System.out.println("mapOfHotelsScores");
        System.out.println(mapOfHotelsScores);
        Queue<Integer> queue = new PriorityQueue<>((x,y)->
                mapOfHotelsScores.get(x)==mapOfHotelsScores.get(y) ? y.compareTo(x)
                        : mapOfHotelsScores.get(x) - mapOfHotelsScores.get(y) );

        Queue<Integer> vqueue = new PriorityQueue<>((x, y)->
                mapOfHotelsScores.get(x)==mapOfHotelsScores.get(y) ? y.compareTo(x)
                        : mapOfHotelsScores.get(x) - mapOfHotelsScores.get(y) );

//        Queue<Integer> queue = new PriorityQueue<>((x, y)->
//                mapOfHotelsScores.get(x)==mapOfHotelsScores.get(y) ? y.compareTo(x) : mapOfHotelsScores.get(x) - mapOfHotelsScores.get(y) );

        for(int hotelId : mapOfHotelsScores.keySet()){
            queue.add(hotelId);
            if(queue.size() > k)
                queue.poll();
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            result.add(0,queue.poll());
        }

        return result;
    }

    public static List<Integer> awardTopKHotels2(String positiveKeywords, String negativeKeywords,
                                                List<Integer> hotelIds,
                                                List<String> reviews, int k) {
        Set<String> positiveWords = new HashSet<>();
        Set<String> negativeWords = new HashSet<>();

        for (String word: positiveKeywords.split(" ")) {
            positiveWords.add(word.toLowerCase());
        }

        for (String word: negativeKeywords.split(" ")) {
            negativeWords.add(word.toLowerCase());
        }

        Map<Integer, Integer> hotelScore = new HashMap<>();
        for (int i = 0; i < reviews.size(); i++) {
            int hotel = hotelIds.get(i);
            int score = hotelScore.getOrDefault(hotel, 0);
            List<String> review = Arrays.asList(reviews.get(i).split(" "));

            int pos=0, neg=0;
            for (String word: reviews.get(i).split(" ")) {
                if (word.charAt(word.length()-1) == '.' || word.charAt(word.length()-1) == ',') {
                    word = word.substring(0, word.length() - 1);
                }
                if (positiveWords.contains(word.toLowerCase())) {
                    pos++;
                }
                if (negativeWords.contains(word.toLowerCase())) {
                    neg++;
                }
            }
            hotelScore.put(hotel, score + 3*pos - neg);
        }

        hotelScore.put(10, 10);
        hotelScore.put(4, 10);

        System.out.println("hotelScore");
        System.out.println(hotelScore);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<Integer, Integer> entry: hotelScore.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }
}

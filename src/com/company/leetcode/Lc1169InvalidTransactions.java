package com.company.leetcode;

/**
 * A transaction is possibly invalid if:
 *
 * the amount exceeds $1000, or;
 * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 * Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.
 *
 * Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * Output: ["alice,20,800,mtv","alice,50,100,beijing"]
 * Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes,
 * have the same name and is in a different city. Similarly the second one is invalid too.
 * Example 2:
 *
 * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * Output: ["alice,50,1200,mtv"]
 * Example 3:
 *
 * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * Output: ["bob,50,1200,mtv"]
 *
 *
 * Constraints:
 *
 * transactions.length <= 1000
 * Each transactions[i] takes the form "{name},{time},{amount},{city}"
 * Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
 * Each {time} consist of digits, and represent an integer between 0 and 1000.
 * Each {amount} consist of digits, and represent an integer between 0 and 2000.
 */

import java.util.*;

public class Lc1169InvalidTransactions {

    public static void main(String[] args) {
        String [] arr = new String[]{"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona",
                "bob,820,596,bangkok", "chalicefy,217,669,barcelona","bob,175,221,amsterdam"};
        System.out.println(invalidTransactions(arr));
    }

    public static List<String> invalidTransactions(String[] transactions) {
        Set<String> set = new HashSet<>();


        for(int i = 0; i < transactions.length; i++){
            //0 => {name},// 1 => {time},// 2 => {amount},// 3 => {city}
            String [] splitTransaction =transactions[i].split(",");
            if(Integer.parseInt(splitTransaction[2]) > 1000)
                set.add(transactions[i]);

            for(int j = i+1; j < transactions.length; j++ ){
                String [] splitTransaction2 =transactions[j].split(",");
                int timeDifference = Math.abs(Integer.parseInt(splitTransaction[1])
                        - Integer.parseInt(splitTransaction2[1]));

                if(i != j && timeDifference <= 60
                        && splitTransaction[0].equalsIgnoreCase(splitTransaction2[0])
                        && !splitTransaction[3].equalsIgnoreCase(splitTransaction2[3])){
                    set.add(transactions[i]);
                    set.add(transactions[j]);
                }
            }


        }

        List<String> list = new ArrayList<>(set);
        return list;


    }
}

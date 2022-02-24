package com.company.leetcode22.microsoft.easy;

import java.util.ArrayList;
import java.util.List;

/***
 * 118. Pascal's Triangle
 * Easy
 *
 * 4946
 *
 * 192
 *
 * Add to List
 *
 * Share
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
public class Lc118PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        list.add(newRow);
        for (int i=1; i < numRows; i++){
            List<Integer> lastRow = list.get(list.size()-1);
            newRow = new ArrayList<>();
            newRow.add(1);
            for(int j = 1; j < lastRow.size(); j++){
                newRow.add(lastRow.get(j-1)+lastRow.get(j));
            }
            newRow.add(1);
            list.add(newRow);
        }
        return list;
    }
}

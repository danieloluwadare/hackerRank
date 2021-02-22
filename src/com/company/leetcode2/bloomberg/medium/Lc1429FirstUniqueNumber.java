package com.company.leetcode2.bloomberg.medium;

/**
 * 1429. First Unique Number
 * Medium
 *
 * 206
 *
 * 11
 *
 * Add to List
 *
 * Share
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 *
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 *
 *
 * Example 1:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 * Example 2:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 * Example 3:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 * 1 <= value <= 10^8
 * At most 50000 calls will be made to showFirstUnique and add.
 */

import java.util.*;

public class Lc1429FirstUniqueNumber {
    public static void main(String[] args) {

        FirstUnique fu = new FirstUnique(new int[]{2,3,5});
        System.out.println(fu.showFirstUnique());
        fu.add(2);
        System.out.println(fu.showFirstUnique());
        fu.add(5);
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());
        fu.add(7);
        System.out.println(fu.showFirstUnique());
    }



}
class FirstUnique {
    Set<Integer> uniqueSet = new LinkedHashSet<>();
    Set<Integer> allSet = new HashSet<>();
    public FirstUnique(int[] nums) {
        initializeSet(nums);
    }

    public int showFirstUnique() {
        if(!uniqueSet.isEmpty()){
            return uniqueSet.iterator().next();
        }
        return -1;
    }

    public void add(int value) {
        if(!allSet.contains(value)){
            allSet.add(value);
            uniqueSet.add(value);
        }else {
            uniqueSet.remove(value);
        }
    }

    public void initializeSet(int[] nums){
        for(int i : nums){
            add(i);
        }
    }
}

/**
 * The interview experience was awful. The interviewer had a strong accent and it was very hard to understand. The majority of the interview was spent on understanding the questions.
 *
 * Behavioral Questions:
 * Tell me about yourself ?
 * Tell me about a project you are most proud of ?
 * Coding questions:
 * Total Sum -->
 * Input: arr1 = [1,2,3,5], arr2 = [1,10,13,11], target = 15
 * Output: True ( 5 (from arr1) + 10(from arr2) == 15(target))
 * I solved this question and told him both brute force as well as an optimized solution.
 *
 * Flatten Singly Linked List (Just next and child attributes)--> Similar to this question https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * I told him multiple solutions with O(n) space complexity, but he insisted on O(1) space complexity.
 *
 * I had very little time to think about space optimized solution as the majority of the time was wasted in clarifying the questions asked by the interviewer. Two days after the interview, I got rejection mail from them.
 *
 * I hope this helps and All the Best
 *
 * -------------------------------------------------------------------------------------------------------
 * Applied in September 2020, reached out to schedule first round phone interview around December 2020 and virtual onsite in January 2021. I studied the list of frequently asked Bloomberg questions nonstop. Hope my experience helps those with upcoming onsites :)
 *
 * Position: New Grad SE
 * Location: NYC
 *
 * Phone Interview
 *
 * Given an array of securities and its associated price, return the top K stocks
 * Similar to https://leetcode.com/problems/top-k-frequent-words/ and https://leetcode.com/problems/design-a-leaderboard
 * Onsite Interview (2 rounds of technical, each round started with resume overview, why Bloomberg?)
 *
 * Round 1
 *
 * Word Search (https://leetcode.com/problems/word-search/)
 * 1D Candy Crush (https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/)
 * Round 2
 *
 * Number of ways to purchase oil (https://leetcode.com/discuss/interview-question/550259/bloomberg-phone-interview-se-grad-2020)
 * This one was not listed, but brought up once on a post back in May 2020. Caught me off guard and wasn't able to solve it. Looking at discussion post, it seems to be a blend of https://leetcode.com/problems/subsets/ and dp(?)
 * Valid BST (https://leetcode.com/problems/validate-binary-search-tree/)
 * Valid Palindrome (https://leetcode.com/problems/valid-palindrome/)
 * Follow up: How would you make the string valid, if not valid ?
 * Didn't get asked for an HR round, so by Bloomberg standards I'll get a rejection lol
 *
 * Key Takeaway - Bloomberg asks a huge diverse number of questions ranging from vastly different topics. Best to do ALL phone and onsite questions that are listed here on Leetcode
 * -------------------------------------------------------------------------------------------------------------------------------
 */
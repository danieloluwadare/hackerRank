package com.company.leetcode2.bloomberg.medium;

import java.util.*;

/**
 * Medium
 *
 * You have n processes forming a rooted tree structure. You are given two integer arrays pid and ppid, where pid[i] is the ID of the ith process
 * and ppid[i] is the ID of the ith process's parent process.
 *
 * Each process has only one parent process but may have multiple children processes. Only one process has ppid[i] = 0, which means this process
 * has no parent process (the root of the tree).
 *
 * When a process is killed, all of its children processes will also be killed.
 *
 * Given an integer kill representing the ID of a process you want to kill, return a list of the IDs of the processes that will be killed.
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
 * Output: [5,10]
 * Explanation: The processes colored in red are the processes that should be killed.
 *
 * Example 2:
 *
 * Input: pid = [1], ppid = [0], kill = 1
 * Output: [1]
 *
 *
 *
 * Constraints:
 *
 *     n == pid.length
 *     n == ppid.length
 *     1 <= n <= 5 * 104
 *     1 <= pid[i] <= 5 * 104
 *     0 <= ppid[i] <= 5 * 104
 *     Only one process has no parent.
 *     All the values of pid are unique.
 *     kill is guaranteed to be in pid.
 */
public class Lc582KillProcess {
    public static void main(String[] args) {
        System.out.println(killProcess(Arrays.asList(1,3,10,5),Arrays.asList(3,0,5,3), 5));
        System.out.println(killProcess(Arrays.asList(1),Arrays.asList(0), 1));

    }

    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> parentToChild = new HashMap<>();
        for(int i = 0; i < pid.size(); i++){
            if(!parentToChild.containsKey(ppid.get(i)))
                parentToChild.put(ppid.get(i),new ArrayList<>());
            parentToChild.get(ppid.get(i)).add(pid.get(i));

            if(!parentToChild.containsKey(pid.get(i)))
                parentToChild.put(pid.get(i),new ArrayList<>());

        }
//        [3=>[1], 1=>[], 0=>[3], 3=>[5], 5=>[10], 10=>[],]

        List<Integer> killedProcesses = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()){
            int killedProcess = queue.poll();
            killedProcesses.add(killedProcess);
            if(parentToChild.containsKey(killedProcess)){
                queue.addAll(parentToChild.get(killedProcess));
            }
        }
        return killedProcesses;
    }
}

package com.company.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Follow up:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is less than 6000.
 * -100 <= node.val <= 100
 */
public class Lc117PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node7;

        connect(node1);

    }

    public static Node connect(Node root) {
        if(root == null)
            return root;
        Map<Integer, List<Node>> map = new HashMap<>();
        dfsTransversal(root, map, 0);
        for(int i = 0; i < map.size(); i++){
            List<Node> list = map.get(i);
            for (int j = 1; j < list.size(); j++){
                list.get(j-1).next = list.get(j);
            }
            list.get(list.size()-1).next = null;
        }
        System.out.println(map.size());
        return root;
    }
     public static void dfsTransversal(Node root, Map<Integer, List<Node>> map, int depth){
        if(root == null)
            return;
         System.out.println(root.val+" =====> depth ======>" + depth);
         if(!map.containsKey(depth))
             map.put(depth,new ArrayList<>());

         map.get(depth).add(root);
         dfsTransversal(root.left, map, depth+1);
         dfsTransversal(root.right, map, depth +1);

     }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

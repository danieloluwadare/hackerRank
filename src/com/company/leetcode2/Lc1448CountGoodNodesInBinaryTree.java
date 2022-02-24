package com.company.leetcode2;

import com.company.leetcode.TreeNode;

/**
 * Medium
 *
 * 736
 *
 * 36
 *
 * Add to List
 *
 * Share
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no
 * nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * Example 2:
 *
 *
 *
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 *
 *
 * Constraints:
 *
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 */
public class Lc1448CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode o1Node = new TreeNode(3);
        TreeNode o2Node = new TreeNode(1);
        TreeNode o3Node = new TreeNode(4);
        TreeNode o4Node = new TreeNode(3);
//        TreeNode o5Node = new TreeNode(5);
        TreeNode o6Node = new TreeNode(1);
        TreeNode o7Node = new TreeNode(5);

        o1Node.left=o2Node;
        o1Node.right=o3Node;

        o2Node.left=o4Node;
//        o2Node.right=o5Node;

        o3Node.left=o6Node;
        o3Node.right=o7Node;
        System.out.println(goodNodes(o1Node));
    }
    public static int goodNodes(TreeNode root) {
        return goodNodes(root,root.val);
//        return 0;
    }
    public static int goodNodes(TreeNode root, int max) {
        if(root == null)return 0;
        int newMax  = Math.max(root.val,max);
        int countLeft = goodNodes(root.left,newMax);
        int countRight = goodNodes(root.right,newMax);
        int countRoot = (root.val >= max) ? 1 : 0;
        return countRoot + countLeft + countRight;
    }
}

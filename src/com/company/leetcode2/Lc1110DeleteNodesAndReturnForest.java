package com.company.leetcode2;

import com.company.leetcode.TreeNode;

import java.util.*;

/**
 * Share
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * Example 2:
 *
 * Input: root = [1,2,4,null,3], to_delete = [3]
 * Output: [[1,2,4]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 */
public class Lc1110DeleteNodesAndReturnForest {

    public static void main(String[] args) {
        TreeNode o1Node = new TreeNode(1);
        TreeNode o2Node = new TreeNode(2);
        TreeNode o3Node = new TreeNode(3);
        TreeNode o4Node = new TreeNode(4);
        TreeNode o5Node = new TreeNode(5);
        TreeNode o6Node = new TreeNode(6);
        TreeNode o7Node = new TreeNode(7);

        o1Node.left=o2Node;
        o1Node.right=o3Node;

        o2Node.left=o4Node;
        o2Node.right=o5Node;

        o3Node.left=o6Node;
        o3Node.right=o7Node;

        List<TreeNode> nodes =delNodes(o1Node,new int[]{3,5});
        System.out.println(nodes);
    }


    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete)
            set.add(i);
        List<TreeNode> forest = new ArrayList<>();
        root = delNodesHelper(root,set,forest);
        if (root != null && !set.contains(root.val))forest.add(root);
        return forest;
    }

    public static TreeNode delNodesHelper(TreeNode root, Set<Integer> to_delete,List<TreeNode> forest){
        if(root==null)return null;
        root.left=delNodesHelper(root.left,to_delete,forest);
        root.right=delNodesHelper(root.right,to_delete,forest);
        if(to_delete.contains(root.val)){
            if(root.left !=null)forest.add(root.left);
            if(root.right !=null)forest.add(root.right);
            return null;
        }
        return root;
    }


}

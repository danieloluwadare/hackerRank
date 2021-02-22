package com.company.revision;

import com.company.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 *
 * Note: The merging process must start from the root nodes of both trees.
 */
public class RevLc617MergeTwoBinaryTrees {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left=new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left=new TreeNode(2);
//        root2.right = new TreeNode(3);

        System.out.println(mergeTrees(root1, root2));



    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        if(t1==null)
            return t2;

        Queue<TreeNode[]> queue = new LinkedList<>();
        TreeNode [] nodes = {t1,t2};
        queue.add(nodes);
        while (!queue.isEmpty()){
            TreeNode [] currentNodes = queue.poll();
            TreeNode tree1 = currentNodes[0];
            TreeNode tree2 = currentNodes[1];

            if(tree2 == null){
                continue;
            }

            tree1.val += tree2.val;
            if(tree1.left != null){
                queue.add(new TreeNode[]{tree1.left,tree2.left});
            }else {
                tree1.left=tree2.left;
            }
            if(tree1.right != null){
                queue.add(new TreeNode[]{tree1.right,tree2.right});
            }else {
                tree1.right=tree2.right;
            }


        }

        return t1;
    }
}

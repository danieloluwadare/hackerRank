package com.company.leetcode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
 * lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */
public class Lc236LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        TreeNode rootThree = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8);
        TreeNode two = new TreeNode(2);
        TreeNode six = new TreeNode(6);
        TreeNode zero = new TreeNode(0);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);

        rootThree.left=five;
        rootThree.right=one;

        five.left=six;
        five.right=two;

        two.left=seven;
        two.right=four;

        one.left=zero;
        one.right=eight;

        System.out.println(lowestCommonAncestor(rootThree,five, one).val);
        System.out.println(lowestCommonAncestor(rootThree,five, four).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!=null && right !=null) return root;

        return (left != null) ? left : right;

    }

}

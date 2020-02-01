package com.company.firecode;

public class FindTheSumOfAllElementsInABinaryTree {

    public int sum(TreeNode root) {
        if(root==null){
            return 0;
        }

        return root.data + sum(root.left) + sum(root.right);

    }

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}

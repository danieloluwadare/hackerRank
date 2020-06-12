package com.company.firecode;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheSizeOfTheBinaryTree {

    public int size(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while(!queue.isEmpty()){
            TreeNode curentNode = queue.remove();
            count++;
            if(curentNode.left != null)queue.add(curentNode.left);
            if(curentNode.right != null)queue.add(curentNode.right);
        }

        return count;

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

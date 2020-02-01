package com.company.firecode;

import java.util.LinkedList;
import java.util.Queue;

public class CountTheLeaves {

    public int numberOfLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int numberOfChildren = 0;
        while (queue.size() > 0){
            TreeNode currentNode = queue.remove();
            if(currentNode.left == null && currentNode.right == null){
                numberOfChildren++;
            }else{
                if(currentNode.left != null)queue.add(currentNode.left);
                if(currentNode.right != null)queue.add(currentNode.right);
            }
        }

        return numberOfChildren;
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

package com.company.firecode;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxElementInABinaryTreeRecursively {

    public int findMax(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        queue.add(root);
        while(queue.size() > 0){
            TreeNode currentELement = queue.remove();
            max = Math.max(max,currentELement.data);
            if(currentELement.left != null) queue.add(currentELement.left);
            if(currentELement.right != null) queue.add(currentELement.right);

        }

        return max;
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

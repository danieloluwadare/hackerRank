package com.company.firecode;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfABinaryTree {

    public int findHeight(TreeNode root) {
        if(root==null){
            return 0;
        }
        int height = 1;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        height = height + ((leftHeight > rightHeight ) ? leftHeight : rightHeight);
        return height;

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

package com.company.firecode;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePreorderTraversal {

    public ArrayList<Integer> preorderItr(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root==null)return arr;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while(!stack.empty()){
            TreeNode currentNode = stack.pop();
            arr.add(currentNode.data);

            if(currentNode.right != null) stack.push(currentNode.right);
            if(currentNode.left != null) stack.push(currentNode.left);
        }

        return arr;
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

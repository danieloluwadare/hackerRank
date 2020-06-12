package com.company.firecode;

public class MaximumSumPath {

    public static void main(String[] args) {
//        TreeNode
    }

    public static int maxSumPath(TreeNode root) {
        int[]maxRecursiveHolder = new int[1];
        maxSumPathMain(root, maxRecursiveHolder);
        return maxRecursiveHolder[0];
    }

    public static int maxSumPathMain(TreeNode root, int [] maxRecursiveHolder){
        if(root==null){
            return 0;
        }

        int leftSum = maxSumPathMain(root.left, maxRecursiveHolder);
        int rightSum = maxSumPathMain(root.right, maxRecursiveHolder);

        int nodeCumVal = Math.max(root.data + leftSum, root.data + rightSum);

        maxRecursiveHolder[0]=Math.max(maxRecursiveHolder[0], leftSum + root.data + rightSum);

        return nodeCumVal;
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

        TreeNode(int data){
            this.data=data;
        }
    }
}

package com.company.firecode;

public class BSTValidation {


    public static boolean validateBST(TreeNode root) {
        return checkvalidateBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean checkvalidateBST(TreeNode root, int max, int min){
        if(root == null){
            return true;
        }

        if(root.data < min || root.data > max){
            return false;
        }

        if(
                checkvalidateBST(root.left, root.data, min ) &&
                        checkvalidateBST(root.right, max, root.data )
                ){
            return true;
        }else{
            return false;
        }
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

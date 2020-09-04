package com.company.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Lc617MergeTwoBinaryTrees {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left=new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left=new TreeNode(2);
        root2.right = new TreeNode(3);

        mergeTrees(root1, root2);



    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)return t2;
        if(t2==null)return t1;

        Queue<TreeNode[]> queue = new LinkedList<>();
        TreeNode [] rootNodes = new TreeNode[2];
        rootNodes[0]=t1;
        rootNodes[1]=t2;

        queue.offer(rootNodes);

        while (!queue.isEmpty()){
            TreeNode [] nodes = queue.poll();
            TreeNode tree1 = nodes[0];
            TreeNode tree2 = nodes[1];

            if(tree1==null || tree2==null){
                continue;
            }

            tree2.val = tree2.val + tree1.val;
            if(tree2.left==null){
                tree2.left=tree1.left;
            }else {
                queue.offer(new TreeNode[]{tree1.left,tree2.left});
            }

            if(tree2.right==null){
                tree2.right=tree1.right;
            }
            else {
                queue.offer(new TreeNode[]{tree1.right,tree2.right});
            }

        }
        rootNodes=null;
        return t2;


    }





}

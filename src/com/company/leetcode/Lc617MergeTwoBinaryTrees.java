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
//        root2.right = new TreeNode(3);

        System.out.println(mergeTrees(root1, root2));



    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)return t2;
        if(t2==null)return t1;

        Queue<TreeNode[]> queue = new LinkedList<>();
        TreeNode [] rootNodes = new TreeNode[2];
        rootNodes[0]=t1;
        rootNodes[1]=t2;

        queue.offer(rootNodes);
//                  1
//              2       3
//            4   6   7    8
        while (!queue.isEmpty()){
            rootNodes = queue.poll();
            TreeNode node1 = rootNodes[0];
            TreeNode node2 = rootNodes[1];
            if(node1 == null || node2==null){
                continue;
            }
            node1.val = node1.val+ node2.val;
            if(node1.left==null){
                node1.left=node2.left;
            }else{
                queue.add(new TreeNode[]{node1.left,node2.left});
            }
            if(node1.right==null){
                node1.right=node2.right;
            }else {
                queue.add(new TreeNode[]{node1.right,node2.right});

            }

        }
        return t1;
    }





}

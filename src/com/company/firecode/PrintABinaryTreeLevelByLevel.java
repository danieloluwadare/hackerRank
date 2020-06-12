package com.company.firecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintABinaryTreeLevelByLevel {

    public ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        TreeNodeLevel treeNodeLevel = new TreeNodeLevel(root, 1);
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.add(treeNodeLevel);

        while(!queue.isEmpty()){

            TreeNodeLevel currentNodeLevel = queue.remove();
            if(result.size() < currentNodeLevel.level ){
                ArrayList<Integer> listInteger = new ArrayList<>();
                result.add(listInteger);
            }

            TreeNode treeNode = currentNodeLevel.treeNode;
            int level = currentNodeLevel.level;
            result.get(level - 1).add(treeNode.data);

            if(treeNode.left != null){
                queue.add(new TreeNodeLevel(treeNode.left, level+1));
            }
            if(treeNode.right != null){
                queue.add(new TreeNodeLevel(treeNode.right, level+1));
            }

        }


        return result;


    }

    class TreeNodeLevel{
        TreeNode treeNode;
        int level;

        TreeNodeLevel(TreeNode treeNode, int level){
            this.treeNode=treeNode;
            this.level=level;
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

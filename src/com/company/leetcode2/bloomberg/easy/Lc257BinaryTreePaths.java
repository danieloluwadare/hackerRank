package com.company.leetcode2.bloomberg.easy;

import com.company.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc257BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        one.left=two;
        one.right=three;
        two.left=four;
        System.out.println("ab->".substring(0,"ab->".length()-2));
        binaryTreePaths(one);
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if(root == null)
            return null;
        List<List<TreeNode>> list = new ArrayList<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> rootNode = new ArrayList<>();
        rootNode.add(root);
        queue.add(rootNode);

        while (!queue.isEmpty()){
            List<TreeNode> nodes = queue.poll();
            if(nodes.get(nodes.size()-1).left != null){
                List<TreeNode> leftNode = new ArrayList<>();
                leftNode.addAll(nodes);
                leftNode.add(nodes.get(nodes.size()-1).left);
                queue.add(leftNode);

            }
            if(nodes.get(nodes.size()-1).right != null){
                List<TreeNode> rightNode = new ArrayList<>();
                rightNode.addAll(nodes);
                rightNode.add(nodes.get(nodes.size()-1).right);
                queue.add(rightNode);

            }
            if(nodes.get(nodes.size()-1).right == null && nodes.get(nodes.size()-1).left == null)
                list.add(nodes);

        }
        StringBuilder sb = new StringBuilder();
        for(List<TreeNode> listTreeNode : list){
            for (TreeNode treeNode : listTreeNode){
                sb.append(treeNode.val);
                sb.append("->");
            }

            result.add(sb.substring(0,sb.length()-2));
            sb=new StringBuilder();
        }

        System.out.println(result);
        return result;
    }
}




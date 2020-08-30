package com.company.firecode.level3;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {
    public static void main(String[] args) {
        FullTreeDecompression fullTreeDecompression = new FullTreeDecompression();
//        TreeNode treeNode = fullTreeDecompression.decompressTree("1,2,3,4,5,6,7");
        TreeNode treeNode = fullTreeDecompression.decompressTree("1,2,3,*,5,6,*");

        BinaryTreeSerialization binaryTreeSerialization = new BinaryTreeSerialization();
        String serializedString = binaryTreeSerialization.serializeTree(treeNode);
        System.out.println(serializedString);
        binaryTreeSerialization.restoreTree(serializedString);
    }

    public String serializeTree(TreeNode root){

        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        TreeNode nullNode = new TreeNode(0,null, null);


        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            sb.append(node.data);
            sb.append(",");

            if(node.data==0){
                continue;
            }

            if(node.left!=null){
                queue.add(node.left);
            }else {
                queue.add(nullNode);
            }
            if(node.right != null){
                queue.add(node.right);
            }else {
                queue.add(nullNode);
            }
        }

        System.out.println();

        String serializedTreeContainingZero =  sb.substring(0, sb.length() - 1);
        String serializedString =serializedTreeContainingZero.replace("0","*");

        return serializedString;

    }

    public TreeNode restoreTree(String str){

        if(str==null || str.length() ==0){
            return null;
        }

        String [] arr = str.split(",");

        if(arr.length == 0){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);

        int length = arr.length;
        int i = 0;

        while (i < length){
            int leftIndex = (2*i) + 1;
            int rightIndex = (2*i) + 2;
            if(!arr[i].equals("*")){
                TreeNode node = queue.poll();
                if(leftIndex<length){
                    node.left=getTreeNodeFromChar(arr[leftIndex],queue);
                }
                if(rightIndex<length){

                    node.right=getTreeNodeFromChar(arr[rightIndex],queue);;
                }

            }
            i++;
        }



        return root;
    }

    public TreeNode getTreeNodeFromChar(String element, Queue<TreeNode> queue){
        if(element.equals("*")){
            return null;
        }
        int intValue = Integer.parseInt(element);
        TreeNode node = new TreeNode(intValue);
        queue.add(node);
        return node;


    }



}

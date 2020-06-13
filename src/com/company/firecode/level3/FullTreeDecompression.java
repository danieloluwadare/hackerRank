package com.company.firecode.level3;

import java.util.LinkedList;
import java.util.Queue;

public class FullTreeDecompression {

    public static void main(String[] args) {
        FullTreeDecompression fullTreeDecompression = new FullTreeDecompression();
        final TreeNode treeNode = fullTreeDecompression.decompressTree("1,2,3,*,5,6,*");

    }

    public TreeNode decompressTree(String str){
        if(str.charAt(0) == '*'){
            return null;
        }
        int rootValue = Character.getNumericValue(str.charAt(0));
        TreeNode root = new TreeNode(rootValue);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        String [] arr = str.split(",");
        int length = arr.length;
        int i =0;
        while (i < length){
            String element = arr[i];
            if(!element.equals("*")){
                TreeNode node = queue.poll();
                int leftIndex = (2 * i) + 1;
                int rightIndex = (2 * i) + 2;

                if(leftIndex<length){
                    node.left=getTreeNodeFromChar(arr[leftIndex],queue);
                }

                if(rightIndex<length){
                    node.right=getTreeNodeFromChar(arr[rightIndex], queue);
                }
            }


            i++;
        }

        return root;
    }

    public TreeNode getTreeNodeFromChar(String element, Queue<TreeNode> queue){
        if(element.equals("*")){
            return null;
        }else {

            int intValue = Integer.parseInt(element);
            TreeNode node = new TreeNode(intValue);
            queue.add(node);
            return node;
        }

    }


}

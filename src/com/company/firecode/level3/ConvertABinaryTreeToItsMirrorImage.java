package com.company.firecode.level3;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class ConvertABinaryTreeToItsMirrorImage {

    public static void main(String[] args) {
        FullTreeDecompression fullTreeDecompression = new FullTreeDecompression();
//        final TreeNode treeNode = fullTreeDecompression.decompressTree("1,2,3,4,5,6,7");
        final TreeNode treeNode = fullTreeDecompression.decompressTree("6,4,*,3");

        ConvertABinaryTreeToItsMirrorImage cbtm = new ConvertABinaryTreeToItsMirrorImage();
        cbtm.mirrorImgae(treeNode);

    }

    public TreeNode mirror(TreeNode root) {
        if (root == null)
            return null;
        TreeNode curr = null;
        if(root != null) {
            mirror(root.left);
            mirror(root.right);
            //swap node pointers between left and right nodes
            curr = root.left;
            root.left = root.right;
            root.right = curr;
        }
        return root;
    }

    public TreeNode mirrorImgae(TreeNode root){

        if(root == null){
            return null;
        }

        String serializedTree = serializeTreee(root);

        System.out.println(serializedTree);

//        TreeNode rootNode = deSerializeTree(serializedTree);
//
//        return rootNode;

        return null;

    }

    public String serializeTreee(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        TreeNode nullNode = new TreeNode(0);
        int heightOfTree = findHeight(root);
        int maximumNumberOfNodes= ((int)Math.pow(2,heightOfTree)) - 1;


        while(!queue.isEmpty() && queue.size() <= maximumNumberOfNodes){
            TreeNode node = queue.poll();
            sb.append(node.data);
            sb.append(",");

            if(node.data==0){
                queue.add(nullNode);
                queue.add(nullNode);
                continue;
            }

            if(node.right != null){
                queue.add(node.right);
            }else {
                queue.add(nullNode);
            }

            if(node.left!=null){
                queue.add(node.left);
            }else {
                queue.add(nullNode);
            }

        }

        String serializedTreeContainingZero =  sb.substring(0, sb.length() - 1);
        String serializedString =serializedTreeContainingZero.replace("0","*");

        return serializedString;
    }

    public TreeNode deSerializeTree(String str) {
        if(str==null || str.length()==0){
            return null;
        }

        String [] arr = str.split(",");

        if(arr.length == 0){
            return null;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);

        int i = 0;
        while (i<arr.length){
            int leftIndex = (2*i) + 1;
            int rightIndex = (2*i) + 2;

            if(!arr[i].equals("*")){
                TreeNode node = queue.poll();
                if(leftIndex<arr.length){
                    node.left=getTreeNodeFromChar(arr[leftIndex],queue);
                }
                if(rightIndex<arr.length){

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


        int value = Integer.parseInt(element);
        TreeNode node = new TreeNode(value);
        queue.add(node);
        return node;


    }

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
}

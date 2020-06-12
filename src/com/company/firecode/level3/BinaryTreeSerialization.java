package com.company.firecode.level3;

public class BinaryTreeSerialization {
    public static void main(String[] args) {
        FullTreeDecompression fullTreeDecompression = new FullTreeDecompression();
        TreeNode treeNode = fullTreeDecompression.decompressTree("1,2,3,*,5,6,*");

        BinaryTreeSerialization binaryTreeSerialization = new BinaryTreeSerialization();
        binaryTreeSerialization.serializeTree(treeNode);
    }

    public String serializeTree(TreeNode root){




        return null;

    }

    public TreeNode restoreTree(String str){
        return null;
    }
}

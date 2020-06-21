package com.company.firecode.level3;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfATree {

    public int minTreeDepth(TreeNode root) {

        if(root==null){
            return 0;
        }

        TreeNodeLevel rootLevel = new TreeNodeLevel(root,1);
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.add(rootLevel);

        // boolean found = false;
        int minDepth = 1;

        while (!queue.isEmpty()){
            TreeNodeLevel treeNodeLevel = queue.poll();
            TreeNode node = treeNodeLevel.treeNode;
            int level = treeNodeLevel.level;
            if(node.left == null && node.right == null){
                minDepth=level;
                break;
            }
            if(node.left != null){
                TreeNodeLevel leftNodeLevel = new TreeNodeLevel(node.left,level + 1);
                queue.add(leftNodeLevel);
            }
            if(node.right != null){
                TreeNodeLevel rightNodeLevel = new TreeNodeLevel(node.right, level + 1);
                queue.add(rightNodeLevel);
            }

        }

        return minDepth;

    }

    class TreeNodeLevel{
        TreeNode treeNode;
        int level;

        TreeNodeLevel(TreeNode treeNode, int level){
            this.treeNode=treeNode;
            this.level=level;
        }
    }

    public static int minTreeDepth2(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> curLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        curLevel.add(root);
        while(!curLevel.isEmpty()){
            TreeNode t = curLevel.poll();
            if(t.left == null && t.right == null) return depth;
            else {
                if(t.left != null) nextLevel.add(t.left);
                if(t.right != null) nextLevel.add(t.right);
                if(curLevel.isEmpty()){
                    depth++;
                    curLevel = nextLevel;
                    nextLevel = new LinkedList<>();
                }
            }
        }
        return depth;
    }
}

package com.company.leetcode;

import java.util.*;

public class Lc987VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        int arr [][] = new int [6][6];
        Set<Integer> arr2 [][] = new TreeSet[6][6];

        TreeNode root = new TreeNode(10,new TreeNode(4),new TreeNode(3));
        root.left.left=new TreeNode(11);
        root.left.right=new TreeNode(8);

        root.right.left= new TreeNode(5);
        root.right.right= new TreeNode(13);

        TreeNode root1 = new TreeNode(3,new TreeNode(9),new TreeNode(20));
        root1.right.left= new TreeNode(15);
        root1.right.right= new TreeNode(7);

        System.out.println(verticalTraversal(root));
        System.out.println(verticalTraversal(root1));

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null)
            return null;

        Queue<XyCordTreeNode> queue = new LinkedList<>();
        queue.offer(new XyCordTreeNode(0, 0, root));
        Map<Integer,TreeSet<XyCordTreeNode>> map = new HashMap<>();
        int minX=0, maxX=0;

        while (!queue.isEmpty()){
//            pop out the node
            XyCordTreeNode node = queue.poll();
            minX=Math.min(minX,node.xCoordinate);
            maxX =Math.max(maxX,node.xCoordinate);

            if(!map.containsKey(node.xCoordinate))
                map.put(node.xCoordinate,new TreeSet<>());

            map.get(node.xCoordinate).add(node);

            if(node.treeNode.left != null) queue.offer(new XyCordTreeNode( node.xCoordinate-1,node.yCoordinate-1, node.treeNode.left));

            if(node.treeNode.right != null) queue.offer(new XyCordTreeNode( node.xCoordinate+1,node.yCoordinate-1, node.treeNode.right));

        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = minX; i<=maxX; i++){
            if(map.containsKey(i)){
                List<Integer> list = new ArrayList<>();
                for(XyCordTreeNode xy :map.get(i)){
                    list.add(xy.treeNode.val);
                };
                result.add(list);
            }
        }

        return result;
    }

    static class XyCordTreeNode implements Comparable<XyCordTreeNode>{
        public int xCoordinate;
        public int yCoordinate;
        public TreeNode treeNode;

        public XyCordTreeNode(int x, int y, TreeNode node) {
            this.xCoordinate = x;
            this.yCoordinate = y;
            this.treeNode = node;
        }

        @Override
        public int compareTo(XyCordTreeNode o) {
            if(xCoordinate==o.xCoordinate){
                if(yCoordinate==o.yCoordinate){
                    return treeNode.val - o.treeNode.val;
                }else {
                    return -1*(yCoordinate-o.yCoordinate);
                }
            }else {
                return xCoordinate-o.xCoordinate;
            }
//            return 0;
        }
    }
}

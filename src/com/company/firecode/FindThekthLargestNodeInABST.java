package com.company.firecode;

import java.util.*;

public class FindThekthLargestNodeInABST {

    public TreeNode MyfindKthLargest(TreeNode root, int k) {
        if(root==null){
            return root;
        }
        Map<Integer,TreeNode> dict = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.remove();
            set.add(currentNode.data);
            dict.put(currentNode.data, currentNode);
            if(currentNode.left != null)queue.add(currentNode.left);
            if(currentNode.right != null)queue.add(currentNode.right);
        }

        List<Integer> list = new ArrayList<>(set);
        int index =list.size() - k ;

        if( index  > list.size() ){
            return null;
        }else{
            int currentInteger = list.get(index);
            TreeNode result = dict.get(currentInteger);
            return result;
        }


    }

//
//                 5
//                / \
//              /     \
//             3       8
//            / \     / \
//           1    4  9   10

    public TreeNode findKthLargest(TreeNode root, int k) {
        if(root == null) return null;
        int rightSize=0;
        if(root.right != null) {
            rightSize=size(root.right);
        }
        if(rightSize+1 == k) {
            return root;
        } else if(k <= rightSize) {
            return findKthLargest(root.right, k);
        } else {
            return findKthLargest(root.left, k-rightSize-1);
        }
    }

    public TreeNode findKthLargestAlternative(TreeNode root, int k) {
        // Add your code below this line. Do not modify any other code.

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(!stack.empty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.right;
            } else {
                current = stack.pop();
                if (k-- == 1) break;
                current = current.left;
            }
        }

        return current;
        // Add your code above this line. Do not modify any other code.
    }

    public static int size(TreeNode node){
//        Implement the size when you have time;
        return  1;
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

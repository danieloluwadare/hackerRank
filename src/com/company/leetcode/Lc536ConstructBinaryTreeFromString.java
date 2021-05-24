package com.company.leetcode;

import java.util.*;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 *
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
 * The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "4(2(3)(1))(6(5))"
 * Output: [4,2,6,3,1,5]
 * Example 2:
 *
 * Input: s = "4(2(3)(1))(6(5)(7))"
 * Output: [4,2,6,3,1,5,7]
 * Example 3:
 *
 * Input: s = "-4(2(3)(1))(6(5)(7))"
 * Output: [-4,2,6,3,1,5,7]
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s consists of digits, '(', ')', and '-' only.
 */
public class Lc536ConstructBinaryTreeFromString {
    public static void main(String[] args) {

        str2tree("4(2(3)(1))(6(5))");
        str2tree("4(2(3)(1))(6(5)(7))");
        str2tree("-4(2(3)(1))(6(5)(7))");
        str2tree("");
        str2tree("-489");
        str2tree("5");

    }

    public static TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }

        Stack<TreeNode> stack =new Stack<>();
        int count = 0;
        boolean foundCount = false;
        boolean foundNegativeSign = false;
        boolean hasFoundOpeningBrace = false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch=='-'){
                foundNegativeSign=true;
                continue;
            }
            else if(Character.isDigit(ch)){
                count = count * 10 + ch - '0';
                foundCount=true;
            }
            else if(ch == '(' && foundCount){
                if(foundNegativeSign)
                    count = -count;
                TreeNode node=new TreeNode(count);
                stack.push(node);
                foundNegativeSign=false;
                foundCount=false;
                hasFoundOpeningBrace=true;
                count=0;
            }else if(ch == ')' && foundCount){
                if(foundNegativeSign)
                    count = -count;
                TreeNode childNode=new TreeNode(count);
                TreeNode node = stack.pop();
                if(node.left != null)
                    node.right=childNode;
                else{
                    node.left=childNode;
                }
                stack.push(node);
                foundNegativeSign=false;
                foundCount=false;
                count=0;

            }else if(ch == ')' && !foundCount){
                TreeNode childNode = stack.pop();
                TreeNode parent = stack.pop();
                if(parent.left != null)
                    parent.right=childNode;
                else{
                    parent.left=childNode;
                }
                stack.push(parent);
                foundNegativeSign=false;
                foundCount=false;
                count=0;
            }
        }
        if(!hasFoundOpeningBrace){
            if(foundNegativeSign)
                count = -count;
            return new TreeNode(count);
        }
        TreeNode node = stack.pop();
        return node;
    }
}

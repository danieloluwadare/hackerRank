package com.company.pramp;
/*
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation:

The multilevel linked list in the input is as follows:

1 = 2 = 3 = 4 = 5 =6
       ||
       7 = 8 = 9 = 10
           ||
           11 = 12

           result = [1,2,3,7,8,11,12,9,10,4,5,6]
*/

/*
solution for a Node.

                        1
                          \
                            2
                              \
                                3
                               /  \
                              7     4
                                \
                                8
                               /  \
                              11    9
                                      \
                                        10



1, 2, 3, 7, 8, 11, 9, 4,

[]

1, 2, 3, 7, 8, 11,9,10, 4, 5, 6

*/
//import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestPramp {
    static public void main( String args[] ) {
        System.out.println( "Practice makes Perfect!" );

    }

    public static Node flatten(Node root){
        if(root == null){
            return root;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();

        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.next != null) stack.push(node.next);//Right child
            if(node.child != null) stack.push(node.child);//Left child
            list.add(node.val);
        }

        //System.out.println(list.toString());
        //System.out.println(list.toString());

        Node newRootNode = new Node(list.get(0));
        Node current = newRootNode;
        for(int i = 1; i < list.size(); i++){
            Node newNode = new Node(list.get(i));
            current.next = newNode;
            newNode.prev = current;

            current = newNode;
        }


        return newRootNode;
    }

    public static Node flatten2(Node root){
        if(root == null){
            return root;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Node newRootNode = null;
        Node current = null;
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.next != null) stack.push(node.next);//Right child
            if(node.child != null) stack.push(node.child);//Left child
            //list.add(currentNode.val);
            Node newNode = new Node(node.val);
            if(current == null){
                newRootNode = newNode;
            }else{
                current.next = newNode;
                newNode.prev = current;

            }
            current = newNode;

        }

        return newRootNode;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next; //Right child
    public Node child; //Left child

    public Node (int val){
        this.val = val;
    }

};
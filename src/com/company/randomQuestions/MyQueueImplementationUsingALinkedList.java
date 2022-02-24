package com.company.randomQuestions;

public class MyQueueImplementationUsingALinkedList {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue.empty());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.empty());

        queue = new MyQueue();
        System.out.println(queue.peek());
        System.out.println(queue.pop());

    }

    static class MyQueue {
        private Node head;
        private Node tail;
        private int size;

        public MyQueue() {
            size =0;
        }

        public void push(int x) {
            if(tail == null){
                tail = new Node(x);
                head = tail;
            }else {
                Node newTail = new Node(x);
                tail.next = newTail;
                tail = newTail;
            }
            size++;
        }

        public int pop() {
            if(head != null){
                size--;
                int value = head.value;
                head = head.next;
                return value;
            }

            return -1;
        }

        public int peek() {
            if(head != null)
                return head.value;
            return -1;
        }

        public boolean empty() {
            return head==null;
        }

        public int size (){
            return size;
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

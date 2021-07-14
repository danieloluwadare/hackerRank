package com.company.leetcode2;

/**
 * 60. LFU Cache
 * Hard
 *
 * 2234
 *
 * 159
 *
 * Add to List
 *
 * Share
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 *                  // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 *                  // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 *                  // cache=[3,4], cnt(4)=2, cnt(3)=3
 *
 *
 * Constraints:
 *
 * 0 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * At most 2 * 105 calls will be made to get and put.
 */

import java.util.*;

public class Lc460LFUCache {

    public static void main(String[] args) {
//        DoubleLinkedList l1 = new DoubleLinkedList(1);
//        DoubleLinkedList l2 = new DoubleLinkedList(12);
//        DoubleLinkedList l3 = new DoubleLinkedList(3);
//
//        l1.next=l2;
//        l2.prev = l1;
//        l2.next=l3;
//        l3.prev=l2;
//        l1.prev = l3;
//
//        System.out.println(l1);
//
//        DoubleLinkedList m1 = new DoubleLinkedList(21);
//        DoubleLinkedList m2 = new DoubleLinkedList(22);
//        m1.next=m2;
//        m2.prev = m1;
//        m1.prev = m2;
//        System.out.println(m1);
//
////        Take l2 add it to end of m2
//
////        nullify the previous pointer  and next pointer
//        l2.prev.next = l2.next;
//        l2.next=null;
//
////
//        m1.prev.next= l2;
//        l2.prev = m1.prev;
//        m1.prev=l2;
//        System.out.println(m1);
//
//        DoubleLinkedList c1 = new DoubleLinkedList(31);
//        DoubleLinkedList c2 = new DoubleLinkedList(32);
//
////        1-> <-2
//        c1.next = c2;
//        c1.prev= c2;
//        c2.prev= c1;
//
////        remove c2
//        c2.prev.next=c2.next;
//        c2.next.prev = c2.prev;
//        c2.next=null;
//        c2.prev=null;
//        System.out.println(c1);


        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));// return -1 (not found)
        System.out.println(lfu.get(3));      // return 3

        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // return 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3

    }

    static class LFUCache {
        private Map<Integer,Node> keyValueMap;
        private Map<Integer, Node> frequencyMap;
        private int maximumCapacity;
        private int minimumFrequency;
        private int size;
        public LFUCache(int capacity) {
            frequencyMap = new HashMap<>();
            keyValueMap = new HashMap<>();
            maximumCapacity = capacity;
            minimumFrequency= 1;
            size = 0;
        }

        public int get(int key) {
            if(!keyValueMap.containsKey(key))
                return -1;

            Node node = keyValueMap.get(key);
            deleteNodeFrequency(node);
            node.frequency++;
            addFrequency(node);
            System.out.println("-------------");
            return node.value;
        }

        public void put(int key, int value) {
            if(maximumCapacity==0)
                return;
            if(keyValueMap.containsKey(key)){
//                put inside the keyValueMap
//                and increase the frequency
                Node node = keyValueMap.get(key);
                deleteNodeFrequency(node);
                node.value = value;
                node.frequency++;
                addFrequency(node);

            }else {
                if(size == maximumCapacity){
//                    remove from the cacheMap & frequencyMap
//                    the least frequently used / least recently used
//                    and add the new key and it value
//                    set the new frequency to one.
                    Node node = frequencyMap.get(minimumFrequency).next;
                    deleteNodeFrequency(node);
                    keyValueMap.remove(node.key);
                    minimumFrequency = 1;
                    node = new Node(key,value,minimumFrequency);
                    keyValueMap.put(key,node);
                    addFrequency(node);

                }else {
//                    Add the new key to the cacheMap
//                    Add the frequency of 1 to the frequencyMap
//                    Add the Node  to keyNode Map
                    minimumFrequency = 1;
                    Node node = new Node(key,value,minimumFrequency);
                    keyValueMap.put(key,node);
                    addFrequency(node);
                    size++;
                }
            }
            System.out.println("------------");
        }

        private void deleteNodeFrequency(Node node) {

            node.prev.next=node.next;
            node.next.prev= node.prev;

//            check if current node is the last node
            if(node.prev.value == -1 && node.next.value == -1){
                int currentFrequency = node.frequency;
                frequencyMap.remove(currentFrequency);
//                check if current frequency is the minimum frequency
                if(currentFrequency == minimumFrequency)
                    minimumFrequency=currentFrequency+1;

            }
            node.prev = null;
            node.next = null;
        }

        private void addFrequency(Node node) {
            if(!frequencyMap.containsKey(node.frequency)){
                Node startNode = new Node(-1,-1, -1);
                Node endNode = new Node(-1,-1, -1);
                startNode.next=endNode;
                endNode.prev=startNode;
                startNode.prev=endNode;
                frequencyMap.put(node.frequency, startNode);
            }
            Node startNode = frequencyMap.get(node.frequency);
            Node endNode = startNode.prev;

            endNode.prev.next = node;
            node.prev = endNode.prev;

            node.next=endNode;
            endNode.prev=node;

            System.out.println("print");
        }

    }

    static class Node{
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
    static class DoubleLinkedList{
        int key;
        DoubleLinkedList next;
        DoubleLinkedList prev;
        public DoubleLinkedList(int key) {
            this.key = key;
        }
    }



}

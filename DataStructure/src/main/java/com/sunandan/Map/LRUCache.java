package com.sunandan.Map;

import java.util.concurrent.ConcurrentHashMap;

//Least Recently Used
public class LRUCache {
    private ConcurrentHashMap<Integer, DoubleLinkedNode>
            cache = new ConcurrentHashMap<Integer, DoubleLinkedNode>();
    private int count;
    private int capacity;

    //Doubly linked lists let us remove and insert in constant time if we have access to a node directly.
    //The Map gives us access to a node directly. Also removal takes O(1) time in Singly Linked List it will take O(n).
    private DoubleLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DoubleLinkedNode();
        head.pre = null;

        tail = new DoubleLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DoubleLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }

        this.moveToHead(node);

        return node.value;
    }


    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);

        if(node == null){

            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity){
                // pop the tail
                DoubleLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else{
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }


    private void addNode(DoubleLinkedNode node) {

        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DoubleLinkedNode node){
        DoubleLinkedNode pre = node.pre;
        DoubleLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DoubleLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DoubleLinkedNode popTail(){
        DoubleLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }


}
package com.orbit.review.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node{
        int key,val;
        Node pre,next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;

        }
    }

    static class DoubleLinkedList{
        Node head,tail;
        private int size;
        public DoubleLinkedList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size =0;
        }

        public int size(){
            return size;
        }
        public void removeNode(Node x) {
            x.pre.next = x.next;
            x.next.pre = x.pre;
            size--;
        }
        public Node removeFirst() {
            if (head.next == tail){
                return null;
            }
            Node first = head.next;
            removeNode(first);
            return first;
        }

        public void addLast(Node x) {
            x.pre = tail.pre;
            x.next = tail;
            tail.pre.next = x;
            tail.pre = x;
            size++;
        }
    }
    Map<Integer,Node> map;
    DoubleLinkedList cache;
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
       makeRecently(key);
       return map.get(key).val;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)){
            // 删除旧的数据
            deleteKey(key);
            // 新插入的数据为最近使用的数据
            addRecently(key, value);
            return;
        }
        if (cache.size >= cap){
            removeLeastRecently();
        }
        addRecently(key,value);
    }

    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        map.remove(node.key);
    }

    private void addRecently(int key, int value) {
        Node x = new Node(key, value);
        cache.addLast(x);
        map.put(key,x);
    }

    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.removeNode(node);
        map.remove(node.key);
    }

    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.removeNode(node);
        cache.addLast(node);
    }
}

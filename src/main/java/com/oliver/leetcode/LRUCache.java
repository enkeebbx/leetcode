package com.oliver.leetcode;

import java.util.HashMap;
import java.util.Map;

//146. LRU Cache
public class LRUCache {

    private Map<Integer, CacheNode> pointers;
    private CacheNode head;
    private CacheNode tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        CacheNode head = new CacheNode();
        CacheNode tail = new CacheNode();
        head.next = tail;
        tail.prev = head;

        this.head = head;
        this.tail = tail;
        this.pointers = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        CacheNode cacheNode = pointers.get(key);
        if (cacheNode == null) {
            return -1;
        }
        wireAfterHead(cacheNode);
        return cacheNode.value;
    }

    public void put(int key, int value) {
        CacheNode cacheNode = pointers.get(key);
        if (cacheNode == null) {
            if (size == capacity) {
                CacheNode toEvict = tail.prev;
                toEvict.prev.next = tail;
                tail.prev = toEvict.prev;
                size--;
                pointers.remove(toEvict.key);
            }
            cacheNode = new CacheNode();
            cacheNode.key = key;
            cacheNode.value = value;
            wireAfterHead(cacheNode);
            size++;
        } else {
            cacheNode.value = value;
            wireAfterHead(cacheNode);
        }
    }

    public void wireAfterHead(CacheNode cacheNode) {
        CacheNode prev = cacheNode.prev;
        CacheNode next = cacheNode.next;
        if (prev != null && next != null) {
            prev.next = next;
            next.prev = prev;
        }
        cacheNode.next = head.next;
        cacheNode.prev = head;
        head.next = cacheNode;
        cacheNode.next.prev = cacheNode;
        pointers.put(cacheNode.key, cacheNode);
    }

    class CacheNode {
        CacheNode next;
        CacheNode prev;
        int key;
        int value;
    }

}

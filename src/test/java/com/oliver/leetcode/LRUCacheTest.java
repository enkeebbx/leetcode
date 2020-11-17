package com.oliver.leetcode;

import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    @Test
    void check() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 3); // cache is {1=1}
        lRUCache.put(4, 1); // cache is {1=1}
        System.out.println(lRUCache.get(1));    // return 1
        System.out.println(lRUCache.get(2));    // return 1
    }

}

package com.sunandan.Map;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {


    LRUCache lruCache = new LRUCache(10);

    @Test
    public void test1MethodPut() {
        lruCache.put(1, 3);
        lruCache.put(2, 4);
        assertEquals(3, lruCache.get(1));
    }

    @Test
    public void testCapacity() {
        lruCache = new LRUCache(2);
        lruCache.put(1, 3);
        lruCache.put(2, 4);
        lruCache.put(10, 40);
        assertEquals(-1, lruCache.get(1));
    }


}
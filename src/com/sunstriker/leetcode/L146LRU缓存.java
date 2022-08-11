package com.sunstriker.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class L146LRU缓存 {
    class LRUCache {
        int cap;
        LinkedHashMap<Integer, Integer> cache;

        public LRUCache(int capacity) {
            cache = new LinkedHashMap<>();
            cap = capacity;
        }

        public int get(int key) {
            if(!cache.containsKey(key)) return -1;
            makeKeyRecent(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                cache.put(key, value);
                makeKeyRecent(key);
                return;
            }
            if(cache.size() == cap){
                int oldest = cache.keySet().stream().findFirst().get();
                cache.remove(oldest);
            }
            cache.put(key, value);
        }

        private void makeKeyRecent(int key){
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
        }
    }

}

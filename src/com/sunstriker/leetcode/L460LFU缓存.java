package com.sunstriker.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class L460LFU缓存 {

    public static void main(String[] args) {
        var cache = new L460LFU缓存().new LFUCache(0);
        cache.put(0,0);
        cache.get(0);
    }

    class LFUCache {
        HashMap<Integer, Integer> keyValue;
        HashMap<Integer, Integer> keyFreq;
        HashMap<Integer, LinkedHashSet<Integer>> freqKeys;
        int minFreq, cap;

        public LFUCache(int capacity) {
            keyValue = new HashMap<>();
            keyFreq = new HashMap<>();
            freqKeys = new HashMap<>();
            minFreq = 0;
            cap = capacity;
        }

        public int get(int key) {
            if (!keyValue.containsKey(key)) return -1;
            increaseFreq(key);
            return keyValue.get(key);
        }

        public void put(int key, int value) {
            if(cap == 0) return;
            if (keyValue.containsKey(key)) {
                keyValue.put(key, value);
                increaseFreq(key);
            } else {
                if (keyValue.size() == cap) removeMinFreq();
                keyValue.put(key, value);
                keyFreq.put(key, 1);
                LinkedHashSet<Integer> keys = freqKeys.getOrDefault(1, new LinkedHashSet<>());
                keys.add(key);
                freqKeys.put(1, keys);
                minFreq = 1;
            }
        }

        private void removeMinFreq() {
            LinkedHashSet<Integer> minFreqKeys = freqKeys.get(minFreq);
            int first = minFreqKeys.iterator().next();
            minFreqKeys.remove(first);
            if (minFreqKeys.isEmpty()) freqKeys.remove(minFreq);
            keyValue.remove(first);
            keyFreq.remove(first);
        }

        private void increaseFreq(int key) {
            int oldFreq = keyFreq.get(key);
            keyFreq.put(key, oldFreq+1);
            freqKeys.get(oldFreq).remove(key);
            LinkedHashSet<Integer> currentFreqKeys = freqKeys.getOrDefault(oldFreq + 1, new LinkedHashSet<>());
            currentFreqKeys.add(key);
            freqKeys.put(oldFreq + 1, currentFreqKeys);
            if (freqKeys.get(oldFreq).isEmpty()) {
                freqKeys.remove(oldFreq);
                if (oldFreq == minFreq) minFreq++;
            }
        }
    }
}

package com.sunstriker.leetcode;

public class L706设计哈希映射 {

     class MyHashMap {
         class Entry {
            int key;
            int val;
            Entry next;
        }
        Entry[] entries;
        int entrySize = 100000;
        public MyHashMap() {
            entries = new Entry[entrySize];
        }

        public void put(int key, int value) {
            Entry entry = new Entry();
            entry.key = key;
            entry.val = value;
            Entry curr = entries[key%entrySize];
            if(curr==null) {
                entries[key % entrySize] = entry;
                return;
            }
            while (curr.key!=key && curr.next != null){
                curr = curr.next;
            }
            if(curr.key == key) curr.val = value;
            else curr.next = entry;
        }

        public int get(int key) {
            Entry curr = entries[key % entrySize];
            int res = -1;
            while (curr!=null && curr.key!=key){
                curr = curr.next;
            }
            if(curr != null) res = curr.val;
            return res;

        }

        public void remove(int key) {
            Entry curr = entries[key % entrySize];
            if(curr == null) return;
            if(curr.key == key) {
                entries[key % entrySize] = curr.next;
                return;
            }
            while (curr.next!=null){
                if(curr.next.key == key){
                    curr.next = curr.next.next;
                }
            }
        }
    }
}

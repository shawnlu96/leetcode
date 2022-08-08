package com.sunstriker.jzoffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class JZ50第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
                queue.offer(c);
                index.offer(i);
            } else {
                map.put(c, -1);
                while (!queue.isEmpty() && map.get(queue.peek()) == -1) {
                    queue.poll();
                    index.poll();
                }
            }
        }
        if (index.isEmpty()) return -1;
        return index.peek();
    }

    public int FirstNotRepeatingChar2(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            char c = strArr[i];
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, -1);
        }
        for (int i = 0; i < strArr.length; i++) {
            char c = strArr[i];
            if(map.get(c) == 1) return i;
        }
        return -1;
    }
}

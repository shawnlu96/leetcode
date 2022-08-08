package com.sunstriker.jzoffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class JZ75字符流中第一个不重复的字符 {
    HashMap<Character, Boolean> map = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!map.containsKey(ch)) {
            map.put(ch, true);
            queue.offer(ch);
        } else {
            map.put(ch, false);
            while (!queue.isEmpty() && !map.get(queue.peek())) {
                queue.poll();
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty()? '#' : queue.peek();
    }
}

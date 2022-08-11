package com.sunstriker.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class L225用队列实现栈 {
    class MyStack {
        Queue<Integer> queue;
        public MyStack() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < queue.size()-1; i++) {
                queue.offer(pop());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

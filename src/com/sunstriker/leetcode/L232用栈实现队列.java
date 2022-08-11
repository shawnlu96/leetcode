package com.sunstriker.leetcode;

import java.util.Stack;

public class L232用栈实现队列 {
    class MyQueue {
        Stack<Integer> s1, s2;
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            if (!s2.isEmpty() && s1.isEmpty()){
                while (!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
            s1.push(x);
        }

        public int pop() {
            peek();
            return s2.pop();
        }

        public int peek() {
            if(s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            if(s1.isEmpty() &&s2.isEmpty()) return true;
            if(!s1.isEmpty()) s1.empty();
            if (!s2.isEmpty()) s2.empty();
            return false;
        }
    }

}

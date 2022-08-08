package com.sunstriker.jzoffer;

import java.util.Objects;
import java.util.Stack;

public class JZ30StackWithMin {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
       stack.push(node);
       if(minStack.empty() || minStack.peek() >= node){
           minStack.push(node);
       }
    }

    public void pop() {
        if(!minStack.empty() && Objects.equals(stack.peek(), minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

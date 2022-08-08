package com.sunstriker.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L32最长有效括号 {
    public static void main(String[] args) {
        System.out.println(new L32最长有效括号().longestValidParentheses("()(()"));
    }

    // 栈模拟+dp
    public int longestValidParentheses1(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxCount = 0;
        int[] counts = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
                counts[i] = 0;
            }else{
                if(stack.isEmpty()){
                    counts[i] = 0;
                }else{
                    int preIndex = stack.pop();
                    counts[i] = preIndex>0 ? counts[preIndex-1] + 2 : 2;
                    if(s.charAt(i-1) == ')') {
                        counts[i] += counts[i-1];
                    }
                    maxCount = Math.max(maxCount, counts[i]);
                }
            }
        }
        return maxCount;
    }

    // 栈模拟
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(0);
            }else{
                if(stack.isEmpty() || (stack.peek() > 0 && stack.size() == 1)){
                    stack.clear();
                }else {
                    int top = stack.pop();
                    if(top != 0){
                        stack.pop();
                    }
                    top += 2;
                    while (!stack.isEmpty() && stack.peek()!=0){
                        top += stack.pop();
                    }
                    maxCount = Math.max(top, maxCount);
                    stack.push(top);
                }
            }
        }
        return maxCount;
    }
}

package com.sunstriker.leetcode;

import java.util.ArrayDeque;

public class L316去除重复字母 {
    public static void main(String[] args) {
        System.out.println(new L316去除重复字母().removeDuplicateLetters("bcabc"));
    }
    public String removeDuplicateLetters(String s) {
        int[] letterCount = new int[26];
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean[] inStack = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            letterCount[curr - 'a']--;
            if(inStack[curr-'a']) continue;
            while (!stack.isEmpty() && letterCount[ stack.peek() - 'a'] > 0 && curr < stack.peek()) {
                char last = stack.pop();
                inStack[last-'a'] = false;
            }
            stack.push(curr);
            inStack[curr-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class L503下一个更大元素II {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L503下一个更大元素II().nextGreaterElements(new int[]{1, 2, 1})));
    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n * 2 -1; i >=0 ; i--) {
            int num = nums[i % n];
            while (!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }
            res[i%n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }
        return res;
    }
}

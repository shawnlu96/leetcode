package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class L496下一个更大元素I {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L496下一个更大元素I().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] temp = new int[nums2.length];
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            temp[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = temp[map.get(nums1[i])];
        }


        return res;
    }
}

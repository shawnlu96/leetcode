package com.sunstriker.leetcode;

import java.util.*;

public class L239滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> window = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int left = 0, right = 0;
        while (right < nums.length) {
            int added = nums[right++];
            while (!window.isEmpty() && window.getLast() < added) {
                window.pollLast();
            }
            window.offer(added);
            if (right - left == k) {
                int max = window.getFirst();
                res[left] = max;
                int deleted = nums[left++];
                if (max == deleted) window.removeFirst();
            }
        }
        return res;

    }
}

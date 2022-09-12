package com.sunstriker.leetcode;

public class L11盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int smallSide = Math.min(height[left], height[right]);
            max = Math.max(max, smallSide * (right - left));
            if (smallSide == height[left]) left++;
            else right--;
        }
        return max;
    }
}

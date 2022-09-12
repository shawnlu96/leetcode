package com.sunstriker.leetcode;

public class L42接雨水 {
    public static void main(String[] args) {
        new L42接雨水().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        int n = height.length, res = 0;
        if (n < 3) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n - 1; i++) {
            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        }
        for (int i = n - 2; i >= 1; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            int minEdge = Math.min(leftMax[i], rightMax[i]);
            res += Math.max(0, minEdge - height[i]);
        }
        return res;
    }
}

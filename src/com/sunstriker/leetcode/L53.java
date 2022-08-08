package com.sunstriker.leetcode;

public class L53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, -2, 3, -2}));
    }
    public static int maxSubArray(int[] nums) {
        int curr = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i] + Math.max(0, curr);
            maxSum = Math.max(curr, maxSum );
        }

        return maxSum;
    }
}
